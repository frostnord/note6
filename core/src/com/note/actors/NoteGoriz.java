package com.note.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Align;
import com.note.enums.GameState;
import com.note.game.Assets;
import com.note.screens.DirectedGame;
import com.note.utils.GameManager;

import java.util.Random;

/**
 * Created by 1 on 13.06.2015.
 */
public class NoteGoriz extends Actor {
    private final float width;
    private final float height;
    private final Stage stage;
    private float widthBot;
    private TextureRegion textureRegion;
    private TextureRegion lineImg;
    private final DirectedGame game;
    private float index=0;
    private GameState gameState;
    private boolean isSecond;


    private Vector2 position;
    private String note ;
    public Vector2 dimension;
    public Vector2 origin;
    public Vector2 scale;
    public float rotation1;
    private BitmapFont font;
    private boolean move ;
    private int noteNumber;
    private float ran;
    private Animation noteAni;
    public float stateTime ;
    public Animation animation;
    private int ranNote ;
    private float rotation;
    private float widhtTop ;

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        lineImg= Assets.instance.decoration.lineImg;

        if (note.equals("Do")){
            textureRegion = Assets.instance.note.noteRedDoGor;
        }else if (note.equals("Re")){
            textureRegion = Assets.instance.note.noteOrangeReGor;
        }else if (note.equals("Mi")){
            textureRegion = Assets.instance.note.noteYellowMiGor;
        }else if (note.equals("Fa")){
            textureRegion = Assets.instance.note.noteGreenFaGor;
        }else if (note.equals("Sol")){
            textureRegion = Assets.instance.note.noteBlueSolGor;
        }else if (note.equals("La")){
            textureRegion = Assets.instance.note.noteSiniiLaGor;
        }else if (note.equals("Si")){
            textureRegion = Assets.instance.note.notePurpleSiGor;
        }
        noteAni = Assets.instance.note.noteAni;

        if ((index== 5)||(index == 4)){
            batch.draw(lineImg,position.x - 10 , 208,70,2);
        }
        if ((index == 3)||(index == 2)) {
            batch.draw(lineImg,position.x - 10 , 208,70,2);
            batch.draw(lineImg,position.x - 10 , 179,70,2);
        }
        if ((index== 1)||(index == 0)){
            batch.draw(lineImg,position.x - 10 , 208,70,2);
            batch.draw(lineImg,position.x - 10 , 179,70,2);
            batch.draw(lineImg,position.x - 10 , 151,70,2);
        }
        if( (index== 17)||(index==18)){
            batch.draw(lineImg,position.x - 10 , 375,70,2);
        }
        if ((index == 19)||(index==20)){
            batch.draw(lineImg,position.x - 10 , 375,70,2);
            batch.draw(lineImg,position.x - 10 , 403,70,2);
        }
        if ((index == 21)||(index==22)){
            batch.draw(lineImg,position.x - 10 , 375,70,2);
            batch.draw(lineImg,position.x - 10 , 403,70,2);
            batch.draw(lineImg,position.x - 10 , 431,70,2);
        }
        if (isSecond) {
            textureRegion = Assets.instance.note.note_greyGor;
            ran = 1;
            ranNote = 2;
        }
        if (ranNote == 1){
            TextureRegion reg = null;
            reg = noteAni.getKeyFrame(stateTime, true);
//            batch.draw(reg.getTexture(), position.x, position.y, 50, 34);
            batch.draw(reg.getTexture(),
                    position.x, position.y + 6,
                    origin.x, origin.y,
                    width, height,
                    scale.x, scale.y,
                    rotation,
                    reg.getRegionX(), reg.getRegionY(),
                    reg.getRegionWidth(), reg.getRegionHeight(),
                    false, false);
        }else {
            batch.draw(textureRegion, position.x , position.y + 6, width, height);
        }

        this.font = Assets.instance.fonts.levelComplete;
        font.setColor(0.11f,0.11f, 0.11f, 1);
        if (ran != 0) {
            font.draw(batch, note, position.x + 20, position.y + 32, 14 ,Align.center , true);
        }
    }
    private int ranNote(){
        ranNote = MathUtils.random(1, 4);

//        Random random = new Random();
//        ranNote = random.nextInt(1);
        return ranNote;
    }
    public NoteGoriz(DirectedGame directedGame , Stage stage , float widhtTop , float widthBot) {
        this.stage = stage;
        this.width = widthBot / 9.2f;
        this.height = widthBot / 13f;
        this.widhtTop = widhtTop;
        this.widthBot= widthBot ;
        this.game = directedGame;
        randomNote();
        nadpisOFF();
        if (ran==0){
            ranNote();
        }
        this.move= true;
//        ran = 0;
//        index = 22;
//        note ="Do";
//        noteNumber = 1;
        position = new Vector2(1900,((this.stage.getViewport().getWorldHeight() - this.stage.getViewport().getWorldHeight() / 4f - 50) / 23f) * index + this.stage.getViewport().getWorldHeight() / 4f);
//        position = new Vector2(770 , (index * 14) + 118);/////////////////////
        this.isSecond = false;
        dimension = new Vector2(1, 1);
        origin = new Vector2();
        scale = new Vector2(1, 1);
        rotation1 = 0;
    }
    private float nadpisOFF() {
        Random random = new Random();
        ran = random.nextInt(3);
        return ran;
    }
    public void setNoteCliked(boolean isSecond){
        this.isSecond = isSecond;
    }
    public float getIndex(){
        return this.index;
    }
    public String getNote(){
        return note;
    }
    public int getNoteNumber(){
        return noteNumber;
    }
    public Vector2 getPosition() {
        return position;
    }
    private float randomNote(){
        Random rand = new Random();
        index = rand.nextInt(22);

        if (( index==0)||(index==7)||(index==21)||(index==14)) {
            note = "Mi";
            System.out.println("Mi");
            noteNumber = 2;
        }
        if (( index==1)||(index==8)||(index==22)||(index==15)) {
            note = "Fa";
            System.out.println("Fa");
            noteNumber = 3;
        }
        if (( index==2)||(index==9)||(index==16)) {
            note="Sol";
            System.out.println("Sol");
            noteNumber = 4;
        }
        if (( index==3)||(index==10)||(index==17)) {
            note ="La";
            System.out.println("La");
            noteNumber = 5;
        }
        if (( index==4)||(index==11)||(index==18)) {
            note="Si";
            System.out.println("Si");
            noteNumber = 6;
        }
        if (( index==5)||(index==12)||(index==19)) {
            note="Do";
            System.out.println("Do");
            noteNumber = 0;
        }
        if (( index==6)||(index==13)||(index==20)) {
            note="Re";
            System.out.println("Re");
            noteNumber = 1;
        }
        return index;
    }

    public void act(float delta) {

        stateTime += Gdx.graphics.getDeltaTime();

        super.act(delta);
        if  (GameManager.ourInstance.getGameState()== GameState.MOVE) {
            position.x -= 0.9;
        }
        if (position.x <= 25){
            remove();
        }
    }
}
