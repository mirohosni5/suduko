/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class ThreeThreadMode implements SudokuMode {

    public ValidationResult verify(int[][] board) {
        AtomicReference<List<DuplicateValue>> rr = new AtomicReference<>();
        AtomicReference<List<DuplicateValue>> cr = new AtomicReference<>();
        AtomicReference<List<DuplicateValue>> br = new AtomicReference<>();

        Thread tr = new Thread(() -> rr.set(new BasicChecks(board).checkRowsDup()));
        Thread tc = new Thread(() -> cr.set(new BasicChecks(board).checkColsDup()));
        Thread tb = new Thread(() -> br.set(new BasicChecks(board).checkBoxesDup()));

        tr.start();
        tc.start();
        tb.start();

        try {
            tr.join();
            tc.join();
            tb.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<DuplicateValue> rows = rr.get();
        List<DuplicateValue> cols = cr.get();
        List<DuplicateValue> boxes = br.get();
        if (rows == null) rows = new ArrayList<>();
        if (cols == null) cols = new ArrayList<>();
        if (boxes == null) boxes = new ArrayList<>();
        return new ValidationResult(rows, cols, boxes);
    }
}
