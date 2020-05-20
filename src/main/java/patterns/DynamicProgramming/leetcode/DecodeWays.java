package patterns.DynamicProgramming.leetcode;

import java.util.HashMap;

import java.util.*;

public class DecodeWays {

    public static int numDecodings(String s) {
        Map<Integer, Integer> map = new HashMap<>();
    return numDecodings(s, 0, map);
    }
    public static int numDecodings(String s, int level, Map<Integer, Integer> map) {
        if (map.containsKey(level)){
            return map.get(level);
        }
        if (level >= s.length()-1){
            return 1;
        }
        int count = 0 ;
        for (int i = level+1 ; i <= s.length(); i++){
            String prefix = s.substring(level,i);
            Long value = Long.parseLong(prefix);
            if (value ==0){
                return 0;
            }
            if (value >0 && value<=26){
                //count += numDecodings(s.substring(i), 0, map);
                count += numDecodings(s, i, map);
            }
        }
        map.put(level, count);
        return count;
    }

    public static void main(String[] args){
        System.out.println(numDecodings("226"));
    }
}
