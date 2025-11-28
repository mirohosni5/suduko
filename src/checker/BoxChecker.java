package checker;

import java.util.*;


public class BoxChecker {

    public static List<String> check(int[][] board) {
        List<String> errors = new ArrayList<>();

        for (int br = 0; br < 3; br++) {
            for (int bc = 0; bc < 3; bc++) {

                int sr = br * 3;
                int sc = bc * 3;

                for (int i1 = 0; i1 < 9; i1++) {
                    int r1 = sr + (i1 / 3);
                    int c1 = sc + (i1 % 3);
                    int v1 = board[r1][c1];

                    if (v1 == 0) continue;
                    if (v1 < 1 || v1 > 9) {
                        errors.add("Box (" + (br + 1) + "," + (bc + 1) + ") has a wrong number (" + v1 +
                                ") at cell (" + (r1 + 1) + "," + (c1 + 1) + ")");
                        continue;
                    }

                    for (int i2 = i1 + 1; i2 < 9; i2++) {
                        int r2 = sr + (i2 / 3);
                        int c2 = sc + (i2 % 3);
                        int v2 = board[r2][c2];

                        if (v2 == v1) {
                            errors.add("Box (" + (br + 1) + "," + (bc + 1) + ") repeats the number " + v1);
                        }
                    }
                }
            }
        }

        return errors;
    }
}
