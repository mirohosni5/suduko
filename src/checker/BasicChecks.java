package checker;



import java.util.*;

public class BasicChecks {

    protected int[][] board;

    public BasicChecks(int[][] board) {
        this.board = board;
    }

    public List<String> checkRows() {
        List<String> errors = new ArrayList<>();

        for (int r = 0; r < 9; r++) {
            ArrayList<Integer> numbers = new ArrayList<>();

            for (int c = 0; c < 9; c++) {
                int v = board[r][c];

                if (v == 0) continue;
                if (v < 1 || v > 9) {
                    errors.add("Row " + (r + 1) + " has a wrong number (" + v + ")");
                    continue;
                }

                if (numbers.contains(v)) {
                    errors.add("Row " + (r + 1) + " repeats the number " + v);
                } else {
                    numbers.add(v);
                }
            }
        }

        return errors;
    }

    public List<String> checkColumns() {
        List<String> errors = new ArrayList<>();

        for (int c = 0; c < 9; c++) {
            ArrayList<Integer> numbers = new ArrayList<>();

            for (int r = 0; r < 9; r++) {
                int v = board[r][c];

                if (v == 0) continue;
                if (v < 1 || v > 9) {
                    errors.add("Column " + (c + 1) + " has a wrong number (" + v + ")");
                    continue;
                }

                if (numbers.contains(v)) {
                    errors.add("Column " + (c + 1) + " repeats the number " + v);
                } else {
                    numbers.add(v);
                }
            }
        }

        return errors;
    }

    public List<String> checkBoxes() {
        List<String> errors = new ArrayList<>();

        for (int br = 0; br < 3; br++) {
            for (int bc = 0; bc < 3; bc++) {

                ArrayList<Integer> numbers = new ArrayList<>();

                for (int r = br * 3; r < br * 3 + 3; r++) {
                    for (int c = bc * 3; c < bc * 3 + 3; c++) {
                        int v = board[r][c];

                        if (v == 0) continue;
                        if (v < 1 || v > 9) {
                            errors.add("Box (" + (br + 1) + "," + (bc + 1) + ") has a wrong number (" + v + ")");
                            continue;
                        }

                        if (numbers.contains(v)) {
                            errors.add("Box (" + (br + 1) + "," + (bc + 1) + ") repeats the number " + v);
                        } else {
                            numbers.add(v);
                        }
                    }
                }
            }
        }

        return errors;
    }

    public List<String> checkAll() {
        List<String> all = new ArrayList<>();
        all.addAll(checkRows());
        all.addAll(checkColumns());
        all.addAll(checkBoxes());
        return all;
    }
}

