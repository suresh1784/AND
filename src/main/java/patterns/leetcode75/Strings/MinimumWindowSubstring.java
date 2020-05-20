package patterns.leetcode75.Strings;
import java.util.*;
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        String result = "";
        int min = s.length()+1 ;
        int left = 0 ;
        int lIndex = 0 , rindex = 0 ;
        Map<Character, Integer> freMap = new HashMap<>();
        int k = t.length();
        for (char ch : t.toCharArray()){
            freMap.put(ch, freMap.getOrDefault(ch, 0)+1);
        }
        int matched = 0 ;
        for (int right = 0 ; right < s.length(); right++){
            char rch = s.charAt(right);
            if (freMap.get(rch)!=null){
                freMap.put(rch, freMap.get(rch)-1);
                if (freMap.get(rch)>=0){
                    matched++;
                }
            } // if
            while (matched==k ){
                int currMin = right - left+1 ;
                if (currMin < min){
                    lIndex = left;
                    rindex = right;
                    min = currMin;

                }
                char lch = s.charAt(left);
                left++;
                if (freMap.get(lch)!= null){
                    freMap.put(lch, freMap.get(lch)+1);
                    if (freMap.get(lch)>=1){
                        matched--;
                    }
                }

            }// while
        } // for
        if (lIndex==rindex && min>s.length()){
            return "";
        }
        return s.substring(lIndex, rindex+1);
    }

    public static void main(String[] args){
        String S = "a", T = "aa";
        System.out.println(minWindow(S,T));
    }
}
