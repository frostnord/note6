package com.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.note.Note;
import com.note.game.Assets;
import com.note.utils.Constants;
import com.note.utils.GamePreferences;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import java.util.ArrayList;

/**
 * Created by 1 on 29.03.2015.
 */
public class ScripPackScreen extends AbstractGameScreen {

    private int Height;

    private int Width;

    private Table layerBackground;
    private Image imgBackground;
    //    private TextureAtlas atlas;
    private Stage stage;
    private Table layerControls;
    private Button treningMenuImg;
    private Button practiceMenuImg;
    private Button lerningMenuImg;
    private Image keybordImg;
    private float keybordHeight;
    private Image lineImg;
    private Table layerKeyboard;//////
    private Table layerLines;
    private ScrollPane scroller;
    private int mode;
    public Label.LabelStyle number;
    final Color white;


    public ScripPackScreen(final Note directedGame) {
        super(directedGame);
        this.white = new Color(1.0f, 1.0f, 1.0f, 1.0f);

//        this.Height = Gdx.graphics.getHeight();
////        System.out.println( Height);
//        this.Width = Gdx.graphics.getWidth();
    }

    private void rebuildStage() {
//        this.buildMenuLayers();
//        this.assembleStage();////////////////


//        Table table = this.buildPackSelectorLayer();
        this.number = new Label.LabelStyle(Assets.instance.fonts.levelCompleted, this.white);
        Table table2 = this.buildLevelSelectorLayer();
        this.stage.clear();
        this.stage.addActor(table2);
//        this.stage.addActor(table);

//        this.imgBackground = new Image(this.game.gameSkin,"backgroundMenu");
//        this.imgBackground.setBounds(0.0F, 0.0F, this.Width, this.Height);
//
//
//        this.treningMenuImg = new Image(this.game.gameSkin, "TreningScrip_left");
//        float f1 = this.Width / 5f;
//        float f2 = treningMenuImg.getHeight() * f1 / treningMenuImg.getWidth();
//        this.treningMenuImg.setPosition(this.Width - this.Width / 30 - f1, this.Width / 30);
//        this.treningMenuImg.setSize(f1, f2);
//
//        this.stage.addActor(this.imgBackground);
//        this.stage.addActor(this.treningMenuImg);
    }

    private void assembleStage() {
//        this.stage.clear();
//        Stack stack = new Stack();
//        stack.setTransform(true);
//        this.stage.addActor(stack);
//        stack.setSize(this.stage.getViewport().getWorldWidth(), this.stage.getViewport().getWorldHeight());
//        stack.add(this.layerBackground);
//        stack.add(this.layerKeyboard);
//        stack.add(this.layerLines);
//        stack.add(this.layerControls);

    }

    private Table buildLevelSelectorLayer() {
        ScrollPane scrollPane;
        Table table = new Table();
        table.setBackground(game.gameSkin.getDrawable("backgroundMenu"));
//        table.debug();
        table.setSize(stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
        table.setPosition(0.0f, 0.0f);
        Table table2 = new Table();
//        table.debug();
        this.scroller = scrollPane = new ScrollPane(table2);
        this.scroller.setScrollingDisabled(true, false);
        int n = 0;
//        int lastLvl = GamePreferences.instance.loadLastLevel();
        int lastLvl = 0;
        int n3 = 0;
        block0:do {
            if (n3 >= 12) { // lvls
                table.add(this.scroller);
                table.row();
                Button button = new Button(this.game.gameSkin, "base");
                button.setSize(stage.getViewport().getWorldWidth() / 10, stage.getViewport().getWorldWidth() / 10);
                button.setPosition(stage.getViewport().getWorldWidth() - button.getWidth(), -button.getWidth());
//                button.setColor(this.palette[1]);
//                button.add(new Image(this.buttonSkin, "HomeLogo"));
                button.addAction(Actions.sequence((Action) Actions.delay(0.5f), (Action) Actions.moveTo(stage.getViewport().getWorldWidth() - button.getWidth(), 0.0f, 1.0f, Interpolation.circleOut)));
                ChangeListener changeListener = new ChangeListener() {

                    @Override
                    public void changed(ChangeListener.ChangeEvent changeEvent, Actor actor) {
                        ScripPackScreen.this.game.setScreen(new ScripMenuScreen(game));
                    }
                };
                button.addListener(changeListener);
                table.addActor(button);
                return table;
            }
            final int n4 = n3;
            Table table3 = new Table();
            table.debug();
//            GamePreferences.instance.saveLastLevelStar(mode, 2, 3);
            int numStar = GamePreferences.instance.getNumberOfStar(mode, n4);
//            System.out.println(numStar);
            Button button = new Button(this.game.gameSkin, "level");
            table2.add(table3).size(stage.getViewport().getWorldWidth() / 6.0f);
            table3.addActor(button);
//            button.setSize(0.0f, 0.0f);
            button.setSize((stage.getViewport().getWorldWidth() / 6.0f), stage.getViewport().getWorldWidth() / 6.0f);
//            button.setColor(this.palette[2]);
            int n6 = n3 - lastLvl;
            float f = 0.0f;
            if (n6 > 0) {
                f = 0.5f + 0.05f * (float) (++n);
            }
//            button.addAction(Actions.sequence((Action)Actions.delay(f), (Action)Actions.sizeTo(stage.getViewport().getWorldWidth() / 6.0f, stage.getViewport().getWorldWidth() / 6.0f, 0.1f, Interpolation.swingOut)));
            button.addAction(sequence(alpha(0), delay(f), parallel(fadeIn(.5f), moveBy(0, -10, .25f, Interpolation.pow5Out))));

            Label label = new Label((CharSequence) ("" + (n4 + 1)), this.number);
            label.setAlignment(16);
            label.addAction(Actions.sequence((Action) Actions.alpha(0.0f), (Action) Actions.delay(f), (Action) Actions.fadeIn(0.2f)));
            label.setAlignment(1);
            if (n3 - lastLvl > 2) {
                button.setTouchable(Touchable.disabled);
                button.setColor(Color.GRAY);
            } else {
                button.top().add(label).padTop(stage.getViewport().getWorldWidth() / 10.0f);
            }
            int n7 = 0;
            do {
                if (n7 >= numStar) {
                    System.out.println(n7+" "+numStar+ "rrrr"+n3);
                    ChangeListener changeListener = new ChangeListener() {

                        @Override
                        public void changed(ChangeListener.ChangeEvent changeEvent, Actor actor) {
                            ScripPackScreen.this.onLevelSelectClicked(n4);
                        }
                    };
                    button.addListener(changeListener);
                    if ((n3 + 1) % 6 == 0) {
                        table2.row();
                    }
                    ++n3;
                    continue block0;
                }
                Image image;
                ++n7;
                switch (n7) {
                    case 1:
                        image = new Image(this.game.gameSkin, "Star1");
                        break;
                    case 2:
                        image = new Image(this.game.gameSkin, "Star2");
                        break;
                    default:
                        image = new Image(this.game.gameSkin, "Star3");
                        break;
                }
//                Image image = new Image(this.game.gameSkin, "Star1");
                image.setSize(stage.getViewport().getWorldWidth() / 6.0f, stage.getViewport().getWorldWidth() / 6.0f);
                button.addActor(image);
//                image.setColor(this.white);
                image.addAction(Actions.sequence((Action) Actions.alpha(0.0f), (Action) Actions.delay(f), (Action) Actions.fadeIn(0.2f)));
            } while (true);
//            break;
        } while (true);
    }
//    private Table buildLevelSelectorLayer2()
//    {
//        Table localTable1 = new Table();
//        localTable1.setBackground(game.gameSkin.getDrawable("backgroundMenu"));
//        localTable1.setSize(stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
//        localTable1.setPosition(0.0F, 0.0F);
//        Table localTable2 = new Table();
//        this.scroller = new ScrollPane(localTable2);
//        this.scroller.setScrollingDisabled(true, false);
////        localTable2.padTop(Constants.VIEWPORT_GUI_HEIGHT / 5.0F).padBottom(Constants.VIEWPORT_GUI_HEIGHT / 5.0F);
//        int k = 0;
////        int m = GamePreferences.instance.loadLastLevel();
//        int m = 0;
//        final int i = 0;
//        if (i >= 12)
//        {
//            localTable1.add(this.scroller);
//            localTable1.row();
//            Button button = new Button(this.game.gameSkin, "base");
//            button.setSize(Constants.MENU_BUTTON_SIZE, Constants.MENU_BUTTON_SIZE);
//            button.setSize(stage.getViewport().getWorldWidth() / 10, stage.getViewport().getWorldWidth() / 10);
//            button.setPosition(stage.getViewport().getWorldWidth() - button.getWidth(), -button.getWidth());
////                button.setColor(this.palette[1]);
////                button.add(new Image(this.buttonSkin, "HomeLogo"));
//            button.addAction(Actions.sequence((Action) Actions.delay(0.5f), (Action) Actions.moveTo(stage.getViewport().getWorldWidth() - button.getWidth(), 0.0f, 1.0f, Interpolation.circleOut)));
//            button.addListener(new ChangeListener() {
//                public void changed(ChangeListener.ChangeEvent paramAnonymousChangeEvent, Actor paramAnonymousActor) {
//
//                    ScripPackScreen.this.game.setScreen(new ScripMenuScreen(game));
////                    TitleScreen.this.game.solver.showBanner(false);
//                }
//            });
//            localTable1.addActor(button);
//            return localTable1;
//        }
//        Object localObject = new Table();
//        int n = GamePreferences.instance.getNumberOfStar(mode,i);
//        Button localButton = new Button(this.game.gameSkin, "level");
//        localTable2.add((Actor)localObject).size(stage.getViewport().getWorldWidth() / 6.0f);
//        ((Table)localObject).addActor(localButton);
//        localButton.setSize((stage.getViewport().getWorldWidth() / 6.0f), stage.getViewport().getWorldWidth() / 6.0f);
////        localButton.setSize(0.0F, 0.0F);
////        localButton.setColor(this.palette[2]);
//        float f = 0.0F;
//        int j = k;
//        if (i - m > 0)
//        {
//            j = k + 1;
//            f = 0.5F + 0.05F * j;
//        }
////        localButton.addAction(Actions.sequence(Actions.delay(f), Actions.sizeTo(Constants.VIEWPORT_GUI_WIDTH / 3.0F, Constants.VIEWPORT_GUI_WIDTH / 3.0F, 0.1F, Interpolation.swingOut)));
//        localButton.addAction(sequence(alpha(0), delay(f), parallel(fadeIn(.5f), moveBy(0, -10, .25f, Interpolation.pow5Out))));
//
//        localObject = new Label((CharSequence) ("" + (i + 1)), this.number);
//        ((Label)localObject).setAlignment(16);
//        ((Label)localObject).addAction(Actions.sequence(Actions.alpha(0.0F), Actions.delay(f), Actions.fadeIn(0.2F)));
//        ((Label)localObject).setAlignment(1);
//        if (i - m > 2)
//        {
//            localButton.setTouchable(Touchable.disabled);
//            localButton.setColor(Color.GRAY);
//        }
//        for (;;)
//        {
//            k = 0;
//            if (k < n) {
////                break label554;/////////
//            }
//            localButton.addListener(new ChangeListener()
//            {
//                public void changed(ChangeListener.ChangeEvent paramAnonymousChangeEvent, Actor paramAnonymousActor)
//                {
//                    ScripPackScreen.this.onLevelSelectClicked(i);
//                }
//            });
//            if ((i + 1) % 6 == 0) {
//                localTable2.row();
//            }
////            i += 1;/////////////
//            k = j;
//            break;
//            localButton.top().add((Actor)localObject).padTop(Constants.VIEWPORT_GUI_WIDTH / 12.0F);
//        }
//        label554:if (k == 0) {
//            localObject = new Image(this.game.gameSkin, "Star1");
//        }
//        for (;;)
//        {
//            ((Image)localObject).setSize(stage.getViewport().getWorldWidth() / 6.0f, stage.getViewport().getWorldWidth() / 6.0f);
//            localButton.addActor((Actor)localObject);
////            ((Image)localObject).setColor(this.white);
//            ((Image)localObject).addAction(Actions.sequence(Actions.alpha(0.0F), Actions.delay(f), Actions.fadeIn(0.2F)));
//            k += 1;
//            break;
//            if (k == 1) {
//                localObject = new Image(this.game.gameSkin, "Star2");
//            } else {
//                localObject = new Image(this.game.gameSkin, "Star3");
//            }
//        }
//     }


    private void onLevelSelectClicked(int n) {
        System.out.println(n);
//        this.game.levelToLoad = n;
        ScripPackScreen.this.game.setScreen(new ScripPracticeScreen(game, n));
//        AudioManager.instance.play(com.gamelounge.chrooma.game.Assets.instance.sounds.buttonSound, 1.0f);
    }

//    private Table buildLinesLayer() {
//        Table table = new Table();
//        table.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        table.bottom().left().padBottom(keybordHeight);
//        this.lineImg = new Image(this.game.gameSkin, "lines");
//        table.add(this.lineImg);
//
//        return table;
//    }
//    private void buildMenuLayers() {
//        this.layerBackground = this.buildBackgroundLayer();
//
////        this.layerKeyboard=this.buildKeyboardLayer();
////        this.layerLines = this.buildLinesLayer();
////        this.layerControls = this.buildControlsLayer();
////        this.layerSettings = this.buildSettingsLayer();
//    }
//    private Table buildBackgroundLayer() {
//        Table table = new Table();
////        table.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        this.imgBackground = new Image(this.game.gameSkin,"backgroundMenu");
//        table.add(this.imgBackground).fill().expand();
//
//        return table;
//    }

//    private void onLearningClicked() {
//        this.game.setScreen(new ScripMiddleScreen(this.game));
//    }
//
//    private void onTreningClicked() {
//        this.game.setScreen(new ScripTreningScreen(this.game));
//    }
//    private void onPracticeClicked() {
//        this.game.setScreen(new ScripPackScreen(this.game));
//    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        Gdx.gl.glClear(16384);
        stage.act(delta);
        stage.draw();
        renderGuiFpsCounter();
    }

    @Override
    public void resize(int n, int n2) {
        System.out.println("resize");
        this.stage.getViewport().update(n, n2, true);
    }

    @Override
    public void pause() {
        System.out.println("pause");
    }

    @Override
    public void resume() {
        System.out.println("resume");
//        this.game.camera.viewportWidth = Gdx.graphics.getWidth();
//        this.game.camera.viewportHeight = Gdx.graphics.getHeight();
    }

    @Override
    public void hide() {
        System.out.println("hide");
        this.stage.dispose();
    }

    @Override
    public void dispose() {
        System.out.println("dispose");
        this.stage.dispose();
    }

    //    @Override
//    public InputProcessor getInputProcessor() {
//        return null;
//    }
    @Override
    public void show() {
        System.out.println("show");
//        this.stage = new Stage();
//        this.game.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.input.setCatchBackKey(true);
        this.stage = new Stage(new ExtendViewport(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT, game.camera)) {
            @Override
            public boolean keyUp(int keycode) {

                if ((keycode == Input.Keys.BACK) || (keycode == Input.Keys.ESCAPE)) {
                    ScripPackScreen.this.Back();
                }
                return false;
            }
        };
        Gdx.input.setInputProcessor(stage);
        mode = 1;
//        this.stage.setViewport(new StretchViewport(800.0f, 480.0f));

//        GameManager.ourInstance.setGameState(GameState.MOVE);/////////////////////////

//        this.atlas = (TextureAtlas)this.game.manager.get("sprites.atlas", TextureAtlas.class);
        this.rebuildStage();
    }

    private void Back() {
        this.game.setScreen(new ScripMenuScreen(this.game));
    }

    private void renderGuiFpsCounter() {
        float x = 400;
        float y = 240;
        int fps = Gdx.graphics.getFramesPerSecond();
        BitmapFont fpsFont = Assets.instance.fonts.heroInfo;
        if (fps >= 45) {
            // 45 or more FPS show up in green
            fpsFont.setColor(0, 1, 0, 1);
        } else if (fps >= 30) {
            // 30 or more FPS show up in yellow
            fpsFont.setColor(1, 1, 0, 1);
        } else {
            // less than 30 FPS show up in red
            fpsFont.setColor(1, 0, 0, 1);
        }
        stage.getBatch().begin();
        fpsFont.draw(stage.getBatch(), "FPS: " + fps, x, y);
        stage.getBatch().end();
        fpsFont.setColor(1, 1, 1, 1); // white
    }
}


