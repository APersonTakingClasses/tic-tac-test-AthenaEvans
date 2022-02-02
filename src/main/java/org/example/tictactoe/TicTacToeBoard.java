package org.example.tictactoe;

import org.example.tictactoe.model.CellSelection;
import org.example.tictactoe.model.GameState;
import org.example.tictactoe.model.TicTacToeCell;

import static org.example.tictactoe.model.TicTacToeCell.EMPTY;
import static org.example.tictactoe.model.TicTacToeCell.X;

public class TicTacToeBoard {

    private final TicTacToeCell[][] cells;

    public TicTacToeBoard() {
        this.cells = new TicTacToeCell[][]{
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY}
        };
    }

    TicTacToeBoard(TicTacToeCell[][] cells) {
        this.cells = cells;
    }

    public void setCell(CellSelection cell, TicTacToeCell value) {
        this.cells[cell.row()][cell.col()] = value;
    }

    public TicTacToeCell[][] getCells() {
        return this.cells;
    }

    public GameState checkGameState() {
        /*
         * TODO - Based on the current state of the board, is the game still ongoing, has a player won, or is there a tie?
         */
        /**
         * -0,0- | -0,1- | -0,2-
         * -1,0- | -1,1- | -1,2-
         * -2,0- | -2,1- | -2,2-
         *
         * win when: row matches, foreach row : each cell.col() is same val
         * 	: col matches, foreach col : each cell.row() is same val
         * 	: diagonal top left to bot right : same vals for (0,0),(1,1),(2,2)
         * 	: diagonal top right to bot left : same vals for (2,0),(1,1),(0,2)
         */
        boolean gameOver = false, xWIns=false, oWins=false, gameTied=false;
        TicTacToeCell first=null, second=null, third=null;

        //loop for rows
        for(int row = 0; row<3; row++){
            first = this.cells[row][0];
            second = this.cells[row][1];
            third = this.cells[row][2];
            if(first == EMPTY) {
                gameOver=false;
            }
            else if( first == second && first == third){
                gameOver=true;
                switch ( first ) {
                    case X -> xWIns = true;
                    case O -> oWins = true;
                }
            }
        }

        //loop for cols
        for(int col = 0; col<3; col++){
            first = this.cells[0][col];
            second = this.cells[1][col];
            third = this.cells[2][col];
            if (first == EMPTY) {
                gameOver=false;
            }
            else if( first == second && first == third){
                switch ( first ) {
                    case X -> xWIns = true;
                    case O -> oWins = true;
                }
            }
        }

        //diag left->right : same vals for (0,0),(1,1),(2,2)
        first = this.cells[0][0];
        second = this.cells[1][1];
        third = this.cells[2][2];
        if( first != EMPTY){
            if(first == second && first == third){
                switch ( first ){
                    case O -> oWins=true;
                    case X -> xWIns=true;
                }
            }
            gameOver=true;
        }

        //diag right->left : same vals for (2,0),(1,1),(0,2)
        first = this.cells[2][0];
        second = this.cells[1][1];
        third = this.cells[0][2];
        if( first != EMPTY){
            if(first == second && first == third){
                switch ( first ){
                    case O -> oWins=true;
                    case X -> xWIns=true;
                }
            }
            gameOver=true;
        }

        // at this point, all win conditions are evaluated, game is currently ongoing, if no cell
        // holds a EMPTY at this point the game is drawn
        if( !xWIns && !oWins ) {
            for(int row = 0; row<3; row++){
                first = this.cells[row][0];
                second = this.cells[row][1];
                third = this.cells[row][2];
                if( first != EMPTY && second != EMPTY &&
                    third != EMPTY) return GameState.TIE;
            }
        }

        // results
        if ( xWIns) return  GameState.X_WINS;
        else if(oWins) return  GameState.O_WINS;
        else return GameState.ONGOING;
    }

    public boolean isLegalMove(CellSelection selection) {
        /*
        * TODO - Based on the current state of the board, is the input selection allowed? Note that this method does not
        *  need to check that the row and column are in the right range. The InputParser is already doing that
        * */
        if( cells[selection.row()][selection.col()] != EMPTY) return true;
        else return false;
    }

}
