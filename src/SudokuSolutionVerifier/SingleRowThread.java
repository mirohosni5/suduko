package SudokuSolutionVerifier;

import java.util.ArrayList;
import java.util.List;

public class SingleRowThread implements Runnable {
    private int rowIndex;
    private int[][] board;
    private List<String> errors;

    public SingleRowThread(int rowIndex, int[][] board, List<String> errors) {
        this.rowIndex = rowIndex;
        this.board = board;
        this.errors = errors;
    }

    @Override
    public void run() {
        int[] row = board[rowIndex];
        int[] freq = new int[10];
        List<Integer> duplicates = new ArrayList<>();

        for (int num : row) {
            freq[num]++;
            if (freq[num] == 2) duplicates.add(num);
        }

        if (!duplicates.isEmpty()) {
            synchronized (errors) {
                errors.add("ROW " + (rowIndex + 1) + ", duplicates: " + duplicates);
            }
        }
    }
}
