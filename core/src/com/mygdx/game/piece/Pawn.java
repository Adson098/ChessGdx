package com.mygdx.game.piece;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.core.chess.colorT;



public class Pawn extends piece {

    private Texture texture;
    private Sprite sprite;
    private boolean isFirstMove = true;
    private piece.Moves moves1;
    private piece.Moves moves2;

    public Pawn(colorT c) {
        color = c;
        if(c == colorT.white) {
            texture = new Texture(Gdx.files.internal("jpg/128px/w_pawn.png"));
        }
        else{
            texture = new Texture(Gdx.files.internal("jpg/128px/b_pawn.png"));
        }
        sprite = new Sprite(texture);

        //// moves1 2 i kolejny ruch
        moves1 = new piece.Moves();
        moves2 = new piece.Moves();
        moves1.MOVES = new int[][]{
                {3,2,3},   /// 1 lokalizacja pionka
                {0,1,0}  /// 3 gdzie moze bic
        };

        moves1.location.x = 1;
        moves1.location.y = 1;
        moves1.size.x = 3;
        moves1.size.y = 2;

        /// moves2 1 ruch pionka

        moves2.MOVES = new int[][]{
                {3,2,3},   /// 1 lokalizacja pionka
                {0,2,0},   /// 3 gdzie moze bic
                {0,1,0}
        };
        moves2.location.x = 1;
        moves2.location.y = 2;
        moves2.size.x = 3;
        moves2.size.y = 3;

    }


    public colorT getColor(){
        return color;
    }
    public Sprite getSprite(){
        return sprite;
    }
    public String getSymbol(){
        if(color == colorT.white){
            return " P ";
        }
        else return " p ";
    }

    public piece.Moves getMoves(){
        if(isFirstMove) return moves1;
        else return moves2;
    }
    public void dispose(){
        texture.dispose();
    }


}
