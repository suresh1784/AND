package patterns.leetcode75.graphs;
import java.util.*;
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        int max = 0 ;
        while (!set.isEmpty()) {
            int val = set.iterator().next();
            int lowerCount = 0 ;
            int higherCount = 0;
            int lowerVal = val-1;
            int higherVal = val+1;
            set.remove(val);
            while (set.contains(lowerVal)){
                set.remove(lowerVal);
                lowerCount++;
                lowerVal--;
            }

            while (set.contains(higherVal)){
                set.remove(higherVal);
                higherCount++;
                higherVal++;
            }
            int count = lowerCount+higherCount+1;
            if (count > max){
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args){
     int[] in =    {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(in));
    }
}
