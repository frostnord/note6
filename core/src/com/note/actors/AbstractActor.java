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
    public abstract class AbstractActor extends Actor {


    public int number;

     public AbstractActor(){


     }



    public int getNumber(){
        return number;
    }
}
