/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SudokuSolutionVerifier;

/**
 *
 * @author M
 */
public interface SudokuMode {
     public abstract ValidationResult verify(int[][] board);

    ValidationResult run();
}
