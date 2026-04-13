package com.franciscoreina.junglepuzzle.solver;

import com.franciscoreina.junglepuzzle.domain.Position;
import com.franciscoreina.junglepuzzle.domain.PuzzleBoard;
import com.franciscoreina.junglepuzzle.domain.PuzzlePiece;
import com.franciscoreina.junglepuzzle.solver.PuzzleSolver;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.franciscoreina.junglepuzzle.domain.VineColor.EMERALD;
import static com.franciscoreina.junglepuzzle.domain.VineColor.GREEN;
import static com.franciscoreina.junglepuzzle.domain.VineColor.TURQUOISE;
import static com.franciscoreina.junglepuzzle.domain.VineColor.YELLOW;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PuzzleSolverTest {

    @Test
    void shouldSolveSimple2x2Board() {
        PuzzleBoard board = new PuzzleBoard(2);

        /*
         Expected layout:
         [1][2]
         [3][4]
         */
        List<PuzzlePiece> pieces = List.of(
                new PuzzlePiece(1, List.of(), List.of(GREEN), List.of(YELLOW), List.of()),
                new PuzzlePiece(2, List.of(), List.of(), List.of(TURQUOISE), List.of(GREEN)),
                new PuzzlePiece(3, List.of(YELLOW), List.of(EMERALD), List.of(), List.of()),
                new PuzzlePiece(4, List.of(TURQUOISE), List.of(), List.of(), List.of(EMERALD))
        );

        PuzzleSolver solver = new PuzzleSolver(board, pieces);

        boolean solved = solver.solve();

        assertTrue(solved);
        assertTrue(board.isComplete());
        assertBoardIds(board,
                new int[][]{
                        {1, 2},
                        {3, 4}
                }
        );
    }

    @Test
    void shouldSolveSimple3x3Board() {
        PuzzleBoard board = new PuzzleBoard(3);

        List<PuzzlePiece> pieces = List.of(
                new PuzzlePiece(1, List.of(), List.of(GREEN), List.of(YELLOW), List.of()),
                new PuzzlePiece(2, List.of(), List.of(GREEN), List.of(TURQUOISE), List.of(GREEN)),
                new PuzzlePiece(3, List.of(), List.of(), List.of(EMERALD), List.of(GREEN)),

                new PuzzlePiece(4, List.of(YELLOW), List.of(GREEN), List.of(YELLOW), List.of()),
                new PuzzlePiece(5, List.of(TURQUOISE), List.of(GREEN), List.of(TURQUOISE), List.of(GREEN)),
                new PuzzlePiece(6, List.of(EMERALD), List.of(), List.of(EMERALD), List.of(GREEN)),

                new PuzzlePiece(7, List.of(YELLOW), List.of(GREEN), List.of(), List.of()),
                new PuzzlePiece(8, List.of(TURQUOISE), List.of(GREEN), List.of(), List.of(GREEN)),
                new PuzzlePiece(9, List.of(EMERALD), List.of(), List.of(), List.of(GREEN))
        );

        PuzzleSolver solver = new PuzzleSolver(board, pieces);

        boolean solved = solver.solve();

        assertTrue(solved);
        assertTrue(board.isComplete());
        assertBoardIds(board,
                new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }
        );
    }

    @Test
    void shouldReturnFalseWhenNoSolutionExists() {
        PuzzleBoard board = new PuzzleBoard(2);

        List<PuzzlePiece> pieces = List.of(
                new PuzzlePiece(1, List.of(), List.of(GREEN), List.of(), List.of()),
                new PuzzlePiece(2, List.of(), List.of(), List.of(), List.of(YELLOW))
        );

        PuzzleSolver solver = new PuzzleSolver(board, pieces);

        boolean solved = solver.solve();

        assertFalse(solved);
        assertFalse(board.isComplete());
    }

    @Test
    void shouldCountStepsWhenTryingToSolve() {
        PuzzleBoard board = new PuzzleBoard(2);

        List<PuzzlePiece> pieces = List.of(
                new PuzzlePiece(1, List.of(), List.of(GREEN), List.of(YELLOW), List.of()),
                new PuzzlePiece(2, List.of(), List.of(), List.of(TURQUOISE), List.of(GREEN)),
                new PuzzlePiece(3, List.of(YELLOW), List.of(EMERALD), List.of(), List.of()),
                new PuzzlePiece(4, List.of(TURQUOISE), List.of(), List.of(), List.of(EMERALD))
        );

        PuzzleSolver solver = new PuzzleSolver(board, pieces);

        solver.solve();

        assertTrue(solver.getSteps() > 0);
    }

    private static void assertBoardIds(PuzzleBoard board, int[][] expectedIds) {
        for (int row = 0; row < expectedIds.length; row++) {
            for (int col = 0; col < expectedIds[row].length; col++) {
                PuzzlePiece piece = board.get(new Position(row, col));
                assertNotNull(piece, "Expected a piece at position (" + row + ", " + col + ")");
                assertEquals(expectedIds[row][col], piece.getId());
            }
        }
    }
}
