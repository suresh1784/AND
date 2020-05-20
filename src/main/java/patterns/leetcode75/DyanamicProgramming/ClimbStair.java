package patterns.leetcode75.DyanamicProgramming;
import java.util.*;

public class ClimbStair {
    //
    public static int climbStair(int n){
        Map<Integer, Integer >  m = new HashMap<>();
        return dfs(n, m);
    }

    public static int dfs(int n , Map<Integer, Integer > map){
        if (map.get(n)!= null){
            return map.get(n);
        }
        if (n==1 || n==2){
            return n;
        }
        int one = dfs(n-1,map);
        int two = dfs(n-2, map);
        map.put(n,one+two);
        return map.get(n);
    }

    // f(n) = f(n-1)+f(n-2)
       public static int climbStairv1(int n){
        int[] dp = new int[n+1];
        dp[1]= 1;
        dp[2]= 2;
        for (int i = 3; i <= n ; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }



    public static int climbStairv2(int n){
        int result = 0 ;
        int one = 1;
        int two= 2;
        if (n==1){
            return one;
        }
        if (n==2){
            return two;
        }

        for (int i = 3; i <= n ; i++){
            result  = one +two;
            one = two;
            two = result;
        }
        return result;
    }


    public static void main(String[] args){
        System.out.println(climbStair(5));
        System.out.println(climbStairv1(5));
        System.out.println(climbStairv2(5));
    }

}
