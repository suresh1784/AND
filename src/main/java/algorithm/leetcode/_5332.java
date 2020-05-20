package algorithm.leetcode;

import java.util.*;

public class _5332 {

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int zeroCount = 0 ;
        for (int a : arr){
            if (a==0){
                zeroCount++;
            }
           set.add(a);
        }

        for (int a : arr){
            if (set.contains(a*2)){
                if (a==0){
                    if (zeroCount==2){
                        return true;
                    }
                }else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr = {10,2,5,3};
        int[] arr1 = {7,1,14,11};
        int[] arr2 = {3,1,7,11};
        int[] arr3 = {-2,0,10,-19,4,6,-8,0};
        System.out.println(checkIfExist(arr3));
    }
}
