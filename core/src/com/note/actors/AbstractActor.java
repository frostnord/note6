package com.note.actors;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.note.Note;
import com.note.game.Assets;

import java.lang.reflect.Field;

/**
 * Created by 1 on 30.12.2015.
 */
    public abstract class AbstractActor implements Actor {

    private TextureRegion textureRegion;
    private static float textuerKeybordHeight;
    private Stage stage;
    private TextureAtlas.AtlasRegion atlasRegion;
    private float width;
    private float height;
    private float position;
    private Note game;
    private Field NUMBER;
    private Screen screen;
    public int state ;
    public int number;

     public AbstractActor(final Note game, Stage stage, int number, final Screen screen){

         this.game = game;

     }



    public int getNumber(){
        return number;
    }
}
