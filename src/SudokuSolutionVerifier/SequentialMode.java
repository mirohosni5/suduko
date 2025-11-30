package SudokuSolutionVerifier;

import java.util.List;

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

        setBoard(board);
        List<String> errors = validate();
        boolean valid = errors.isEmpty();


        return new ValidationResult(valid, errors);
    }
}
