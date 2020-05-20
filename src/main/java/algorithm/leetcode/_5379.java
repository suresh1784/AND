package algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;


public class _5379 {
    public static String stoneGameIII(int[] stoneValue) {
       // Integer[] nums = Arrays.stream( stoneValue ).boxed().toArray( Integer[]::new );
        List<Integer> nums  = Arrays.stream( stoneValue ).boxed().collect( Collectors.toList() );


        return canWin(nums);
    }


    public static String canWin(List<Integer> nums){
        if (ismySumGreater(nums).equals("Alice")){
            return "Alice";
        }

        if (nums.size()<=6 ){
            if (ismySumGreater(nums).equals("Bob")){
                return "Bob";
            }else {
                return "Tie";
            }

        }

        if (canWin(nums.subList(1,nums.size())).equals("Bob") || canWin(nums.subList(1,nums.size())).equals("Bov") ||!canWin(nums.subList(1,nums.size())).equals("Bob")){
            return "Alice";
        }
    return "Bob";
    }

    public static String ismySumGreater(List<Integer> nums){
        int sum = 0;
        for (int num : nums ){
            sum+= num;
        }
        boolean isTie = false;
        int currSum = 0 ;
        for (int i = 0 ; i < 3 && i< nums.size(); i++){
            currSum += nums.get(i);
            if (currSum > sum-currSum){
                return "Alice";
            }
            if (currSum==sum-currSum){
                isTie = true;
            }
        }
        if (isTie){
            return "Tie";
        }

        return "Bob";
    }

    public static void main(String[] args){
        int[] in = {-1,-2,-3};

        System.out.println(stoneGameIII(in));

    }
}
