package com.franciscoreina.junglepuzzle.domain;

public record Position(int row, int col) {

    public Position move(Direction direction) {
        return new Position(
                row + direction.deltaRow(),
                col + direction.deltaCol()
        );
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}
