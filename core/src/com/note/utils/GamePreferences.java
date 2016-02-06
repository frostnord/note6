package com.note.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by 1 on 03.02.2016.
 */
public class GamePreferences {
    public static final String TAG = GamePreferences.class.getName();
    public static final GamePreferences instance = new GamePreferences();
    private Preferences prefs = Gdx.app.getPreferences("chrooma.prefs");
    public boolean sound;

    private GamePreferences() {
        this.load();
    }

    public void load() {
        this.sound = this.prefs.getBoolean("sound", true);
    }
    public int loadLastLevel() {
        if (this.prefs.getInteger("nextLevel-" + this.loadActualPack()) != 0) {
            return this.prefs.getInteger("nextLevel-" + this.loadActualPack());
        }
        return 0;
    }
    public int loadActualPack() {
        if (this.prefs.getInteger("actualPack") != 0) {
            return -1 + this.prefs.getInteger("actualPack");
        }
        return 0;
    }
    public int getNumberOfStar(int mode, int star) {
        return this.prefs.getInteger("levelStar-" + mode + "-" + star);
    }
}
