package com.franciscoreina.junglepuzzle.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.franciscoreina.junglepuzzle.domain.VineColor.EMERALD;
import static com.franciscoreina.junglepuzzle.domain.VineColor.GREEN;
import static com.franciscoreina.junglepuzzle.domain.VineColor.TURQUOISE;
import static com.franciscoreina.junglepuzzle.domain.VineColor.YELLOW;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PuzzlePieceTest {

    @Test
    void shouldReturnCorrectSidesForAllRotations() {
        PuzzlePiece puzzlePiece = new PuzzlePiece(
                1,
                List.of(YELLOW, GREEN, TURQUOISE),  // NORTH
                List.of(EMERALD, GREEN),            // EAST
                List.of(TURQUOISE, YELLOW),         // SOUTH
                List.of(GREEN)                      // WEST
        );

        // Rotation 0
        puzzlePiece.setRotation(0);
        assertEquals(List.of(YELLOW, GREEN, TURQUOISE), puzzlePiece.getNorth());
        assertEquals(List.of(EMERALD, GREEN), puzzlePiece.getEast());
        assertEquals(List.of(TURQUOISE, YELLOW), puzzlePiece.getSouth());
        assertEquals(List.of(GREEN), puzzlePiece.getWest());

        // Rotation 90° clockwise
        puzzlePiece.setRotation(1);
        assertEquals(List.of(GREEN), puzzlePiece.getNorth());
        assertEquals(List.of(YELLOW, GREEN, TURQUOISE), puzzlePiece.getEast());
        assertEquals(List.of(GREEN, EMERALD), puzzlePiece.getSouth());
        assertEquals(List.of(TURQUOISE, YELLOW), puzzlePiece.getWest());

        // Rotation 180°
        puzzlePiece.setRotation(2);
        assertEquals(List.of(YELLOW, TURQUOISE), puzzlePiece.getNorth());
        assertEquals(List.of(GREEN), puzzlePiece.getEast());
        assertEquals(List.of(TURQUOISE, GREEN, YELLOW), puzzlePiece.getSouth());
        assertEquals(List.of(GREEN, EMERALD), puzzlePiece.getWest());

        // Rotation 270° clockwise
        puzzlePiece.setRotation(3);
        assertEquals(List.of(EMERALD, GREEN), puzzlePiece.getNorth());
        assertEquals(List.of(YELLOW, TURQUOISE), puzzlePiece.getEast());
        assertEquals(List.of(GREEN), puzzlePiece.getSouth());
        assertEquals(List.of(TURQUOISE, GREEN, YELLOW), puzzlePiece.getWest());
    }

    @Test
    void shouldMatchRightWhenEastEqualsOtherWest() {
        PuzzlePiece leftPiece = new PuzzlePiece(
                1,
                List.of(),
                List.of(GREEN, YELLOW),
                List.of(),
                List.of()
        );

        PuzzlePiece rightPiece = new PuzzlePiece(
                2,
                List.of(),
                List.of(),
                List.of(),
                List.of(GREEN, YELLOW)
        );

        assertTrue(leftPiece.matchesRight(rightPiece));
    }

    @Test
    void shouldNotMatchRightWhenEastDoesNotEqualOtherWest() {
        PuzzlePiece leftPiece = new PuzzlePiece(
                1,
                List.of(),
                List.of(GREEN, YELLOW),
                List.of(),
                List.of()
        );

        PuzzlePiece rightPiece = new PuzzlePiece(
                2,
                List.of(),
                List.of(),
                List.of(),
                List.of(YELLOW, GREEN)
        );

        assertFalse(leftPiece.matchesRight(rightPiece));
    }

    @Test
    void shouldMatchDownWhenSouthEqualsOtherNorth() {
        PuzzlePiece topPiece = new PuzzlePiece(
                1,
                List.of(),
                List.of(),
                List.of(EMERALD, GREEN),
                List.of()
        );

        PuzzlePiece bottomPiece = new PuzzlePiece(
                2,
                List.of(EMERALD, GREEN),
                List.of(),
                List.of(),
                List.of()
        );

        assertTrue(topPiece.matchesDown(bottomPiece));
    }

    @Test
    void shouldNotMatchDownWhenSouthDoesNotEqualOtherNorth() {
        PuzzlePiece topPiece = new PuzzlePiece(
                1,
                List.of(),
                List.of(),
                List.of(EMERALD, GREEN),
                List.of()
        );

        PuzzlePiece bottomPiece = new PuzzlePiece(
                2,
                List.of(GREEN, EMERALD),
                List.of(),
                List.of(),
                List.of()
        );

        assertFalse(topPiece.matchesDown(bottomPiece));
    }

    @Test
    void shouldNormalizeRotationValues() {
        PuzzlePiece piece = new PuzzlePiece(1, List.of(), List.of(), List.of(), List.of());

        piece.setRotation(4);
        assertEquals(0, piece.getRotation());

        piece.setRotation(5);
        assertEquals(1, piece.getRotation());

        piece.setRotation(-1);
        assertEquals(3, piece.getRotation());
    }

    @Test
    void shouldReturnRotationInDegrees() {
        PuzzlePiece piece = new PuzzlePiece(1, List.of(), List.of(), List.of(), List.of());

        piece.setRotation(0);
        assertEquals(0, piece.getRotationDegrees());

        piece.setRotation(1);
        assertEquals(90, piece.getRotationDegrees());

        piece.setRotation(2);
        assertEquals(180, piece.getRotationDegrees());

        piece.setRotation(3);
        assertEquals(270, piece.getRotationDegrees());
    }

    @Test
    void shouldTrackPlacementState() {
        PuzzlePiece piece = new PuzzlePiece(1, List.of(), List.of(), List.of(), List.of());

        assertFalse(piece.isPlaced());

        piece.setPosition(2, 3);
        assertTrue(piece.isPlaced());

        piece.clearPosition();
        assertFalse(piece.isPlaced());
    }

    @Test
    void shouldTrackUsedState() {
        PuzzlePiece piece = new PuzzlePiece(1, List.of(), List.of(), List.of(), List.of());

        assertFalse(piece.isUsed());

        piece.setUsed(true);
        assertTrue(piece.isUsed());

        piece.setUsed(false);
        assertFalse(piece.isUsed());
    }
}
