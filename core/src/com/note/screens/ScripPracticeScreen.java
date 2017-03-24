package com.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.note.Note;
import com.note.actors.KeyGorizPack;
import com.note.actors.Lines;
import com.note.actors.BlackNote;
import com.note.game.Assets;
import com.note.utils.Constants;
import com.note.utils.GamePreferences;
import com.note.utils.Randomizer;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


public class ScripPracticeScreen extends AbstractGameScreen {

    //    private final Color black;
    private int number;
    private Note game;
    private ScrollPane scroller;
    private Stage stage;
    private Table layerBackground;
    private Array<BlackNote> actors1 = new Array<BlackNote>();
    private Image znakImg;
    private float time = 300;
    private int a = 0;
    private int noteInArray = 0;
    private int massiv = 20;
    private int time2 = 0;
    private Randomizer randomizer = new Randomizer();
    private int score ;
    private Table scoreLayer;
    private Label scoreLabel;
    private Label.LabelStyle labelStyle;
    private TextButton btnMenuScrip;
    String noteText = "?";
    private boolean showNote = false;
    private Image leftBorder;
    private Image rightBorder;
    private Dialog dialog;
    private Window window;
    private String status = "action";
    private int star = 0;

    public ScripPracticeScreen(final Note game, int number) {
        super(game);
        this.game = game;
        this.number = number;
//        Gdx.app.log("GameScreen", "Starting level: " + number);
//        ar = Levels.getLevel(number);
    }

    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
        this.stage = new Stage(new ExtendViewport(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT, game.camera)) {
            @Override
            public boolean keyUp(int keycode) {

                if ((keycode == Input.Keys.BACK) || (keycode == Input.Keys.ESCAPE)) {
                    ScripPracticeScreen.this.Back();
                }
                return false;
            }
        };
        Gdx.input.setInputProcessor(stage);
//        mode = 1;
//        GameManager.ourInstance.setGameState(GameState.MOVE);/////////////////////////
//        this.atlas = (TextureAtlas)this.game.manager.get("sprites.atlas", TextureAtlas.class);
        this.buildStage();

//        Window window = new Window("title",Assets.instance.window);
    }

    private void controller() {
        scoreLabel.setText("" + score);
        if (massiv != 0) {
            if (noteInArray == 4) {
                time2 += 1;
                if (time2 == 500) { //time between
                    noteInArray = 0;
                    time2 = 0;
                }
            }

            time += 1;

            if (time >= 220f && massiv != 0 && noteInArray != 4) {
                int s = randomizer.getRandom(number);
                BlackNote blackNote1 = new BlackNote(game, s, stage, stage.getViewport().getWorldHeight(),
                        stage.getViewport().getWorldHeight() - this.stage.getViewport().getWorldHeight() / 4f, actors1);
                stage.addActor(blackNote1);
                actors1.add(blackNote1);
                massiv--;
                time = 0f;
                noteInArray++;
            }
        } else if(actors1.size == 0){

            initWindow();
            status="pause";
            int currentStar = GamePreferences.instance.getNumberOfStar(1,number);
            if (currentStar<star){
            GamePreferences.instance.saveLastLevelStar(1,number,star);
        }
        }

    }

    private void onLevelSelectClicked(int n) {
        System.out.println(n);
//        if (n == actors1.get(0).getNumber()) {

//        }
    }
//        this.game.levelToLoad = n;
//        ScripPackScreen.this.game.setScreen(new ScripPracticeScreen(game, n));
//        AudioManager.instance.play(com.gamelounge.chrooma.game.Assets.instance.sounds.buttonSound, 1.0f);


    private void buildStage() {
        this.layerBackground = this.buildBackgroundLayer();
        this.scoreLayer = buildScoreLayer();
        stage.addActor(layerBackground);
        stage.addActor(scoreLayer);
        stage.addActor(new Lines(game, stage));
//        this.layerKeyboard=this.buildKeyboardLayer();
//        this.layerLines = this.buildLinesLayer();
//        this.layerControls = this.buildControlsLayer();
//        this.layerSettings = this.buildSettingsLayer();

    }
    private void initWindow(){
        window = new Window("", Assets.instance.skin.windowStyle);
        Dialog dialog = new Dialog("",Assets.instance.skin.windowStyle);
        Table table = new Table();
        table.debug();
        Table table2 = new Table();
        table2.debug();
        window.debug();

//        Actor musicCheckBox = new CheckBox("Music",game.gameSkin,"music").getSkin().getFont("default.fnt").getData().setScale(0.33f, 0.33f);
        Actor musicCheckBox = new CheckBox("Music",game.uiSkin,"music");

//        musicCheckBox
//        CheckBox.CheckBoxStyle checkBoxStyle = new CheckBox.CheckBoxStyle();


        window.setSize(stage.getViewport().getWorldWidth() / 2, stage.getViewport().getWorldWidth() / 3);
        window.setPosition(stage.getViewport().getWorldWidth() / 4, stage.getViewport().getWorldHeight() / 3);

        if (score<=50) {
           table.add(new Image(Assets.instance.decoration.star)).center().colspan(3).padBottom(50).size(150,150);
            star = 1;
       }else if(score>50 && score<90){
            table.debug();
           table.add(new Image(Assets.instance.decoration.star)).padBottom(50).size(150, 150).padRight(100);
           table.add(new Image(Assets.instance.decoration.star)).padBottom(50).size(150, 150);
            table.center();
            star = 2;
        }else if(score>=90){
            table.add(new Image(Assets.instance.decoration.star)).center().padBottom(50).padRight(100);
            table.add(new Image(Assets.instance.decoration.star)).center().padBottom(50).padRight(100);
            table.add(new Image(Assets.instance.decoration.star)).center().padBottom(50);
            star= 3;
        }
        TextButton tb = new TextButton("<", Assets.instance.skin.textButtonStyle);
        tb.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                window.remove();
            }
        });
//
        table2.add(tb).size(200, 200).padRight(50);
        table2.add(new TextButton("[=]", Assets.instance.skin.textButtonStyle)).size(200, 200);
        table2.add(new TextButton(">",Assets.instance.skin.textButtonStyle)).padLeft(50).size(200, 200);

        window.add(musicCheckBox).left().fill();
        window.row();
//        window.add(table);
//        window.row();
//        window.add(table2);
        stage.addActor(window);


    }

    private Table buildScoreLayer() {
        Table table = new Table();
//        table.setSize(stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
//        table.setPosition(0.0f, 0.0f);
        table.setFillParent(true);
        table.setDebug(true);
        table.right().bottom();

        labelStyle = new Label.LabelStyle(Assets.instance.fonts.packScreenScore,new Color(1.0f, 1.0f, 1.0f, 1.0f));
//        Label scoreLabel = new Label((String.format("%02d",score)),labelStyle );
        scoreLabel = new Label(""+score,labelStyle );
        table.add(scoreLabel).padRight(stage.getViewport().getWorldWidth()/8).padBottom( stage.getViewport().getWorldHeight()/8);
//        System.out.println(score);
//        scoreLabel.setAlignment(16);
//        table.add(scoreLabel).padRight(stage.getViewport().getWorldWidth() / 20).padBottom(stage.getViewport().getWorldHeight()/ 10);

        this.btnMenuScrip = new TextButton("?",Assets.instance.skin.textButtonStyle);
        this.btnMenuScrip.setOrigin(btnMenuScrip.getWidth() / 2.0f, btnMenuScrip.getHeight() / 2.0f);
//        table.add(this.btnMenuScrip).size(Constants.VIEWPORT_GUI_WIDTH /4f ,Constants.VIEWPORT_GUI_WIDTH /4f*  Constants.ASPECT_RATIO);/////////////////////////////
//        System.out.println(stage.getViewport().getWorldWidth() / 4);
        this.btnMenuScrip.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
//                FirstMenuScreen.this.onPlayClicked();/////////////////////

                showNote= true;
                showNote();

                initWindow();////////////////////
            }
        });
        table.add(this.btnMenuScrip).right().size(stage.getViewport().getWorldHeight() / 4, stage.getViewport().getWorldHeight() / 4);
        return table;
    }

    private void showNote() {
        if (actors1.size!=0) {
            btnMenuScrip.setText(actors1.get(0).getNote());
            btnMenuScrip.addAction(sequence(delay(1.0f), run(new Runnable() {
                public void run() {
//                    System.out.println("Action complete!");
                    btnMenuScrip.setText("?");
                }
            })));
        }
    }

    private Table buildBackgroundLayer() {
        Table table = new Table();
        table.setBackground(game.gameSkin.getDrawable("backgroundGame"));
//        table.debug();
        table.setSize(stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
        table.setPosition(0.0f, 0.0f);
        znakImg = new Image(this.game.gameSkin, "ScripGorZnak");
        znakImg.setPosition(0, this.stage.getViewport().getWorldHeight() / 2.7f);
        table.addActor(znakImg);

        leftBorder = new Image(Assets.instance.decoration.leftBorder);
        leftBorder.setSize(this.stage.getViewport().getWorldWidth() / 90, this.stage.getViewport().getWorldHeight() / 4f);
        leftBorder.setPosition(this.stage.getViewport().getWorldWidth() / 23f * 8f - (this.stage.getViewport().getWorldWidth() / 90 - 1), 0);
        table.addActor(leftBorder);

        rightBorder = new Image(Assets.instance.decoration.rightBorder);
        rightBorder.setSize(this.stage.getViewport().getWorldWidth() / 90, this.stage.getViewport().getWorldHeight() / 4f);
        rightBorder.setPosition(this.stage.getViewport().getWorldWidth() / 23f * 15f, 0);
        table.addActor(rightBorder);

        KeyGorizPack keyGorizPack;
        for (int i = 8; i < 15; i++) {
            keyGorizPack = new KeyGorizPack(game, i - 7, stage, i);
            final int finalI = i;
            keyGorizPack.addListener(new ClickListener() {
                //            @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                    ScripPracticeScreen.this.onLevelSelectClicked(finalI);
                    KeyGorizPack key = (KeyGorizPack) event.getListenerActor();
                    if (actors1.size != 0) {
                        if (key.getKey() == actors1.get(0).getKey()) {
                            key.status = 2;//green
                            if (!showNote) {
                                score += 5;
                            }
                            showNote = false;
                        } else {
                            key.status = 3;//red
                            actors1.get(0).showTitle = true;
                        }
                        actors1.get(0).isNoteBlack=false;
                        actors1.removeIndex(0);
                    } else {
                        key.status = 3;
                    }
                    return true;
                }
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    KeyGorizPack key = (KeyGorizPack) event.getListenerActor();
                    key.status = 1;
                }
            });
            table.addActor(keyGorizPack);
        }
        return table;
    }



    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        renderGuiFpsCounter();
        if (status=="action"){
        controller();
        }

    }

    private void Back() {
        this.game.setScreen(new ScripPackScreen(this.game));
    }

    private void renderGuiFpsCounter() {
        float x = 400;
        float y = 240;
        int fps = Gdx.graphics.getFramesPerSecond();
        BitmapFont fpsFont = Assets.instance.fonts.defaultNormal;
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
        fpsFont.setColor(1, 1, 1, 1); // black
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
