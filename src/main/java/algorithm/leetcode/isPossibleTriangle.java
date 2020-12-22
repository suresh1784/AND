package algorithm.leetcode;

public class isPossibleTriangle {
    public static int[] isPossibleTriangle(int[] A){
        int[] result = new int[A.length-2];
        for (int i = 2; i < A.length ; i++){
            result[i-2] = isTriangle(A[i-2],A[i-1],A[i]) ? 1:0;
        }
        return result;
    }

    public static boolean isTriangle(int a , int b, int c){
        return ((a+b) >=c && (a+c)>=b && (b+c)>=a);
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,5,2};
        int[] result = isPossibleTriangle(A);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
