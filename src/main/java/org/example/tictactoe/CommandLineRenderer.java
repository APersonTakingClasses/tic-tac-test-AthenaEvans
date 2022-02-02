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
        String rowVal = "";
        String cellVal = "   ";
        String divVal = "|";
        TicTacToeCell[][] renderBoard = board.getCells();
        CellSelection cS = new CellSelection(0,2);

        this.output.println(BOARD_BORDER);
        for( int row = 0; row < 3; row++ ){
            for(int col = 0; col<12; col++){
                if(col%2==0 || col==11) rowVal+=" ";        //stays " " = 0,2,4,6,8,10,11
                else if(col==3 || col==7) rowVal+=divVal;   //divVal | = 3,7
                else {                                      //changes val = 1,5,9
                    //cS = renderBoard[row][col].getrow();
                    rowVal+= cS.col();
                }
            }

            this.output.println(rowVal);
            rowVal = "";
            cellVal = "";
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
