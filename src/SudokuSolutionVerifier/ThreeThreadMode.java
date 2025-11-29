/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

import checker.BasicChecks;

import java.util.concurrent.*;
import java.util.*;

/**
 *
 * @author Engyz
 */
//


public class ThreeThreadMode extends BasicChecks implements SudokuMode {

    public ThreeThreadMode(int[][] board) {
        super(board);
    }

    public ThreeThreadMode() {
        super(null);
    }

    public ValidationResult verify(int[][] boardIgnored) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<ValidationResult>> futures = new ArrayList<>();


        futures.add(executor.submit(() -> {
            ValidationResult result = new ValidationResult();
            for (String err : checkRows()) {
                result.addDuplicate(
                        "Row",
                        new DuplicateValue(-1, List.of())
                );
            }
            return result;
        }));


        futures.add(executor.submit(() -> {
            ValidationResult result = new ValidationResult();
            for (String err : checkColumns()) {
                result.addDuplicate(
                        "Column",
                        new DuplicateValue(-1, List.of())
                );
            }
            return result;
        }));


        futures.add(executor.submit(() -> {
            ValidationResult result = new ValidationResult();
            for (String err : checkBoxes()) {
                result.addDuplicate(
                        "Box",
                        new DuplicateValue(-1, List.of())
                );
            }
            return result;
        }));

        ValidationResult finalResult = new ValidationResult();
        for (Future<ValidationResult> future : futures) {
            try {
                finalResult.merge(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return finalResult;
    }
}


