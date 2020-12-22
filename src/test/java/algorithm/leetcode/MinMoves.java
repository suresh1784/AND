package algorithm.leetcode;

import java.util.PriorityQueue;

public class MinMoves {

    public static class  Pair{
        int i ;
        int j ;
        int sum;
        public Pair(int i , int j , int sum){
            this.i = i ;
            this.j = j ;
            this.sum = sum;
        }
    }

    public static int minMoves(int[] nums, int limit) {
       return 0;
    }

    public static void main(String[] args) {
        int[] in1 = {1,2,4,3};
        int limit1 = 4;
        System.out.println("In1 -> "+minMoves(in1, limit1));
        int[] in2 = {1,2,2,1};
        int limit2 = 2;
        System.out.println("In2 -> "+minMoves(in2, limit2));
        int[] in3 = {1,2,1,2};
        int limit3 = 2;
        System.out.println("In2 -> "+minMoves(in3, limit3));


    }
}
