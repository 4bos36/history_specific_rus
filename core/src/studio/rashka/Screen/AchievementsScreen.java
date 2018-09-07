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

import java.util.HashMap;
import java.util.Map;

import studio.rashka.History;
import studio.rashka.Lib.Game;
import studio.rashka.Lib.State;

public class AchievementsScreen extends State {

    private Stage stage;

    private Map<String, ImageButtonStyle> buttonStyles;
    private Map<String, ImageButton> buttons;
    private Label text;
    private StringBuilder str = new StringBuilder("Нажмите на иконку");

    public AchievementsScreen(final Game game) {
        super(game);

        stage = new Stage();

        if (History.getPreference().loadPeasant() >= 40) History.getPreference().setPeasant((byte)1);
        if (History.getPreference().loadPostelnichy() >= 40) History.getPreference().setPostelnichy((byte)1);
        if (History.getPreference().loadMerchant() >= 40) History.getPreference().setMerchant((byte)1);
        if (History.getPreference().loadBoyarin() >= 40) History.getPreference().setBoyarin((byte)1);
        if (History.getPreference().loadMonarch() >= 40) History.getPreference().setMonarch((byte)1);
        if (History.getPreference().loadPrince() >= 40) History.getPreference().setPrince((byte)1);
        if (History.getPreference().loadIn() >= 40) History.getPreference().setIn((byte)1);
        if (History.getPreference().loadAll() >= 40) History.getPreference().setAll((byte)1);
        if (History.getPreference().loadTrueOtvet() >= 80) History.getPreference().setTrueOtvet((byte)1);
        if (History.getPreference().loadTrueOtvet() < 80) History.getPreference().setTrueOtvet((byte)0);
        if (History.getPreference().loadStability() == 5) History.getPreference().setStability((byte)1);
        if (History.getPreference().loadLike() >= 1) History.getPreference().setLike((byte)1);
        History.getPreference().saveAllAch();

        buttonStyles = new HashMap<String, ImageButtonStyle>();
        buttons = new HashMap<String, ImageButton>();
        buttonStyles.put("Home", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Home"), null, null, null, null, null));
        buttonStyles.put("NONE", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("NONE"), null, null, null, null, null));

        buttons.put("Home", new ImageButton(buttonStyles.get("Home")));
        buttons.put("Outlaw", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Slave", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Peasant", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Volunteer", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Feudal", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Prince", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("In", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("All", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("TrueOtvet", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Stability", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Like", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("AllAch", new ImageButton(buttonStyles.get("NONE")));

        buttons.get("Home").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Home").setPosition((History.WIDTH / 2 - 128 / 2)* History.getRatioMonitorW(), 16 * History.getRatioMonitorH());
        buttons.get("Home").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new MenuScreen(game));
            }
        });

        /***** ДОСТИЖЕНИЕ КРЕСТЬЯНИН *****/
        buttons.get("Outlaw").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Outlaw").setPosition(64 * History.getRatioMonitorW(), 1216 * History.getRatioMonitorH());
        buttons.get("Outlaw").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadPeasant() < 40) {
                    str = new StringBuilder("Осталось до получения: ");
                    str.append(40 - History.getPreference().loadPeasant());
                }
                else if (History.getPreference().loadPeasant() >= 40) str = new StringBuilder("Крестьянин - низший слой общества");
                stage.clear();
                onRestart();
            }
        });

        /***** ДОСТИЖЕНИЕ РАБ *****/
        buttons.get("Slave").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Slave").setPosition(416 * History.getRatioMonitorW(), 1216 * History.getRatioMonitorH());
        buttons.get("Slave").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadPostelnichy() < 40) {
                    str = new StringBuilder("Осталось до получения: ");
                    str.append(40 - History.getPreference().loadPostelnichy());
                }
                else if (History.getPreference().loadPostelnichy() >= 40) str = new StringBuilder("Постельничий - доверяют даже цари");
                stage.clear();
                onRestart();
            }
        });

        /***** ДОСТИЖЕНИЕ КУПЕЦ *****/
        buttons.get("Peasant").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Peasant").setPosition(768 * History.getRatioMonitorW(), 1216 * History.getRatioMonitorH());
        buttons.get("Peasant").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadMerchant() < 40) {
                    str = new StringBuilder("Осталось до получения: ");
                    str.append(40 - History.getPreference().loadMerchant());
                }
                else if (History.getPreference().loadMerchant() >= 40) str = new StringBuilder("Вы великий купец");
                stage.clear();
                onRestart();
            }
        });

        /***** ДОСТИЖЕНИЕ ВОИН *****/
        buttons.get("Volunteer").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Volunteer").setPosition(64 * History.getRatioMonitorW(), 896 * History.getRatioMonitorH());
        buttons.get("Volunteer").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadBoyarin() < 40) {
                    str = new StringBuilder("Осталось до получения: ");
                    str.append(40 - History.getPreference().loadBoyarin());
                }
                else if (History.getPreference().loadBoyarin() >= 40) str = new StringBuilder("Боготый и уважаемый боярин");
                stage.clear();
                onRestart();
            }
        });

        /***** ДОСТИЖЕНИЕ ФЕОДАЛ *****/
        buttons.get("Feudal").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Feudal").setPosition(416 * History.getRatioMonitorW(), 896 * History.getRatioMonitorH());
        buttons.get("Feudal").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadMonarch() < 40) {
                    str = new StringBuilder("Осталось до получения: ");
                    str.append(40 - History.getPreference().loadMonarch());
                }
                else if (History.getPreference().loadMonarch() >= 40) str = new StringBuilder("Вы монарх Великого княжества");
                stage.clear();
                onRestart();
            }
        });

        /***** ДОСТИЖЕНИЕ КНЯЗЬ *****/
        buttons.get("Prince").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Prince").setPosition(768 * History.getRatioMonitorW(), 896 * History.getRatioMonitorH());
        buttons.get("Prince").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadPrince() < 40) {
                    str = new StringBuilder("Осталось до получения: ");
                    str.append(40 - History.getPreference().loadPrince());
                }
                else if (History.getPreference().loadPrince() >= 40) str = new StringBuilder("Вы Князь всея Руси");
                stage.clear();
                onRestart();
            }
        });

        /***** ДОСТИЖЕНИЕ ЗАПУСК ИГРЫ *****/
        buttons.get("In").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("In").setPosition(64 * History.getRatioMonitorW(), 576 * History.getRatioMonitorH());
        buttons.get("In").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadIn() < 40) {
                    str = new StringBuilder("Осталось до получения: ");
                    str.append(40 - History.getPreference().loadIn());
                }
                else if (History.getPreference().loadIn() >= 40) str = new StringBuilder("Вы тот еще игроман");
                stage.clear();
                onRestart();
            }
        });

        /***** ДОСТИЖЕНИЕ ПРОЙДЕНО ТЕСТОВ *****/
        buttons.get("All").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("All").setPosition(416 * History.getRatioMonitorW(), 576 * History.getRatioMonitorH());
        buttons.get("All").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadAll() < 40) {
                    str = new StringBuilder("Осталось до получения: ");
                    str.append(40 - History.getPreference().loadAll());
                }
                else if (History.getPreference().loadAll() >= 40) str = new StringBuilder("Вот это Вы исторовед");
                stage.clear();
                onRestart();
            }
        });

        /***** ДОСТИЖЕНИЕ ПРОЦЕНТ ВЕРНЫХ ОТВЕТОВ *****/
        buttons.get("TrueOtvet").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("TrueOtvet").setPosition(768 * History.getRatioMonitorW(), 576 * History.getRatioMonitorH());
        buttons.get("TrueOtvet").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadTrueOtvet() < 80) {
                    str = new StringBuilder("Нужно дать больше верных ответов");
                }
                else if (History.getPreference().loadTrueOtvet() >= 80) str = new StringBuilder("Да Вы, Сударь, историк");
                stage.clear();
                onRestart();
            }
        });

        /***** ДОСТИЖЕНИЕ СТАБИЛЬНОСТЬ - 4 подряд одиннаковых результата *****/
        buttons.get("Stability").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Stability").setPosition(64 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Stability").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadStability() != 5) {
                    if (History.getPreference().loadStability() < 4) {
                        str = new StringBuilder("Осталось до получения: ");
                        str.append(4 - History.getPreference().loadStability());
                    } else if (History.getPreference().loadStability() >= 4) {
                        str = new StringBuilder("Стабильность - 4 одинаковых результата");
                        History.getPreference().saveStability(5);
                    }
                    stage.clear();
                    onRestart();
                } else {
                    str = new StringBuilder("Стабильность");
                    stage.clear();
                    onRestart();
                }
            }
        });

        /***** ДОСТИЖЕНИЕ ОЦЕНКА ПРИЛОЖЕНИЯ *****/
        buttons.get("Like").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Like").setPosition(416 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Like").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadLike() < 1) {
                    str = new StringBuilder("Оцените приложение");
                }
                else if (History.getPreference().loadLike() >= 1) str = new StringBuilder("Благодарствую за оценку =)");
                stage.clear();
                onRestart();
            }
        });

        /***** ДОСТИЖЕНИЕ ВСЁ ОТКРЫТО *****/
        buttons.get("AllAch").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("AllAch").setPosition(768 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("AllAch").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadAllAch() < 11) {
                    str = new StringBuilder("Нужно приложить больше усилий");
                }
                else if (History.getPreference().loadAllAch() == 11) str = new StringBuilder("Поистине великий подвиг");
                stage.clear();
                onRestart();
            }
        });

        onRestart();
    }

    private void onRestart() {
        text = new Label(str, new LabelStyle(History.getFontTTF().getFont(), Color.WHITE));
        text.setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.getWidth() / 2, 165 * History.getRatioMonitorH());

        stage.addActor(text);
        stage.addActor(buttons.get("Home"));
        stage.addActor(buttons.get("Outlaw"));
        stage.addActor(buttons.get("Slave"));
        stage.addActor(buttons.get("Peasant"));
        stage.addActor(buttons.get("Volunteer"));
        stage.addActor(buttons.get("Feudal"));
        stage.addActor(buttons.get("Prince"));
        stage.addActor(buttons.get("In"));
        stage.addActor(buttons.get("All"));
        stage.addActor(buttons.get("TrueOtvet"));
        stage.addActor(buttons.get("Stability"));
        stage.addActor(buttons.get("Like"));
        stage.addActor(buttons.get("AllAch"));
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
        sb.draw(History.getTextures().textureRegions.get("black"), 10, 155, History.WIDTH - 20, 75);
        sb.draw(History.getTextures().textureRegions.get("peasant"), 64, 1216, 256, 256);
        sb.draw(History.getTextures().textureRegions.get("postelnichy"), 416, 1216, 256, 256);
        sb.draw(History.getTextures().textureRegions.get("merchant"), 768, 1216, 256, 256);
        sb.draw(History.getTextures().textureRegions.get("boyarin"), 64, 896, 256, 256);
        sb.draw(History.getTextures().textureRegions.get("monarch"), 416, 896, 256, 256);
        sb.draw(History.getTextures().textureRegions.get("prince"), 768, 896, 256, 256);
        sb.draw(History.getTextures().textureRegions.get("In"), 64, 576, 256, 256);
        sb.draw(History.getTextures().textureRegions.get("Done"), 416, 576, 256, 256);
        sb.draw(History.getTextures().textureRegions.get("True"), 768, 576, 256, 256);
        sb.draw(History.getTextures().textureRegions.get("Stability"), 64, 256, 256, 256);
        sb.draw(History.getTextures().textureRegions.get("Like"), 416, 256, 256, 256);
        sb.draw(History.getTextures().textureRegions.get("All"), 768, 256, 256, 256);

        if (History.getPreference().loadPeasant() < 10) {
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 1216, 256, 256);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 1280, 128, 128);
        }
        else if (History.getPreference().loadPeasant() >= 10 && History.getPreference().loadPeasant() < 20) {
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 1216, 256, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 1344, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 1280, 128, 128);
        }
        else if (History.getPreference().loadPeasant() >= 20 && History.getPreference().loadPeasant() < 30) {
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 1216, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 192, 1344, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 1280, 128, 128);
        }
        else if (History.getPreference().loadPeasant() >= 30 && History.getPreference().loadPeasant() < 40) {
            sb.draw(History.getTextures().textureRegions.get("black"), 192, 1344, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 1280, 128, 128);
        }
        /* *** */
        if (History.getPreference().loadPostelnichy() < 10) {
            sb.draw(History.getTextures().textureRegions.get("black"), 416, 1216, 256, 256);
            sb.draw(History.getTextures().textureRegions.get("hide"), 480, 1280, 128, 128);
        }
        else if (History.getPreference().loadPostelnichy() >= 10 && History.getPreference().loadPostelnichy() < 20) {
            sb.draw(History.getTextures().textureRegions.get("black"), 416, 1216, 256, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 416, 1344, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 480, 1280, 128, 128);
        }
        else if (History.getPreference().loadPostelnichy() >= 20 && History.getPreference().loadPostelnichy() < 30) {
            sb.draw(History.getTextures().textureRegions.get("black"), 416, 1216, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 544, 1344, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 480, 1280, 128, 128);
        }
        else if (History.getPreference().loadPostelnichy() >= 30 && History.getPreference().loadPostelnichy() < 40) {
            sb.draw(History.getTextures().textureRegions.get("black"), 544, 1344, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 480, 1280, 128, 128);
        }
        /* *** */
        if (History.getPreference().loadMerchant() < 10) {
            sb.draw(History.getTextures().textureRegions.get("black"), 768, 1216, 256, 256);
            sb.draw(History.getTextures().textureRegions.get("hide"), 832, 1280, 128, 128);
        }
        else if (History.getPreference().loadMerchant() >= 10 && History.getPreference().loadMerchant() < 20) {
            sb.draw(History.getTextures().textureRegions.get("black"), 768, 1216, 256, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 768, 1344, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 832, 1280, 128, 128);
        }
        else if (History.getPreference().loadMerchant() >= 20 && History.getPreference().loadMerchant() < 30) {
            sb.draw(History.getTextures().textureRegions.get("black"), 768, 1216, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 896, 1344, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 832, 1280, 128, 128);
        }
        else if (History.getPreference().loadMerchant() >= 30 && History.getPreference().loadMerchant() < 40) {
            sb.draw(History.getTextures().textureRegions.get("black"), 896, 1344, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 832, 1280, 128, 128);
        }
        /* *** */
        if (History.getPreference().loadBoyarin() < 10) {
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 896, 256, 256);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 960, 128, 128);
        }
        else if (History.getPreference().loadBoyarin() >= 10 && History.getPreference().loadBoyarin() < 20) {
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 896, 256, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 1024, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 960, 128, 128);
        }
        else if (History.getPreference().loadBoyarin() >= 20 && History.getPreference().loadBoyarin() < 30) {
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 896, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 192, 1024, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 960, 128, 128);
        }
        else if (History.getPreference().loadBoyarin() >= 30 && History.getPreference().loadBoyarin() < 40) {
            sb.draw(History.getTextures().textureRegions.get("black"), 192, 1024, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 960, 128, 128);
        }
        /* *** */
        if (History.getPreference().loadMonarch() < 10) {
            sb.draw(History.getTextures().textureRegions.get("black"), 416, 896, 256, 256);
            sb.draw(History.getTextures().textureRegions.get("hide"), 480, 960, 128, 128);
        }
        else if (History.getPreference().loadMonarch() >= 10 && History.getPreference().loadMonarch() < 20) {
            sb.draw(History.getTextures().textureRegions.get("black"), 416, 896, 256, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 416, 1024, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 480, 960, 128, 128);
        }
        else if (History.getPreference().loadMonarch() >= 20 && History.getPreference().loadMonarch() < 30) {
            sb.draw(History.getTextures().textureRegions.get("black"), 416, 896, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 544, 1024, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 480, 960, 128, 128);
        }
        else if (History.getPreference().loadMonarch() >= 30 && History.getPreference().loadMonarch() < 40) {
            sb.draw(History.getTextures().textureRegions.get("black"), 544, 1024, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 480, 960, 128, 128);
        }
        /* *** */
        if (History.getPreference().loadPrince() < 10) {
            sb.draw(History.getTextures().textureRegions.get("black"), 768, 896, 256, 256);
            sb.draw(History.getTextures().textureRegions.get("hide"), 832, 960, 128, 128);
        }
        else if (History.getPreference().loadPrince() >= 10 && History.getPreference().loadPrince() < 20) {
            sb.draw(History.getTextures().textureRegions.get("black"), 768, 896, 256, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 768, 1024, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 832, 960, 128, 128);
        }
        else if (History.getPreference().loadPrince() >= 20 && History.getPreference().loadPrince() < 30) {
            sb.draw(History.getTextures().textureRegions.get("black"), 768, 896, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 896, 1024, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 832, 960, 128, 128);
        }
        else if (History.getPreference().loadPrince() >= 30 && History.getPreference().loadPrince() < 40) {
            sb.draw(History.getTextures().textureRegions.get("black"), 896, 1024, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 832, 960, 128, 128);
        }
        /* *** */
        if (History.getPreference().loadIn() < 10) {
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 576, 256, 256);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 640, 128, 128);
        }
        else if (History.getPreference().loadIn() >= 10 && History.getPreference().loadIn() < 20) {
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 576, 256, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 704, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 640, 128, 128);
        }
        else if (History.getPreference().loadIn() >= 20 && History.getPreference().loadIn() < 30) {
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 576, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 192, 704, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 640, 128, 128);
        }
        else if (History.getPreference().loadIn() >= 30 && History.getPreference().loadIn() < 40) {
            sb.draw(History.getTextures().textureRegions.get("black"), 192, 704, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 640, 128, 128);
        }
        /* *** */
        if (History.getPreference().loadAll() < 10) {
            sb.draw(History.getTextures().textureRegions.get("black"), 416, 576, 256, 256);
            sb.draw(History.getTextures().textureRegions.get("hide"), 480, 640, 128, 128);
        }
        else if (History.getPreference().loadAll() >= 10 && History.getPreference().loadAll() < 20) {
            sb.draw(History.getTextures().textureRegions.get("black"), 416, 576, 256, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 416, 704, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 480, 640, 128, 128);
        }
        else if (History.getPreference().loadAll() >= 20 && History.getPreference().loadAll() < 30) {
            sb.draw(History.getTextures().textureRegions.get("black"), 416, 576, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 544, 704, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 480, 640, 128, 128);
        }
        else if (History.getPreference().loadAll() >= 30 && History.getPreference().loadAll() < 40) {
            sb.draw(History.getTextures().textureRegions.get("black"), 544, 704, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 480, 640, 128, 128);
        }
        /* *** */
        if (History.getPreference().loadTrueOtvet() < 80) {
            sb.draw(History.getTextures().textureRegions.get("black"), 768, 576, 256, 256);
            sb.draw(History.getTextures().textureRegions.get("hide"), 832, 640, 128, 128);
        }
        /* *** */
        if (History.getPreference().loadStability() < 1) {
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 256, 256, 256);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 320, 128, 128);
        }
        else if (History.getPreference().loadStability() == 1) {
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 256, 256, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 384, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 320, 128, 128);
        }
        else if (History.getPreference().loadStability() == 2) {
            sb.draw(History.getTextures().textureRegions.get("black"), 64, 256, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 192, 384, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 320, 128, 128);
        }
        else if (History.getPreference().loadStability() == 3) {
            sb.draw(History.getTextures().textureRegions.get("black"), 192, 384, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 128, 320, 128, 128);
        }
        /* *** */
        if (History.getPreference().loadLike() < 1) {
            sb.draw(History.getTextures().textureRegions.get("black"), 416, 256, 256, 256);
            sb.draw(History.getTextures().textureRegions.get("hide"), 480, 320, 128, 128);
        }
        /* *** */
        if (History.getPreference().loadAllAch() < 1) {
            sb.draw(History.getTextures().textureRegions.get("black"), 768, 256, 256, 256);
            sb.draw(History.getTextures().textureRegions.get("hide"), 832, 320, 128, 128);
        }
        else if (History.getPreference().loadAllAch() >= 1 && History.getPreference().loadAllAch() < 4) {
            sb.draw(History.getTextures().textureRegions.get("black"), 768, 256, 256, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 768, 384, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 832, 320, 128, 128);
        }
        else if (History.getPreference().loadAllAch() >= 4 && History.getPreference().loadAllAch() < 7) {
            sb.draw(History.getTextures().textureRegions.get("black"), 768, 256, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("black"), 896, 384, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 832, 320, 128, 128);
        }
        else if (History.getPreference().loadAllAch() >= 7 && History.getPreference().loadAllAch() < 11) {
            sb.draw(History.getTextures().textureRegions.get("black"), 896, 384, 128, 128);
            sb.draw(History.getTextures().textureRegions.get("hide"), 832, 320, 128, 128);
        }
        sb.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        text.remove();
        buttons.clear();
        buttonStyles.clear();
    }
}