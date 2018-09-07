package studio.rashka.Lib;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.StringBuilder;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Random;

import studio.rashka.History;

public class Time {

    private Stage stage;
    private Random random;
    private Label timeSec;

    private long startTime;
    private int time = 31;

    public Time() {
        stage = new Stage();
        random = new Random();
        startTime = TimeUtils.nanoTime();

        timeSec = new Label(new StringBuilder().append(time), new LabelStyle(History.getFontTTF().getFont(), Color.BLACK));
        timeSec.setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - timeSec.getWidth() / 2, (990 + 36) * History.getRatioMonitorH());
        onStageAdd();
    }

    public void onTime () {
        if (TimeUtils.nanoTime() - startTime > 1000000000) { /* 1,000,000,000ns == one second */
            time = time - 1;
            onStageNewDelete();
            timeSec = new Label(new StringBuilder().append(time), new LabelStyle(History.getFontTTF().getFont(), Color.BLACK));
            timeSec.setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - timeSec.getWidth() / 2, (990 + 36) * History.getRatioMonitorH());
            onStageAdd();
            startTime = TimeUtils.nanoTime();
        }
        else if (time == 0) {
            if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
            History.setNomerTesta(History.getNomerTesta() + 1);
            History.getRunTest().onStageNewDelete();
            History.getRunTest().onTest(random.nextInt(History.getQ_all()));
            time = 31;
        }
    }

    public void onStageNewDelete() {
        try {
            stage.dispose();
        } catch (IllegalArgumentException e) {
            // может выскочить
        }
        stage = new Stage();
    }

    public void onStageAdd() {
        stage.addActor(timeSec);
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Stage getStage() {
        return stage;
    }

    public void dispose() {
        /*try {
            stage.dispose();
            timeSec.remove();
        } catch (NullPointerException e) {
            // игнорим ошибку
        }*/
    }
}