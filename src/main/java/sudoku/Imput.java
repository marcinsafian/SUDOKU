package sudoku;

public class Imput {
    private static int column;
    private static int row;
    private static int value;

    public static void convert(String input){
        String[] tokens = input.split(",");
        int[] nums = new int[tokens.length];

        for(int x=0; x<tokens.length; x++)
            nums[x] = Integer.parseInt(tokens[x]);

        column = nums[0];
        row = nums[1];
        value = nums[2];
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getValue() {
        return value;
    }
}
