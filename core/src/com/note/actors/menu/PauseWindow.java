package com.note.actors.menu;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.note.Note;
import com.note.enums.GameState;
import com.note.game.Assets;
import com.note.screens.ScripPackScreen;
import com.note.screens.ScripPracticeScreen;

public class PauseWindow extends Window {

    private final int score;
    private final int number;
    private Stage stage ;
    private int star;
    private Note game;

    public PauseWindow(String title, Stage stage, int score, final Note game, final int number) {
        super("", Assets.instance.skin.windowStyle);
        this.stage = stage;
        this.score = score;
        this.game= game;
        this.number = number;

        Table table = new Table();
        //        table.debug();
        Table table2 = new Table();
        table2.debug();

        setSize(stage.getViewport().getWorldWidth() / 2, stage.getViewport().getWorldWidth() / 3);
        System.out.println(stage.getViewport().getWorldWidth() / 2 +"+"+ stage.getViewport().getWorldWidth() / 3);
        setPosition(stage.getViewport().getWorldWidth() / 4, stage.getViewport().getWorldHeight() / 3);


        Button btnWindowPack = new Button(Assets.instance.skin.buttonStyle);
        Image imgWindowPrew = new Image(this.game.gameSkin, "prew");
        imgWindowPrew.setOrigin(imgWindowPrew.getWidth() / 2.0f, imgWindowPrew.getHeight() / 2.0f);
        btnWindowPack.add((Actor) imgWindowPrew);
        btnWindowPack.setOrigin(btnWindowPack.getWidth() / 2.0f, btnWindowPack.getHeight() / 2.0f);
        btnWindowPack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent changeEvent, Actor actor) {

                game.setScreen( new ScripPackScreen(game));
                remove();
            }
        });
        table2.add(btnWindowPack).size(200, 200).padRight(50);

//        TextButton homeButton = new TextButton("<", Assets.instance.skin.textButtonStyle);
//        homeButton.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//
////                window.remove();
//                ScripPracticeScreen.this.game.setScreen( new ScripPackScreen(game));
//            }
//        });
//        table2.add(homeButton).size(200, 200).padRight(50);
//        TextButton packButton = new TextButton("[=]", Assets.instance.skin.textButtonStyle);
//        packButton.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                window.remove();
//            }
//        });
//        table2.add(packButton).size(200, 200);


        Button btnWindowRestart = new Button(Assets.instance.skin.buttonStyle);
        Image imgWindowRestart = new Image(this.game.gameSkin, "restart");
        imgWindowRestart.setOrigin(imgWindowRestart.getWidth() / 2.0f, imgWindowRestart.getHeight() / 2.0f);
        btnWindowRestart.add((Actor) imgWindowRestart);
        btnWindowRestart.setOrigin(btnWindowRestart.getWidth() / 2.0f, btnWindowRestart.getHeight() / 2.0f);
        btnWindowRestart.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent changeEvent, Actor actor) {
                game.setScreen(new ScripPracticeScreen(game, number));
                remove();
            }
        });
        table2.add(btnWindowRestart).size(200, 200).center();
////////////////////////////

//        table2.add(new MyTextButton("R", Assets.instance.skin.textButtonStyle, new ChangeListener() {
//            @Override
//            public void changed(ChangeEvent event, Actor actor) {
//                ScripPracticeScreen.this.game.setScreen(new ScripPracticeScreen(game, number));
////                System.out.println(number+"pack number");
//            }
//        })).size(200, 200).center();


            Button btnWindowPlay = new Button(Assets.instance.skin.buttonStyle);
            Image imgWindowNext = new Image(this.game.gameSkin, "next");
            imgWindowNext.setOrigin(imgWindowNext.getWidth() / 2.0f, imgWindowNext.getHeight() / 2.0f);
            btnWindowPlay.add((Actor) imgWindowNext);
            btnWindowPlay.setOrigin(btnWindowRestart.getWidth() / 2.0f, btnWindowRestart.getHeight() / 2.0f);
            btnWindowPlay.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
//                    ScripPracticeScreen.this.game.setScreen(new ScripPracticeScreen(game, number + 1));
                    remove();
//                status("action");
//                    game.gameStatus = "action";
                    game.gs = GameState.MOVE;
                }
            });
            table2.add(btnWindowPlay).size(200, 200).padLeft(50);

//            table2.add(new MyTextButton(">>", Assets.instance.skin.textButtonStyle, new ChangeListener() {
//                @Override
//                public void changed(ChangeEvent event, Actor actor) {
//                    ScripPracticeScreen.this.game.setScreen(new ScripPracticeScreen(game, number + 1));
//                }
//            })) .size(200, 200).padLeft(50);

//       window.add(musicCheckBox).left().fill();
        row().pad(5);
        add(table);
        row().pad(5);
        add(table2);


    }

}
