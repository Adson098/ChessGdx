package com.mygdx.game;
public class CONFIG {

    ///// WINDOW ////////////////////////////////
    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720 ;



    ////////// CELL /////////////////////////////

    public static final int CELL_WIDTH = 70;
    public static final int CELL_HEIGHT = 70;

    /////// CHESS BOARD /////////////////////////
    public static final int CHESS_BOARD_X = (WINDOW_WIDTH/2)-(4*CELL_WIDTH);
    public static final int CHESS_BOARD_Y =(WINDOW_HEIGHT/2) -(4*CELL_WIDTH);

    //////  PIECE ///////////////////////////////
    public static final int PIECE_TEXTURE_OFFSET_X = 2;
    public static final int PIECE_TEXTURE_OFFSET_Y = 0;

    public static final int PIECE_TEXTURE_SIZE_X = 55;
    public static final int PIECE_TEXTURE_SIZE_Y = 60;

    public static final int TRANSLATE_Y_TO_LUC(int y){
        int iy = WINDOW_HEIGHT - y;
     //   iy  = Math.abs(y- WINDOW_HEIGHT);

        return iy;
    }

}
