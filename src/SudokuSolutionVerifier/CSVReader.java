/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author M
 */
public class CSVReader {
    private static CSVReader reader;

    public CSVReader() {
    }
    public static CSVReader getInstance() {
        if (reader == null) {
            reader= new CSVReader();
        }
        return reader;
    }
     public int[][] readCSV(String filePath) throws FileNotFoundException, IOException {
        int[][] board = new int[9][9];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null && row < 9) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] values ;
                 if (line.contains(",")) {
                    values= line.split(",");
                } else {
                    values= line.split("\\s+");
                }
                 if (values.length != 9) {
                    throw new IllegalArgumentException("Each row must have only 9 values.");
                }
            for (int col=0;col<9;col++) {
                try {
                    int  i = Integer.parseInt(values[col].trim()); 
                    if (i < 1 || i > 9) throw new NumberFormatException(); 
                        board[row][col] = i; 
                    } catch (NumberFormatException ex) {
                        throw new IllegalArgumentException("Invalid number at row " + (row+1) + " col " + (col+1));
                    }}
                row++;
            }
            if (row != 9) throw new IllegalArgumentException("File must contain 9 rows.Found " + row +"rows.");
        }
        return board;
    }}