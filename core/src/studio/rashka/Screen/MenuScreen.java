package studio.rashka.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;

import java.util.HashMap;
import java.util.Map;

import studio.rashka.History;
import studio.rashka.Lib.Game;
import studio.rashka.Lib.State;

public class MenuScreen extends State {

    private Stage stage;

    private Map<String, ImageButtonStyle> buttonStyles;
    private Map<String, ImageButton> buttons;
    private ImageButton btn_mus;
    private ImageButtonStyle btn_mus_style;

    public MenuScreen(final Game game) {
        super(game);

        stage = new Stage();

        History.setLoadMusic((byte)1);
        buttonStyles = new HashMap<String, ImageButtonStyle>();
        buttons = new HashMap<String, ImageButton>();
        buttonStyles.put("Start", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Start"), null, null, null, null, null));
        buttonStyles.put("Stat", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Stat"), null, null, null, null, null));
        buttonStyles.put("Exit", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Exit"), null, null, null, null, null));
        buttonStyles.put("About", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("About"), null, null, null, null, null));
        buttonStyles.put("Help", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Help"), null, null, null, null, null));
        buttonStyles.put("Achievements", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Achievements"), null, null, null, null, null));

        buttons.put("Start", new ImageButton(buttonStyles.get("Start")));
        buttons.put("Stat", new ImageButton(buttonStyles.get("Stat")));
        buttons.put("Exit", new ImageButton(buttonStyles.get("Exit")));
        buttons.put("About", new ImageButton(buttonStyles.get("About")));
        buttons.put("Help", new ImageButton(buttonStyles.get("Help")));
        buttons.put("Achievements", new ImageButton(buttonStyles.get("Achievements")));

        /********** КНОПКА НАЧАЛО ИГРЫ **********/
        buttons.get("Start").setSize(704 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
        buttons.get("Start").setPosition((History.WIDTH / 2 - 704 / 2) * History.getRatioMonitorW(), 736 * History.getRatioMonitorH());
        buttons.get("Start").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new StartTestScreen(game));
            }
        });

        /********** КНОПКА СТАТИСТИКИ **********/
        buttons.get("Stat").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Stat").setPosition((History.WIDTH / 2 - 128 / 2 - 208) * History.getRatioMonitorW(), (History.HEIGHT - History.getTextures().textureRegions.get("name").getRegionWidth() / 2 - 192) * History.getRatioMonitorH());
        buttons.get("Stat").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new StatScreen(game));
            }
        });

        /********** КНОПКА ВЫХОДА **********/
        buttons.get("Exit").setSize(160 * History.getRatioMonitorW(), 160 * History.getRatioMonitorH());
        buttons.get("Exit").setPosition((History.WIDTH / 2 - 160 / 2) * History.getRatioMonitorW(), 64 * History.getRatioMonitorH());
        buttons.get("Exit").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.app.exit();
                //System.exit(0);
            }
        });

        /********** КНОПКА МУЗЫКИ **********/

        btn_mus_style = new ImageButton.ImageButtonStyle(); // свойства кнопок
        if (History.getPreference().loadMusic() == 1) btn_mus_style.up = History.getTextures().getAtlasTextureSkin().getDrawable("MusOn");
        if (History.getPreference().loadMusic() == 0) btn_mus_style.up = History.getTextures().getAtlasTextureSkin().getDrawable("MusOff");

        btn_mus = new ImageButton(btn_mus_style);
        btn_mus.setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        btn_mus.setPosition((History.WIDTH / 2 - 128 / 2) * History.getRatioMonitorW(), (History.HEIGHT - History.getTextures().textureRegions.get("name").getRegionWidth() / 2 - 192) * History.getRatioMonitorH());
        btn_mus.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                switch (History.getPreference().loadMusic()) {
                    case 0:
                        History.getPreference().saveMusic(1);
                        History.getPreference().saveSound(1);
                        btn_mus_style.up = History.getTextures().getAtlasTextureSkin().getDrawable("MusOn");
                        History.setLoadMusic((byte)1);
                        break;
                    case 1:
                        History.getPreference().saveMusic(0);
                        History.getPreference().saveSound(0);
                        btn_mus_style.up = History.getTextures().getAtlasTextureSkin().getDrawable("MusOff");
                        History.setLoadMusic((byte)1);
                        break;
                }
            }
        });

        /********** КНОПКА О НАС **********/
        buttons.get("About").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("About").setPosition(64 * History.getRatioMonitorW(), (History.HEIGHT - History.getTextures().textureRegions.get("name").getRegionWidth() / 2 - 192) * History.getRatioMonitorH());
        buttons.get("About").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new AboutScreen(game));
            }
        });

        /********** КНОПКА ПОМОЩЬ **********/
        buttons.get("Help").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Help").setPosition((History.WIDTH - 192)* History.getRatioMonitorW(), (History.HEIGHT - History.getTextures().textureRegions.get("name").getRegionWidth() / 2 - 192) * History.getRatioMonitorH());
        buttons.get("Help").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new HelpScreen(game));
            }
        });

        /********** КНОПКА ДОСТИЖЕНИЯ **********/
        buttons.get("Achievements").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Achievements").setPosition((History.WIDTH / 2 - 128 / 2 + 208) * History.getRatioMonitorW(), (History.HEIGHT - History.getTextures().textureRegions.get("name").getRegionWidth() / 2 - 192) * History.getRatioMonitorH());
        buttons.get("Achievements").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new AchievementsScreen(game));
            }
        });

        social();

        stage.addActor(buttons.get("Start"));
        stage.addActor(buttons.get("Stat"));
        stage.addActor(buttons.get("Exit"));
        stage.addActor(btn_mus);
        stage.addActor(buttons.get("About"));
        stage.addActor(buttons.get("Help"));
        stage.addActor(buttons.get("Achievements"));
        Gdx.input.setInputProcessor(stage);
    }

    private void social() {
        buttonStyles.put("Facebook", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Facebook"), null, null, null, null, null));
        buttonStyles.put("VK", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("VK"), null, null, null, null, null));
        buttonStyles.put("Twitter", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Twitter"), null, null, null, null, null));
        buttonStyles.put("GooglePlus", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("GooglePlus"), null, null, null, null, null));

        buttons.put("Facebook", new ImageButton(buttonStyles.get("Facebook")));
        buttons.put("VK", new ImageButton(buttonStyles.get("VK")));
        buttons.put("Twitter", new ImageButton(buttonStyles.get("Twitter")));
        buttons.put("GooglePlus", new ImageButton(buttonStyles.get("GooglePlus")));

        buttons.get("Facebook").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Facebook").setPosition((History.WIDTH / 2 - 352) * History.getRatioMonitorW(), 300 * History.getRatioMonitorH());
        buttons.get("Facebook").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("https://www.facebook.com/groups/rashka.studio/");
            }
        });

        buttons.get("VK").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("VK").setPosition((History.WIDTH / 2 - 160) * History.getRatioMonitorW(), 300 * History.getRatioMonitorH());
        buttons.get("VK").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("https://vk.com/rashka.studio");
            }
        });

        buttons.get("Twitter").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Twitter").setPosition((History.WIDTH / 2 + 32) * History.getRatioMonitorW(), 300 * History.getRatioMonitorH());
        buttons.get("Twitter").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("https://twitter.com/rashka_studio/");
            }
        });

        buttons.get("GooglePlus").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("GooglePlus").setPosition((History.WIDTH / 2 + 224) * History.getRatioMonitorW(), 300 * History.getRatioMonitorH());
        buttons.get("GooglePlus").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("https://plus.google.com/communities/117036335723806113531/");
            }
        });

        stage.addActor(buttons.get("Facebook"));
        stage.addActor(buttons.get("VK"));
        stage.addActor(buttons.get("Twitter"));
        stage.addActor(buttons.get("GooglePlus"));
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(History.getTextures().textureRegions.get("fon"), 0, 0, History.WIDTH, History.HEIGHT);
        sb.draw(History.getTextures().textureRegions.get("name"), History.WIDTH / 2 - History.getTextures().textureRegions.get("name").getRegionWidth() / 2, History.HEIGHT - History.getTextures().textureRegions.get("name").getRegionWidth() / 2 - 80);
        sb.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        try {
            stage.dispose();
            buttons.clear();
            buttonStyles.clear();
            btn_mus.remove();
        } catch (Exception e) {
            // защита от дурака
        }
    }
}