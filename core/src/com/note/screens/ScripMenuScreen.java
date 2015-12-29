package com.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.note.Note;
import com.note.enums.GameState;
import com.note.game.Assets;
import com.note.utils.Constants;
import com.note.utils.GameManager;

/**
 * Created by 1 on 25.03.2015.
 */
public class ScripMenuScreen extends AbstractGameScreen  {

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


    public ScripMenuScreen(final Note directedGame) {
        super(directedGame);

//        this.Height = Gdx.graphics.getHeight();
////        System.out.println( Height);
//        this.Width = Gdx.graphics.getWidth();
    }

    private void rebuildStage() {
        this.buildMenuLayers();
        this.assembleStage();////////////////

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
        this.stage.clear();
        Stack stack = new Stack();
//        stack.setTransform(true);
        this.stage.addActor(stack);
        stack.setSize(this.stage.getViewport().getWorldWidth(), this.stage.getViewport().getWorldHeight());
        stack.add(this.layerBackground);
//        stack.add(this.layerKeyboard);
//        stack.add(this.layerLines);
        stack.add(this.layerControls);

    }
    private Table buildKeyboardLayer() {
        final Table table = new Table();
//        table.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        table.center().bottom();
        this.keybordImg = new Image(this.game.gameSkin, "keybord");
        table.add(this.keybordImg);
        keybordHeight = keybordImg.getTop();
        return table;
    }
    private Table buildLinesLayer() {
        Table table = new Table();
        table.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        table.bottom().left().padBottom(keybordHeight);
        this.lineImg = new Image(this.game.gameSkin, "lines");
        table.add(this.lineImg);

        return table;
    }
    private void buildMenuLayers() {
        this.layerBackground = this.buildBackgroundLayer();

        this.layerKeyboard=this.buildKeyboardLayer();
        this.layerLines = this.buildLinesLayer();
        this.layerControls = this.buildControlsLayer();
//        this.layerSettings = this.buildSettingsLayer();
    }
    private Table buildBackgroundLayer() {
        Table table = new Table();
//        table.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.imgBackground = new Image(this.game.gameSkin,"backgroundMenu");
        table.add(this.imgBackground).fill().expand();;

        return table;
    }
    private Table buildControlsLayer() {
        Table table = new Table();
//        table.validate();
        table.debug();
//        table.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        table.center().bottom();
//        .padBottom(this.game.gameSkin.getRegion("ScripButton").getRegionWidth() / 1.5f);

        this.treningMenuImg = new Button(this.game.gameSkin, "TreningScrip_left");
        table.add(this.treningMenuImg);
        this.treningMenuImg.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {/////////
//                FirstMenuScreen.this.onPlayClicked();
                System.out.println("dsdsd");
                ScripMenuScreen.this.onTreningClicked();

            }
        });

        this.practiceMenuImg = new Button(this.game.gameSkin, "TreningScrip_left");///"LearningScrip_mid"
        table.add(this.practiceMenuImg).padLeft(this.stage.getViewport().getWorldWidth()/11.0f);
        this.practiceMenuImg.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                onLearningClicked();
            }
        });

        this.lerningMenuImg = new Button(this.game.gameSkin, "TreningScrip_left");///"PracticeScrip_right"
        table.add(this.lerningMenuImg).padLeft(this.stage.getViewport().getWorldWidth()/11.0f );
        this.lerningMenuImg.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                onPracticeClicked();
            }
        });
        System.out.println(this.game.gameSkin.getRegion("LearningScrip_mid").getRegionHeight() /2.5f);
        return table;
    }

    private void onLearningClicked() {
        this.game.setScreen(new ScripMiddleScreen(this.game));
    }

    private void onTreningClicked() {
        this.game.setScreen(new ScripTreningScreen(this.game));
    }
    private void onPracticeClicked() {
        this.game.setScreen(new ScripPracticeScreen(this.game));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        Gdx.gl.glClear(16384);
        stage.act(delta);
        stage.draw();
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
        this.game.camera.viewportWidth = Gdx.graphics.getWidth();
        this.game.camera.viewportHeight = Gdx.graphics.getHeight();
    }

    @Override
    public void hide() {
        this.stage.dispose();
    }

    @Override
    public void dispose() {
        this.stage.dispose();
    }

//    @Override
//    public InputProcessor getInputProcessor() {
//        return null;
//    }
    @Override
    public void show() {

//        this.stage = new Stage();
//        this.game.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.input.setCatchBackKey(true);
        this.stage = new Stage(new ExtendViewport(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT,game.camera)){
            @Override
            public boolean keyUp(int keycode) {

                if ((keycode == Input.Keys.BACK)|| (keycode == Keys.ESCAPE)){
                    ScripMenuScreen.this.Back();
                }
                return false;
            }
        };
        Gdx.input.setInputProcessor(stage);
//        this.stage.setViewport(new StretchViewport(800.0f, 480.0f));
        GameManager.ourInstance.setGameState(GameState.MOVE);
//        this.atlas = (TextureAtlas)this.game.manager.get("sprites.atlas", TextureAtlas.class);
        this.rebuildStage();
    }

    private void Back() {
        this.game.setScreen(new FirstMenuScreen(this.game));
    }

}
