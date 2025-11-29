/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

/**
 *
 * @author M
 */
public class ResultPrinter {
     private static ResultPrinter instance;

    private ResultPrinter() {}

    public static ResultPrinter getInstance() {
        if (instance == null) {
            instance = new ResultPrinter();
        }
        return instance;
    }
    public void printResult(ValidationResult result) {
        if (result.isValid()) {
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
            for (int i = 1; i <= 9; i++) {
                String key = "ROW " + i;
                if (result.getDuplicates().containsKey(key)) {
                    for (DuplicateValue info : result.getDuplicates().get(key)) {
                        System.out.println(key + ", #" + info.getValue() + ", " + info.getPositions());}}}
           
         for (int i = 1; i <= 9; i++) {
                String key = "COL " + i;
                if (result.getDuplicates().containsKey(key)) {
                    for (DuplicateValue info : result.getDuplicates().get(key)) {
                        System.out.println(key + ", #" + info.getValue() + ", " + info.getPositions());}}}
         for (int i = 1; i <= 9; i++) {
                String key = "BOX " + i;
                if (result.getDuplicates().containsKey(key)) {
                    for (DuplicateValue info : result.getDuplicates().get(key)) {
                        System.out.println(key + ", #" + info.getValue() + ", " + info.getPositions());}}}
        }
    }
}