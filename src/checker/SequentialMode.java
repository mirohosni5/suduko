package checker;

import java.util.ArrayList;
import java.util.List;

public class SequentialMode extends BasicChecks {

    public SequentialMode() {
        super(null);   // we will set the board later using setBoard()
    }

    public void setBoard(int[][] b) {
        this.board = b;
    }

    @Override
    public List<String> validate() {
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
}
