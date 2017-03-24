package com.note.actors;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.note.enums.GameState;
import com.note.game.Assets;
import com.note.screens.DirectedGame;
import com.note.utils.Constants;
import com.note.utils.GameManager;

import java.util.Random;


public class NoteVert extends Actor {

    private final Stage stage;
    private final float width;
    private final float height;
    private TextureRegion textureRegion;
    private TextureRegion lineImg;
    private final DirectedGame game;
    private float index=0;
    private GameState gameState;
    private boolean isSecond;

    private Label label;
    private Vector2 position;
    private String note ;
    public Vector2 dimension;
    public Vector2 origin;
    public Vector2 scale;
    public float rotation1;
    private BitmapFont font;
    private boolean move ;
    private int lineNamber;
    private float speed = 90;

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        lineImg= Assets.instance.decoration.lineImg;
        if (note.equals("do")){
            textureRegion = Assets.instance.note.noteRedDoVert;
        }else if (note.equals("re")){
            textureRegion = Assets.instance.note.noteOrangeReVert;
        }else if (note.equals("mi")){
            textureRegion = Assets.instance.note.noteYellowMiVert;
        }else if (note.equals("fa")){
            textureRegion = Assets.instance.note.noteGreenFaVert;
        }else if (note.equals("sol")){
            textureRegion = Assets.instance.note.noteBlueSolVert;
        }else if (note.equals("la")){
            textureRegion = Assets.instance.note.noteSiniiLaVert;
        }else if (note.equals("si")){
            textureRegion = Assets.instance.note.notePurpleSiVert;
        }

//        switch ((int)index){
//            case 4   :
//                batch.draw(lineImg,position.x-5,position.y-40,lineImg.getRegionWidth(),lineImg.getRegionHeight());
//                return;
//        }
        float widhtW =  stage.getViewport().getWorldWidth();
        float heidthH = stage.getViewport().getWorldHeight();

        if (index== 5){
            lineNamber = 1 ;
            batch.draw(lineImg, widhtW / 46 * 11 - widhtW / 220  /2 , position.y - 10,widhtW  / 220,heidthH / 5 );
        }
        if (index == 4) {
            lineNamber = 1;
            batch.draw(lineImg, widhtW / 46 * 11 - widhtW / 220  /2 , position.y - 10, widhtW  / 220, heidthH / 5 );
//            batch.draw(lineImg,192 ,position.y - lineImg.getRegionHeight()/4+8,lineImg.getRegionWidth(),lineImg.getRegionHeight()+40);
        }
        if ((index == 3)||(index == 2)) {
            lineNamber = 2;
            batch.draw(lineImg, widhtW / 46 * 11 - widhtW / 220  /2 , position.y - 10, widhtW  / 220, heidthH / 5 );
            batch.draw(lineImg, widhtW / 46 * 7 - widhtW / 220  /2 , position.y - 10, widhtW  / 220, heidthH / 5 );

//            batch.draw(lineImg, 192, position.y - lineImg.getRegionHeight() / 4 + 8, lineImg.getRegionWidth(), lineImg.getRegionHeight()+40);
        }
        if ((index== 1)||(index == 0)){
            lineNamber = 3;
            batch.draw(lineImg, widhtW / 46 * 11 - widhtW / 220  /2 , position.y - 10, widhtW  / 220, heidthH / 5 );
            batch.draw(lineImg, widhtW / 46 * 7 - widhtW / 220  /2 , position.y - 10, widhtW  / 220, heidthH / 5 );
            batch.draw(lineImg, widhtW / 46 * 3 - widhtW / 220  /2 , position.y - 10, widhtW  / 220, heidthH / 5 );

//            batch.draw(lineImg, 55, position.y - lineImg.getRegionHeight() / 4 + 8, lineImg.getRegionWidth(), lineImg.getRegionHeight()+40);
        }
        if (index== 17){
            lineNamber = 1;
            batch.draw(lineImg, widhtW / 46 * 35 - widhtW / 220  /2 , position.y - 10, widhtW  / 220, heidthH / 5 );
//            batch.draw(lineImg,600 ,position.y - lineImg.getRegionHeight()/4+8,lineImg.getRegionWidth(),lineImg.getRegionHeight()+40);
        }
        if (index==18){
            lineNamber = 1;
            batch.draw(lineImg, widhtW / 46 * 35 - widhtW / 220  /2 , position.y - 10, widhtW  / 220, heidthH / 5 );
//            batch.draw(lineImg,600 ,position.y - lineImg.getRegionHeight()/4+8,lineImg.getRegionWidth(),lineImg.getRegionHeight()+40);
        }
        if ((index == 19)||(index==20)){
            lineNamber = 2;
            batch.draw(lineImg, widhtW / 46 * 35 - widhtW / 220  /2 , position.y - 10, widhtW  / 220, heidthH / 5 );
            batch.draw(lineImg, widhtW / 46 * 39 - widhtW / 220  /2 , position.y - 10, widhtW  / 220, heidthH / 5 );
        }

        if ((index == 21)||(index==22)){
            lineNamber = 3;
            batch.draw(lineImg, widhtW / 46 * 35 - widhtW / 220  /2 , position.y - 10, widhtW  / 220, heidthH / 5 );
            batch.draw(lineImg, widhtW / 46 * 39 - widhtW / 220  /2 , position.y - 10, widhtW  / 220, heidthH / 5 );
            batch.draw(lineImg, widhtW / 46 * 43 - widhtW / 220  /2 , position.y - 10, widhtW  / 220, heidthH / 5 );
        }
        if (isSecond) {
            textureRegion = Assets.instance.note.note_greyVert;
        }

        batch.draw(textureRegion, position.x + 0 , position.y , width,height);/////// Note




        this.font = Assets.instance.fonts.noteName;
//        font.setColor(18f ,45f ,115f , 1f);
        font.setColor(Color.valueOf("071d53"));
        if (lineNamber > 0) {
            font.draw(batch, Integer.toString(lineNamber), position.x + 55, position.y + 300);//lineNumber
        }
        if (note.equals("sol")) {
            font.draw(batch, note, position.x + 7, position.y + 140);
//                label.setPosition(position.x + 15 , position.y + 55);
        }else if(note.equals("si")){
            font.draw(batch, note, position.x + 35, position.y + 140);
        }else if(note.equals("do")){
            font.draw(batch, note, position.x + 15, position.y + 140);
        }else if(note.equals("re")){
            font.draw(batch, note, position.x + 18, position.y + 140);
        }else {
            font.draw(batch, note, position.x + 23, position.y + 140);
//            label.setPosition(position.x + 10 , position.y + 55);
        }
//        font.drawMultiLine(batch, Float.toString( index), position.x+50, position.y, 0, BitmapFont.HAlignment.CENTER);
//        if (GameManager.ourInstance.getGameState()== GameState.WAITKEYPRESS) {
    }
    public NoteVert(DirectedGame directedGame,Stage stage) {
        this.game = directedGame;
        this.stage = stage;
        randomNote();
        this.move= true;
//        Skin skin2 = new Skin();
//        label = new Label(note,skin2);
//        label.setRotation(-90.0f);
//        index = 20;
//        note ="mi";
        width = stage.getViewport().getWorldWidth() / 12;
        height = stage.getViewport().getWorldWidth()/ 10;
        setOrigin(getWidth() /2,getHeight() /2 );
        position = new Vector2(this.stage.getViewport().getWorldWidth() / 23 * index  - 38, stage.getViewport().getWorldHeight()- (stage.getViewport().getWorldHeight()/ 5));
        this.isSecond=false;
        dimension = new Vector2(1, 1);
        origin = new Vector2();
        scale = new Vector2(1, 1);
        rotation1 = 0;
    }


    public void setNoteCliked(boolean isSecond){
        this.isSecond = isSecond;
    }
    public boolean getNoteCliked(boolean isSecond){
        return this.isSecond ;
    }
    public float getIndex(){
        return this.index;
    }
    public String getNote(){
        return note;
    }
//    public void move(boolean move){
//        this.move = move;
//    }
    public Vector2 getPosition() {
        return position;
    }
    private float randomNote(){
        Random rand = new Random();
        index = rand.nextInt(22);

        if (( index==0)||(index==7)||(index==21)||(index==14)) {
            note = "mi";
            System.out.println("mi");
        }
        if (( index==1)||(index==8)||(index==22)||(index==15)) {
            note = "fa";
            System.out.println("fa");
        }
        if (( index==2)||(index==9)||(index==16)) {
            note="sol";
            System.out.println("sol");
        }
        if (( index==3)||(index==10)||(index==17)) {
            note ="la";
            System.out.println("la");
        }
        if (( index==4)||(index==11)||(index==18)) {
            note="si";
            System.out.println("si");
        }
        if (( index==5)||(index==12)||(index==19)) {
            note="do";
            System.out.println("do");
        }
        if (( index==6)||(index==13)||(index==20)) {
            note="re";
            System.out.println("re");
        }
        return index;
    }
    public void speedUp(){
        speed = 500;
    }

    public void act(float delta) {
        super.act(delta);
        if  (GameManager.ourInstance.getGameState()== GameState.MOVE) {
            position.y -= speed * delta;
        }
    }

}


