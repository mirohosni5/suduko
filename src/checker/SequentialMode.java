package checker;

import java.util.List;
import SudokuSolutionVerifier.SudokuMode;
import SudokuSolutionVerifier.ValidationResult;

public class SequentialMode extends BasicChecks implements SudokuMode {

    public SequentialMode() {
        super(null);
    }

    public void setBoard(int[][] b) {
        this.board = b;
    }


    public List<String> validate() {
        if (this.board == null) {
            return java.util.Collections.singletonList("Board not set");
        }
        return checkAll();
    }

    
    public void printResult() {
        List<String> errors = validate();

        if (errors.isEmpty()) {
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
            for (String e : errors) {
                System.out.println(e);
            }
        }
    }

    @Override
    public ValidationResult verify(int[][] board) {
        // set board, run validation and return a ValidationResult
        setBoard(board);
        List<String> errors = validate();
        boolean valid = errors.isEmpty();

        // Assumes ValidationResult has a constructor ValidationResult(boolean, List<String>)
        return new ValidationResult(valid, errors);
    }
}
