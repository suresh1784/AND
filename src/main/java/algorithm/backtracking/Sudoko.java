package algorithm.backtracking;

public class Sudoko {




    public static void main(String[] args){
        int[][] board = new int[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
        solveSudoku(board, 0, 0);
        print(board, 9);
    }

    public static void solveSudoku(int[][] board, int r, int c){

        if (r==9){
            print(board,9);
        }
        else {
            if (board[r][c]!=0) {
                int nr = getRow(r,c);
                int nc = getColumn(r,c);
                solveSudoku(board,nr,nc);
            }else {
                for (int k = 1; k <= 9; k++) {
                    if (getValidNum(r, c, board, k)) {
                        board[r][c] = k;
                        int nr = getRow(r,c);
                        int nc = getColumn(r,c);
                        solveSudoku(board,nr,nc);

                    }

                }
                board[r][c]=0;

            }
        }


    }


    static int getRow(int r, int c){
        if (c==8){
            return r+1;
        }
        return r;
    }

    static int getColumn(int r, int c){
        if (c==8){
            return 0;
        }
        return c+1;
    }

    static boolean getValidNum( int r, int c, int[][] board, int digit){
        //check for column

        for (int k = 0; k< 9; k++ ){
            if (k!=c && digit == board[r][k]){
                return false;
            }
        }

        // check for row

        for (int k = 0; k<9; k++){
            if (k!=r && digit == board[k][c]){
                return false;
            }
        }

        //check for box

        int b_r = r/3;
        int b_c = c/3;

        for (int k = 0; k<=2; k++){
            for (int j = 0; j<=2;j++){
                if ((r!= 3*b_r+k) && (c!=3*b_c+k)) {
                    if (digit == board[3 * b_r + k][3 * b_c + k]) {
                        return false;
                    }
                }
            }

        }
        System.out.println("r "+r +" c "+c +" digit "+ digit);
        return true;
    }





    public static void print(int[][] board, int N)
    {
        // we got the answer, just print it
        for (int r = 0; r < N; r++)
        {
            for (int d = 0; d < N; d++)
            {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int) Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
    }
}
