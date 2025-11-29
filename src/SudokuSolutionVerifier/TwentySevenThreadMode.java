package SudokuSolutionVerifier;

public class TwentySevenThreadMode implements SudokuMode {
    private int[][] board;

    public TwentySevenThreadMode(int[][] board) {
        this.board = board;
    }

    public TwentySevenThreadMode() {
        super();
    }


    @Override
    public ValidationResult verify(int[][] board) {
        return null;
    }
}
