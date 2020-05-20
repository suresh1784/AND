package patterns.Graph;

import algorithm.leetcode._5257;

import java.util.Arrays;

public class LongestIncreasingPathMatrix {

    public static class Coordinates {
        int x;
        int y;

        Coordinates(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        int[][] m1 = {{9,9,4},{6,6,8},{2,1,1}};
        int[][] m2 = {{3,4,5},
                      {3,2,6},
                      {2,2,7}};
        System.out.println("longestIncreasingPath " +longestIncreasingPath(m1));
    }
    private static int longestIncreasingPath(int[][] matrix) {
        int max = 1 ;
        if (matrix.length == 0  ){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] distance = new int[matrix.length][matrix[0].length];
        for (int i = 0  ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, longestIncreasingPathRecursive(matrix, i , j, matrix[i][j],distance));
            }
        }

        return max;
    }

    private static int longestIncreasingPathRecursive(int[][] matrix, int i , int j, int prev, int[][] distance){
        if (distance[i][j]!=0){
            return distance[i][j];
        }

        int longestPath = 0 ;
        int path = 0;
        for (Coordinates next : Arrays.asList(new Coordinates(i+1, j),
                new Coordinates(i, j+1), new Coordinates(i, j-1),new Coordinates(i-1, j) )){
            if (next.x >=0 && next.x < matrix.length && next.y >= 0 && next.y <  matrix[0].length && matrix[i][j] < matrix[next.x][next.y]){
             path = longestIncreasingPathRecursive(matrix, next.x, next.y,matrix[i][j], distance );
             longestPath = Math.max(longestPath, path);
            }
        }
        longestPath=longestPath+1; // calculate Max
        distance[i][j]= longestPath;
        return distance[i][j];
    }
}
