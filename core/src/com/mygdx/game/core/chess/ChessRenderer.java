package com.mygdx.game.core.chess;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.core.chess.Chess;

public class ChessRenderer extends Chess {

    private SpriteBatch batch;

    public ChessRenderer() {
        super();
        batch = new SpriteBatch();


    }

    public void render() {
        batch.begin();

            for (int j = 0; j < 8; j++) {
                for (int i = 0; i < 8; i++) {
                    board.getPieces()[j][i].getSprite().draw(batch);
                    if(!board.getPieces()[j][i].isEmpty()) {
                        board.getPieces()[j][i].getPiece().getSprite().draw(batch);
                    }

                }
            }


        /*
        for(int i= 0;i<64; i++){
            board.getPiecesArray()[i].getSprite().draw(batch);
            if(!board.getPiecesArray()[i].isEmpty()) {
                board.getPiecesArray()[i].getPiece().getSprite().draw(batch);
            }
        }

         */
        batch.end();
    }

    public void dispose(){
        batch.dispose();
        board.dispose();
    }
}

