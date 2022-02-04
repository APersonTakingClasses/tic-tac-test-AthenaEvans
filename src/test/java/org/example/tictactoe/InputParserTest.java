package org.example.tictactoe;

import org.example.tictactoe.input.InputMoveException;
import org.example.tictactoe.input.InputParser;
import org.example.tictactoe.model.CellSelection;
import org.example.tictactoe.model.TicTacToeCell;
import org.junit.jupiter.api.Test;

import static org.example.tictactoe.model.TicTacToeCell.EMPTY;
import static org.example.tictactoe.model.TicTacToeCell.X;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputParserTest {
    /*
    * TODO - Write some tests in this file. You should test the InputParser class. Please test the following behaviors
    *  1. When a user inputs a valid coordinate string (in the form 2,1 where 2 is the row and 1 is the column)
    *     the InputParser returns a CellSelection with what they entered
    *  2. If the user tries to use a coordinate with an out of bounds row or column, the InputParser throws an InputMoveException
    *  3. If the user tries to use a coordinate that has too many components, the InputParser throws an InputMoveException
    *  4. If the user tries to use a coordinate with invalid integer numbers, the InputParser throws an InputMoveException
    *  5. If the user tries to choose a coordinate in a square that is already filled with another value, the InputParser
    *     throws an InputMoveException
    * */

    /*1. When a user inputs a valid coordinate string (in the form 2,1 where 2 is the row and 1 is the column)
     *     the InputParser returns a CellSelection with what they entered
    * */
    @Test
    void userInputsValid() throws InputMoveException {
        String tester;
        var board = new TicTacToeBoard(new TicTacToeCell[][]{
                { EMPTY, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY }
        });
        tester = "2,2";
        CellSelection cellSelection = new CellSelection(2,2);
        InputParser inputParser = new InputParser();

        assertEquals(cellSelection,inputParser.parseInput(tester,board));
    }

    //2. If the user tries to use a coordinate with an out-of-bounds row or column, the InputParser throws an InputMoveException
    @Test
    void userInputsOutOfBounds() {
        String tester;
        var board = new TicTacToeBoard(new TicTacToeCell[][]{
                { EMPTY, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY }
        });
        tester = "5,5";
        InputParser inputParser = new InputParser();


        InputMoveException thrown =
                assertThrows(InputMoveException.class, () ->
                        inputParser.parseInput(tester,board), "One of your selections was out of bounds");

        assertEquals("One of your selections was out of bounds", thrown.getMessage());
    }

    //3. If the user tries to use a coordinate that has too many components, the InputParser throws an InputMoveException
    @Test
    void userInputsTooMany() {
        String tester;
        var board = new TicTacToeBoard(new TicTacToeCell[][]{
                { EMPTY, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY }
        });
        tester = "1";
        InputParser inputParser = new InputParser();

        InputMoveException thrown =
                assertThrows(InputMoveException.class, () ->
                        inputParser.parseInput(tester,board), "Invalid number of coordinates");

        assertEquals("Invalid number of coordinates", thrown.getMessage());
    }

    //4. If the user tries to use a coordinate with invalid integer numbers, the InputParser throws an InputMoveException
    @Test
    void userInputsInvalidIntegers() {
        String tester;
        var board = new TicTacToeBoard(new TicTacToeCell[][]{
                { EMPTY, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY }
        });
        tester = "9,2";
        InputParser inputParser = new InputParser();

        InputMoveException thrown =
                assertThrows(InputMoveException.class, () ->
                        inputParser.parseInput(tester,board), "One of your selections was out of bounds");

        assertEquals("One of your selections was out of bounds", thrown.getMessage());
    }


    /*5. If the user tries to choose a coordinate in a square that is already filled with another value, the InputParser
     *     throws an InputMoveException*/
    @Test
    void userInputsIntoFilledCell() {
        String tester;
        var board = new TicTacToeBoard(new TicTacToeCell[][]{
                { X, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY }
        });
        tester = "0,0";
        InputParser inputParser = new InputParser();

        InputMoveException thrown =
                assertThrows(InputMoveException.class, () ->
                        inputParser.parseInput(tester,board), "That is not an allowed move");

        assertEquals("That is not an allowed move", thrown.getMessage());
    }
}