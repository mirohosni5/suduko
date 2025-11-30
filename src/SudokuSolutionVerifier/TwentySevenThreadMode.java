package SudokuSolutionVerifier;

import java.util.*;

public class TwentySevenThreadMode implements SudokuMode {

    public ValidationResult verify(int[][] board) {
        List<String> rowErr = Collections.synchronizedList(new ArrayList<>());
        List<String> colErr = Collections.synchronizedList(new ArrayList<>());
        List<String> boxErr = Collections.synchronizedList(new ArrayList<>());

        Thread[] r = new Thread[9];
        Thread[] c = new Thread[9];
        Thread[] b = new Thread[9];

        for (int i = 0; i < 9; i++) {
            final int idx = i;

            r[i] = new Thread(() -> {
                for (String s : new BasicChecks(board).checkRows())
                    if (s.startsWith("ROW " + (idx + 1) + ",")) rowErr.add(s);
            });

            c[i] = new Thread(() -> {
                for (String s : new BasicChecks(board).checkCols())
                    if (s.startsWith("COL " + (idx + 1) + ",")) colErr.add(s);
            });

            final int boxIndex = i + 1;
            b[i] = new Thread(() -> {
                for (String s : new BasicChecks(board).checkBoxes())
                    if (s.startsWith("BOX " + boxIndex + ",")) boxErr.add(s);
            });
        }

        for (int i = 0; i < 9; i++) {
            r[i].start();
            c[i].start();
            b[i].start();
        }

        try {
            for (int i = 0; i < 9; i++) {
                r[i].join();
                c[i].join();
                b[i].join();
            }
        } catch (Exception e) {}

        return new ValidationResult(rowErr, colErr, boxErr);
    }
}
