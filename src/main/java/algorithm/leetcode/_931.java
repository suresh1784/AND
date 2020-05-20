package algorithm.leetcode;

import java.util.Arrays;

public class _931 {
    public static void main(String[] args){
        int[][] arr = new int[][] {
                {1,2,3},
                {4,5,6},
                {9,7,8}
        };
        System.out.println("Solution  "+minFallingPathSum(arr));

    }

    public static int minFallingPathSum(int[][] A) {
        int reccMin = 1000;
        int min =1000;
        int sum = 0;
        for(int i = 0; i<A[0].length;i++){
            sum = A[0][i];
             int min1 = rec(A,0,i, reccMin,0);
            System.out.println(sum+"  min1 ---------------->>>>>>>>>>>" + min1);
             min = Math.min(min1, min);
        }
        return min;
    }

    static int rec(int[][] arr, int i , int j, int min, int sum){

//        if (j == arr[0].length-1){
//            System.out.println("Return------ arr[i][j] -- "+arr[i][j]);
//            System.out.println("return -- sum ------------ "+sum);
//            return sum + arr[i][j];
//        }

        if (i==arr.length-1){
            System.out.println("Return------ arr[i][j] -- "+arr[i][j]);
            System.out.println("return -- sum ------------ "+sum);
            return sum + arr[i][j];
        }

        if (arr.length-1 ==i && arr[0].length-1 ==j){
            return arr[i][j];
        }
        System.out.println("1-- arr[i][j] -- "+arr[i][j]);
        System.out.println("sum ------------ "+sum);
        int min1 = rec(arr,i+1, j, min,sum + arr[i][j]) ;

        min = Math.min (min1,min);
        System.out.println("1----------------------min1 "+ min1);
        System.out.println("1----------------------min "+ min);
        if (j+1 < arr[0].length) {
            System.out.println("2-- arr[i][j] -- " + arr[i][j]);
            System.out.println("2 sum ----------- " + sum);
            int min2 = rec(arr, i + 1, j + 1, min, sum + arr[i][j]);
            min = Math.min(min2, min);

            System.out.println("2----------------------min2 " + min2);
            System.out.println("2----------------------min " + min);
        }
        if (j > 0) {
            System.out.println("3-- arr[i][j] -- " + arr[i][j]);
            System.out.println("3 sum ----------- " + sum);
            int min3 = rec(arr, i + 1, j - 1, min, sum);
            min = Math.min(min3, min);
            System.out.println("3----------------------min3 " + min3);
            System.out.println("3----------------------min " + min);
        }
        return min;

    }
}
