package studio.rashka.Screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

import studio.rashka.History;
import studio.rashka.Lib.Game;
import studio.rashka.Lib.State;

public class LoadScreen extends State {

    private static final int MAX = 80; // полная загрузка
    private byte i = 0; // индекс процесса загрузки

    private Stage stage;

    public LoadScreen(Game game) {
        super(game);
        stage = new Stage();
        History.getPreference().saveIn(1);

        History.getTextures().icon = new Texture("btn.png");
        History.getTextures().textureRegions.put("logo", new TextureRegion(History.getTextures().icon, 704, 0, 960, 640));
        History.getTextures().textureRegions.put("name", new TextureRegion(History.getTextures().icon, 704, 640, 832, 256));
        History.getTextures().textureRegions.put("Click", new TextureRegion(History.getTextures().icon, 640, 448, 64, 64));
    }

    private void loadTextures() {
        History.getTextures().pack = new Texture("texture.jpg");

        History.getTextures().textureRegions.put("black", new TextureRegion(History.getTextures().icon, 32, 32, 8, 8));
        History.getTextures().textureRegions.put("white", new TextureRegion(History.getTextures().icon, 576, 448, 32, 32));
        History.getTextures().textureRegions.put("hide", new TextureRegion(History.getTextures().icon, 576, 192, 128, 128));
        History.getTextures().textureRegions.put("time", new TextureRegion(History.getTextures().icon, 576, 320, 128, 128));
        History.getTextures().textureRegions.put("fon", new TextureRegion(History.getTextures().pack, 1, 1, 1080, 1920));

        History.getTextures().textureRegions.put("Remove", new TextureRegion(History.getTextures().icon, 1664, 0, 128, 128));
        History.getTextures().textureRegions.put("5050", new TextureRegion(History.getTextures().icon, 1792, 0, 128, 128));
        History.getTextures().textureRegions.put("HelpTrue", new TextureRegion(History.getTextures().icon, 1664, 128, 128, 128));
        History.getTextures().textureRegions.put("Add", new TextureRegion(History.getTextures().icon, 1792, 128, 128, 128));
        History.getTextures().textureRegions.put("RemoveNO", new TextureRegion(History.getTextures().icon, 1664, 256, 128, 128));
        History.getTextures().textureRegions.put("5050NO", new TextureRegion(History.getTextures().icon, 1792, 256, 128, 128));
        History.getTextures().textureRegions.put("HelpTrueNO", new TextureRegion(History.getTextures().icon, 1664, 384, 128, 128));

        History.getTextures().textureRegions.put("peasant", new TextureRegion(History.getTextures().pack, 1659, 1155, 576, 576));
        History.getTextures().textureRegions.put("postelnichy", new TextureRegion(History.getTextures().pack, 1659, 578, 576, 576));
        History.getTextures().textureRegions.put("merchant", new TextureRegion(History.getTextures().pack, 1659, 1, 576, 576));
        History.getTextures().textureRegions.put("boyarin", new TextureRegion(History.getTextures().pack, 1082, 1155, 576, 576));
        History.getTextures().textureRegions.put("monarch", new TextureRegion(History.getTextures().pack, 1082, 578, 576, 576));
        History.getTextures().textureRegions.put("prince", new TextureRegion(History.getTextures().pack, 1082, 1, 576, 576));

        History.getTextures().textureRegions.put("In", new TextureRegion(History.getTextures().pack, 2236, 772, 256, 256));
        History.getTextures().textureRegions.put("Done", new TextureRegion(History.getTextures().pack, 2236, 1029, 256, 256));
        History.getTextures().textureRegions.put("True", new TextureRegion(History.getTextures().pack, 2236, 1, 256, 256));
        History.getTextures().textureRegions.put("Stability", new TextureRegion(History.getTextures().pack, 2236, 258, 256, 256));
        History.getTextures().textureRegions.put("Like", new TextureRegion(History.getTextures().pack, 2236, 515, 256, 256));
        History.getTextures().textureRegions.put("All", new TextureRegion(History.getTextures().pack, 2236, 1286, 256, 256));
    }

    @Override
    public void update(float deltaTime) {
        i++;
        if (i == 20) loadTextures();
        if (i == MAX) game.set(new MenuScreen(game));
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(History.getTextures().textureRegions.get("logo"), History.WIDTH / 2 - History.getTextures().textureRegions.get("logo").getRegionWidth() / 4, History.WIDTH + 128,
                History.getTextures().textureRegions.get("logo").getRegionWidth() / 2, History.getTextures().textureRegions.get("logo").getRegionHeight() / 2);
        sb.draw(History.getTextures().textureRegions.get("name"), History.WIDTH / 2 - History.getTextures().textureRegions.get("name").getRegionWidth() / 2, History.HEIGHT / 2 - 96);
        sb.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}