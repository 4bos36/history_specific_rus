package studio.rashka.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import studio.rashka.AdHandler;
import studio.rashka.History;

public class DesktopLauncher implements AdHandler {

	private static DesktopLauncher application;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		if (application == null) {
			application = new DesktopLauncher();
		}

		config.title = History.TITLE;
		config.width = History.WIDTH / 3;
		config.height = History.HEIGHT / 3;
		new LwjglApplication(new History(application), config);
	}

	@Override
	public void showAds(int show) {
		// TODO Auto-generated method stub
	}

	@Override
	public void toast(StringBuilder result) {

	}
}