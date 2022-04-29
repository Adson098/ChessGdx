package com.mygdx.game.core;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.CONFIG;
import com.mygdx.game.core.chess.ChessRenderer;
import com.mygdx.game.engine.GameState;

public class PlayState implements GameState {

    private ChessRenderer chess;
    //private Board board;

    @Override
    public void create() {
        chess = new ChessRenderer();
        //board = new Board();


    }

    @Override
    public void render() {
        chess.render();
    }

    @Override
    public void destroy() {

    }

    @Override
    public void input() {
                int clickX = Gdx.input.getX();
                int clickY = Math.abs(Gdx.input.getY() - CONFIG.WINDOW_HEIGHT);
                if (clickX >= CONFIG.CHESS_BOARD_X && clickX <= CONFIG.CHESS_BOARD_X + (8 * CONFIG.CELL_WIDTH)) {
                    if (clickY >= CONFIG.CHESS_BOARD_Y && clickY <= CONFIG.CHESS_BOARD_Y + (8 * CONFIG.CELL_HEIGHT)) {
                        chess.clickInput(clickX, clickY);
                    }
                }
    }





    @Override
    public void update(double deltaTime) {
    }

}