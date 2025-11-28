/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

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
            System.out.println("Error: Mode must be a number!");
            System.out.println("Valid modes: 0, 3, or 27");
            return;
        }
           if (mode != 0 && mode != 3 && mode != 27) {
            System.out.println("Error: Invalid mode '" + mode + "'");
            System.out.println("Valid modes: 0, 3, or 27");
            return;
        }
    }
    
}
