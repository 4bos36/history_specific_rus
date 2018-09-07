package studio.rashka.Screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import studio.rashka.History;
import studio.rashka.Lib.Game;
import studio.rashka.Lib.State;

public class StartTestScreen extends State {

    public StartTestScreen(Game game) {
        super(game);

        History.setNomerTesta(1); // обнуляем параметры
        History.setPravilno(0);

        History.getRunTest().onStart();
    }

    @Override
    public void update(float deltaTime) {
        if (History.getPreference().loadBonus()) {
            History.getPreference().setBonus(false);
            History.getRunTest().onStageNewDeleteText();
            History.getRunTest().newTextBonus();
            History.getRunTest().repeatText();
        }
        if (History.getPreference().loadTimeRun() && !History.getRunTest().isShowTrue())
            if (History.getNomerTesta() <= History.getRunTest().getTest()) History.getTime().onTime();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(History.getTextures().textureRegions.get("fon"), 0, 0, History.WIDTH, History.HEIGHT);
        batch.draw(History.getTextures().textureRegions.get("name"), History.WIDTH / 2 - History.getTextures().textureRegions.get("name").getRegionWidth() / 2, History.HEIGHT - History.getTextures().textureRegions.get("name").getRegionWidth() / 2 - 80);
        if (!History.getRunTest().isShowTrue()) {
            if (History.getNomerTesta() <= History.getRunTest().getTest()) {
                batch.draw(History.getTextures().textureRegions.get("white"), 16, History.HEIGHT - (698 + History.getRunTest().getYq()), History.WIDTH - 32, 160 + History.getRunTest().getHq());
                batch.draw(History.getTextures().textureRegions.get("time"), History.WIDTH / 2 - 56, 1000, 112, 112);
                batch.draw(History.getTextures().textureRegions.get("black"), History.WIDTH / 2 - 704 / 2, 832, 704, 128);
                if (History.getQuestions().isTouchV1()) batch.draw(History.getTextures().textureRegions.get("Click"), History.WIDTH / 2 - 704 / 2, 832, 704, 128);
                batch.draw(History.getTextures().textureRegions.get("black"), History.WIDTH / 2 - 704 / 2, 640, 704, 128);
                if (History.getQuestions().isTouchV2()) batch.draw(History.getTextures().textureRegions.get("Click"), History.WIDTH / 2 - 704 / 2, 640, 704, 128);
                batch.draw(History.getTextures().textureRegions.get("black"), History.WIDTH / 2 - 704 / 2, 448, 704, 128);
                if (History.getQuestions().isTouchV3()) batch.draw(History.getTextures().textureRegions.get("Click"), History.WIDTH / 2 - 704 / 2, 448, 704, 128);
                batch.draw(History.getTextures().textureRegions.get("black"), History.WIDTH / 2 - 704 / 2, 256, 704, 128);
                if (History.getQuestions().isTouchV4()) batch.draw(History.getTextures().textureRegions.get("Click"), History.WIDTH / 2 - 704 / 2, 256, 704, 128);
                batch.draw(History.getTextures().textureRegions.get("white"), History.WIDTH / 2 - 224 / 2, 0, 224, 104);
                batch.draw(History.getTextures().textureRegions.get("white"), 0, 0, (History.WIDTH / 20) * History.getNomerTesta(), 20);
                batch.draw(History.getTextures().textureRegions.get("black"), 0, 20, (History.WIDTH / 20) * History.getNomerTesta(), 2);

                if (History.getPreference().loadHelpRemove() > 0 && History.getRunTest().isOn1())
                    batch.draw(History.getTextures().textureRegions.get("Remove"), 256, History.HEIGHT - 224);
                else if (History.getPreference().loadHelpRemove() > 0 && !History.getRunTest().isOn1())
                    batch.draw(History.getTextures().textureRegions.get("RemoveNO"), 256, History.HEIGHT - 224);
                else if (History.getPreference().loadHelpRemove() <= 0) {
                    batch.draw(History.getTextures().textureRegions.get("RemoveNO"), 256, History.HEIGHT - 224);
                    batch.draw(History.getTextures().textureRegions.get("Add"), 256, History.HEIGHT - 224);
                }
                if (History.getPreference().loadHelp50() > 0 && History.getRunTest().isOn50())
                    batch.draw(History.getTextures().textureRegions.get("5050"), History.WIDTH / 2 - 64, History.HEIGHT - 160);
                else if (History.getPreference().loadHelp50() > 0 && !History.getRunTest().isOn50())
                    batch.draw(History.getTextures().textureRegions.get("5050NO"), History.WIDTH / 2 - 64, History.HEIGHT - 160);
                else if (History.getPreference().loadHelp50() <= 0) {
                    batch.draw(History.getTextures().textureRegions.get("5050NO"), History.WIDTH / 2 - 64, History.HEIGHT - 160);
                    batch.draw(History.getTextures().textureRegions.get("Add"), History.WIDTH / 2 - 64, History.HEIGHT - 160);
                }
                if (History.getPreference().loadHelpTrue() > 0 && History.getRunTest().isOnTrue())
                    batch.draw(History.getTextures().textureRegions.get("HelpTrue"), History.WIDTH - 384, History.HEIGHT - 224);
                else if (History.getPreference().loadHelpTrue() > 0 && !History.getRunTest().isOnTrue())
                    batch.draw(History.getTextures().textureRegions.get("HelpTrueNO"), History.WIDTH - 384, History.HEIGHT - 224);
                else if (History.getPreference().loadHelpTrue() <= 0) {
                    batch.draw(History.getTextures().textureRegions.get("HelpTrueNO"), History.WIDTH - 384, History.HEIGHT - 224);
                    batch.draw(History.getTextures().textureRegions.get("Add"), History.WIDTH - 384, History.HEIGHT - 224);
                }
            } else if (History.getNomerTesta() > History.getRunTest().getTest()) {
                batch.draw(History.getTextures().textureRegions.get("white"), 16, History.HEIGHT - 710 + 120, History.WIDTH - 32, 160);
                batch.draw(History.getTextures().textureRegions.get("black"), 16, 224, History.WIDTH - 32, 330 + 150);
                if (History.getPravilno() >= 0 && History.getPravilno() <= 4)
                    batch.draw(History.getTextures().textureRegions.get("peasant"), History.WIDTH / 2 - History.getTextures().textureRegions.get("peasant").getRegionWidth() / 2, 592 + 130);
                else if (History.getPravilno() >= 5 && History.getPravilno() <= 9)
                    batch.draw(History.getTextures().textureRegions.get("postelnichy"), History.WIDTH / 2 - History.getTextures().textureRegions.get("postelnichy").getRegionWidth() / 2, 592 + 130);
                else if (History.getPravilno() >= 10 && History.getPravilno() <= 14)
                    batch.draw(History.getTextures().textureRegions.get("merchant"), History.WIDTH / 2 - History.getTextures().textureRegions.get("merchant").getRegionWidth() / 2, 592 + 130);
                else if (History.getPravilno() >= 15 && History.getPravilno() <= 17)
                    batch.draw(History.getTextures().textureRegions.get("boyarin"), History.WIDTH / 2 - History.getTextures().textureRegions.get("boyarin").getRegionWidth() / 2, 592 + 130);
                else if (History.getPravilno() >= 18 && History.getPravilno() <= 19)
                    batch.draw(History.getTextures().textureRegions.get("monarch"), History.WIDTH / 2 - History.getTextures().textureRegions.get("monarch").getRegionWidth() / 2, 592 + 130);
                else if (History.getPravilno() == 20)
                    batch.draw(History.getTextures().textureRegions.get("prince"), History.WIDTH / 2 - History.getTextures().textureRegions.get("prince").getRegionWidth() / 2, 592 + 130);
            }
        }
        else if (History.getRunTest().isShowTrue()) {
            batch.draw(History.getTextures().textureRegions.get("white"), 16, History.HEIGHT - 698, History.WIDTH - 32, 160);
            batch.draw(History.getTextures().textureRegions.get("black"), 16, 224, History.WIDTH - 32, 896);
        }
        batch.end();

        if (!History.getRunTest().isShowTrue()) {
            History.getRunTest().getStageText().act();
            History.getRunTest().getStageText().draw();
        }

        History.getRunTest().getStage().act();
        History.getRunTest().getStage().draw();

        if (History.getNomerTesta() <= History.getRunTest().getTest() && !History.getRunTest().isShowTrue()) {
            History.getTime().getStage().act();
            History.getTime().getStage().draw();
        }
    }

    @Override
    public void dispose() {
        History.getRunTest().dispose();
        History.getQuestions().dispose();
        History.getTime().dispose();
    }
}