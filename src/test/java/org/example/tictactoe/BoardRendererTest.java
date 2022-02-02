package org.example.tictactoe;

import org.example.tictactoe.model.TicTacToeCell;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import static org.example.tictactoe.model.TicTacToeCell.EMPTY;
import static org.example.tictactoe.model.TicTacToeCell.O;
import static org.example.tictactoe.model.TicTacToeCell.X;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardRendererTest {

    @Test
    void render() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream fakeStream = new PrintStream(outputStreamCaptor);

        CommandLineRenderer renderer = new CommandLineRenderer(fakeStream);
        renderer.renderBoard(new TicTacToeBoard(new TicTacToeCell[][]{
            { EMPTY, X, X },
            { EMPTY, O, X },
            { EMPTY, X, O },
        }));

        String output = outputStreamCaptor.toString(Charset.defaultCharset());
        assertEquals(
            CommandLineRenderer.BOARD_BORDER + "\n"
            + "   | X | X \n"
            + "   | O | X \n"
            + "   | X | O \n"
            + CommandLineRenderer.BOARD_BORDER + "\n", output);
    }
}