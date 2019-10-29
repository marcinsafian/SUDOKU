package sudoku;

import org.junit.Assert;
import org.junit.Test;

import static sudoku.Imput.convert;
import static sudoku.UserAppi.solved;
import static sudoku.UserAppi.error;
import static sudoku.UserAppi.sudokuDisplay;

public class Tests {
    public static int[][] GRID_TO_SOLVE = {

            {9,0,0,1,0,0,0,0,5},
            {0,0,5,0,9,0,2,0,1},
            {8,0,0,0,4,0,0,0,0},
            {0,0,0,0,8,0,0,0,0},
            {0,0,0,7,0,0,0,0,0},
            {0,0,0,0,2,6,0,0,9},
            {2,0,0,3,0,0,0,0,6},
            {0,0,0,2,0,0,9,0,0},
            {0,0,1,9,0,4,5,7,0},

    };

    public static int[][] GRID_RES = {
            {9,3,4,1,7,2,6,8,5},
            {7,6,5,8,9,3,2,4,1},
            {8,1,2,6,4,5,3,9,7},
            {4,2,9,5,8,1,7,6,3},
            {6,5,8,7,3,9,1,2,4},
            {1,7,3,4,2,6,8,5,9},
            {2,9,7,3,5,8,4,1,6},
            {5,4,6,2,1,7,9,3,8},
            {3,8,1,9,6,4,5,7,2},
    };


    @Test
    public void testConvert(){
        //Given
        //When
        AiAlgorytm sudokuAlgorithm = new AiAlgorytm(GRID_TO_SOLVE);
        sudokuDisplay(sudokuAlgorithm.getBoard());


        if (sudokuAlgorithm.solver()){
            solved();
            sudokuDisplay(sudokuAlgorithm.getBoard());
        }else {
            error();
        }

        //Then
        Assert.assertArrayEquals(GRID_RES,sudokuAlgorithm.getBoard());
    }

    @Test
    public void testConvertString(){
        //Given
        Imput imputStringConvert = new Imput();
        String testString = "1,2,3";
        Integer columntForTest = 1;
        Integer rowForTest = 2;
        Integer valueForTest = 3;

        //When
        convert(testString);

        Integer columntAfterTest = imputStringConvert.getColumn() ;
        Integer rowAfterTest = imputStringConvert.getRow();
        Integer valueAfterTest = imputStringConvert.getValue();

        //Then
        Assert.assertEquals(columntForTest, columntAfterTest );
        Assert.assertEquals(rowForTest, rowAfterTest );
        Assert.assertEquals(valueForTest, valueAfterTest );
    }
}
