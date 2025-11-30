/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

public class SudokuVerifier {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("RUN that is the bonus i think");
            return;
        }

        int mode;
        try {
            mode = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Invalid mode");
            return;
        }

        String file = args[1];

        int[][] board;
        try {
            board = CSVReader.load(file);
        } catch (Exception e) {
            System.out.println("wont read it");
            return;
        }

        SudokuMode m;
        try {
            m = ModesFactory.create(mode);
        } catch (Exception e) {
            System.out.println("Invalid");
            return;
        }

        ValidationResult r = m.verify(board);
        ResultPrinter.get().print(r);
    }
}
