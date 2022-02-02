package org.example.tictactoe;

import org.example.tictactoe.model.TicTacToeCell;

import java.io.PrintStream;

public class CommandLineRenderer {

    private final PrintStream output;
    static final String BOARD_BORDER = "============";
    public CommandLineRenderer(PrintStream output) {
        this.output = output;
    }

    public void renderBoard(TicTacToeBoard board) {
        /*
          012 3 456 7 8910 11
          --- | --- | ---
          --- | --- | ---
          --- | --- | ---
         */
        StringBuilder rowVal = new StringBuilder();
        String divVal = "|";
        TicTacToeCell[][] renderBoard = board.getCells();
        int trueCol = 4;

        this.output.print(BOARD_BORDER+"\n");
        for( int row = 0; row < 3; row++ ){
            for(int col = 0; col<12; col++){
                if(col%2==0) rowVal.append(" ");        //stays " " = 0,2,4,6,8,10,11
                else if(col == 11);
                else if(col==3 || col==7) rowVal.append(divVal);   //divVal | = 3,7
                else {                                             //changes val = 1,5,9
                    if(col == 1) trueCol= 0;    // 1mod3 = 1
                    if(col == 5) trueCol= 1;    // 5mod3 = 2
                    if(col == 9) trueCol= 2;    // 9mod3 = 0
                    switch ( renderBoard[row][trueCol] ){
                        case EMPTY -> rowVal.append(" ");
                        case X -> rowVal.append("X");
                        case O -> rowVal.append("O");
                    }
                }
            }

            this.output.print(rowVal+"\n");
            rowVal = new StringBuilder();
        }
        this.output.print(BOARD_BORDER+"\n");
    }

    public void renderMessage(String message) {
        this.output.println(message);
    }

    public void renderError(String message) {
        this.output.println(message);
    }

}
