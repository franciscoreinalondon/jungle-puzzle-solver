package com.franciscoreina.junglepuzzle.factory;

import com.franciscoreina.junglepuzzle.domain.PuzzlePiece;

import java.util.ArrayList;
import java.util.List;

import static com.franciscoreina.junglepuzzle.domain.VineColor.EMERALD;
import static com.franciscoreina.junglepuzzle.domain.VineColor.GREEN;
import static com.franciscoreina.junglepuzzle.domain.VineColor.TURQUOISE;
import static com.franciscoreina.junglepuzzle.domain.VineColor.YELLOW;

public class PuzzlePieceFactory {

    public static List<PuzzlePiece> createPieces() {

        List<PuzzlePiece> puzzlePieces = new ArrayList<>();

        // NORTH, EAST, SOUTH, WEST
        puzzlePieces.add(new PuzzlePiece(8864, List.of(EMERALD), List.of(), List.of(YELLOW, EMERALD), List.of(YELLOW, EMERALD)));
        puzzlePieces.add(new PuzzlePiece(8865, List.of(GREEN, TURQUOISE, YELLOW), List.of(), List.of(YELLOW, TURQUOISE), List.of(GREEN)));
        puzzlePieces.add(new PuzzlePiece(8866, List.of(YELLOW, TURQUOISE, GREEN), List.of(GREEN, YELLOW), List.of(TURQUOISE, YELLOW, GREEN), List.of()));

        puzzlePieces.add(new PuzzlePiece(8867, List.of(TURQUOISE), List.of(GREEN, YELLOW, GREEN), List.of(), List.of(GREEN, YELLOW, TURQUOISE)));
        puzzlePieces.add(new PuzzlePiece(8869, List.of(TURQUOISE, GREEN), List.of(GREEN, TURQUOISE), List.of(GREEN, TURQUOISE, YELLOW), List.of(YELLOW, GREEN, TURQUOISE)));
        puzzlePieces.add(new PuzzlePiece(8870, List.of(GREEN), List.of(TURQUOISE, YELLOW, GREEN, EMERALD), List.of(GREEN, YELLOW, EMERALD, TURQUOISE), List.of(GREEN)));

        puzzlePieces.add(new PuzzlePiece(8872, List.of(YELLOW, GREEN), List.of(YELLOW, GREEN, EMERALD, TURQUOISE), List.of(), List.of(EMERALD, GREEN, YELLOW, TURQUOISE)));
        puzzlePieces.add(new PuzzlePiece(8873, List.of(TURQUOISE, GREEN), List.of(GREEN, TURQUOISE), List.of(TURQUOISE, EMERALD, GREEN, YELLOW), List.of(TURQUOISE, GREEN, EMERALD, YELLOW)));
        puzzlePieces.add(new PuzzlePiece(8874, List.of(GREEN), List.of(TURQUOISE, EMERALD, GREEN, YELLOW), List.of(YELLOW, GREEN), List.of(TURQUOISE, EMERALD, YELLOW, GREEN)));

        puzzlePieces.add(new PuzzlePiece(8875, List.of(EMERALD, GREEN, TURQUOISE), List.of(TURQUOISE, GREEN, EMERALD), List.of(YELLOW, GREEN), List.of(GREEN, YELLOW)));
        puzzlePieces.add(new PuzzlePiece(8876, List.of(TURQUOISE, GREEN), List.of(GREEN), List.of(EMERALD, GREEN, TURQUOISE), List.of(EMERALD, GREEN, TURQUOISE)));
        puzzlePieces.add(new PuzzlePiece(8877, List.of(GREEN, TURQUOISE), List.of(TURQUOISE, GREEN), List.of(TURQUOISE, YELLOW), List.of(TURQUOISE, YELLOW)));

        puzzlePieces.add(new PuzzlePiece(8878, List.of(GREEN, YELLOW, GREEN), List.of(GREEN), List.of(TURQUOISE, GREEN), List.of(YELLOW, TURQUOISE)));
        puzzlePieces.add(new PuzzlePiece(8879, List.of(YELLOW), List.of(YELLOW, GREEN, TURQUOISE), List.of(GREEN, TURQUOISE), List.of()));
        puzzlePieces.add(new PuzzlePiece(8880, List.of(), List.of(TURQUOISE), List.of(YELLOW, TURQUOISE, GREEN), List.of(YELLOW, GREEN, TURQUOISE)));

        puzzlePieces.add(new PuzzlePiece(8881, List.of(GREEN), List.of(TURQUOISE, GREEN), List.of(), List.of(TURQUOISE)));
        puzzlePieces.add(new PuzzlePiece(8882, List.of(EMERALD, GREEN, TURQUOISE), List.of(TURQUOISE, GREEN, EMERALD), List.of(TURQUOISE, YELLOW), List.of(YELLOW)));
        puzzlePieces.add(new PuzzlePiece(8883, List.of(GREEN), List.of(), List.of(TURQUOISE, GREEN), List.of(TURQUOISE)));

        puzzlePieces.add(new PuzzlePiece(8884, List.of(TURQUOISE, GREEN, EMERALD, YELLOW), List.of(EMERALD, GREEN, TURQUOISE), List.of(TURQUOISE, YELLOW), List.of(TURQUOISE)));
        puzzlePieces.add(new PuzzlePiece(8885, List.of(TURQUOISE, GREEN), List.of(GREEN, TURQUOISE), List.of(), List.of(GREEN)));
        puzzlePieces.add(new PuzzlePiece(8886, List.of(YELLOW), List.of(YELLOW, GREEN, TURQUOISE), List.of(TURQUOISE, GREEN, EMERALD, YELLOW), List.of(TURQUOISE, GREEN, EMERALD)));

        puzzlePieces.add(new PuzzlePiece(8887, List.of(YELLOW, EMERALD), List.of(GREEN), List.of(EMERALD, YELLOW, GREEN), List.of()));
        puzzlePieces.add(new PuzzlePiece(8888, List.of(GREEN, YELLOW, EMERALD), List.of(TURQUOISE, GREEN, EMERALD, YELLOW), List.of(TURQUOISE), List.of()));
        puzzlePieces.add(new PuzzlePiece(8889, List.of(), List.of(TURQUOISE, GREEN, EMERALD), List.of(TURQUOISE, YELLOW, GREEN, EMERALD), List.of(EMERALD, YELLOW)));

        puzzlePieces.add(new PuzzlePiece(8890, List.of(TURQUOISE), List.of(), List.of(YELLOW, GREEN, EMERALD, TURQUOISE), List.of(YELLOW, EMERALD, GREEN, TURQUOISE)));
        puzzlePieces.add(new PuzzlePiece(8891, List.of(YELLOW, GREEN), List.of(GREEN, YELLOW, GREEN), List.of(TURQUOISE, GREEN, EMERALD, YELLOW), List.of(TURQUOISE, EMERALD)));
        puzzlePieces.add(new PuzzlePiece(8892, List.of(), List.of(EMERALD, YELLOW, GREEN), List.of(), List.of(GREEN, YELLOW, EMERALD)));

        puzzlePieces.add(new PuzzlePiece(8893, List.of(TURQUOISE), List.of(TURQUOISE, EMERALD, YELLOW, GREEN), List.of(TURQUOISE, YELLOW, GREEN, EMERALD), List.of()));
        puzzlePieces.add(new PuzzlePiece(8894, List.of(GREEN), List.of(TURQUOISE, GREEN, EMERALD, YELLOW), List.of(GREEN, YELLOW), List.of(TURQUOISE, EMERALD, YELLOW, GREEN)));
        puzzlePieces.add(new PuzzlePiece(8895, List.of(), List.of(EMERALD, GREEN, TURQUOISE), List.of(GREEN), List.of(TURQUOISE, GREEN, EMERALD)));

        puzzlePieces.add(new PuzzlePiece(8896, List.of(EMERALD), List.of(GREEN, YELLOW, TURQUOISE), List.of(YELLOW, TURQUOISE), List.of(EMERALD, GREEN, TURQUOISE)));
        puzzlePieces.add(new PuzzlePiece(8897, List.of(YELLOW, TURQUOISE), List.of(EMERALD, GREEN, TURQUOISE), List.of(TURQUOISE), List.of(TURQUOISE, GREEN, EMERALD, YELLOW)));
        puzzlePieces.add(new PuzzlePiece(8898, List.of(TURQUOISE, GREEN), List.of(TURQUOISE), List.of(EMERALD, TURQUOISE), List.of(EMERALD, GREEN, TURQUOISE)));

        puzzlePieces.add(new PuzzlePiece(8899, List.of(), List.of(TURQUOISE, YELLOW, GREEN), List.of(TURQUOISE, GREEN), List.of(GREEN, YELLOW, TURQUOISE)));
        puzzlePieces.add(new PuzzlePiece(8900, List.of(), List.of(TURQUOISE, GREEN), List.of(GREEN, YELLOW, GREEN), List.of(TURQUOISE, YELLOW, GREEN)));
        puzzlePieces.add(new PuzzlePiece(8901, List.of(GREEN, YELLOW), List.of(TURQUOISE, YELLOW), List.of(GREEN), List.of(TURQUOISE, GREEN)));

        return puzzlePieces;
    }
}
