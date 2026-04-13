package com.franciscoreina.junglepuzzle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PuzzlePiece {

    private static final int ROTATION_COUNT = 4;
    private static final int NOT_PLACED = -1;

    private final int id;

    // Base orientation (0°):
    // NORTH & SOUTH -> left to right
    // EAST & WEST -> top to bottom
    private final List<VineColor> north;
    private final List<VineColor> east;
    private final List<VineColor> south;
    private final List<VineColor> west;

    // 0 = 0°, 1 = 90°, 2 = 180°, 3 = 270°
    private int rotation;

    private int row;
    private int col;

    private boolean used;

    public PuzzlePiece(
            int id,
            List<VineColor> north,
            List<VineColor> east,
            List<VineColor> south,
            List<VineColor> west
    ) {
        this.id = id;
        this.north = List.copyOf(north);
        this.east = List.copyOf(east);
        this.south = List.copyOf(south);
        this.west = List.copyOf(west);
        this.rotation = 0;
        this.row = NOT_PLACED;
        this.col = NOT_PLACED;
        this.used = false;
    }

    public int getId() {
        return id;
    }

    public int getRotation() {
        return rotation;
    }

    public int getRotationDegrees() {
        return rotation * 90;
    }

    public void setRotation(int rotation) {
        this.rotation = Math.floorMod(rotation, ROTATION_COUNT);
    }

    public void resetRotation() {
        this.rotation = 0;
    }

    // ---------------- SIDE ACCESS ----------------

    public List<VineColor> getNorth() {
        return getSide(Direction.NORTH);
    }

    public List<VineColor> getEast() {
        return getSide(Direction.EAST);
    }

    public List<VineColor> getSouth() {
        return getSide(Direction.SOUTH);
    }

    public List<VineColor> getWest() {
        return getSide(Direction.WEST);
    }

    /**
     * Returns the side in the current rotation, following "human reading":
     * - Horizontal sides -> left to right
     * - Vertical sides   -> top to bottom
     */
    public List<VineColor> getSide(Direction targetSide) {
        Objects.requireNonNull(targetSide, "targetSide must not be null");

        List<VineColor> result = switch (rotation) {
            case 0 -> baseSide(targetSide);
            case 1 -> rotate90Clockwise(targetSide);
            case 2 -> rotate180(targetSide);
            case 3 -> rotate90CounterClockwise(targetSide);

            default -> throw new IllegalStateException("Invalid rotation: " + rotation);
        };

        // Defensive copy so internal state cannot be modified from outside
        return List.copyOf(result);
    }

    // ---------------- MATCHING ----------------

    public boolean matchesRight(PuzzlePiece other) {
        return this.getEast().equals(other.getWest());
    }

    public boolean matchesDown(PuzzlePiece other) {
        return this.getSouth().equals(other.getNorth());
    }

    // ---------------- POSITION ----------------

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void clearPosition() {
        this.row = NOT_PLACED;
        this.col = NOT_PLACED;
    }

    public boolean isPlaced() {
        return row != NOT_PLACED && col != NOT_PLACED;
    }

    // ---------------- USAGE ----------------

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    private List<VineColor> baseSide(Direction targetSide) {
        return switch (targetSide) {
            case NORTH -> north;
            case EAST -> east;
            case SOUTH -> south;
            case WEST -> west;
        };
    }

    private List<VineColor> rotate90Clockwise(Direction side) {
        return switch (side) {
            case NORTH -> reversed(west);
            case EAST -> north;
            case SOUTH -> reversed(east);
            case WEST -> south;
        };
    }

    private List<VineColor> rotate90CounterClockwise(Direction side) {
        return switch (side) {
            case NORTH -> east;
            case EAST -> reversed(south);
            case SOUTH -> west;
            case WEST -> reversed(north);
        };
    }

    private List<VineColor> rotate180(Direction side) {
        return switch (side) {
            case NORTH -> reversed(south);
            case EAST -> reversed(west);
            case SOUTH -> reversed(north);
            case WEST -> reversed(east);
        };
    }

    // ---------------- HELPERS ----------------

    private List<VineColor> reversed(List<VineColor> list) {
        List<VineColor> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        return reversed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PuzzlePiece that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PuzzlePiece{" +
                "id=" + id +
                ", rotation=" + getRotationDegrees() + "°" +
                ", position=(" + row + ", " + col + ")" +
                ", used=" + used +
                '}';
    }
}
