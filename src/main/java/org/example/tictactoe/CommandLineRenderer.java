package org.example.tictactoe;

import org.example.tictactoe.model.CellSelection;
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
        * TODO - This function should use the "output" PrintStream to print a command line representation of the board.
        *        Check out how the BoardRendererTest JUnit test expects it to be rendered. This method should not call
        *        renderMessage or renderError. Just directly print to this.output
        * */
        /**
         * 012 3 456 7 8910 11
         * --- | --- | ---
         * --- | --- | ---
         * --- | --- | ---
         */
        StringBuilder rowVal = new StringBuilder();
        String cellVal = "";
        String divVal = "|";
        TicTacToeCell[][] renderBoard = board.getCells();
        int trueCol = 4;

        this.output.println(BOARD_BORDER);
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
                        case EMPTY -> {
                            rowVal.append(" ");
                            break;
                        }
                        case X -> {
                            rowVal.append("X");
                            break;
                        }
                        case O -> {
                            rowVal.append("O");
                            break;
                        }
                    }
                }
            }

            this.output.print(rowVal+"\n");
            rowVal = new StringBuilder();
        }
        this.output.println(BOARD_BORDER);
    }

    public void renderMessage(String message) {
        this.output.println(message);
    }

    public void renderError(String message) {
        this.output.println(message);
    }

}
