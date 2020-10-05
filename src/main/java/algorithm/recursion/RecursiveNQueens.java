package algorithm.recursion;

public class RecursiveNQueens {

    public static void main(String[] args) {

        int n = 4;
        int[] q = new int[n];



        if (solveNQueenOneSolutionUtil( n, 0, q)) {
            for (int i = 0; i < q.length; i++) {
                System.out.println("row i : " + i + " col : " + q[i]);
            }
        }
        System.out.println("---------------------------------------------");
        if (isQueen(q, 0, n)) {

            for (int i = 0; i < q.length; i++) {
                System.out.println("row i : " + i + " col : " + q[i]);
            }
        }
        System.out.println("---------------------------------------------");
    } //main



    static boolean solveNQueenOneSolutionUtil(int n, int row, int[] Q) {
        if (n == row) {
            return true;
        }
        int col;
        for (col = 0; col < n; col++) {
            boolean foundSafe = true;

            //check if this row and col is not under attack from any previous queen.
            for (int queen = 0; queen < row; queen++) {
                if (Q[queen] == col || queen - Q[queen] == row - col ||
                        queen + Q[queen] == row + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                Q[row] = col;
                if (solveNQueenOneSolutionUtil(n, row + 1, Q)) {

                    return true;
                }
            }
        }
        return false;
    }


    public static boolean isQueen(int[] Q, int row, int n) {

        if (n == row) {
            return true;
        }
        int col;
        for (col = 0; col < n; col++) {
            boolean foundSafe = true;

            //check if this row and col is not under attack from any previous queen.
            for (int queen = 0; queen < row; queen++) {
                if (Q[queen] == col || queen - Q[queen] == row - col ||
                        queen + Q[queen] == row + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                if (row == 4){
                    Q[4] = 4;
                }else {
                    Q[row] = col;
                }
                if(isQueen(Q, row + 1, n))
                {
                    return true;
                }
            }
        }//1st for
        return false;

    }
}
