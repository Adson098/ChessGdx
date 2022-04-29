package com.mygdx.game.core.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.core.chess.colorT;
import com.mygdx.game.piece.Pawn;
import com.mygdx.game.piece.piece;

public class Cell {
    public int x;
    public int y;
    colorT color;
    piece cpiece;
    private int id;
    private Texture texture;
    private Sprite sprite;
    private boolean empty;

    public Cell(int x, int y, colorT c, boolean mempty, int iid){
        this.x = x;
        this.y = y;
        empty = mempty;
        id = iid;

        this.color = c;
        this.cpiece = new Pawn(colorT.black);
        if(color == colorT.white){
            texture = new Texture(Gdx.files.internal("jpg/128px/whiteCell.png"));

        }
        else{
            texture = new Texture(Gdx.files.internal("jpg/128px/blackCell.png"));
        }
        sprite = new Sprite(texture);
    }

    colorT getColor(){
        return color;
    }
    public boolean isEmpty(){
        return empty;
    }
    public void setEmpty(){
        empty = true;
    }
    void setPiece(piece p){
        cpiece = p;
        empty = false;
    }
    public piece getPiece(){
        return cpiece;
    }
    public int getId(){
        return id;
    }
    public Sprite getSprite(){
        return sprite;
    }
}
