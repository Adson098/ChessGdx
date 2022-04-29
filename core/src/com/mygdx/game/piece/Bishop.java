package com.mygdx.game.piece;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.core.chess.colorT;


public class Bishop extends piece {

    private Texture texture;
    private Sprite sprite;

    private piece.Moves moves;

    public Bishop(colorT mcolor){
        color = mcolor;
        if(color == colorT.white){
            texture = new Texture(Gdx.files.internal("jpg/128px/w_bishop.png"));
        }
        else{
            texture = new Texture(Gdx.files.internal("jpg/128px/b_bishop.png"));
        }
        sprite = new Sprite(texture);
        moves = new piece.Moves();
        moves.MOVES = new int[][]{
                {4,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0},
                {0,4,0,0,0,0,0,0,0,0,0,0,0,4,0,0},
                {0,0,4,0,0,0,0,0,0,0,0,0,4,0,0,0},
                {0,0,0,4,0,0,0,0,0,0,0,4,0,0,0,0},
                {0,0,0,0,4,0,0,0,0,0,4,0,0,0,0,0},
                {0,0,0,0,0,4,0,0,0,4,0,0,0,0,0,0},
                {0,0,0,0,0,0,4,0,4,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,4,0,4,0,0,0,0,0,0,0},
                {0,0,0,0,0,4,0,0,0,4,0,0,0,0,0,0},
                {0,0,0,0,4,0,0,0,0,0,4,0,0,0,0,0},
                {0,0,0,4,0,0,0,0,0,0,0,4,0,0,0,0},
                {0,0,4,0,0,0,0,0,0,0,0,0,4,0,0,0},
                {0,4,0,0,0,0,0,0,0,0,0,0,0,4,0,0},
                {4,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4},
        };
        moves.location.x = 7;
        moves.location.y = 7;
        moves.size.x = 16;
        moves.size.y =16;

    }

    public colorT getColor(){
        return color;
    }
    public Sprite getSprite(){return sprite;}
    public String getSymbol(){
        if(color == colorT.white){
            return " B ";
        }
        else return " b ";
    }
    public piece.Moves getMoves(){
        return moves;
    }

    public void dispose(){
        texture.dispose();
    }
}
