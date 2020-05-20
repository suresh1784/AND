package patterns.leetcode75.DyanamicProgramming;

import java.util.*;
public class LongestCommonSubsequence {
    public static int findLCSLength(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(s1, s2, 0, 0, map);
    }

    public static int dfs(String s1, String s2, int i, int j,Map<String, Integer> map){
        if (map.get(i+"_"+j)!=null){
            return map.get(i+"_"+j);
        }
        if (i==s1.length() || j == s2.length()){
            return 0;
        }

        if (s1.charAt(i)==s2.charAt(j)){
           return 1+dfs(s1,s2, i+1,j+1,map) ;
        }

        int c1 = dfs(s1,s2,i+1,j,map);
        int c2 = dfs(s1,s2,i,j+1,map);
        map.put(i+"_"+j,Math.max(c1,c2) );
        return map.get(i+"_"+j);
    }

    public static void main(String[] args){
        String s1 = "passport";
        String s2 = "ppsspt";

        System.out.println(findLCSLength(s1, s2));
    }


}
