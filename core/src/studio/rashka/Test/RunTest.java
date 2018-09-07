package studio.rashka.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import studio.rashka.History;
import studio.rashka.Screen.MenuScreen;

public class RunTest {

    private boolean on1 = true, on50 = true, onTrue = true;
    private Stage stage, stageText;
    private Random random;
    private Map<String, ImageButtonStyle> buttonStyles;
    private Map<String, ImageButton> buttons;
    private Map<String, LabelStyle> labelStyles;
    private Map<String, Label> text;

    private static final int test = 20;
    private int Xq, Yq, Hq;
    private int bugFix = 1;
    private boolean isShowTrue = false;

    private float RatioMonitorW, RatioMonitorH;

    public RunTest() {
        stage = new Stage();
        stageText = new Stage();
        random = new Random();

        buttonStyles = new HashMap<String, ImageButtonStyle>();
        buttons = new HashMap<String, ImageButton>();

        buttonStyles.put("Repeat", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Repeat"), null, null, null, null, null));
        buttonStyles.put("Home", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Home"), null, null, null, null, null));
        buttonStyles.put("Exit", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Exit"), null, null, null, null, null));
        buttonStyles.put("Continue", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Next"),null, null, null, null, null));
        buttonStyles.put("Feedback", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Feedback"),null, null, null, null, null));

        labelStyles = new HashMap<String, LabelStyle>();
        text = new HashMap<String, Label>();
        labelStyles.put("Black", new LabelStyle(History.getFontTTF().getFont(), Color.BLACK));
        labelStyles.put("White", new LabelStyle(History.getFontTTF().getFont(), Color.WHITE));

        text.put("V1", new Label("", labelStyles.get("White")));
        text.put("V2", new Label("", labelStyles.get("White")));
        text.put("V3", new Label("", labelStyles.get("White")));
        text.put("V4", new Label("", labelStyles.get("White")));
        text.put("Help-1", new Label("", labelStyles.get("Black")));
        text.put("50/50", new Label("", labelStyles.get("Black")));
        text.put("True", new Label("", labelStyles.get("Black")));

        RatioMonitorW = (float) Gdx.graphics.getWidth() / (float) History.WIDTH;
        RatioMonitorH = (float) Gdx.graphics.getHeight() / (float) History.HEIGHT;
    }

    public void onStart() {
        onNomerTesta();

        //onTest(236);
        onTest(random.nextInt(History.getQ_all()));
    }

    public void onTest(int i) {
        if (History.getNomerTesta() > test) {
            onResult();
            return;
        }
        else History.getQuestions().onQuestion(i);
    }

    public void onResult() {
        Gdx.app.log("", "" + History.getPravilno());
        buttons.put("Repeat", new ImageButton(buttonStyles.get("Repeat")));
        buttons.put("Home", new ImageButton(buttonStyles.get("Home")));
        buttons.put("Exit", new ImageButton(buttonStyles.get("Exit")));
        buttons.put("Feedback", new ImageButton(buttonStyles.get("Feedback")));

        text.put("NameQuestion", new Label("* Результат *", labelStyles.get("Black")));
        if (History.getPravilno() >= 0 && History.getPravilno() <= 4) {
            text.put("V1", new Label("Вы - Крестьянин", labelStyles.get("Black")));
            text.put("V2", new Label("Самый низший слой общества. Вы пытае-\nтесь каждый день изо всех сил что-то\n сделать, но все валится из рук.\nРаботая от рассвета до заката, удается\nпрокормить свою любимую жену и пару\nнеугомонных детишек. Если бы не\nсемья, которая постоянно поддерживает,\nне было бы смысла жизни.", labelStyles.get("White")));
            History.getPreference().savePeasant(1);
        }
        else if (History.getPravilno() >= 5 && History.getPravilno() <= 9) {
            text.put("V1", new Label("Вы - Постельничий", labelStyles.get("Black")));
            text.put("V2", new Label("Как интересно легли карты. Вроде бы\nживете, практически, по-княжески, и\nтут же все на волоске. Вы придворный\nцаря, который следит за его усыпаль-\nной. Она должна быть всегда чистой,\nзаправленной и пахнуть свежими цве-\nтами. Если всего этого не будет, то\nне сносить Вам головы.", labelStyles.get("White")));
            History.getPreference().savePostelnichy(1);
        }
        else if (History.getPravilno() >= 10 && History.getPravilno() <= 14) {
            text.put("V1", new Label("Вы - Купец", labelStyles.get("Black")));
            text.put("V2", new Label("Вы тот человек, который повидал на\nсвоем веку множество прекрасных мест\nи разных культур, а Вас почитают не\nхуже местных бояр, да и богатства не\nменьше. Вы можете с легкостью менять\nцены на товары, так как выгодно Вам.\nВот еще немного стараний и быть ува-\nжаемым при царском дворе.", labelStyles.get("White")));
            History.getPreference().saveMerchant(1);
        }
        else if (History.getPravilno() >= 15 && History.getPravilno() <= 17) {
            text.put("V1", new Label("Вы - Боярин", labelStyles.get("Black")));
            text.put("V2", new Label("Вы прошли тяжелый путь, много дости-\nгли в своей жизни и, наконец, князь\nзамечает ваши деяния и назначает вас\nбоярином. Это высший слой феодально-\nго общества, который позволяет ре-\nшать многие вопросы, а так же дает\nбольшую власть. Не останавливайтесь\nи княжество будет в ваших руках.", labelStyles.get("White")));
            History.getPreference().saveBoyarin(1);
        }
        else if (History.getPravilno() >= 18 && History.getPravilno() <= 19) {
            text.put("V1", new Label("Вы - Монарх", labelStyles.get("Black")));
            text.put("V2", new Label("Походу Вам боготворит сама судьба, ведь\nродиться в царской семье - это большая\nудача. По наследству Вам досталось Ве-\nликое процветающее княжество, дальней-\nшая судьба которой будет зависть толь-\nко от Ваших разумных действий. Делайте\nвперед верные шаги, ведь за спиной\nлюбящий народ.", labelStyles.get("White")));
            History.getPreference().saveMonarch(1);
        }
        else if (History.getPravilno() == 20) {
            text.put("V1", new Label("Вы - Государь всея Руси", labelStyles.get("Black")));
            text.put("V2", new Label("Будучи князем, Вы поучаствовали во\nмножестве сухопутных и морских сраже-\nний, расширении своего княжества,\nзаключении мирных договоров. Все это\nне могло пройти мимо Золотой Орды. Они\nщедро оценили все чего вы достигли и\nнарекли Вас великого титула\n\"Государя всея Руси\".", labelStyles.get("White")));
            History.getPreference().savePrince(1);
        }

        History.getPreference().saveMin(History.getPravilno());
        History.getPreference().saveMax(History.getPravilno());
        History.getPreference().saveLast(History.getPravilno());
        History.getPreference().saveAll(1);
        History.getPreference().saveTrue(History.getPravilno());

        History.getAdHandler().toast(new StringBuilder().append("Верных ответов: ").append(History.getPravilno()).append(" из 20"));

        text.get("NameQuestion").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("NameQuestion").getWidth() / 2, (History.HEIGHT - (698 - 85 - 115)) * History.getRatioMonitorH());
        text.get("V1").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V1").getWidth() / 2, (History.HEIGHT - (698 - 15 - 115)) * History.getRatioMonitorH());
        text.get("V2").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V2").getWidth() / 2, 242 * History.getRatioMonitorH());

        buttons.get("Repeat").setSize(160 * History.getRatioMonitorW(), 160 * History.getRatioMonitorH());
        buttons.get("Repeat").setPosition(32 * History.getRatioMonitorW(), 32 * History.getRatioMonitorH());
        buttons.get("Repeat").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                History.setNomerTesta(1);
                History.setPravilno(0);
                History.getQuestions().onALL_1();
                onStageNewDelete();
                onTest(random.nextInt(History.getQ_all()));
            }
        });

        buttons.get("Home").setSize(160 * History.getRatioMonitorW(), 160 * History.getRatioMonitorH());
        buttons.get("Home").setPosition((History.WIDTH / 2 - 160 / 2)* History.getRatioMonitorW(), 32 * History.getRatioMonitorH());
        buttons.get("Home").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                History.getGame().set(new MenuScreen(History.getGame()));
                History.setNomerTesta(1);
                History.setPravilno(0);
                History.getQuestions().onALL_1();
                onStageNewDelete();
                //dispose();
            }
        });

        buttons.get("Exit").setSize(160 * History.getRatioMonitorW(), 160 * History.getRatioMonitorH());
        buttons.get("Exit").setPosition((History.WIDTH - 160 - 32)* History.getRatioMonitorW(),  32 * History.getRatioMonitorH());
        buttons.get("Exit").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.app.exit();
            }
        });

        buttons.get("Feedback").setSize(256 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Feedback").setPosition((History.WIDTH / 2 - 128)* History.getRatioMonitorW(), (History.HEIGHT - 160) * History.getRatioMonitorH());
        buttons.get("Feedback").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("https://play.google.com/store/apps/details?id=studio.rashka.history_specific_rus");
            }
        });

        stage.addActor(text.get("NameQuestion"));
        stage.addActor(text.get("V1"));
        stage.addActor(text.get("V2"));

        stage.addActor(buttons.get("Repeat"));
        stage.addActor(buttons.get("Home"));
        stage.addActor(buttons.get("Exit"));
        stage.addActor(buttons.get("Feedback"));
        Gdx.input.setInputProcessor(stage);
    }

    public void showInfoTrue() {
        text.put("NameQuestion", new Label("* Верный ответ *", labelStyles.get("Black")));
        text.put("V1", new Label(History.getQuestions().getV1(), labelStyles.get("Black")));
        text.put("V2", new Label(History.getQuestions().getV2(), labelStyles.get("White")));
        text.get("V2").setWidth((History.WIDTH - 65) * History.getRatioMonitorW());

        text.get("NameQuestion").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("NameQuestion").getWidth() / 2, (History.HEIGHT - (698 - 85)) * History.getRatioMonitorH());
        text.get("V1").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V1").getWidth() / 2, (History.HEIGHT - (698 - 15)) * History.getRatioMonitorH());
        text.get("V2").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V2").getWidth() / 2, 1110 * History.getRatioMonitorH() - text.get("V2").getPrefHeight());

        buttons.put("Continue", new ImageButton(buttonStyles.get("Continue")));
        buttons.get("Continue").setSize(192 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Continue").setPosition((History.WIDTH / 2 - 96) * History.getRatioMonitorW(), 0);
        buttons.get("Continue").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                isShowTrue = false;
                onStageNewDelete();
                onTest(random.nextInt(History.getQ_all()));
            }
        });

        stage.addActor(text.get("NameQuestion"));
        stage.addActor(text.get("V1"));
        stage.addActor(text.get("V2"));

        stage.addActor(buttons.get("Continue"));
        Gdx.input.setInputProcessor(stage);
    }

    public void onLabelText() {
        text.put("NameQuestion", new Label(History.getQuestions().getNameQuestion(), labelStyles.get("Black")));
        text.put("V1", new Label(History.getQuestions().getV1(), labelStyles.get("White")));
        text.put("V2", new Label(History.getQuestions().getV2(), labelStyles.get("White")));
        text.put("V3", new Label(History.getQuestions().getV3(), labelStyles.get("White")));
        text.put("V4", new Label(History.getQuestions().getV4(), labelStyles.get("White")));

        text.put("Help-1", new Label(new StringBuilder().append(History.getPreference().loadHelpRemove()), labelStyles.get("Black")));
        text.put("50/50", new Label(new StringBuilder().append(History.getPreference().loadHelp50()), labelStyles.get("Black")));
        text.put("True", new Label(new StringBuilder().append(History.getPreference().loadHelpTrue()), labelStyles.get("Black")));
        onLabelTextPosition();
    }

    public void newTextBonus() {
        text.put("Help-1", new Label(new StringBuilder().append(History.getPreference().loadHelpRemove()), labelStyles.get("Black")));
        text.put("50/50", new Label(new StringBuilder().append(History.getPreference().loadHelp50()), labelStyles.get("Black")));
        text.put("True", new Label(new StringBuilder().append(History.getPreference().loadHelpTrue()), labelStyles.get("Black")));
    }

    private void onLabelTextPosition() {
        if (bugFix == 0) {
            text.get("NameQuestion").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("NameQuestion").getWidth() / 2, (History.HEIGHT - (698 + Yq - Xq)) * History.getRatioMonitorH());
            text.get("V1").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V1").getWidth() / 2, (830 + 36) * History.getRatioMonitorH());
            text.get("V2").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V2").getWidth() / 2, (638 + 36) * History.getRatioMonitorH());
            text.get("V3").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V3").getWidth() / 2, (446 + 36) * History.getRatioMonitorH());
            text.get("V4").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V4").getWidth() / 2, (254 + 36) * History.getRatioMonitorH());

            text.get("Help-1").setPosition(320 * History.getRatioMonitorW() - text.get("Help-1").getWidth() / 2, (History.HEIGHT - 96) * History.getRatioMonitorH());
            text.get("50/50").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("50/50").getWidth() / 2, (History.HEIGHT - 224) * History.getRatioMonitorH());
            text.get("True").setPosition((History.WIDTH - 320) * History.getRatioMonitorW() - text.get("True").getWidth() / 2, (History.HEIGHT - 96) * History.getRatioMonitorH());
        }
        else if (bugFix == 1) {
            text.get("NameQuestion").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("NameQuestion").getWidth() / 2, (History.HEIGHT - (698 + Yq - Xq)) * RatioMonitorH);
            text.get("V1").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("V1").getWidth() / 2, (830 + 36) * RatioMonitorH);
            text.get("V2").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("V2").getWidth() / 2, (638 + 36) * RatioMonitorH);
            text.get("V3").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("V3").getWidth() / 2, (446 + 36) * RatioMonitorH);
            text.get("V4").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("V4").getWidth() / 2, (254 + 36) * RatioMonitorH);

            text.get("Help-1").setPosition(320 * RatioMonitorW - text.get("Help-1").getWidth() / 2, (History.HEIGHT - 96) * RatioMonitorH);
            text.get("50/50").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("50/50").getWidth() / 2, (History.HEIGHT - 224) * RatioMonitorH);
            text.get("True").setPosition((History.WIDTH - 320) * RatioMonitorW - text.get("True").getWidth() / 2, (History.HEIGHT - 96) * RatioMonitorH);
            bugFix = 0;
        }
    }

    public void repeatText() {
        onLabelText();

        stageText.addActor(text.get("NameQuestion"));
        stageText.addActor(text.get("V1"));
        stageText.addActor(text.get("V2"));
        stageText.addActor(text.get("V3"));
        stageText.addActor(text.get("V4"));
        stageText.addActor(text.get("TestText"));

        stageText.addActor(text.get("Help-1"));
        stageText.addActor(text.get("50/50"));
        stageText.addActor(text.get("True"));
    }

    public void onAddActor() {
        onNomerTesta();
        onLabelText();

        stageText.addActor(text.get("NameQuestion"));
        stageText.addActor(text.get("V1"));
        stageText.addActor(text.get("V2"));
        stageText.addActor(text.get("V3"));
        stageText.addActor(text.get("V4"));
        stageText.addActor(text.get("TestText"));
        stageText.addActor(text.get("Help-1"));
        stageText.addActor(text.get("50/50"));
        stageText.addActor(text.get("True"));

        stage.addActor(History.getQuestions().getBtn_v1());
        stage.addActor(History.getQuestions().getBtn_v2());
        stage.addActor(History.getQuestions().getBtn_v3());
        stage.addActor(History.getQuestions().getBtn_v4());
        stage.addActor(History.getQuestions().getBtn_Remove());
        stage.addActor(History.getQuestions().getBtn_5050());
        stage.addActor(History.getQuestions().getBtn_True());

        Gdx.input.setInputProcessor(stage);
    }

    public void onNomerTesta() {
        text.put("TestText", new Label(History.getNomerTesta() + " из " + test, labelStyles.get("Black")));
        text.get("TestText").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("TestText").getWidth() / 2, 32 * RatioMonitorH);
    }

    public void onStageNewDelete() {
        try {
            stage.dispose();
            stageText.dispose();
        } catch (IllegalArgumentException e) {
            // может выскочить
        }
        stage = new Stage();
        stageText = new Stage();
    }

    public void onStageNewDeleteText() {
        try {
            stageText.dispose();
        } catch (IllegalArgumentException e) {
            // может выскочить
        }
        stageText = new Stage();
    }

    public Stage getStage() {
        return stage;
    }

    public Stage getStageText() {
        return stageText;
    }

    public void setXq(int xq) {
        Xq = xq;
    }

    public void setYq(int yq) {
        Yq = yq;
    }

    public void setHq(int hq) {
        Hq = hq;
    }

    public int getTest() {
        return test;
    }

    public int getYq() {
        return Yq;
    }

    public int getHq() {
        return Hq;
    }

    public boolean isOn1() {
        return on1;
    }

    public boolean isOn50() {
        return on50;
    }

    public boolean isOnTrue() {
        return onTrue;
    }

    public void setOn1(boolean on1) {
        this.on1 = on1;
    }

    public void setOn50(boolean on50) {
        this.on50 = on50;
    }

    public void setOnTrue(boolean onTrue) {
        this.onTrue = onTrue;
    }

    public boolean isShowTrue() {
        return isShowTrue;
    }

    public void setShowTrue(boolean showTrue) {
        isShowTrue = showTrue;
    }

    public void dispose() {
        /*buttons.clear();
        buttonStyles.clear();
        labelStyles.clear();
        text.clear();*/
    }
}