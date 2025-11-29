package SudokuSolutionVerifier;

import java.util.ArrayList;
import java.util.List;

public class SingleBoxThread implements Runnable {
    private int boxIndex;
    private int[][] board;
    private List<String> errors;

    public SingleBoxThread(int boxIndex, int[][] board, List<String> errors) {
        this.boxIndex = boxIndex;
        this.board = board;
        this.errors = errors;
    }

    @Override
    public void run() {
        int startRow = (boxIndex / 3) * 3;
        int startCol = (boxIndex % 3) * 3;

        int[] freq = new int[10];
        List<Integer> duplicates = new ArrayList<>();

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                int num = board[r][c];
                freq[num]++;
                if (freq[num] == 2) duplicates.add(num);
            }
        }

        if (!duplicates.isEmpty()) {
            synchronized (errors) {
                errors.add("BOX " + (boxIndex + 1) + ", duplicates: " + duplicates);
            }
        }
    }
}
