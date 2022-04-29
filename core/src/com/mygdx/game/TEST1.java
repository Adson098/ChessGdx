package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TEST1 extends ApplicationAdapter {

    int state;

    @Override
    public void create () {
        state = 0;


    }

    @Override
    public void render () {

        //if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) && state == 0){
           // System.out.println("nacisnieto coord : " + Gdx.input.getX() + " y: " + Math.abs(Gdx.input.getY()-720));
       // }
       if(!Gdx.input.isTouched()&&state == 1){
            System.out.println("puszczone coord x: " + Gdx.input.getX() + " y: " + Math.abs(Gdx.input.getY()-720));
            state = 0;

        }

        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            System.out.println("nacisnieto coord : " + Gdx.input.getX() + " y: " + Math.abs(Gdx.input.getY()-720));
            state =1;
        }

    }
}