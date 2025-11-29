/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;
import checker.BasicChecks;
import checker.SequentialMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 *
 * @author Engyz
 */
class ThreeThreadMode extends BasicChecks{

    public ThreeThreadMode(int[][] board) {
        super(board);
    }
    
 public ValidationResult verify(int[][] board) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<ValidationResult>> futures = new ArrayList<>();

       
 futures.add(executor.submit(() -> {
            ValidationResult result = new ValidationResult();
            for (int i = 0; i < 9; i++) {
                checkRow(board, i, result);
            }
            return result;
        }));

       
futures.add(executor.submit(() -> {
            ValidationResult result = new ValidationResult();
            for (int i = 0; i < 9; i++) {
                checkColumn(board, i, result);
            }
            return result;
        }));

     
  futures.add(executor.submit(() -> {
            ValidationResult result = new ValidationResult();
            for (int i = 0; i < 9; i++) {
                checkBox(board, i, result);
            }
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


