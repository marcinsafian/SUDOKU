package sudoku;

import static sudoku.Board.*;

public class AiAlgorytm {
    private static final int EMPTY = 0;
    private static int[][] board = new int[COLUMN][ROW];

    public AiAlgorytm(int [][] sudokuBoard) {
        this.board = new int[COLUMN][ROW];

        for (int i = 0; i< COLUMN; i++){
            for (int j = 0; j< ROW; j++){
                this.board[i][j] = sudokuBoard[i][j];
            }
        }
    }

    //Row Check
    private boolean isInRow(int row, int number){
        for (int i = 0; i< ROW; i++){
            if (board[row][i] == number){
                return true;
            }
        }
        return false;
    }

    //Column Check
    private boolean isInCol(int col, int number){
        for (int i = 0; i< COLUMN; i++){
            if (board[i][col] == number){
                return true;
            }
        }
        return false;
    }

    //Box Check
    private boolean isInBox(int row, int col, int number){
        int r = row - row% 3;
        int c = col - col% 3;

        for (int i=r; i<r+3; i++){
            for (int j=c; j<c+3; j++){
                if (board[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }

    //Combine
    private boolean isOk(int row, int col, int number){
        return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
    }

    // Solver BackTracking algorithm
    public boolean solver(){
        for (int row = 0; row < ROW; row++){
            for (int col = 0; col < COLUMN; col++){
                if (board[row][col] == EMPTY){
                    for (int number = 1; number<= ROW; number++){
                        if (isOk(row, col, number)){
                            board[row][col] = number;

                            if (solver()){
                                return true;
                            } else {
                                board[row][col] = EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] getBoard() {
        return board;
    }
}
