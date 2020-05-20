package algorithm.karat;

public class MaxSumMatrix {

    public static void main (String[] args) {
        int input[][] = {{2, 1, -3, -4, 5},
                {0, 6, 3, 4, 1},
                {2, -2, -1, 4, -5},
                {-3, 3, 1, 0, 3}};
        System.out.println(maxArea(input));

    }


    static int maxArea(int[][] A){
        int maxArea = 0 ;

        for (int i = 0 ; i < A.length ; i ++){
            for (int j= 0 ; j<A[0].length; j++) {
                if (i > 0) {
                    A[i][j] += A[i-1][j];
                }

                if (j>0){
                    A[i][j] += A[i][j-1];
                }

                if (i>0 && j> 0){
                    A[i][j] -= A[i-1][j-1];
                }
                System.out.println("i: "+i+" j: "+j + " value " +A[i][j]);
                maxArea = Math.max(maxArea,A[i][j]);
            }
        }
        return maxArea;
    }
}
