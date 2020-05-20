package patterns.leetcode75.Strings;

public class LongestOnes {
    public static int longestOnes(int[] A, int K) {
    int max = 0 ;
    int left = 0 ;
    int count = 0;
    for (int right = 0 ; right < A.length ; right++){
        int r = A[right];
        if (r==0){
            count++;
        }

        while (count > K){
            int l = A[left];
            left++;
            if (l==0){
                count--;
            }
        }

        max = Math.max(max, right-left+1);
    }

    return max;
    }

    public static void main(String[] args){
       int[] A = {1,1,1,0,0,0,1,1,1,1,0};
       int K = 2;
       int[] A1 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
       int K1 = 3;
        System.out.println(longestOnes(A1,K1));
    }
}
