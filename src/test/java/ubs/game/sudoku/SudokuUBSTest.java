package ubs.game.sudoku;

import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.*;

public class SudokuUBSTest {

    @Test
    public void Should_Get_sudoku_Table_from_file() {

        // given
        URL resource = getClass().getClassLoader().getResource("input_valid.txt");
        String[][] sudokuExpectedTable = {{"4", "9", "8", "2", "6", "3", "1", "5", "7"}, {"1", "3", "6", "5", "7", "8", "2", "9", "4"},
                                          {"5", "7", "2", "4", "9", "1", "6", "8", "3"}, {"8", "1", "9", "3", "4", "2", "7", "6", "5"},
                                          {"6", "5", "3", "8", "1", "7", "9", "4", "2"}, {"2", "4", "7", "6", "5", "9", "8", "3", "1"},
                                          {"7", "6", "1", "9", "3", "5", "4", "2", "8"}, {"9", "8", "5", "1", "2", "4", "3", "7", "6"},
                                          {"3", "2", "4", "7", "8", "6", "5", "1", "9"}};
        // when
        String[][] sudokuTable = SudokuUBS.readFromFile(resource.getPath());

        // then
        assertEquals(sudokuExpectedTable, sudokuTable);
    }

    @Test
    public void Should_checkVerticalAndHorizontal_Valid() {

        // given
        URL resource = getClass().getClassLoader().getResource("input_valid.txt");
        String expectedValue = "0";
        // when

        String isValid = SudokuUBS.checkVerticalAndHorizontal(SudokuUBS.readFromFile(resource.getPath()));


        // then
        assertEquals(expectedValue, isValid);

    }

    @Test
    public void Should_checkVerticalAndHorizontal_Is_not_Valid() {

        // given
        URL resource = getClass().getClassLoader().getResource("input_not_valid.txt");
        String expectedValue = "Invalid number :1 on position x: 1 and position y: 0";
        // when

        String is_not_Valid = SudokuUBS.checkVerticalAndHorizontal(SudokuUBS.readFromFile(resource.getPath()));


        // then
        assertEquals(expectedValue, is_not_Valid);

    }

    @Test
    public void Should_checkSquare_Valid() {

        // given
        URL resource = getClass().getClassLoader().getResource("input_valid.txt");
        String expectedValue = "0";
        // when

        String isValid = SudokuUBS.checkSquare(SudokuUBS.readFromFile(resource.getPath()));


        // then
        assertEquals(expectedValue, isValid);
    }

    @Test
    public void Should_checkSquare_is_not_Valid() {

        // given
        URL resource = getClass().getClassLoader().getResource("input_not_valid.txt");
        String expectedValue = "Invalid number :1 on position x: 1 and position y: 0";
        // when

        String isValid = SudokuUBS.checkSquare(SudokuUBS.readFromFile(resource.getPath()));

        // then
        assertEquals(expectedValue, isValid);
    }
}