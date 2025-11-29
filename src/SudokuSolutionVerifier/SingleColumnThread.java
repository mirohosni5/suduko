package SudokuSolutionVerifier;

import java.util.ArrayList;
import java.util.List;

public class SingleColumnThread implements Runnable {
    private int colIndex;
    private int[][] board;
    private List<String> errors;

    public SingleColumnThread(int colIndex, int[][] board, List<String> errors) {
        this.colIndex = colIndex;
        this.board = board;
        this.errors = errors;
    }

    @Override
    public void run() {
        int[] freq = new int[10];
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            int num = board[i][colIndex];
            freq[num]++;
            if (freq[num] == 2) duplicates.add(num);
        }

        if (!duplicates.isEmpty()) {
            synchronized (errors) {
                errors.add("COL " + (colIndex + 1) + ", duplicates: " + duplicates);
            }
        }
    }
}
