package com.mygdx.game.piece;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.core.chess.colorT;
import com.mygdx.game.vector2i;


public abstract class piece {

    Texture texture;
    Sprite sprite;
    colorT color;

     public class Moves{
         public vector2i size = new vector2i();
        public vector2i location = new vector2i();
        public int[][] MOVES = new int[16][16];
    }

    public abstract colorT getColor();
    public abstract Sprite getSprite();
    public abstract void dispose();
    public abstract String getSymbol();
    public abstract Moves getMoves();
}
