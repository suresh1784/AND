package patterns.leetcode75.Strings;

import java.util.*;

public class LengthOfLongestSubstringKDistinct {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0 ;
        int left = 0 ;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0 ; right < s.length() ; right++){
            char rCh = s.charAt(right);
            map.put(rCh, map.getOrDefault(rCh, 0)+1);

            while (map.size()==k+1){
                char lCh = s.charAt(left);
                map.put(lCh, map.get(lCh)-1);
                if (map.get(lCh)==0){
                    map.remove(lCh);
                }
                left++;
            }

            int currMax = right-left +1;
            if (currMax> max){
                max = currMax;
            }
        }
        return max;
    }

    public static void main(String[] args){
        String s = "aa";
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s,1));
    }
}
