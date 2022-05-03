package com.mygdx.game.core.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.CONFIG;
import com.mygdx.game.core.mouseStateT;
import com.mygdx.game.piece.Empty;
import com.mygdx.game.vector2i;


public class Chess {

    protected Board board;
    protected mouseStateT mouseState;
    protected colorT currentColor;

    Chess(){
        currentColor = colorT.white;
        board = new Board(currentColor);
        mouseState = mouseStateT.let;

    }
    private Cell mapClicktoCell(int x, int y){
        x -= CONFIG.CHESS_BOARD_X;
        y -= CONFIG.CHESS_BOARD_Y;
        x /= CONFIG.CELL_WIDTH;
        y /= CONFIG.CELL_HEIGHT;
        return board.getPieces()[y][x];

    }

    public void clickInput(int x, int y){
        //System.out.println("nacisnieto coord : " + Gdx.input.getX() + " y: " + CONFIG.TRANSLATE_Y_TO_LUC(Gdx.input.getY()) + " Y norm: " + Gdx.input.getY());
        // *** gdy puszczono ****  ///
        if(!Gdx.input.isTouched() && mouseState == mouseStateT.pressed){
            Cell tempCell;
            tempCell = mapClicktoCell(x,y);

            if(!(tempCell.getPiece() instanceof Empty)&&tempCell.getPiece().getColor() == currentColor) {
                System.out.println("START CALCULATING piece is: " + tempCell.getPiece().getSymbol());
                putPiecesMoveonPosMatrix(board,tempCell,board.getPosMoves().matrix);
            }

           // System.out.println("puszczone coord x: " + Gdx.input.getX() + " y: " + Math.abs(Gdx.input.getY()- CONFIG.WINDOW_HEIGHT));
            mouseState = mouseStateT.let;

        }
            /// *** gdy wcisnieto *** ////
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            Cell tempCell;
            tempCell = mapClicktoCell(x,y);
            //System.out.println("nacisnieto coord : " + Gdx.input.getX() + " y: " + CONFIG.TRANSLATE_Y_TO_LUC(Gdx.input.getY()) + " Y norm: " + Gdx.input.getY());
            mouseState = mouseStateT.pressed;
        }


    }
/*
    public void generatePossibleMoves(Board iboard, Cell icell){
        int[][] posMovesMatrix = new int[8][8];
        putPiecesMovesonPosMatrix(iboard, icell,posMovesMatrix);


    }
    */


    public void putPiecesMoveonPosMatrix(Board iboard, Cell icell, int[][] posMovesMatrix) {
        if (icell != null) {
            vector2i posMatrixSize = icell.getPiece().getMoves().size;
           vector2i posPieceLocation = icell.getPiece().getMoves().location;
            int[][] tempMatrix = new int[8][8];
            int[][] posMatrix = icell.getPiece().getMoves().MOVES;
            //System.out.println("posMatrixSize. x: " + posMatrixSize.x + " posMatrixSize y: " + posMatrixSize.y);

            int startPointY = icell.i - posPieceLocation.y;
            int startPointX = icell.j - posPieceLocation.x;
            System.out.println("AA StartPointX " + startPointX+ " startPointY " + startPointY+ " posPieceX " + posPieceLocation.x + " posPieceY " + posPieceLocation.y + " icellX " + icell.j + " icellY " + icell.i);
            for (int i = 0; i < posMatrixSize.y && i < 8; i++) {
                for (int j = 0; j < posMatrixSize.x && j < 8; j++) {

                    if ((j + startPointX )>= 0 && (j + startPointX )< 8) {
                        if ((i + startPointY) >= 0 &&( i + startPointY) < 8) {
                            System.out.println("Y: " + j + startPointY + " X: " + i + startPointY +  " icellX " + icell.j + " icellY " + icell.i + " i: "+i + " j "+j);
                            tempMatrix[startPointX + j][startPointY + i] = posMatrix[i][j];


                        }

                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(tempMatrix[j][i] + " ");

                }
                System.out.println("");
            }
            board.printMatrixBoard();
            iboard.setPosMoves(tempMatrix);
            System.out.println("FINISH CALCULATING");
        }
    }

}
