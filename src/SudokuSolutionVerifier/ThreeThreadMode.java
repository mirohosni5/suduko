/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class ThreeThreadMode implements SudokuMode {

    public ValidationResult verify(int[][] board) {
        AtomicReference<List<String>> r = new AtomicReference<>();
        AtomicReference<List<String>> c = new AtomicReference<>();
        AtomicReference<List<String>> b = new AtomicReference<>();

        Thread t1 = new Thread(() -> r.set(new BasicChecks(board).checkRows()));
        Thread t2 = new Thread(() -> c.set(new BasicChecks(board).checkCols()));
        Thread t3 = new Thread(() -> b.set(new BasicChecks(board).checkBoxes()));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {}

        return new ValidationResult(r.get(), c.get(), b.get());
    }
}
