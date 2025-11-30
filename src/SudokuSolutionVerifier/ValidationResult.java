/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

import java.util.*;

public class ValidationResult {

    private List<String> rows;
    private List<String> cols;
    private List<String> boxes;

    public ValidationResult(List<String> r, List<String> c, List<String> b) {
        this.rows = r == null ? new ArrayList<>() : new ArrayList<>(r);
        this.cols = c == null ? new ArrayList<>() : new ArrayList<>(c);
        this.boxes = b == null ? new ArrayList<>() : new ArrayList<>(b);
    }

    public List<String> getRows() { return rows; }
    public List<String> getCols() { return cols; }
    public List<String> getBoxes() { return boxes; }

    public boolean isValid() {
        return rows.isEmpty() && cols.isEmpty() && boxes.isEmpty();
    }
}
