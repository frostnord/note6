package com.note.actors;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.note.Note;
import com.note.game.Assets;

import java.lang.reflect.Field;

public class DoKey extends AbstractActor {

    private TextureRegion textureRegion;
    private static float textuerKeybordHeight;
    private Stage stage;
    private AtlasRegion atlasRegion;
    private float width;
    private float height;
    private float position;
    private Note game;
    private Field NUMBER;
    private Screen screen;
    public int state ;
    public int number;



    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
//        textureRegion = Assets.instance.
        batch.draw(textureRegion, position, 0, width, height);



    }

    public DoKey(final Note game, Stage stage, int number, final Screen screen) {

        this.number = number;
        this.screen = screen;
        this.game = game;
        this.stage = stage;
        this.position = this.stage.getViewport().getWorldWidth() / 23 * number - 1;
        this.width = this.stage.getViewport().getWorldWidth() / 23 ;
        this.height = this.stage.getViewport().getWorldHeight() / 3;
        System.out.println(height);
        System.out.println(width);
        textureRegion = Assets.instance.noteImg.doKeyImgActor;
        this.state = 0;

        addListener(new ClickListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (((DoKey) event.getTarget()).state != 0) {
                    return false;
                }
                System.out.println("dsdsd");
                System.out.println(x);


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
        return position;
    }

    //    public Actor hit (float x, float y, boolean touchable) {
//
//    }

}