/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author M
 */
public class SudokuVerifier {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar SudokuVerifier.jar <csv_file> <mode>");
            System.out.println("Modes: 0 (sequential), 3 (4 threads), 27 (28 threads)");
            return;
        }

        String filePath = args[0];
        int mode;
          try {
            mode = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid mode.Mode must be number");
            System.out.println("Valid modes: 0, 3, or 27");
            return;
        }
           if (mode != 0 && mode != 3 && mode != 27) {
            System.out.println("Invalid mode.Valid modes:(0,3,27)");
            return;
        }
            int[][] board ;
            try {
            board = CSVReader.getInstance().readCSV(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found '" + filePath + "'");
            return;
        } catch (IOException e) {
            System.out.println("Error: Could not read file '" + filePath + "'");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        SudokuMode verifier = ModesFactory.createMode(mode);
        ValidationResult result = verifier.verify(board);
        
        ResultPrinter.getInstance().printResult(result);
    } 
}
