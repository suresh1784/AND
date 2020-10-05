package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingSubstring {
    public int longestRepeatingSubstring(String S) {
        Map<String, Integer> map = new HashMap<>();

        int result = 0 ;
        char[] chars = S.toCharArray();
        for (int i = 0 ; i < S.length() ; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = i ; j < S.length(); j++){
                sb.append(chars[j]);
                String str = sb.toString();
                map.put(str, map.getOrDefault(str,0)+1);
                if (map.get(str) >=2){
                    result = Math.max(result, str.length());
                }
            }
        }
        return result;
    }

    public int longestRepeatingSubstring1(String S) {
        Map<String, Integer> map = new HashMap<>();

        int result = 0 ;
        char[] chars = S.toCharArray();
        for (int i = 0 ; i < S.length() ; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = i ; j < S.length(); j++){
                sb.append(chars[j]);
                String str = sb.toString();
                map.put(str, map.getOrDefault(str,0)+1);
                if (map.get(str) >=2){
                    result = Math.max(result, str.length());
                }
            }
        }
        return result;
    }
}
