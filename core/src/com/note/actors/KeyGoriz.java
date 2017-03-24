package com.note.actors;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.note.Note;
import com.note.game.Assets;
import com.note.screens.ScripMiddleScreen;
import com.note.screens.ScripLeftScreen;

import java.lang.reflect.Field;

public class KeyGoriz extends AbstractActor {

    private final TextureRegion triangleTextureRegion;
    private final TextureRegion lineTextureRegion;
    private TextureRegion keyTextureRegion;
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
    public int key;



    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(keyTextureRegion, position, 0, width, height);

//        if(!((number%2)==0)){
//            batch.draw(triangleTextureRegion,position,height - 1,width, height /10 );
//        }
//        if ((number==7)||(number==9)||(number==11)||(number==13)||(number==15)){
//            float lineWidth = width / 10;
//            batch.draw(lineTextureRegion,
//                    position + width / 2 - lineWidth / 2,
//                    height,
//                    width / 10,
//                    stage.getViewport().getWorldHeight()/1.5f);///////////////
//        }

    }

    public KeyGoriz(final Note game, final int key, Stage stage, final int number) {

        this.number = number;
        this.game = game;
        this.stage = stage;
        this.position = (this.stage.getViewport().getWorldWidth() / 23 )* number ;
        this.width = this.stage.getViewport().getWorldWidth() / 23 + 1 ;
        this.height = this.stage.getViewport().getWorldHeight() / 4f;
        this.key = key;

        if (key == 1) {
            keyTextureRegion = Assets.instance.noteImg.doKeyImgActor;
        }else if (key == 2){
            keyTextureRegion = Assets.instance.noteImg.reKeyImgActor;
        }else if (key == 3) {
            keyTextureRegion = Assets.instance.noteImg.miKeyImgActor;
        }else if (key == 4){
            keyTextureRegion = Assets.instance.noteImg.faKeyImgActor;
        }else if (key == 5){
            keyTextureRegion = Assets.instance.noteImg.solKeyImgActor;
        }else if (key == 6){
            keyTextureRegion = Assets.instance.noteImg.laKeyImgActor;
        }else if (key == 7){
            keyTextureRegion = Assets.instance.noteImg.siKeyImgActor;
        }

        triangleTextureRegion = Assets.instance.decoration.triangleImg;
        lineTextureRegion = Assets.instance.decoration.lineImg;
        this.state = 0;

        setBounds(position,0,width,height);


        addListener(new ClickListener() {
            //            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                if (((DoKey) event.getTarget()).state != 0) {
            if(ScripMiddleScreen.getNoteActors().size != 0) {
                if (key == 1) {
                    if (ScripMiddleScreen.getNoteActors().get(0).getNoteKey() == key) {
                        keyTextureRegion = Assets.instance.noteImg.doGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.doRedKeyImgActor;
                    }
                } else if (key == 2) {
                    if (ScripMiddleScreen.getNoteActors().get(0).getNoteKey() == key) {
                        keyTextureRegion = Assets.instance.noteImg.reGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.reRedKeyImgActor;
                    }
                } else if (key == 3) {
                    if (ScripMiddleScreen.getNoteActors().get(0).getNoteKey() == key) {
                        keyTextureRegion = Assets.instance.noteImg.miGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.miRedKeyImgActor;
                    }
                } else if (key == 4) {
                    if (ScripMiddleScreen.getNoteActors().get(0).getNoteKey() == key) {
                        keyTextureRegion = Assets.instance.noteImg.faGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.faRedKeyImgActor;
                    }
                } else if (key == 5) {
                    if (ScripMiddleScreen.getNoteActors().get(0).getNoteKey() == key) {
                        keyTextureRegion = Assets.instance.noteImg.solGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.solRedKeyImgActor;
                    }
                } else if (key == 6) {
                    if (ScripMiddleScreen.getNoteActors().get(0).getNoteKey() == key) {
                        keyTextureRegion = Assets.instance.noteImg.laGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.laRedKeyImgActor;
                    }
                } else if (key == 7) {
                    if (ScripMiddleScreen.getNoteActors().get(0).getNoteKey() == key) {
                        keyTextureRegion = Assets.instance.noteImg.siGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.siRedKeyImgActor;
                    }
                }

                if (game.getScreen().getClass() == ScripLeftScreen.class) {
                    ScripLeftScreen.firstActor.setNoteCliked(true);
                }
                if (game.getScreen().getClass() == ScripMiddleScreen.class) {
                    if ((ScripMiddleScreen.getNoteActors().get(0).getNoteKey() == key)) {
                        ScripMiddleScreen.scoreRight++;
                    } else {
                        ScripMiddleScreen.scoreWrong++;
                    }
//                    ScripMiddleScreen.setIndex(number);
                    if (ScripMiddleScreen.getNoteActors().size != 0) {
                        ScripMiddleScreen.getNoteActors().get(0).setNoteCliked(true);
                        ScripMiddleScreen.getNoteActors().removeIndex(0);

                    }
                }
//                System.out.println("key "+(ScripMiddleScreen.getNoteActors().get(0).getNoteKey()));
            }
//                try {
//                    NUMBER = game.getScreen().getClass().getField("currIndex");
//                    String n = NUMBER.getName();
//                    System.out.println(n);
//
//                    keyTextureRegion = Assets.instance.noteImg.reKeyImgActor;
//
//                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
//                }
//                if (ScripPracticeScreen.class == screen.getClass()) {
//                    ScripPracticeScreen.setJeybordHeight(true);
//                }

                return true;
            }
            //            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                switch (key) {
                    case 1:
                        keyTextureRegion = Assets.instance.noteImg.doKeyImgActor;
                        break;
                    case 2:
                        keyTextureRegion = Assets.instance.noteImg.reKeyImgActor;
                        break;
                    case 3:
                        keyTextureRegion = Assets.instance.noteImg.miKeyImgActor;
                        break;
                    case 4:
                        keyTextureRegion = Assets.instance.noteImg.faKeyImgActor;
                        break;
                    case 5:
                        keyTextureRegion = Assets.instance.noteImg.solKeyImgActor;
                        break;
                    case 6:
                        keyTextureRegion = Assets.instance.noteImg.laKeyImgActor;
                        break;
                    case 7:
                        keyTextureRegion = Assets.instance.noteImg.siKeyImgActor;
                        break;
                }
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
}