package com.mygdx.game.core.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.CONFIG;
import com.mygdx.game.piece.Empty;

import com.mygdx.game.piece.piece;

public class Cell {
    public int j;
    public int i;
    colorT color;
    piece cpiece;
    private int id;
    private Texture texture;
    private Sprite sprite;
    private boolean empty;

    public Cell(int ii, int ij, colorT c, int iid){
        this.j = ij;
        this.i = ii;
        empty = true;
        id = iid;

        this.color = c;
        this.cpiece = new Empty(colorT.black);
        if(color == colorT.white){
            texture = new Texture(Gdx.files.internal("jpg/128px/whiteCell.png"));

        }
        else{
            texture = new Texture(Gdx.files.internal("jpg/128px/blackCell.png"));
        }
        sprite = new Sprite(texture);
        sprite.setPosition(CONFIG.CHESS_BOARD_X + j * CONFIG.CELL_WIDTH, CONFIG.TRANSLATE_Y_TO_LUC(CONFIG.CHESS_BOARD_Y + i * CONFIG.CELL_HEIGHT)-CONFIG.CELL_HEIGHT);
        sprite.setSize(CONFIG.CELL_WIDTH,CONFIG.CELL_HEIGHT);
    }

    colorT getColor(){
        return color;
    }
    public boolean isEmpty(){
        return empty;
    }
    void setPiece(piece p){
        cpiece = p;
        if(p instanceof Empty){
            empty = true;
        }
        else {
            empty = false;
            p.getSprite().setPosition(CONFIG.CHESS_BOARD_X + j * CONFIG.CELL_WIDTH + CONFIG.PIECE_TEXTURE_OFFSET_X, CONFIG.TRANSLATE_Y_TO_LUC(CONFIG.CHESS_BOARD_Y + i * CONFIG.CELL_HEIGHT + CONFIG.PIECE_TEXTURE_OFFSET_Y)-CONFIG.CELL_HEIGHT);
            p.getSprite().setSize(CONFIG.PIECE_TEXTURE_SIZE_X, CONFIG.PIECE_TEXTURE_SIZE_Y);
        }
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
