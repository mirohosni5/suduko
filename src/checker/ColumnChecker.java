package checker;


import java.util.*

public class ColumnChecker {

    public static List<String> check(int[][] board) {
        List<String> errors = new ArrayList<>();

        for (int c = 0; c < 9; c++) {
            for (int r1 = 0; r1 < 9; r1++) {
                int v1 = board[r1][c];
                if (v1 == 0) continue;
                if (v1 < 1 || v1 > 9) {
                    errors.add("Column " + (c + 1) + " has a wrong number (" + v1 + ") at row " + (r1 + 1));
                    continue;
                }

                for (int r2 = r1 + 1; r2 < 9; r2++) {
                    int v2 = board[r2][c];
                    if (v2 == v1) {
                        errors.add("Column " + (c + 1) + " repeats the number " + v1);
                    }
                }
            }
        }

        return errors;
    }
}

