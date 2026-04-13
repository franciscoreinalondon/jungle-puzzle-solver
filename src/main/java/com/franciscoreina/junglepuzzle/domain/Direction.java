package com.franciscoreina.junglepuzzle.domain;

public enum Direction {

    NORTH(-1, 0),
    EAST(0, 1),
    SOUTH(1, 0),
    WEST(0, -1);

    private final int deltaRow;
    private final int deltaCol;

    Direction(int deltaRow, int deltaCol) {
        this.deltaRow = deltaRow;
        this.deltaCol = deltaCol;
    }

    public int deltaRow() {
        return deltaRow;
    }

    public int deltaCol() {
        return deltaCol;
    }

    public Direction opposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case EAST -> WEST;
            case SOUTH -> NORTH;
            case WEST -> EAST;
        };
    }

    public Direction rotateClockwise() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public Direction rotateCounterClockwise() {
        return switch (this) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
        };
    }
}
