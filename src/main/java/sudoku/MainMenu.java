package sudoku;

import static sudoku.Imput.convert;
import static sudoku.UserAppi.*;
import static sudoku.ExitProgram.closeApp;

public class MainMenu {
    private static int userChoice;
    private static boolean gameFinished = false;
    private static Board sudokuBoard = new Board();
    private static Imput convert = new Imput();

    public static void programMenu() {

        mainMenuPrinter();
        userChoice = gettingConsoleImputIntiger();

        switch (userChoice) {

            case 1:
                gameStart();
                break;
            case 2:
                closeApp();
                break;

            default:
                break;

        }

    }

    public static void gameStart() {
        while (!gameFinished) {

            gamePrint();
            String userInput = gettingConsoleImputString();


            if (!userInput.equals("SUDOKU") && !userInput.equals("X") ){
                convert(userInput);

                sudokuBoard.sudokuNewBoardFill(convert.getColumn(), convert.getRow(), convert.getValue());
                sudokuDisplay(sudokuBoard.getSudokuMatrix());
            }else if (userInput.equals("SUDOKU")){
                System.out.println("test");
                AiAlgorytm sudokuAlgorithm = new AiAlgorytm(sudokuBoard.getSudokuMatrix());
                sudokuDisplay(sudokuAlgorithm.getBoard());

                if (sudokuAlgorithm.solver()){
                    solved();
                    sudokuDisplay(sudokuAlgorithm.getBoard());
                }else {
                    error();
                }
            }else if (userInput.equals("X")){
                closeApp();
            }



        }


    }
}
