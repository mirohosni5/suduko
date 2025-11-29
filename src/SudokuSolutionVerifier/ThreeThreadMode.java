/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;
import checker.BasicChecks;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.*;
/**
 *
 * @author Engyz
 */
//


class ThreeThreadMode extends BasicChecks {

public ThreeThreadMode(int[][] board) {
        super(board);
    }

public ValidationResult verify() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<ValidationResult>> futures = new ArrayList<>();

       
futures.add(executor.submit(() -> {
            ValidationResult result = new ValidationResult();
            checkRows().forEach(result::addError); 
            return result;
        }));

        
futures.add(executor.submit(() -> {
   ValidationResult result = new ValidationResult();
   checkColumns().forEach(result::addError);
    return result;
        }));

        
futures.add(executor.submit(() -> {
   ValidationResult result = new ValidationResult();
   checkBoxes().forEach(result::addError);
    return result;
        }));

  ValidationResult finalResult = new ValidationResult();
        for (Future<ValidationResult> future : futures) {
            try {
                finalResult.merge(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return finalResult;
    }
}


