package com.franciscoreina.junglepuzzle.solver;

import com.franciscoreina.junglepuzzle.domain.Position;
import com.franciscoreina.junglepuzzle.domain.PuzzleBoard;
import com.franciscoreina.junglepuzzle.domain.PuzzlePiece;

import java.util.List;
import java.util.Objects;

public class PuzzleSolver {

    private static final int ROTATION_COUNT = 4;
    private static final Position START_POSITION = new Position(0, 0);

    private final PuzzleBoard board;
    private final List<PuzzlePiece> pieces;

    private long steps;

    public PuzzleSolver(PuzzleBoard board, List<PuzzlePiece> pieces) {
        this.board = Objects.requireNonNull(board, "board must not be null");
        this.pieces = List.copyOf(pieces);
    }

    public boolean solve() {
        steps = 0;
        return backtrack(START_POSITION);
    }

    public long getSteps() {
        return steps;
    }

    private boolean backtrack(Position position) {
        // If we've reached the end, then solved
        if (position == null) {
            return true;
        }

        for (PuzzlePiece piece : pieces) {
            if (piece.isUsed()) {
                continue;
            }

            if (tryPieceInAllRotations(position, piece)) {
                return true;
            }
        }

        return false;
    }

    private boolean tryPieceInAllRotations(Position position, PuzzlePiece piece) {
        for (int rotation = 0; rotation < ROTATION_COUNT; rotation++) {
            steps++;
            piece.setRotation(rotation);

            if (!board.canPlace(position, piece)) {
                continue;
            }

            placePiece(position, piece);

            if (backtrack(board.next(position))) {
                return true;
            }

            removePiece(position, piece);
        }

        piece.resetRotation();
        return false;
    }

    private void placePiece(Position position, PuzzlePiece piece) {
        board.set(position, piece);
        piece.setUsed(true);
    }

    private void removePiece(Position position, PuzzlePiece piece) {
        board.remove(position);
        piece.setUsed(false);
        piece.clearPosition();
    }
}
