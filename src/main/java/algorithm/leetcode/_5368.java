package algorithm.leetcode;

import java.util.*;

public class _5368 {
    public static int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr){
            map.put(a, map.getOrDefault(a, 0)+1);
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == entry.getKey()){
                max = Math.max(entry.getKey(),max);
            }
        }
        return max;
    }

    public static void main(String[] args){
        int [] in = {-1,-2};
        System.out.println(findLucky(in));
    }
}
