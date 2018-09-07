package studio.rashka.Lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class MusicSound {

    private Music music;
    private Sound click;

    public MusicSound() {
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/fon_play.ogg"));
        click = Gdx.audio.newSound(Gdx.files.internal("sounds/button.ogg"));
    }

    public void StartFon(){
        if (!music.isPlaying()) {
            music.setLooping(true);
            music.setVolume(1);//History.getPreference().loadVolume());
            music.play();
        }
    }

    public void releaseMP() {
        if (music != null) { // если запущено, то выключаем
            try {
                music.dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Music getMusic() {
        return music;
    }

    public Sound getClick() {
        return click;
    }

    public void dispose() {
        releaseMP();
        click.dispose();
    }
}