/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SudokuSolutionVerifier;

import java.io.BufferedReader;
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
     public int[][] readCSV(String filePath) {
        int[][] board = new int[9][9];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null && row < 9) {
                String[] values = line.split(",");
                for (int col = 0; col < 9 && col < values.length; col++) {
                    board[row][col] = Integer.parseInt(values[col].trim());
                }
                row++;
            }
        } catch (IOException e) {
            System.out.println("cannot open the file");
            return null;
        }
        return board;
    }
}
    
    

