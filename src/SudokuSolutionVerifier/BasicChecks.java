package SudokuSolutionVerifier;

import java.util.*;

public class BasicChecks {

    protected int[][] grid;

    public BasicChecks(int[][] g) {
        this.grid = g;
    }

    public List<String> checkRows() {
        List<String> out = new ArrayList<>();
        if (grid == null) return out;

        for (int r = 0; r < 9; r++) {
            Map<Integer, List<Integer>> m = new LinkedHashMap<>();
            for (int c = 0; c < 9; c++) {
                int v = grid[r][c];
                if (v <= 0 || v > 9) continue;
                m.computeIfAbsent(v, k -> new ArrayList<>()).add(c + 1);
            }
            for (var e : m.entrySet()) {
                if (e.getValue().size() > 1) out.add("ROW " + (r + 1) + ", #" + e.getKey() + ", " + e.getValue());
            }
        }
        return out;
    }

    public List<String> checkCols() {
        List<String> out = new ArrayList<>();
        if (grid == null) return out;

        for (int c = 0; c < 9; c++) {
            Map<Integer, List<Integer>> m = new LinkedHashMap<>();
            for (int r = 0; r < 9; r++) {
                int v = grid[r][c];
                if (v <= 0 || v > 9) continue;
                m.computeIfAbsent(v, k -> new ArrayList<>()).add(r + 1);
            }
            for (var e : m.entrySet()) {
                if (e.getValue().size() > 1) out.add("COL " + (c + 1) + ", #" + e.getKey() + ", " + e.getValue());
            }
        }
        return out;
    }

    public List<String> checkBoxes() {
        List<String> out = new ArrayList<>();
        if (grid == null) return out;

        for (int br = 0; br < 3; br++) {
            for (int bc = 0; bc < 3; bc++) {
                Map<Integer, List<Integer>> m = new LinkedHashMap<>();
                int pos = 0;
                for (int r = br * 3; r < br * 3 + 3; r++) {
                    for (int c = bc * 3; c < bc * 3 + 3; c++) {
                        pos++;
                        int v = grid[r][c];
                        if (v <= 0 || v > 9) continue;
                        m.computeIfAbsent(v, k -> new ArrayList<>()).add(pos);
                    }
                }
                int boxIndex = br * 3 + bc + 1;
                for (var e : m.entrySet()) {
                    if (e.getValue().size() > 1) out.add("BOX " + boxIndex + ", #" + e.getKey() + ", " + e.getValue());
                }
            }
        }
        return out;
    }

    public List<String> allChecks() {
        List<String> a = new ArrayList<>();
        a.addAll(checkRows());
        a.addAll(checkCols());
        a.addAll(checkBoxes());
        return a;
    }
}
