package sudoku;

public class Board {
    public static final int ROW = 9;
    public static final int COLUMN = 9;

    private static int[][] sudokuMatrix = new int[COLUMN][ROW];

    public static void sudokuNewBoardFill(int columnn, int roww, int valuee) {
        sudokuMatrix[columnn][roww] = valuee;
    }

    public static int[][] getSudokuMatrix() {
        return sudokuMatrix;
    }
}
