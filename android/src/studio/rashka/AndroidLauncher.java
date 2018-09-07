package studio.rashka;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.HashMap;
import java.util.Map;

public class AndroidLauncher extends AndroidApplication implements AdHandler, RewardedVideoAdListener {

	private Map<String, RewardedVideoAd> videoAd;
	private int loadVideo = 3;
	private Preferences setting;
	private DisplayRatio displayRatio;

	protected Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case 0: // -1
					if (videoAd.get("HelpRemove").isLoaded()) {
						videoAd.get("HelpRemove").show();
						loadVideo = 0;
					}
					else {
						Toast.makeText(getContext(), "Нет доступа в интернет", Toast.LENGTH_SHORT).show();
						loadVideoAd();
					}
					break;
				case 1: // 50/50
					if (videoAd.get("Help50").isLoaded()) {
						videoAd.get("Help50").show();
						loadVideo = 1;
					}
					else {
						Toast.makeText(getContext(), "Нет доступа в интернет", Toast.LENGTH_SHORT).show();
						loadVideoAd();
					}
					break;
				case 2: // верно
					if (videoAd.get("HelpTrue").isLoaded()) {
						videoAd.get("HelpTrue").show();
						loadVideo = 2;
					}
					else {
						Toast.makeText(getContext(), "Нет доступа в интернет", Toast.LENGTH_SHORT).show();
						loadVideoAd();
					}
					break;
			}
		}
	};

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // не даёт туснуть экрану
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		super.onCreate(savedInstanceState);

		RelativeLayout layout = new RelativeLayout(this);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useAccelerometer = false;
		config.useCompass = false;

		View gameView = initializeForView(new History(this), config);
		layout.addView(gameView);
		setContentView(layout);

		setting = Gdx.app.getPreferences("Pref_app");
		displayRatio = new DisplayRatio(getWindowManager(), setting);
		videoAd = new HashMap<>();

		MobileAds.initialize(this, "ca-app-pub-4502192705853513~8570086719");
		//MobileAds.initialize(this, "");

		videoAd.put("HelpRemove", MobileAds.getRewardedVideoAdInstance(this));
		videoAd.get("HelpRemove").setRewardedVideoAdListener(this);

		videoAd.put("Help50", MobileAds.getRewardedVideoAdInstance(this));
		videoAd.get("Help50").setRewardedVideoAdListener(this);

		videoAd.put("HelpTrue", MobileAds.getRewardedVideoAdInstance(this));
		videoAd.get("HelpTrue").setRewardedVideoAdListener(this);
		loadVideoAd();
	}

	private void loadVideoAd() {
		if (loadVideo == 3) {
			videoAd.get("HelpRemove").loadAd("ca-app-pub-4502192705853513/1000131539", new AdRequest.Builder().build());
			videoAd.get("Help50").loadAd("ca-app-pub-4502192705853513/7092920683", new AdRequest.Builder().build());
			videoAd.get("HelpTrue").loadAd("ca-app-pub-4502192705853513/7831287282", new AdRequest.Builder().build());
		}
		else if (loadVideo == 0)
			videoAd.get("HelpRemove").loadAd("ca-app-pub-4502192705853513/1000131539", new AdRequest.Builder().build());
		else if (loadVideo == 1)
			videoAd.get("Help50").loadAd("ca-app-pub-4502192705853513/7092920683", new AdRequest.Builder().build());
		else if (loadVideo == 2) {
			videoAd.get("HelpTrue").loadAd("ca-app-pub-4502192705853513/7831287282", new AdRequest.Builder().build());
		}
	}

	@Override
	public void onBackPressed(){ // кнопка назад

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) { // скрываем панель навигации
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
					| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
					| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
					| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
					| View.SYSTEM_UI_FLAG_FULLSCREEN
					| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
					| View.KEEP_SCREEN_ON);
		}
	}

	@Override
	public void showAds(final int show) {
		handler.sendEmptyMessage(show);
	}

	@Override
	public void toast(final StringBuilder result) {
		handler.post(new Runnable()
		{
			@Override
			public void run() {
				Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public void onResume() {
		videoAd.get("HelpRemove").resume(this);
		videoAd.get("Help50").resume(this);
		videoAd.get("HelpTrue").resume(this);
		super.onResume();
	}

	@Override
	public void onPause() {
		videoAd.get("HelpRemove").pause(this);
		videoAd.get("Help50").pause(this);
		videoAd.get("HelpTrue").pause(this);
		super.onPause();
	}

	@Override
	public void onDestroy() {
		videoAd.get("HelpRemove").destroy(this);
		videoAd.get("Help50").destroy(this);
		videoAd.get("HelpTrue").destroy(this);
		super.onDestroy();
	}

	@Override
	public void onRewardedVideoAdLoaded() {

	}

	@Override
	public void onRewardedVideoAdOpened() {

	}

	@Override
	public void onRewardedVideoStarted() {

	}

	@Override
	public void onRewardedVideoAdClosed() {
		loadVideoAd();
	}

	@Override
	public void onRewarded(RewardItem rewardItem) {
		if (loadVideo == 0) { // -1
			setting.putInteger("HelpRemove", 5);
			setting.putBoolean("Bonus", true);
			setting.putBoolean("RunTime", true);
			setting.flush();
		}
		else if (loadVideo == 1) { // 50/50
			setting.putInteger("Help50", 5);
			setting.putBoolean("Bonus", true);
			setting.putBoolean("RunTime", true);
			setting.flush();
		}
		else if (loadVideo == 2) { // верно
			setting.putInteger("HelpTrue", 5);
			setting.putBoolean("Bonus", true);
			setting.putBoolean("RunTime", true);
			setting.flush();
		}
	}

	@Override
	public void onRewardedVideoAdLeftApplication() {

	}

	@Override
	public void onRewardedVideoAdFailedToLoad(int i) {

	}
}