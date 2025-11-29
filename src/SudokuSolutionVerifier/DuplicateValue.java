/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

import java.util.List;

/**
 *
 * @author M
 */
public class DuplicateValue {
     private int value;
    private List<Integer> positions;

    public DuplicateValue(int value, List<Integer> positions) {
        this.value = value;
        this.positions = positions;
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getPositions() {
        return positions;
    }
    
}
