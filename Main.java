public class Main {
    static int[][] sudoku = {
            {3,0,6,5,0,8,4,0,0},
            {5,2,0,0,0,0,0,0,0},
            {0,8,7,0,0,0,0,3,1},
            {0,0,3,0,1,0,0,8,0},
            {9,0,0,8,6,3,0,0,5},
            {0,5,0,0,9,0,6,0,0},
            {1,3,0,0,0,0,2,5,0},
            {0,0,0,0,0,0,0,7,4},
            {0,0,5,2,0,6,3,0,0}
    };

    static final int UNASSIGNED = 0;

    public static void displaySudoku(){
        for (int r = 0; r < sudoku.length; r++) {
            for (int c = 0; c < sudoku[r].length; c++) {
                if (c % 3 == 0){
                    System.out.print(" | ");
                }
                System.out.print(" "+sudoku[r][c]+"");
            }
            if ((r + 1) % 3 == 0){
                System.out.println("\n-------------------------");
            }else {
                System.out.println();
            }
        }

    }

    public static boolean containsInRow(int row, int number){
        for (int i = 0; i < sudoku[row].length; i++) {
            if (sudoku[row][i] == number){
                return true;
            }
        }
        return false;
    }

    public static boolean containsInCol(int col, int number){
        for (int i = 0; i < sudoku[col].length; i++) {
            if (sudoku[i][col] == number){
                return true;
            }
        }
        return false;
    }

    public static boolean containsInBox(int row, int col, int n){
        int r = (row/3)*3;
        int c = (col/3)*3;

        for (int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++){
                if (sudoku[i][j] == n){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean solveSudoku(){
        for (int r = 0; r < sudoku.length; r++) {
            for (int c = 0; c < sudoku[r].length; c++) {
                if (sudoku[r][c] == UNASSIGNED){
                    for (int n = 1; n <= 9; n++){
                        if (!containsInRow(r,n) && !containsInCol(c, n) && !containsInBox(r,c,n)){
                            sudoku[r][c] = n;
                            if (solveSudoku()){
                                return true;
                            }else {
                                sudoku[r][c] = UNASSIGNED;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        displaySudoku();
        System.out.println("\n--------solved---------------");
        solveSudoku();
        displaySudoku();

    }
}