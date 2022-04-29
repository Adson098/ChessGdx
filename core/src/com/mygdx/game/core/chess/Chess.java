package com.mygdx.game.core.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.CONFIG;
import com.mygdx.game.core.mouseStateT;
import com.mygdx.game.vector2i;


public class Chess {

    protected Board board;
    protected mouseStateT mouseState;

    Chess(){
        board = new Board();
        board.printMatrixBoard();
       // board.changeOrientation(colorT.black);
        //board.printMatrixBoard();
        mouseState = mouseStateT.let;
    }
    private Cell mapClicktoCell(int x, int y){
        x -= CONFIG.CHESS_BOARD_X;
        y -= CONFIG.CHESS_BOARD_Y;
        x /= CONFIG.CELL_WIDTH;
        y /= CONFIG.CELL_HEIGHT;
        System.out.print("CLICK EVENT ON CELL: x: "+x   + " y: " + y );
        System.out.println();
        if(board.getPieces()[y][x].isEmpty()) return null;
        return board.getPieces()[y][x];

    }

    public void clickInput(int x, int y){
        // *** gdy puszczono ****  ///
        if(!Gdx.input.isTouched() && mouseState == mouseStateT.pressed){
            Cell tempCell;
            tempCell = mapClicktoCell(x,y);
           // tempCell.getPiece().getSprite().setPosition(0,0);
           // putPiecesMoveonPosMatrix(board,tempCell,board.getPosMoves().matrix);
            if(!(tempCell == null)) {
                System.out.println("START CALCULATING piece is: " + tempCell.getPiece().getSymbol());
                putPiecesMoveonPosMatrix(board,tempCell,board.getPosMoves().matrix);
            }
          //  board.printMatrixBoard();
            //board.printPosMatrixBoard();
           // System.out.println("puszczone coord x: " + Gdx.input.getX() + " y: " + Math.abs(Gdx.input.getY()- CONFIG.WINDOW_HEIGHT));
            mouseState = mouseStateT.let;

        }
            /// *** gdy wcisnieto *** ////
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            Cell tempCell;
            tempCell = mapClicktoCell(x,y);
           // System.out.println("nacisnieto coord : " + Gdx.input.getX() + " y: " + Math.abs(Gdx.input.getY()- CONFIG.WINDOW_HEIGHT));
            mouseState = mouseStateT.pressed;
        }
      //  if(Gdx.input.isButtonJustPressed() && mouseState)


    }
/*
    public void generatePossibleMoves(Board iboard, Cell icell){
        int[][] posMovesMatrix = new int[8][8];
        putPiecesMovesonPosMatrix(iboard, icell,posMovesMatrix);


    }
    */


    public void putPiecesMoveonPosMatrix(Board iboard, Cell icell, int[][] posMovesMatrix) {
        if (icell != null) {
            System.out.println("//////////");
            System.out.println("//////////");
            System.out.println("START CALCULATING piece is: " + icell.getPiece().getSymbol());
            System.out.println("//////////");
            System.out.println("//////////");
            vector2i posMatrixSize = icell.getPiece().getMoves().size;
            int posPieceY = icell.getPiece().getMoves().location.x;
            int posPieceX = icell.getPiece().getMoves().location.y;
            int[][] tempMatrix = new int[8][8];
            int[][] posMatrix = icell.getPiece().getMoves().MOVES;
            System.out.println("posMatrixSize. x: " + posMatrixSize.x + " posMatrixSize y: " + posMatrixSize.y);

            int startPointY = icell.y;
            int deltaX = posPieceX - icell.x;
            int deltaY = posPieceY - icell.y;
            System.out.println("AA DeltaX " + deltaX + " DeltaY " + deltaY + " posPieceX " + posPieceX + " posPieceY " + posPieceY + " icellX " + icell.x + " icellY " + icell.y);
            for (int i = 0; i < posMatrixSize.y && i < 8; i++) {
                for (int j = 0; j < posMatrixSize.x && j < 8; j++) {
                    if (board.position[j][i].isEmpty()) {
                        System.out.print(" . ");
                        continue;
                    }
                    System.out.print(board.getPieces()[j][i].getPiece().getSymbol());


                    //System.out.println("");
                    if (j + deltaX > 0 && j + deltaX < 8) {
                        if (i + deltaY > 0 && i + deltaY < 8) {
                            System.out.println("Y: " + j + deltaY + " X: " + i + deltaX + " DeltaX " + deltaX + " DeltaY " + deltaY + " posPieceX " + posPieceX + " posPieceY " + posPieceY + " icellX " + icell.x + " icellY " + icell.y);
                            // tempMatrix[j + deltaY][i + deltaX] = posMatrix[j][i];


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
