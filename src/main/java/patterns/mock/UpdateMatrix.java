package patterns.mock;
// Uber Online
import java.util.*;

public class UpdateMatrix {
    public  static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m==0){
         return matrix;
        }

        int n = matrix[0].length;
        Integer[][] mem = new Integer[m][n];
        int[][] result = new int[m][n];
        for (int i = 0 ; i < m; i++ ){
            for (int j = 0 ; j < n ; j++){
                if (mem[i][j]== null){
                    updateMatrixRecursive(matrix, i , j , mem);
                }
            }
        }
        if ( matrix[m-1][n-1] > 0){
            mem[m-1][n-1] = Math.min((n-2 < 0)? m*n :mem[m-1][n-2],(m-2 < 0)? m*n :mem[m-2][n-1])+1;
        }

        for (int i = 0 ; i < m; i++ ){
            for (int j = 0 ; j < n ; j++){
                if (mem[i][j]!= null){
                    result[i][j] = mem[i][j];
                }else {
                    result[i][j] = 0;
                }
            }
        }



        return result;
    }

    public static int updateMatrixRecursive(int[][] matrix, int i , int j , Integer[][] mem){
        System.out.println("i "+i + " j  " + j);
        if (matrix[i][j]==0){
            mem[i][j] = 0;
            return 0;
        }

        if (i == matrix.length-1 && j == matrix[0].length-1 ){
            return matrix[0].length*matrix.length;
        }

        if (i < 0 || i >= matrix.length || j < 0 || j>= matrix[0].length){
            return matrix[0].length*matrix.length;
        }

        if (mem[i][j]!= null){
            return mem[i][j];
        }
        int path = 0;
        int minPath = matrix[0].length*matrix.length;
        for (Coordinates next : Arrays.asList(new Coordinates(i+1, j), new Coordinates(i, j+1),
                                                new Coordinates(i-1, j),new Coordinates(i, j-1))){
            if (next.r >=0 && next.r < matrix.length && next.c >=0 && next.c < matrix[0].length){
                 path = updateMatrixRecursive(matrix, next.r, next.c, mem)+1;
                minPath = Math.min(path, minPath);
                mem[i][j] = minPath;

            }
        }
        return mem[i][j];
    }

    public static class Coordinates {
        int r;
        int c;

        public Coordinates(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }





    public static void main(String[] args) {
        int[][] input = {{0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] input2 = {{0},{1}};

        int[][] input1 = {{0,1,0,1,1},
                            {1,1,0,0,1},
                            {0,0,0,1,0},
                            {1,0,1,1,1},
                            {1,0,0,1,1}};

        System.out.println(updateMatrix(input2));
    }
}
