![Java](https://img.shields.io/badge/Java-21-blue?logo=openjdk)
![JUnit](https://img.shields.io/badge/JUnit-5-orange?logo=junit5)
![Build](https://img.shields.io/badge/build-passing-brightgreen)

# Jungle Puzzle Solver (Backtracking)

Java 21 project that solves a 6x6 jungle puzzle using a backtracking algorithm.

Designed as a portfolio project to demonstrate problem-solving, clean code, and algorithmic thinking.


## Problem Description

The puzzle consists of 36 pieces arranged in a 6x6 grid.

Each piece has four sides (north, east, south, west), and each side contains a sequence of color (vines).

The goal is to place all pieces on the board so that:

- Adjacent sides match exactly
- Each piece is used only once
- Pieces can be rotated (0°, 90°, 180°, 270°)


## Tech Stack

- Java 21
- JUnit 5


## Approach

The solution uses a **backtracking algorithm**:

- Try placing each unused piece in the current position
- Try all possible rotations (4 per piece)
- Validate placement against already placed neighbors
- If valid → move forward
- If not → backtrack and try another option

This guarantees finding a solution if one exists.


## Running the Application

Run from terminal:

```
./mvnw clean compile exec:java
```

## Output Example

Solution found.<br>

IDs:<br>
[8864, 8889, 8895, 8896, 8899, 8900]<br>
...

Rotations:<br>
[270, 0, 0, 0, 0, 0]<br>
...


## Testing

Run from terminal:

```
./mvnw test
```

Test coverage includes:

- PuzzlePiece (rotation logic, matching)
- PuzzleBoard (placement rules)
- PuzzleSolver (end-to-end solving)


## Notes

- The solver uses a deterministic search strategy (from left to right, top to bottom)
- Only checks top and left neighbors for efficiency
- Rotations are handled via normalized values (0–3)
