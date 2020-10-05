package algorithm.leetcode;

import java.util.Arrays;

public class CanMakeArithmeticProgression {
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1]-arr[0];
        for (int i = 1 ; i < arr.length ; i++){
            int currDiff = arr[i]-arr[i-1];
            if (currDiff != diff){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] arr = {3,5,1};
        int[] arr1 = {1,2,4};
        System.out.println( canMakeArithmeticProgression(arr));
        System.out.println( canMakeArithmeticProgression(arr1));
    }
}
