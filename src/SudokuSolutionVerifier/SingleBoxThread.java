package SudokuSolutionVerifier;

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

    }
}
