/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

import checker.SequentialMode;

/**
 *
 * @author M
 */
public class ModesFactory {
     public static SudokuMode createMode(int mode) {
        switch (mode) {
            case 0:
                return new SequentialMode();
            case 3:
                return new ThreeThreadMode();
            case 27:
                return new TwentySevenThreadMode();
            default:
                throw new IllegalArgumentException("Invalid mode: " + mode);
        }
    }
    
}
