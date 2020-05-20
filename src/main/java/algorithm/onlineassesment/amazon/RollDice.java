package algorithm.onlineassesment.amazon;

import java.util.*;

public class RollDice {
    int mod = 1000000007;
    public int numRollsToTarget(int d, int f, int target) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(d,f,target, map);
    }

    private int dfs(int d, int f, int target , Map<String, Integer> map){
        String str = d+"_"+target;
        if (map.get(str)!= null){
            return map.get(str);
        }
        if (target==0 && d==0){
            return 1;
        }

        if (target<=0 || d==0){
            return 0;
        }

        int count = 0 ;
        for (int i = 1 ; i <= f ; i++){
           int res= dfs(d-1, f, target-i, map);
           count = (count+res)%mod;
        }
        map.put(str, count);
        return map.get(str);
    }
}
