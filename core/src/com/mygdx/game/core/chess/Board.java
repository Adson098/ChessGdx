package com.mygdx.game.core.chess;

import com.mygdx.game.CONFIG;
import com.mygdx.game.piece.*;

public class Board {

    public class PosMoves{ // possible moves matrix and data
        public int[][] matrix;
    }

    public final String[][] position =new String[][]{
            {"W","S","G","H","K","G","S","W"},
            {"P","P","P","P","P","P","P","P"},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {"p","p","p","p","p","p","p","p"},
            {"w","s","g","h","k","g","s","w"}
    };
    private colorT orientation;
    private  Cell[][] board;
    private PosMoves posMoves;

    Board(){
        board = new Cell[8][8];
        setupBoard();
        setPawns();
        setupSpritePositionbyWhite();
        resetAllSpritePosition();
        orientation = colorT.black;
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
                    board[i][j] = new Cell(i,j,colorT.white,true,c);
                }
                else {
                    board[i][j] =new Cell(i,j,colorT.black,true,c);
                }
                board[i][j].getSprite().setSize(CONFIG.CELL_WIDTH,CONFIG.CELL_HEIGHT);
                c++;
            }
        }
    }
    private void setPawns(){
        for(int i = 0;i<8;i++){
            for(int j = 0;j <8; j++) {
                if (position[i][j] == "p") {
                    board[i][j].setPiece(new Pawn(colorT.black));
                } else if (position[i][j] == "P") {
                    board[i][j].setPiece(new Pawn(colorT.white));
                } else if (position[i][j] == "g") {
                    board[i][j].setPiece(new Bishop(colorT.black));
                } else if (position[i][j] == "G") {
                    board[i][j].setPiece(new Bishop(colorT.white));
                } else if (position[i][j] == "S") {
                    board[i][j].setPiece(new Knight(colorT.white));
                } else if (position[i][j] == "s") {
                    board[i][j].setPiece(new Knight(colorT.black));
                } else if (position[i][j] == "H") {
                    board[i][j].setPiece(new Queen(colorT.white));
                } else if (position[i][j] == "h") {
                    board[i][j].setPiece(new Queen(colorT.black));
                } else if (position[i][j] == "W") {
                    board[i][j].setPiece(new Rook(colorT.white));
                } else if (position[i][j] == "w") {
                    board[i][j].setPiece(new Rook(colorT.black));
                } else if (position[i][j] == "k") {
                    board[i][j].setPiece(new King(colorT.black));
                } else if (position[i][j] == "K") {
                    board[i][j].setPiece(new King(colorT.white));
                }
                if(board[i][j].isEmpty()){
                    continue;
                }
                board[i][j].getPiece().getSprite().setSize(CONFIG.PIECE_TEXTURE_SIZE_X, CONFIG.PIECE_TEXTURE_SIZE_Y);
            }
        }
    }
    private void setupSpritePositionbyWhite() {
        orientation = colorT.white;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board[i][j].getSprite().setPosition(CONFIG.CHESS_BOARD_X + j * CONFIG.CELL_WIDTH, CONFIG.CHESS_BOARD_Y + i * CONFIG.CELL_HEIGHT);

                    if (board[i][j].isEmpty()) {
                        continue;
                    }
                    board[i][j].getPiece().getSprite().setPosition(CONFIG.CHESS_BOARD_X + j * CONFIG.CELL_WIDTH + CONFIG.PIECE_TEXTURE_OFFSET_X, CONFIG.CHESS_BOARD_Y + i * CONFIG.CELL_HEIGHT + CONFIG.PIECE_TEXTURE_OFFSET_Y);

                }
            }


        }


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
        /*
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
    }


    ///  PUBLIC
    public Cell[][] getPieces(){
        return board;
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
    public void changeOrientation(colorT orient){
        orientation = orient;
        resetAllSpritePosition();
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

    public PosMoves getPosMoves(){
        return posMoves;
    }

    public void printMatrixBoard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (position[i][j] == " ") {
                    System.out.print(" . ");
                    continue;
                }
                System.out.print(board[i][j].getPiece().getSymbol());

            }
            System.out.println("");
        }
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
