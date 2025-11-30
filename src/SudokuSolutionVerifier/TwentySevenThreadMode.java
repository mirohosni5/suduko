package SudokuSolutionVerifier;

import java.util.*;

public class TwentySevenThreadMode implements SudokuMode {

    public ValidationResult verify(int[][] board) {
        List<DuplicateValue> rowDups = Collections.synchronizedList(new ArrayList<>());
        List<DuplicateValue> colDups = Collections.synchronizedList(new ArrayList<>());
        List<DuplicateValue> boxDups = Collections.synchronizedList(new ArrayList<>());

        // Use BasicChecks to get all duplicates, then filter by index in parallel threads.
        // Each worker will extract the duplicates relevant to its index and add them to shared lists.
        Thread[] rts = new Thread[9];
        Thread[] cts = new Thread[9];
        Thread[] bts = new Thread[9];

        List<DuplicateValue> allRow = new BasicChecks(board).checkRowsDup();
        List<DuplicateValue> allCol = new BasicChecks(board).checkColsDup();
        List<DuplicateValue> allBox = new BasicChecks(board).checkBoxesDup();

        for (int i = 0; i < 9; i++) {
            final int idx = i + 1;
            rts[i] = new Thread(() -> {
                for (DuplicateValue dv : allRow) if (dv.getIndex() == idx) rowDups.add(dv);
            });
            cts[i] = new Thread(() -> {
                for (DuplicateValue dv : allCol) if (dv.getIndex() == idx) colDups.add(dv);
            });
            final int bidx = i + 1;
            bts[i] = new Thread(() -> {
                for (DuplicateValue dv : allBox) if (dv.getIndex() == bidx) boxDups.add(dv);
            });
        }

        for (int i = 0; i < 9; i++) {
            rts[i].start();
            cts[i].start();
            bts[i].start();
        }

        try {
            for (int i = 0; i < 9; i++) {
                rts[i].join();
                cts[i].join();
                bts[i].join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return new ValidationResult(rowDups, colDups, boxDups);
    }
}
