package SudokuSolutionVerifier;

import checker.BasicChecks;

import java.util.*;

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
        BasicChecks checker = new BasicChecks(board);
        List<String> errors = checker.checkAll();

        boolean isValid = errors.isEmpty();
        return new ValidationResult(isValid, errors);
    }
}
