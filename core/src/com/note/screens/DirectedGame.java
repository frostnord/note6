package com.note.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.note.actors.BlackNote;
import com.note.enums.GameState;

/**
 * Created by 1 on 13.04.2015.
 */
public class DirectedGame extends Game {

    public AssetManager manager = new AssetManager();
    public Skin gameSkin;
    public Skin uiSkin;
    public String gameStatus = "action";
    public GameState gs = GameState.MOVE ;



    @Override
    public void create() {

    }
}
