package com.note.utils;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.note.actors.DoKey;

/**
 * Created by 1 on 23.12.2015.
 */
public class MyListener extends InputListener {
    @Override
    public boolean touchDown(InputEvent event, float x, float y,
                             int pointer, int button) {

        DoKey actor = (DoKey) event.getListenerActor();
        //работаем с актером
//        actor.setNumber(event.);

        return true;
    }
}