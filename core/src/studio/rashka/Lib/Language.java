package studio.rashka.Lib;

import com.badlogic.gdx.utils.StringBuilder;

public class Language {

    public StringBuilder version;

    public Language() {
        version = new StringBuilder("Версия 1.0.5 (сборка 8)");
    }

    public void dispose() {
        version.setLength(0);
    }
}