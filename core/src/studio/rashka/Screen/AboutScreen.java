package studio.rashka.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.StringBuilder;

import java.util.HashMap;
import java.util.Map;

import studio.rashka.History;
import studio.rashka.Lib.Game;
import studio.rashka.Lib.State;

public class AboutScreen extends State {

    private Stage stage;
    private Map<String, ImageButtonStyle> buttonStyles;
    private Map<String, ImageButton> buttons;
    private Map<String, Label> text;

    public AboutScreen(final Game game) {
        super(game);

        stage = new Stage();
        buttonStyles = new HashMap<String, ImageButtonStyle>();
        buttons = new HashMap<String, ImageButton>();

        buttonStyles.put("Home", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Home"), null, null, null, null, null));
        buttonStyles.put("Rate", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Rate"), null, null, null, null, null));
        buttonStyles.put("Logo", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Logo"), null, null, null, null, null));
        buttonStyles.put("DownloadApp", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("DownloadApp"), null, null, null, null, null));

        buttons.put("Home", new ImageButton(buttonStyles.get("Home")));
        buttons.put("Rate", new ImageButton(buttonStyles.get("Rate")));
        buttons.put("Logo", new ImageButton(buttonStyles.get("Logo")));
        buttons.put("DownloadApp", new ImageButton(buttonStyles.get("DownloadApp")));

        buttons.get("Home").setSize(160 * History.getRatioMonitorW(), 160 * History.getRatioMonitorH());
        buttons.get("Home").setPosition((History.WIDTH / 2 - 160 / 2) * History.getRatioMonitorW(), 64 * History.getRatioMonitorH());
        buttons.get("Home").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new MenuScreen(game));
            }
        });

        buttons.get("Rate").setSize(480 * History.getRatioMonitorW(), 288 * History.getRatioMonitorH());
        buttons.get("Rate").setPosition((History.WIDTH / 2 - 480 / 2) * History.getRatioMonitorW(), 300 * History.getRatioMonitorH());
        buttons.get("Rate").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("https://play.google.com/store/apps/details?id=studio.rashka.history_specific_rus");
                if (History.getPreference().loadLike() != 1) History.getPreference().saveLike(1);
            }
        });

        buttons.get("Logo").setSize(History.getTextures().textureRegions.get("logo").getRegionWidth() / 3 * History.getRatioMonitorW(), History.getTextures().textureRegions.get("logo").getRegionHeight() / 3 * History.getRatioMonitorH());
        buttons.get("Logo").setPosition((History.WIDTH / 2 - History.getTextures().textureRegions.get("logo").getRegionWidth() / 6) * History.getRatioMonitorW(), (1070 - History.getTextures().textureRegions.get("logo").getRegionWidth() / 6) * History.getRatioMonitorH());
        buttons.get("Logo").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("http://rashka.studio/");
            }
        });

        buttons.get("DownloadApp").setSize(192 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
        buttons.get("DownloadApp").setPosition((History.WIDTH / 2 + 128) * History.getRatioMonitorW(), (History.HEIGHT - 680) * History.getRatioMonitorH());
        buttons.get("DownloadApp").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("https://play.google.com/store/apps/details?id=studio.rashka.history_IX_XIII");
            }
        });

        text = new HashMap<String, Label>();

        text.put("ALL", new Label(new StringBuilder().append("Всего вопросов: ").append(History.getQ_all() - 1), new LabelStyle(History.getFontTTF().getFont(), Color.WHITE)));
        text.get("ALL").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("ALL").getWidth() / 2, 768 * History.getRatioMonitorH());

        text.put("about", new Label("Разработчик: Табаков Юрий", new LabelStyle(History.getFontTTF().getFont(), Color.WHITE)));
        text.put("version", new Label(History.getLanguage().version, new LabelStyle(History.getFontTTF().getFont(), Color.WHITE)));
        text.put("app", new Label("Понравилось?\nСкачивай еще!", new LabelStyle(History.getFontTTF().getFont(), Color.WHITE)));
        text.get("about").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("about").getWidth() / 2, 832 * History.getRatioMonitorH());
        text.get("version").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("version").getWidth() / 2, 704 * History.getRatioMonitorH());
        text.get("app").setPosition(240 * History.getRatioMonitorW(), (History.HEIGHT - 640) * History.getRatioMonitorH());

        stage.addActor(text.get("about"));
        stage.addActor(text.get("version"));
        stage.addActor(text.get("app"));
        stage.addActor(text.get("ALL"));
        stage.addActor(buttons.get("Home"));
        stage.addActor(buttons.get("Rate"));
        stage.addActor(buttons.get("Logo"));
        stage.addActor(buttons.get("DownloadApp"));

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(History.getTextures().textureRegions.get("fon"), 0, 0, History.WIDTH, History.HEIGHT);
        sb.draw(History.getTextures().textureRegions.get("name"), History.WIDTH / 2 - History.getTextures().textureRegions.get("name").getRegionWidth() / 2, History.HEIGHT - History.getTextures().textureRegions.get("name").getRegionWidth() / 2 - 80);
        sb.draw(History.getTextures().textureRegions.get("black"), History.WIDTH / 2 - 764 / 2, 672, 764, 496);
        sb.draw(History.getTextures().textureRegions.get("black"), History.WIDTH / 2 - 764 / 2, History.HEIGHT - 710, 764, 252);
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
            text.clear();
        } catch (NullPointerException e) {
            // защита от дурака
        }
    }
}