package studio.rashka.Lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Preference {

    private Preferences setting;
    private byte peasant = 0, postelnichy = 0, merchant = 0, boyarin = 0, monarch = 0, prince = 0, in = 0, all = 0,
            trueOtvet = 0, stability = 0, like = 0;

    public Preference() {
        setting = Gdx.app.getPreferences("Pref_app"); // настройки приложения
        //setting.clear(); // если изменили тип данных, то разкомментировать, запускаем и комментируем обратно, т.е. обнуляем всё

        boolean start_pref = setting.getBoolean("Start_Pref");
        boolean startHelpBonus = setting.getBoolean("HelpBonus");
        if (!startHelpBonus) {
            setting.putInteger("HelpRemove", 5);
            setting.putInteger("Help50", 5);
            setting.putInteger("HelpTrue", 5);
            setting.putBoolean("HelpBonus", true); // сообщаем, что уже получены бонусы
            saveSetting();
        }
        if (!start_pref) { // если запускается в первые, то запускаем параметры по умолчанию
            saveSound(1);
            saveMusic(1);
            setting.putInteger("Min", 20); // минимальный балл
            setting.putInteger("Max", 0); // максимальный балл
            setting.putInteger("Last", 0); // баллов за последний тест
            setting.putInteger("All", 0); // всего пройдено тестов
            setting.putInteger("True", 0); // верных ответов
            //saveLanguage(0);
            setting.putBoolean("Start_Pref", true); // сообщаем, что приложение уже было запущено
            saveSetting();
        }
    }

    private void saveSetting() { // внесение изменений в настройки
        setting.flush();
    }

    public int width() {
        return setting.getInteger("Width");
    }

    public int height() {
        return setting.getInteger("Height");
    }

    public void saveSound(int on_off) { // сохраняем настройки звуков
        setting.putInteger("Sound", on_off);
        saveSetting();
    }

    public int loadSound() { // загружаем настройки звуков
        return setting.getInteger("Sound");
    }

    public void saveMusic(int on_off) { // сохраняем настройки музыки
        setting.putInteger("Music", on_off);
        saveSetting();
    }

    public boolean loadTimeRun() {
        return setting.getBoolean("RunTime");
    }

    public void saveTimeRun(boolean run) {
        setting.putBoolean("RunTime", run);
        saveSetting();
    }

    public boolean loadBonus() {
        return setting.getBoolean("Bonus");
    }

    public void setBonus(boolean bonus) {
        setting.putBoolean("Bonus", bonus);
    }

    /***** Подсказки *****/

    public int loadHelpRemove() {
        return setting.getInteger("HelpRemove");
    }

    public void saveHelpRemove(int plus, int minus) {
        setting.putInteger("HelpRemove", loadHelpRemove() + plus - minus);
        saveSetting();
    }

    public int loadHelp50() {
        return setting.getInteger("Help50");
    }

    public void saveHelp50(int plus, int minus) {
        setting.putInteger("Help50", loadHelp50() + plus - minus);
        saveSetting();
    }

    public int loadHelpTrue() {
        return setting.getInteger("HelpTrue");
    }

    public void saveHelpTrue(int plus, int minus) {
        setting.putInteger("HelpTrue", loadHelpTrue() + plus - minus);
        saveSetting();
    }

    /***** МИНИМУМ *****/

    public int loadMin() {
        return setting.getInteger("Min");
    }

    public void saveMin(int min) {
        if (loadMin() > min) {
            setting.putInteger("Min", min);
            saveSetting();
        }
        if (min == 0) {
            setting.putInteger("Min", min);
            saveSetting();
        }
    }

    /***** МАКСИМУМ *****/

    public int loadMax() {
        return setting.getInteger("Max");
    }

    public void saveMax(int max) {
        if (loadMax() < max) {
            setting.putInteger("Max", max);
            saveSetting();
        }
        if (max == 20) {
            setting.putInteger("Max", max);
            saveSetting();
        }
    }

    /***** ПОСЛЕДНИЙ *****/

    public int loadLast() {
        return setting.getInteger("Last");
    }

    public void saveLast(int last) {
        setting.putInteger("Last", last);
        saveSetting();
    }

    /***** ВСЕГО *****/

    public int loadAll() {
        return setting.getInteger("All");
    }

    public void saveAll(int all) {
        int x;
        x = loadAll() + all;
        setting.putInteger("All", x);
        saveSetting();
    }

    /***** ВСЕГО ВЕРНЫХ ОТВЕТОВ *****/

    public int loadTrue() {
        return setting.getInteger("True");
    }

    public void saveTrue(int True) {
        int x;
        x = loadTrue() + True;
        setting.putInteger("True", x);
        saveSetting();
    }

    /***** ДОСТИЖЕНИЕ КРЕСТЬЯНИН *****/

    public int loadPeasant() {
        return setting.getInteger("Peasant");
    }

    public void savePeasant(int True) {
        int x;
        x = loadPeasant() + True;
        setting.putInteger("Peasant", x);
        saveSetting();
    }

    /***** ДОСТИЖЕНИЕ РАБ *****/

    public int loadPostelnichy() {
        return setting.getInteger("Postelnichy");
    }

    public void savePostelnichy(int True) {
        int x;
        x = loadPostelnichy() + True;
        setting.putInteger("Postelnichy", x);
        saveSetting();
    }

    /***** ДОСТИЖЕНИЕ КУПЕЦ *****/

    public int loadMerchant() {
        return setting.getInteger("Merchant");
    }

    public void saveMerchant(int True) {
        int x;
        x = loadMerchant() + True;
        setting.putInteger("Merchant", x);
        saveSetting();
    }

    /***** ДОСТИЖЕНИЕ БОЯРИН *****/

    public int loadBoyarin() {
        return setting.getInteger("Boyarin");
    }

    public void saveBoyarin(int True) {
        int x;
        x = loadBoyarin() + True;
        setting.putInteger("Boyarin", x);
        saveSetting();
    }

    /***** ДОСТИЖЕНИЕ МОНАРХ *****/

    public int loadMonarch() {
        return setting.getInteger("Monarch");
    }

    public void saveMonarch(int True) {
        int x;
        x = loadMonarch() + True;
        setting.putInteger("Monarch", x);
        saveSetting();
    }

    /***** ДОСТИЖЕНИЕ КНЯЗЬ *****/

    public int loadPrince() {
        return setting.getInteger("Prince");
    }

    public void savePrince(int True) {
        int x;
        x = loadPrince() + True;
        setting.putInteger("Prince", x);
        saveSetting();
    }

    /***** ДОСТИЖЕНИЕ ЗАПУСК ИГРЫ *****/

    public int loadIn() {
        return setting.getInteger("In");
    }

    public void saveIn(int True) {
        int x;
        x = loadIn() + True;
        setting.putInteger("In", x);
        saveSetting();
    }

    /***** ДОСТИЖЕНИЕ ПРОЦЕНТ ВЕРНЫХ ОТВЕТОВ *****/

    public int loadTrueOtvet() {
		if (loadTrue() != 0 && loadAll() != 0) return (loadTrue() / (loadAll() * 20)) * 100;
		else return 0;
    }

    /***** ДОСТИЖЕНИЕ СТАБИЛЬНОСТЬ - 4 подряд одиннаковых результата *****/

    public int loadStability() {
        return setting.getInteger("Stability");
    }

    public void saveStability(int True) {
        int x;
        if (True == 5) x = True;
        else if (loadTrue() == True) x = loadStability() + 1;
        else x = 0;
        setting.putInteger("Stability", x);
        saveSetting();
    }

    /***** ДОСТИЖЕНИЕ ОЦЕНКА ПРИЛОЖЕНИЯ *****/

    public int loadLike() {
        return setting.getInteger("Like");
    }

    public void saveLike(int True) {
        int x;
        x = loadLike() + True;
        setting.putInteger("Like", x);
        saveSetting();
    }

    /***** ДОСТИЖЕНИЕ ВСЁ ОТКРЫТО *****/

    public int loadAllAch() {
        return setting.getInteger("AllAch");
    }

    public void saveAllAch() {
        int x;
        x = peasant + postelnichy + merchant + boyarin + monarch + prince + in + all + trueOtvet + stability + like;
        setting.putInteger("AllAch", x);
        saveSetting();
    }

    public int loadMusic() { // загружаем настройки музыки
        return setting.getInteger("Music");
    }

    public void setPeasant(byte peasant) {
        this.peasant = peasant;
    }

    public void setPostelnichy(byte postelnichy) {
        this.postelnichy = postelnichy;
    }

    public void setMerchant(byte merchant) {
        this.merchant = merchant;
    }

    public void setBoyarin(byte boyarin) {
        this.boyarin = boyarin;
    }

    public void setMonarch(byte monarch) {
        this.monarch = monarch;
    }

    public void setPrince(byte prince) {
        this.prince = prince;
    }

    public void setIn(byte in) {
        this.in = in;
    }

    public void setAll(byte all) {
        this.all = all;
    }

    public void setTrueOtvet(byte trueOtvet) {
        this.trueOtvet = trueOtvet;
    }

    public void setStability(byte stability) {
        this.stability = stability;
    }

    public void setLike(byte like) {
        this.like = like;
    }
}