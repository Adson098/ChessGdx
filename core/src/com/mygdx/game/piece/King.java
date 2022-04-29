package com.mygdx.game.piece;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.core.chess.colorT;


public class King extends piece {

    private Texture texture;
    private Sprite sprite;

    private piece.Moves moves;
    public King(colorT mcolor){
        color = mcolor;
        if(color == colorT.white){
            texture = new Texture(Gdx.files.internal("jpg/128px/w_king.png"));
        }
        else{
            texture = new Texture(Gdx.files.internal("jpg/128px/b_king.png"));
        }
        sprite = new Sprite(texture);
        moves = new piece.Moves();
        moves.MOVES = new int[][] {
                {0,0,0,4,4,4,0,0},
                {0,0,0,4,1,4,0,0},
                {0,0,0,4,4,4,0,0},
        };

        moves.location.x = 4;
        moves.location.y = 1;
        moves.size.x = 8;
        moves.size.y =3;

    }

    public colorT getColor(){
        return color;
    }
    public Sprite getSprite(){
        return sprite;
    }
    public String getSymbol(){
        if(color == colorT.white){
            return " K ";
        }
        else return " k ";
    }
    public piece.Moves getMoves(){
        return moves;
    }

    public void dispose(){
        texture.dispose();
    }
}
