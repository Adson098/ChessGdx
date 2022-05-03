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
        gowno();

    }
    void gowno(){
        int x = -4;
        System.out.println(x);
        x++;
        System.out.println(x);

    }

    @Override
    public void render () {


    }
}