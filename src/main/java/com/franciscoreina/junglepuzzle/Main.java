package com.franciscoreina.junglepuzzle;

import com.franciscoreina.junglepuzzle.domain.Position;
import com.franciscoreina.junglepuzzle.domain.PuzzleBoard;
import com.franciscoreina.junglepuzzle.domain.PuzzlePiece;
import com.franciscoreina.junglepuzzle.factory.PuzzlePieceFactory;
import com.franciscoreina.junglepuzzle.solver.PuzzleSolver;

import java.util.List;

public class Main {

    private static final int BOARD_SIZE = 6;
    private static final int EXPECTED_PIECE_COUNT = 36;

    public static void main(String[] args) {
        PuzzleBoard board = new PuzzleBoard(BOARD_SIZE);
        List<PuzzlePiece> pieces = PuzzlePieceFactory.createPieces();

        validatePieceCount(pieces);

        PuzzleSolver solver = new PuzzleSolver(board, pieces);

        long startTime = System.currentTimeMillis();
        boolean solved = solver.solve();
        long endTime = System.currentTimeMillis();

        printResult(board, solver, solved, endTime - startTime);
    }

    private static void validatePieceCount(List<PuzzlePiece> pieces) {
        if (pieces.size() != EXPECTED_PIECE_COUNT) {
            throw new IllegalStateException("Expected " + EXPECTED_PIECE_COUNT + " pieces, but got " + pieces.size());
        }
    }

    private static void printResult(PuzzleBoard board, PuzzleSolver solver, boolean solved, long elapsedMillis) {
        if (!solved) {
            System.out.println("No solution found.");
            System.out.println("Steps: " + solver.getSteps());
            System.out.println("Elapsed time: " + elapsedMillis + " ms");
            return;
        }

        System.out.println("Solution found.");
        System.out.println("Steps: " + solver.getSteps());
        System.out.println("Elapsed time: " + elapsedMillis + " ms");

        System.out.println();
        System.out.println("IDs:");
        printIdMatrix(board);

        System.out.println();
        System.out.println("Rotations:");
        printRotationMatrix(board);
    }

    private static void printIdMatrix(PuzzleBoard board) {
        int size = board.getSize();

        for (int row = 0; row < size; row++) {
            StringBuilder line = new StringBuilder("[");

            for (int col = 0; col < size; col++) {
                PuzzlePiece piece = board.get(new Position(row, col));
                line.append(piece == null ? 0 : piece.getId());

                if (col < size - 1) {
                    line.append(", ");
                }
            }

            line.append("]");
            System.out.println(line);
        }
    }

    private static void printRotationMatrix(PuzzleBoard board) {
        int size = board.getSize();

        for (int row = 0; row < size; row++) {
            StringBuilder line = new StringBuilder("[");

            for (int col = 0; col < size; col++) {
                PuzzlePiece piece = board.get(new Position(row, col));
                line.append(piece == null ? 0 : piece.getRotation() * 90);

                if (col < size - 1) {
                    line.append(", ");
                }
            }

            line.append("]");
            System.out.println(line);
        }
    }
}
