package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumSplits {
    public int numSplits(String s) {
        char[] chars = s.toCharArray();
        int[] forward = new int[s.length()];

        Set<Character> set = new HashSet<>();

        for (int i = 0 ; i < chars.length ; i++){
            if (set.contains(chars[i])) {
                forward[i]= forward[i-1];
            }else {
                set.add(chars[i]);
                if (i==0){
                    forward[i] = 1;
                }else {
                    forward[i] = forward[i - 1] + 1;
                }
            }
        }
        set = new HashSet<>();
        int res = 0 ;
        for (int i = chars.length-1 ; i >= 0 ; i--){
            if (set.contains(chars[i])) {
                forward[i]= forward[i+1];
            }else {
                set.add(chars[i]);
                if (i==chars.length-1){
                    forward[i] = 1;
                }else {
                    forward[i] = forward[i + 1] + 1;
                }
            }

            if (i>0 && forward[i]==forward[i-1]){
               res++;
            }
        }

        return res;
    }
}
