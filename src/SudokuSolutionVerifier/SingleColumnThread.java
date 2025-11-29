package SudokuSolutionVerifier;

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

    }
}
