package com.franciscoreina.junglepuzzle.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.franciscoreina.junglepuzzle.domain.VineColor.GREEN;
import static com.franciscoreina.junglepuzzle.domain.VineColor.YELLOW;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PuzzleBoardTest {

    private static final int BOARD_SIZE = 3;

    @Test
    void shouldAllowPlacementWhenPositionHasNoNeighbors() {
        PuzzleBoard board = new PuzzleBoard(BOARD_SIZE);

        PuzzlePiece piece = new PuzzlePiece(1, List.of(GREEN), List.of(), List.of(), List.of());

        assertTrue(board.canPlace(new Position(0, 0), piece));
    }

    @Test
    void shouldAllowPlacementWhenLeftNeighborMatches() {
        PuzzleBoard board = new PuzzleBoard(BOARD_SIZE);

        PuzzlePiece leftPiece = new PuzzlePiece(1, List.of(), List.of(GREEN), List.of(), List.of());
        PuzzlePiece currentPiece = new PuzzlePiece(2, List.of(), List.of(), List.of(), List.of(GREEN));

        board.set(new Position(0, 0), leftPiece);

        assertTrue(board.canPlace(new Position(0, 1), currentPiece));
    }

    @Test
    void shouldRejectPlacementWhenLeftNeighborDoesNotMatch() {
        PuzzleBoard board = new PuzzleBoard(BOARD_SIZE);

        PuzzlePiece leftPiece = new PuzzlePiece(1, List.of(), List.of(GREEN), List.of(), List.of());
        PuzzlePiece currentPiece = new PuzzlePiece(2, List.of(), List.of(), List.of(), List.of(YELLOW));

        board.set(new Position(0, 0), leftPiece);

        assertFalse(board.canPlace(new Position(0, 1), currentPiece));
    }

    @Test
    void shouldAllowPlacementWhenTopNeighborMatches() {
        PuzzleBoard board = new PuzzleBoard(BOARD_SIZE);

        PuzzlePiece topPiece = new PuzzlePiece(1, List.of(), List.of(), List.of(GREEN), List.of());
        PuzzlePiece currentPiece = new PuzzlePiece(2, List.of(GREEN), List.of(), List.of(), List.of());

        board.set(new Position(0, 0), topPiece);

        assertTrue(board.canPlace(new Position(1, 0), currentPiece));
    }

    @Test
    void shouldRejectPlacementWhenTopNeighborDoesNotMatch() {
        PuzzleBoard board = new PuzzleBoard(BOARD_SIZE);

        PuzzlePiece topPiece = new PuzzlePiece(1, List.of(), List.of(), List.of(GREEN), List.of());
        PuzzlePiece currentPiece = new PuzzlePiece(2, List.of(YELLOW), List.of(), List.of(), List.of());

        board.set(new Position(0, 0), topPiece);

        assertFalse(board.canPlace(new Position(1, 0), currentPiece));
    }

    @Test
    void shouldAllowPlacementWhenTopAndLeftNeighborsMatch() {
        PuzzleBoard board = new PuzzleBoard(BOARD_SIZE);

        PuzzlePiece leftPiece = new PuzzlePiece(1, List.of(), List.of(GREEN), List.of(), List.of());
        PuzzlePiece topPiece = new PuzzlePiece(2, List.of(), List.of(), List.of(YELLOW), List.of());
        PuzzlePiece currentPiece = new PuzzlePiece(3, List.of(YELLOW), List.of(), List.of(), List.of(GREEN));

        board.set(new Position(1, 0), leftPiece);
        board.set(new Position(0, 1), topPiece);

        assertTrue(board.canPlace(new Position(1, 1), currentPiece));
    }

    @Test
    void shouldRejectPlacementWhenOneNeighborDoesNotMatch() {
        PuzzleBoard board = new PuzzleBoard(BOARD_SIZE);

        PuzzlePiece leftPiece = new PuzzlePiece(1, List.of(), List.of(GREEN), List.of(), List.of());
        PuzzlePiece topPiece = new PuzzlePiece(2, List.of(), List.of(), List.of(YELLOW), List.of());
        PuzzlePiece currentPiece = new PuzzlePiece(3, List.of(YELLOW), List.of(), List.of(), List.of(YELLOW));

        board.set(new Position(1, 0), leftPiece);
        board.set(new Position(0, 1), topPiece);

        assertFalse(board.canPlace(new Position(1, 1), currentPiece));
    }

    @Test
    void shouldReturnNextPositionInRowMajorOrder() {
        PuzzleBoard board = new PuzzleBoard(2);

        assertEquals(new Position(0, 1), board.next(new Position(0, 0)));
        assertEquals(new Position(1, 0), board.next(new Position(0, 1)));
        assertEquals(new Position(1, 1), board.next(new Position(1, 0)));
        assertNull(board.next(new Position(1, 1)));
    }

    @Test
    void shouldSetAndGetPieceAtPosition() {
        PuzzleBoard board = new PuzzleBoard(2);
        PuzzlePiece piece = emptyPiece(1);
        Position position = new Position(1, 1);

        board.set(position, piece);

        assertEquals(piece, board.get(position));
        assertTrue(piece.isPlaced());
    }

    @Test
    void shouldRemovePieceFromPosition() {
        PuzzleBoard board = new PuzzleBoard(2);
        Position position = new Position(0, 0);

        board.set(position, emptyPiece(1));
        board.remove(position);

        assertNull(board.get(position));
    }

    @Test
    void shouldDetectCompleteBoard() {
        PuzzleBoard board = new PuzzleBoard(2);

        board.set(new Position(0, 0), emptyPiece(1));
        board.set(new Position(0, 1), emptyPiece(2));
        board.set(new Position(1, 0), emptyPiece(3));
        board.set(new Position(1, 1), emptyPiece(4));

        assertTrue(board.isComplete());
    }

    @Test
    void shouldDetectIncompleteBoard() {
        PuzzleBoard board = new PuzzleBoard(2);

        board.set(new Position(0, 0), emptyPiece(1));

        assertFalse(board.isComplete());
    }

    private static PuzzlePiece emptyPiece(int id) {
        return new PuzzlePiece(id, List.of(), List.of(), List.of(), List.of());
    }
}
