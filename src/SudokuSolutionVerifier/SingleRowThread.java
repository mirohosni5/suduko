package SudokuSolutionVerifier;

import java.util.List;

public class SingleRowThread implements Runnable{
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

    }
}
