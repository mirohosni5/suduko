package SudokuSolutionVerifier;

import java.util.*;

public class SequentialMode implements SudokuMode {

    public ValidationResult verify(int[][] board) {
        BasicChecks ck = new BasicChecks(board);
        List<DuplicateValue> r = ck.checkRowsDup();
        List<DuplicateValue> c = ck.checkColsDup();
        List<DuplicateValue> b = ck.checkBoxesDup();
        return new ValidationResult(r, c, b);
    }
}
