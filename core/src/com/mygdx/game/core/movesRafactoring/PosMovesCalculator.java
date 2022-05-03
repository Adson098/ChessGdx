package com.mygdx.game.core.movesRafactoring;

import com.mygdx.game.core.chess.Board;
import com.mygdx.game.core.chess.Cell;
import com.mygdx.game.vector2i;

public class PosMovesCalculator {

    public PosMovesCalculator(){ // possible moves calculator

    }

    public static int[][] stage1(Board iboard, Cell icell){ // nalozenie mozliwych ruchow figury na macierz szachownicy

        vector2i posMatrixSize = icell.getPiece().getMoves().size;
        int posPieceX = icell.getPiece().getMoves().location.x;
        int posPieceY = icell.getPiece().getMoves().location.y;
        int[][] tempMatrix = new int[8][8];
        int[][] posMatrix = icell.getPiece().getMoves().MOVES;

        int startPointY = icell.i;
        /*
        for(int i = icell.y;i<posMatrixSize.y+icell.y;i++) {
            for (int j = 0; j < posMatrixSize.x; j++) {

                int deltaX = icell.x - posPieceX;
                int deltaY = icell.y - posPieceY;
                int newCoordX = i-deltaY;
                int newCoordY = j -deltaX;
                if(newCoordY >0 && newCoordY< 8){
                    if(newCoordX > 0 && newCoordX <8){
                        tempMatrix[i][j] = posMatrix[i-deltaY][j-deltaX];
                    }
                }

            }
        }
        */

        int deltaX = posPieceX - icell.j;
        int deltaY = posPieceY -icell.i;
        for(int i = 0;i<posMatrixSize.y && i <8;i++){
            for(int j = 0; j < posMatrixSize.x && j <8;j++){
                if(j+deltaX >0 && j+deltaX <8) {
                    if(i+deltaY>0 && i+deltaY <8){
                        tempMatrix[i + deltaY][j + deltaX] = posMatrix[i][j];
                    }
                }
            }
        }
        return tempMatrix;
    }
}

