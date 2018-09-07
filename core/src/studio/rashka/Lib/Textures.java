package studio.rashka.Lib;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Textures {

    private TextureAtlas AtlasTexture;
    private Skin AtlasTextureSkin;

    public Texture icon, pack;
    public Map<String, TextureRegion> textureRegions; //массив регионов

    public Textures() {
        AtlasTexture = new TextureAtlas("buttons.texture");
        AtlasTextureSkin = new Skin(AtlasTexture);
        textureRegions = new HashMap<String, TextureRegion>();
    }

    public Skin getAtlasTextureSkin() {
        return AtlasTextureSkin;
    }

    public void dispose() {
        icon.dispose();
        pack.dispose();

        AtlasTexture.dispose();
        AtlasTextureSkin.dispose();
        textureRegions.clear();
    }
}