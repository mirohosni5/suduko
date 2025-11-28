package checker;

import java.util.ArrayList;


public class RowChecker {

    public static List<String> check(int[][] board) {
        List<String> errors = new ArrayList<>();

        for (int r = 0; r < 9; r++) {
            for (int c1 = 0; c1 < 9; c1++) {
                int v1 = board[r][c1];
                if (v1 == 0) continue;
                if (v1 < 1 || v1 > 9) {
                    errors.add("Row " + (r + 1) + " has a wrong number (" + v1 + ") at column " + (c1 + 1));
                    continue;
                }

                for (int c2 = c1 + 1; c2 < 9; c2++) {
                    int v2 = board[r][c2];
                    if (v2 == v1) {
                        errors.add("Row " + (r + 1) + " repeats the number " + v1);
                    }
                }
            }
        }

        return errors;
    }
}
