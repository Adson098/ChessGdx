package com.mygdx.game.piece;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.core.chess.colorT;


public class Empty extends piece {


    private Sprite sprite;
    private Texture texture;

    private Moves moves;

    public Empty(colorT mcolor){
        color = mcolor;
        texture = new Texture(Gdx.files.internal("jpg/128px/w_king.png"));
        sprite = new Sprite(texture);
        sprite.setSize(1,1);
        moves = new Moves();
        moves.MOVES = new int[][]{
                {0},
        };
        moves.location.x = 0;
        moves.location.y = 0;
        moves.size.x = 0;
        moves.size.y =0;

    }

    public colorT getColor(){
        return color;
    }
    public Sprite getSprite(){return sprite; }
    public String getSymbol(){
        if(color == colorT.white){
            return "   ";
        }
        else return "   ";
    }
    public Moves getMoves(){
        return moves;
    }

    public void dispose(){

    }
}
