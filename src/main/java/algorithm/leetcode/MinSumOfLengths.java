package algorithm.leetcode;
import java.util.*;
public class MinSumOfLengths {
    public int minSumOfLengths(int[] arr, int target) {
        int result = -1;
        int[] sumArr = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();

        int[] subArraylength = new int[arr.length];
        int minLength = arr.length+1 ;
        for (int i = 0 ; i < arr.length ; i++){
            sumArr[i] = (i==0) ? arr[i] : sumArr[i-1]+arr[i];
            int val = sumArr[i]- target;
            if (map.get(val)!= null || val==0){
                if (val==0){
                    minLength = Math.max(i+1, minLength );
                }else {
                    minLength = Math.max(i-map.get(val), minLength );
                }
                subArraylength[i] = minLength;
            }else {
                subArraylength[i] = minLength;
            }
            map.put(sumArr[i], i);
        }

        map = new HashMap<>();
        minLength = arr.length+1 ;
        int[] subArraylength1 = new int[arr.length];


        for (int i = arr.length-1 ; i >= 0 ; i--){
            sumArr[i] = (i==arr.length-1) ? arr[i] : sumArr[i+1]+arr[i];
            int val = sumArr[i]- target;
            if (map.get(val)!= null || val==0){
                if (val==0){
                    minLength = Math.max(arr.length-i, minLength );
                }else {
                    minLength = Math.max(map.get(val)-i, minLength );
                }
                subArraylength1[i] = minLength;
            }else {
                subArraylength[i] = minLength;
            }
            map.put(sumArr[i], i);
        } // for
        int len = arr.length+1;
        for (int i = 0 ; i < arr.length ; i++){
            int v1 = subArraylength[i];
            int v2 = i < arr.length-1 ? subArraylength1[i+1]: arr.length+1 ;

            if (v1+v2 < len){
                len = v1+v2;
            }

        }

        return len> arr.length ? -1 : len;
    }
}
