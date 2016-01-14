package com.note.actors;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.note.Note;
import com.note.game.Assets;
import com.note.game.WorldController;
import com.note.screens.ScripPracticeScreen;

import java.lang.reflect.Field;

public class ReKey extends AbstractActor {

    private final float position;
    private TextureRegion textureRegion;
    private static float textuerKeybordHeight;
    private Stage stage;
    private AtlasRegion atlasRegion;
    private float width;
    private float height;
    private float number;
    private Note game;
    private Field NUMBER;
    private Screen screen;


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
//        textureRegion = Assets.instance.
        batch.draw(textureRegion, position, 0, width, height);

    }

    public ReKey(final Note game, Stage stage, final int number) {
        this.number = number;
        this.game = game;
        this.stage = stage;
        this.position = this.stage.getViewport().getWorldWidth() / 23 * number - 1;
        this.width = this.stage.getViewport().getWorldWidth() / 23 ;
        this.height = this.stage.getViewport().getWorldHeight() / 3;
        textureRegion = Assets.instance.noteImg.reKeyImgActor;
        setBounds(position,0,width,height);


        addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                if (((DoKey) event.getTarget()).state != 0) {
//
//                }
                if (WorldController.KEYNUMBER == number){
                    textureRegion = Assets.instance.noteImg.reGreenKeyImgActor;
                }else {
                    textureRegion = Assets.instance.noteImg.reRedKeyImgActor;
                }



//                try {
//                    NUMBER = game.getScreen().getClass().getField("currIndex");
//                    String n = NUMBER.getName();
//                    System.out.println(n);
//
//                    textureRegion = Assets.instance.noteImg.reKeyImgActor;
//
//                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
//                }
//                if (ScripPracticeScreen.class == screen.getClass()) {
//                    ScripPracticeScreen.setJeybordHeight(true);
//                }

                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                textureRegion = Assets.instance.noteImg.reKeyImgActor;

            }
        });
    }
    public boolean isTouched() {
       return Gdx.input.justTouched();
    }




    public static float getTextuerKeybordHeight() {
        return textuerKeybordHeight;
    }

    public float getRigth(){
        return number;
    }

    //    public Actor hit (float x, float y, boolean touchable) {
//
//    }

}