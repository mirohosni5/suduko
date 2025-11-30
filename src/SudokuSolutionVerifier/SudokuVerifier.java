/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

public class SudokuVerifier {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Use: java -jar SudokuVerifier.jar <csv> <mode>");
            return;
        }

        String first = args[0];
        String second = args[1];

        String csvPath;
        int mode;

        // If first arg looks like an int and second looks like a path, accept mode-first.
        // Otherwise assume csv-first (this matches the instructor's bonus: csv then mode).
        int maybeMode = -1;
        try {
            maybeMode = Integer.parseInt(first);
        } catch (Exception ex) {
            maybeMode = -1;
        }

        if (maybeMode == 0 || maybeMode == 3 || maybeMode == 27) {
            mode = maybeMode;
            csvPath = second;
        } else {
            // try parse second as mode (csv-first case)
            try {
                mode = Integer.parseInt(second);
                csvPath = first;
            } catch (Exception ex) {
                System.out.println("Invalid mode. Use 0, 3, or 27");
                return;
            }
        }

        if (mode != 0 && mode != 3 && mode != 27) {
            System.out.println("Invalid mode. Use 0, 3, or 27");
            return;
        }

        int[][] board;
        try {
            board = CSVReader.load(csvPath);
        } catch (Exception e) {
            System.out.println("Error reading file");
            return;
        }

        SudokuMode sm;
        try {
            sm = ModesFactory.create(mode);
        } catch (Exception e) {
            System.out.println("Invalid mode");
            return;
        }

        ValidationResult result = sm.verify(board);
        ResultPrinter.get().print(result);
    }
}
