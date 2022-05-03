package com.mygdx.game.core.chess;

import com.mygdx.game.CONFIG;
import com.mygdx.game.piece.*;

public class Board {

    public class PosMoves{ // possible moves matrix and data
        public int[][] matrix;
    }

    public final String[][] position =new String[][]{
            {"w","s","g","h","k","g","s","w"},
            {"p","p","p","p","p","p","p","p"},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {"P","P","P","P","P","P","P","P"},
            {"W","S","G","H","K","G","S","W"}
    };
    private colorT orientation;
    private  Cell[][] board;
    private PosMoves posMoves;

    Board(colorT colorPrespective){
        board = new Cell[8][8];
        setupBoard();
        setPawns(colorPrespective);
        posMoves = new PosMoves();
        posMoves.matrix = new int[][]{
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},

        };
    }

    private void setupBoard(){
        for(int i = 0, x=0, c=0;i<8;i++){
            x+=1;
            for(int j = 0;j <8; j++,x++){

                if(x%2==0) {
                    board[i][j] = new Cell(i,j,colorT.white,c);
                }
                else {
                    board[i][j] =new Cell(i,j,colorT.black,c);
                }
                c++;
            }
        }
    }
    private void setPawns(colorT colorPerspective){
        int tx,ty;
        if(colorPerspective == colorT.white) {
             tx = 0;
             ty = 0;
        }
        else{
             tx = -7;
             ty = -7;
        }
            for (int i = 0, iy = ty; i <8; i++,iy+=1) {
                for (int j = 0,ix = tx; j <8; j++,ix+=1) {
                    int x = Math.abs(ix);
                    int y = Math.abs(iy);
                    if (position[i][j] == "p") {
                        board[y][x].setPiece(new Pawn(colorT.black));
                    } else if (position[i][j] == "P") {
                        board[y][x].setPiece(new Pawn(colorT.white));
                    } else if (position[i][j] == "g") {
                        board[y][x].setPiece(new Bishop(colorT.black));
                    } else if (position[i][j] == "G") {
                        board[y][x].setPiece(new Bishop(colorT.white));
                    } else if (position[i][j] == "S") {
                        board[y][x].setPiece(new Knight(colorT.white));
                    } else if (position[i][j] == "s") {
                        board[y][x].setPiece(new Knight(colorT.black));
                    } else if (position[i][j] == "H") {
                        board[y][x].setPiece(new Queen(colorT.white));
                    } else if (position[i][j] == "h") {
                        board[y][x].setPiece(new Queen(colorT.black));
                    } else if (position[i][j] == "W") {
                        board[y][x].setPiece(new Rook(colorT.white));
                    } else if (position[i][j] == "w") {
                        board[y][x].setPiece(new Rook(colorT.black));
                    } else if (position[i][j] == "k") {
                        board[y][x].setPiece(new King(colorT.black));
                    } else if (position[i][j] == "K") {
                        board[y][x].setPiece(new King(colorT.white));
                    } else if (position[i][j] == " ") {
                        board[y][x].setPiece(new Empty(colorT.white));
                    }
                }
            }
        }

/*


    private void resetAllSpritePosition(){
     //   if (orientation == colorT.white) {
        Cell[][] tempboard = new Cell[8][8];
        for(int i = 0, x=0, c=0;i<8;i++){
            x+=1;
            for(int j = 0;j <8; j++,x++){

                if(x%2==0) {
                    tempboard[i][j] = new Cell(i,j,colorT.white,true,c);
                }
                else {
                    tempboard[i][j] =new Cell(i,j,colorT.black,true,c);
                }
                tempboard[i][j].getSprite().setSize(CONFIG.CELL_WIDTH,CONFIG.CELL_HEIGHT);
                c++;
            }
        }

            for (int i = 0,y = 7; i < 8; i++,y--) {
                for (int j = 0,x = 7; j < 8; j++,x--) {

                    if (!board[i][j].isEmpty()) {
                        System.out.println("figura: " + board[i][j].getPiece().getSymbol() + " na figure "+ board[y][x].getPiece().getSymbol() + " i: " + i + " j: " + j + " y: "+y + " x: "+x);
                        piece tempPiece =  board[y][x].getPiece();
                        tempboard[i][j].setPiece(tempPiece);
                    }

                }
            }
        for(int i = 0, x=0, c=0;i<8;i++){

            for(int j = 0;j <8; j++,x++) {
                board[i][j].setPiece(tempboard[i][j].getPiece());

            }
        }
      //  } else {

            for (int i = 7,y = 0; i >=0; i--,y++) {
                for (int j = 0,x =7; j < 8; j++,x--) {
                    board[i][i].getSprite().setPosition(CONFIG.CHESS_BOARD_X + y * CONFIG.CELL_WIDTH, CONFIG.CHESS_BOARD_Y + x * CONFIG.CELL_HEIGHT);

                    if (position[j][i] == " ") {
                        continue;
                    }
                    board[j][i].getPiece().getSprite().setPosition(CONFIG.CHESS_BOARD_X + y * CONFIG.CELL_WIDTH + CONFIG.PIECE_TEXTURE_OFFSET_X, CONFIG.CHESS_BOARD_Y + x * CONFIG.CELL_HEIGHT + CONFIG.PIECE_TEXTURE_OFFSET_Y);
                }
            }


    }


 */

    ///  PUBLIC
    public Cell[][] getPieces(){
        return board;
    }
    public PosMoves getPosMoves(){
        return posMoves;
    }

    public void dispose(){
        for(int i = 0;i<8;i++){
            for(int j = 0;j <8; j++){
                board[i][j].getPiece().dispose();
            }
        }
    }

    public String[][] returnBoardStringMatrix(){
        String[][] mboard = new String[8][8];

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                    if (board[j][i].isEmpty()) {
                        mboard[j][i] = "";
                        continue;
                    }
                    mboard[j][i] = board[j][i].getPiece().getSymbol();

                }
            }
        return mboard;
    }

    public void setPosMoves(int[][] iposMovesMatrix){
        posMoves.matrix = iposMovesMatrix;
    }


    public void printMatrixBoard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i==0 && j == 0){
                    System.out.print("1");
                }
                if (position[i][j] == " ") {
                    System.out.print(" . ");
                    continue;
                }
                System.out.print(board[i][j].getPiece().getSymbol());

            }
            System.out.println("");
        }
    }
    public Cell[] getPiecesArray(){
        Cell[] temp = new Cell[64];
        for(int i = 0; i<8;i++){
            for(int j = 0; j<8;j++){
                temp[i+j] = board[i][j];
            }
        }
        return temp;
    }

    public void printPosMatrixBoard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(posMoves.matrix[i][j]+" ");

            }
            System.out.println("");
        }
    }


}
