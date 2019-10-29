package sudoku;

import java.util.Scanner;
import static sudoku.Board.*;

public class UserAppi {
    private static Scanner in = new Scanner(System.in);
    private static Scanner string = new Scanner(System.in);

    public static void mainMenuPrinter(){
        System.out.println("Welcom to Sudoku Game");
        System.out.println("1 - Imput data and play");
        System.out.println("2 - Exit");
    }

    public static void gamePrint(){
        System.out.println("Imput SUDOKU to calculate");
        System.out.println("Imput X to close");
        System.out.println("Imput data as : Column, Row, Value ");
    }

    public static void solved(){
        System.out.println("Solved");
    }

    public static void error(){
        System.out.println("Unsovable");
    }

    public static Integer gettingConsoleImputIntiger(){
        Integer input = in.nextInt();
        return input;
    }

    public static String gettingConsoleImputString(){
        String input = string.nextLine();
        return input;
    }

    public static void sudokuDisplay(int [][] matrix){
        for (int i =0; i<COLUMN; i++){
            for (int j =0; j<ROW; j++){
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println();
    }
}
