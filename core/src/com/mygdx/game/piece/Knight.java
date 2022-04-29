package com.mygdx.game.piece;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.core.chess.colorT;


public class Knight extends piece {

    private Texture texture;
    private Sprite sprite;

    private piece.Moves moves;


    public Knight(colorT mcolor){
        color = mcolor;
        if(color == colorT.white){
            texture = new Texture(Gdx.files.internal("jpg/128px/w_knight.png"));
        }
        else{
            texture = new Texture(Gdx.files.internal("jpg/128px/b_knight.png"));
        }
        sprite = new Sprite(texture);
        moves = new piece.Moves();
        moves.MOVES = new int[][]{
                {0,0,0,0,0,0,0,0},
                {0,0,0,4,0,4,0,0},
                {0,0,4,0,0,0,4,0},
                {0,0,0,0,1,0,0,0},
                {0,0,4,0,0,0,4,0},
                {0,0,0,4,0,4,0,0}
        };

        moves.location.x = 4;
        moves.location.y = 3;
        moves.size.x = 8;
        moves.size.y =6;
    }

    public colorT getColor(){
        return color;
    }
    public Sprite getSprite(){return sprite;}
    public String getSymbol(){
        if(color == colorT.white){
            return " S ";
        }
        else return " s ";
    }

    public piece.Moves getMoves(){
        return moves;
    }

    public void dispose(){
        texture.dispose();
    }
}
