package ubs.game.sudoku;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SudokuUBS {

    public static void main(String[] args) {

        if (args.length != 0) {
            String[][] sudokuFromFile = readFromFile(args[0]);
            String isValid = checkVerticalAndHorizontal(sudokuFromFile);
            if(isValid.equals("0")){
                System.out.println(checkSquare(sudokuFromFile));
            } else {
                System.out.println(isValid);
            }
        }

    }

     static String[][] readFromFile(String filePath) {

         String[][] sudokuTable = new String[9][9];
         BufferedReader reader;
         String line;

         try {
             reader = new BufferedReader(new FileReader(filePath));
                int i =0;
                 while ((line = reader.readLine()) != null) {

                             String[] oneLineFormFile = line.split(",");
                             for (int j=0; j<oneLineFormFile.length; j++) {
                                 sudokuTable[i][j] = oneLineFormFile[j];

                         }
                         i++;
                 }

             reader.close();
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
            return sudokuTable;
     }

    static String checkVerticalAndHorizontal(String[][] table) {

        Set verticalSet = new HashSet();
        Set horizontalSet = new HashSet();
        for(int i=0; i<table.length; i++) {

            for(int j=0; j<table.length; j++) {

                if (verticalSet.add(table[j][i]) == false) {
                    return "Invalid number :" + table[j][i] + " on position x: " + j + " and position y: " + i;
                }
                if (horizontalSet.add(table[i][j]) == false) {
                    return "Invalid number :" + table[i][j] + " on position x: " + i + " and position y: " + j;
                }
            }
            verticalSet.clear();
            horizontalSet.clear();
        }
        return "0";
    }

    static String checkSquare(String[][] table) {
        Set set = new HashSet();
        for(int i=0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                int x = i / 3 * 3;
                int y = j / 3 * 3;
                for (int m = x; m < x + 3; m++) {
                    for (int n = y; n < y + 3; n++) {
                        if (set.add(table[m][n]) == false) {
                            return "Invalid number :" + table[m][n] + " on position x: " + m + " and position y: " + n;
                        }
                    }
                }
                set.clear();
            }
        }
        return "0";
    }
}
