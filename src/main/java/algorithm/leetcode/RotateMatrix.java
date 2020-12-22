package algorithm.leetcode;

import java.util.Arrays;

public class RotateMatrix {
    static int[][] rotateMatrix(int matrix[][], int k){
        int m = matrix.length;
        int n = matrix[0].length;
        int result[][] = new int[m][n];
//        for (int i = 0 ; i < m ; i++){
//            for (int j = 0 ; j< n ; j++){
//                result[i][j] = 0 ;
//            }
//        }

        k= k%m;



        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                int newi = i ;
                int newj = (j+k)%(m);
                System.out.println( "new i "+i +" " + " new j "+ j);
                result[newi][newj] = matrix[i][j];
            }
        }

        return result;
    }




    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 2;

        rotateMatrix(matrix, k);
    }
}
