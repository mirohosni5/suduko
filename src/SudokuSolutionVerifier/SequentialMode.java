package SudokuSolutionVerifier;

import java.util.*;

public class SequentialMode implements SudokuMode {

    public ValidationResult verify(int[][] board) {
        BasicChecks ck = new BasicChecks(board);
        return new ValidationResult(ck.checkRows(), ck.checkCols(), ck.checkBoxes());
    }
}
