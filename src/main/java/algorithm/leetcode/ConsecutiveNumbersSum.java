package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveNumbersSum {

    public static int consecutiveNumbersSum(int N) {
        if (N==1){
            return 1;
        }
        Set<Long> set = new HashSet<>();
        set.add(0L);
        int n = (N+1)/2;
        long sum = 0 ;
        int count = 0 ;
        for(int i = 1 ; i <= n ; i++){
          sum+=i;
          if (set.contains(sum-N)){
          //    System.out.println("Sum "+sum);
            count++;
          }
          set.add(sum);
        }
        return count+1;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(1000000));
    }
}
