/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

import java.util.*;

public class ValidationResult {

    private List<DuplicateValue> rowDups;
    private List<DuplicateValue> colDups;
    private List<DuplicateValue> boxDups;

    private List<String> rowLines;
    private List<String> colLines;
    private List<String> boxLines;

    public ValidationResult(List<DuplicateValue> rdup, List<DuplicateValue> cdup, List<DuplicateValue> bdup) {
        this.rowDups = rdup == null ? new ArrayList<>() : new ArrayList<>(rdup);
        this.colDups = cdup == null ? new ArrayList<>() : new ArrayList<>(cdup);
        this.boxDups = bdup == null ? new ArrayList<>() : new ArrayList<>(bdup);

        this.rowLines = buildLines(rowDups);
        this.colLines = buildLines(colDups);
        this.boxLines = buildLines(boxDups);
    }

    private List<String> buildLines(List<DuplicateValue> list) {
        List<String> out = new ArrayList<>();
        for (DuplicateValue dv : list) out.add(dv.toString());
        return out;
    }

    public List<DuplicateValue> getRowDups() { return Collections.unmodifiableList(rowDups); }
    public List<DuplicateValue> getColDups() { return Collections.unmodifiableList(colDups); }
    public List<DuplicateValue> getBoxDups() { return Collections.unmodifiableList(boxDups); }

    public List<String> getRows() { return rowLines; }
    public List<String> getCols() { return colLines; }
    public List<String> getBoxes() { return boxLines; }

    public boolean isValid() {
        return rowDups.isEmpty() && colDups.isEmpty() && boxDups.isEmpty();
    }
}
