/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

public class ResultPrinter {

    private static ResultPrinter inst;

    private ResultPrinter() {}

    public static ResultPrinter get() {
        if (inst == null) inst = new ResultPrinter();
        return inst;
    }

    public void print(ValidationResult r) {
        if (r == null) {
            System.out.println("eror validation");
            return;
        }

        if (r.isValid()) {
            System.out.println("valid");
            return;
        }

        System.out.println("Invalid");
        for (String s : r.getRows()) System.out.println(s);
        System.out.println("------------------------------------------");
        for (String s : r.getCols()) System.out.println(s);
        System.out.println("------------------------------------------");
        for (String s : r.getBoxes()) System.out.println(s);
    }
}
