package com.franciscoreina.junglepuzzle.domain;

import java.util.Objects;

public class PuzzleBoard {

    private final int size;
    private final PuzzlePiece[][] grid;

    public PuzzleBoard(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Board size must be greater than 0");
        }

        this.size = size;
        this.grid = new PuzzlePiece[size][size];
    }

    public int getSize() {
        return size;
    }

    public PuzzlePiece get(Position position) {
        if (!isValid(position)) return null;
        Objects.requireNonNull(position, "position must not be null");
        return isValid(position) ? grid[position.row()][position.col()] : null;
    }

    public void set(Position position, PuzzlePiece piece) {
        Objects.requireNonNull(position, "position must not be null");

        if (!isValid(position)) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }

        grid[position.row()][position.col()] = piece;

        if (piece != null) {
            piece.setPosition(position.row(), position.col());
        }
    }

    public void remove(Position position) {
        Objects.requireNonNull(position, "position must not be null");

        if (!isValid(position)) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }

        grid[position.row()][position.col()] = null;
    }

    public boolean isValid(Position position) {
        return position.row() >= 0
                && position.row() < size
                && position.col() >= 0
                && position.col() < size;
    }

    /**
     * Checks if a piece can be placed at a given position
     * considering already placed neighbors (up and left).
     */
    public boolean canPlace(Position position, PuzzlePiece piece) {
        Objects.requireNonNull(position, "position must not be null");
        Objects.requireNonNull(piece, "piece must not be null");

        return matchesNeighbor(position, piece, Direction.NORTH)
                && matchesNeighbor(position, piece, Direction.WEST);
    }

    /**
     * Returns the next position in row-major order
     */
    public Position next(Position position) {
        Objects.requireNonNull(position, "position must not be null");

        int nextCol = position.col() + 1;
        int nextRow = position.row();

        if (nextCol == size) {
            nextCol = 0;
            nextRow++;
        }

        return nextRow == size ? null : new Position(nextRow, nextCol);
    }

    public boolean isComplete() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean matchesNeighbor(Position position, PuzzlePiece piece, Direction direction) {
        Position neighborPosition = position.move(direction);

        if (!isValid(neighborPosition)) {
            return true;
        }

        PuzzlePiece neighbor = get(neighborPosition);
        if (neighbor == null) {
            return true;
        }

        return neighbor.getSide(direction.opposite()).equals(piece.getSide(direction));
    }
}
