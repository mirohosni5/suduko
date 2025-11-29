package checker;

import java.util.ArrayList;
import java.util.List;
import SudokuSolutionVerifier.SudokuMode;   // IMPORTANT import

public class SequentialMode extends BasicChecks implements SudokuMode {

    public SequentialMode() {
        super(null);
    }

    public void setBoard(int[][] b) {
        this.board = b;
    }

    @Override
    public List<String> validate() {
        return checkAll();   // from BasicChecks
    }

    @Override
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
}
