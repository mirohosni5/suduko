package checker;

package mode0;

import java.util.List;

public class SequentialMode extends BasicChecks {

    public SequentialMode(int[][] board) {
        super(board);
    }

    public void printResult() {
        List<String> errors = checkAll();

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
