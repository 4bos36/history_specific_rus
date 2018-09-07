package studio.rashka.Lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.StringBuilder;

import studio.rashka.History;

public class FontTTF {

    private static final String FONT_NAME = "fonts/tt6804m.ttf"; // расположение шрифта
    private FreeTypeFontGenerator generator;
    private FreeTypeFontParameter parameter;
    private BitmapFont font;

    private StringBuilder FONT_CHARS;
    private float RatioMonitor;

    public FontTTF() {
        generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_NAME));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        RatioMonitor = (float) Gdx.graphics.getWidth() / (float) History.WIDTH; // коэффициент масштаба графики

        FONT_CHARS = new StringBuilder("");

        for (int i = 32; i < 127; i++) FONT_CHARS.append((char)i);
        for (int i = 1024; i < 1104; i++) FONT_CHARS.append((char)i); // русские символы

        parameter.size = (int)(48 * RatioMonitor);
        parameter.characters = FONT_CHARS.toString(); // заполняем массив символами рус и остальные
        font = generator.generateFont(parameter);
    }

    public BitmapFont getFont() {
        return font;
    }

    public void dispose() {
        generator.dispose();
        font.dispose();
        parameter = null;
    }
}