package patterns.DynamicProgramming.leetcode;
import java.util.*;
public class UniquePaths {
    public int uniquePaths(int m, int n ) {
        Map<String,Integer> map = new HashMap<>();
        int res = uniquePaths( m-1,  n-1 ,map );
        return res;
    }

    public int uniquePaths(int m , int n , Map<String, Integer> map){
        String str = m+"_"+n;
        if (map.containsKey(str)){
            return map.get(str);
        }

        if (m==0 && n==0){
            return 1;
        }

        if (n==0 || m ==0){
            return 1;
        }

        int waysTop = uniquePaths(m-1, n , map);
        int waysLeft = uniquePaths(m, n-1, map);

        map.put(str, waysTop+waysLeft);
        return waysTop+waysLeft;
    }
}
