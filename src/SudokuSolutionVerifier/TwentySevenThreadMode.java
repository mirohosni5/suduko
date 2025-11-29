package SudokuSolutionVerifier;

import java.util.*;

public class TwentySevenThreadMode implements SudokuMode {
    private int[][] board;

    public TwentySevenThreadMode(int[][] board) {
        this.board = board;
    }

    public TwentySevenThreadMode() {
        super();
    }

    @Override
    public ValidationResult verify(int[][] board) {
        return null;
    }

    @Override
    public ValidationResult run() {
        List<String> errors = Collections.synchronizedList(new ArrayList<>());
        List<Thread> threads = new ArrayList<>();

        // 9 Row threads
        for (int i = 0; i < 9; i++) {
            Thread t = new Thread(new SingleRowThread(i, board, errors));
            threads.add(t);
            t.start();
        }
        // 9 Column threads
        for (int i = 0; i < 9; i++) {
            Thread t = new Thread(new SingleColumnThread(i, board, errors));
            threads.add(t);
            t.start();
        }

    }
}
