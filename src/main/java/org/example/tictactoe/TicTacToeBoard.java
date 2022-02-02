package org.example.tictactoe;

import org.example.tictactoe.model.CellSelection;
import org.example.tictactoe.model.GameState;
import org.example.tictactoe.model.TicTacToeCell;

import static org.example.tictactoe.model.TicTacToeCell.EMPTY;

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
        boolean rowIsFull = false;



        if( !rowIsFull)return GameState.ONGOING;
        else return GameState.X_WINS;
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
