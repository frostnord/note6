package com.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.note.Note;
import com.note.game.Assets;
import com.note.utils.Constants;



public class ScripPracticeScreen extends AbstractGameScreen {


//    private final Color white;
    private int number;
    private Note game;
    private ScrollPane scroller;
    private Stage stage;


//    private Table buildLevelSelectorLayer() {
//        ScrollPane scrollPane;
//        Table table = new Table();
//        table.setSize(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
//        table.setPosition(0.0f, 0.0f);
//        Table table2 = new Table();
//        this.scroller = scrollPane = new ScrollPane(table2);
//        this.scroller.setScrollingDisabled(true, false);
//        table2.padTop(Constants.VIEWPORT_GUI_HEIGHT / 5.0f).padBottom(Constants.VIEWPORT_GUI_HEIGHT / 5.0f);
//        int n = 0;
//        int n2 = GamePreferences.instance.loadLastLevel();
//        int n3 = 0;
//        block0 : do {
//            if (n3 >= this.game.packManager.getPackage().length) {
////                table.add(this.scroller);
//                table.row();
//                Button button = new Button(this.game.gameSkin, "base");
//                button.setSize(Constants.MENU_BUTTON_SIZE, Constants.MENU_BUTTON_SIZE);
//                button.setPosition(Constants.VIEWPORT_GUI_WIDTH - button.getWidth(), -button.getWidth());
////                button.setColor(this.palette[1]);
//                button.add(new Image(this.game.gameSkin, "HomeLogo"));
//                button.addAction(Actions.sequence((Action) Actions.delay(0.5f), (Action) Actions.moveTo(Constants.VIEWPORT_GUI_WIDTH - button.getWidth(), 0.0f, 1.0f, Interpolation.circleOut)));
//                ChangeListener changeListener = new ChangeListener(){
//
//                    @Override
//                    public void changed(ChangeListener.ChangeEvent changeEvent, Actor actor) {
////                        TitleScreen.this.game.setScreen(new MenuScreen(TitleScreen.this.game), TitleScreen.this.slide);
//                    }
//                };
//                button.addListener(changeListener);
//                table.addActor(button);
//                return table;
//            }
//            final int n4 = n3;
//            Table table3 = new Table();
//            int n5 = GamePreferences.instance.getNumberOfStar(n4, 4);
//            Button button = new Button(this.game.gameSkin, "level");
//            table2.add(table3).size(Constants.VIEWPORT_GUI_WIDTH / 3.0f);
//            table3.addActor(button);
//            button.setSize(0.0f, 0.0f);
////            button.setColor(this.palette[2]);
//            int n6 = n3 - n2;
//            float f = 0.0f;
//            if (n6 > 0) {
//                f = 0.5f + 0.05f * (float)(++n);
//            }
//            button.addAction(Actions.sequence((Action)Actions.delay(f), (Action)Actions.sizeTo(Constants.VIEWPORT_GUI_WIDTH / 3.0f, Constants.VIEWPORT_GUI_WIDTH / 3.0f, 0.1f, Interpolation.swingOut)));
//            this.number = new Label.LabelStyle(Assets.instance.fonts.levelCompleted, this.white);
//            Label label = new Label((CharSequence)("" + (n4 + 1)), this.number);
//            label.setAlignment(16);
//            label.addAction(Actions.sequence((Action)Actions.alpha(0.0f), (Action)Actions.delay(f), (Action)Actions.fadeIn(0.2f)));
//            label.setAlignment(1);
//            if (n3 - n2 > 2) {
//                button.setTouchable(Touchable.disabled);
//                button.setColor(Color.GRAY);
//            } else {
//                button.top().add(label).padTop(Constants.VIEWPORT_GUI_WIDTH / 12.0f);
//            }
//            int n7 = 0;
//            do {
//                if (n7 >= n5) {
//                    ChangeListener changeListener = new ChangeListener(){
//
//                        @Override
//                        public void changed(ChangeListener.ChangeEvent changeEvent, Actor actor) {
////                            ScripPracticeScreen.this.onLevelSelectClicked(n4);
//                        }
//                    };
//                    button.addListener(changeListener);
//                    if ((n3 + 1) % 3 == 0) {
//                        table2.row();
//                    }
//                    ++n3;
//                    continue block0;
//                }
//                Image image = new Image(this.game.gameSkin, "Star1");
//                image.setSize(Constants.VIEWPORT_GUI_WIDTH / 3.0f, Constants.VIEWPORT_GUI_WIDTH / 3.0f);
//                button.addActor(image);
////                image.setColor(this.white);
//                image.addAction(Actions.sequence((Action)Actions.alpha(0.0f), (Action)Actions.delay(f), (Action)Actions.fadeIn(0.2f)));
//                ++n7;
//            } while (true);
//            break;
//        } while (true);
//    }



//
    public ScripPracticeScreen(final Note game,int number) {
        super(game);
        this.game= game;
        this.number = number;
//        this.white = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
        this.stage = new Stage(new ExtendViewport(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT,game.camera)){
            @Override
            public boolean keyUp(int keycode) {

                if ((keycode == Input.Keys.BACK)|| (keycode == Input.Keys.ESCAPE)){
                    ScripPracticeScreen.this.Back();
                }
                return false;
            }
        };
        Gdx.input.setInputProcessor(stage);
//        mode = 1;
//        this.stage.setViewport(new StretchViewport(800.0f, 480.0f));

//        GameManager.ourInstance.setGameState(GameState.MOVE);/////////////////////////

//        this.atlas = (TextureAtlas)this.game.manager.get("sprites.atlas", TextureAtlas.class);



//        this.rebuildStage();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        Gdx.gl.glClear(16384);
        stage.act(delta);
        stage.draw();
        renderGuiFpsCounter();
    }
    private void Back() {
        this.game.setScreen(new ScripPackScreen(this.game));
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

    @Override
    public void resize(int n, int n2) {
        this.stage.getViewport().update(n, n2, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.stage.dispose();
    }
}
