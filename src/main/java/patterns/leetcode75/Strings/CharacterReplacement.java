package patterns.leetcode75.Strings;
import java.util.*;

public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {

        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0 , len = s.length();
        int max = 0 , currentMax = 0 ;
        for (int right = 0 ; right < len; right++){
            char rch = s.charAt(right);
            freqMap.put(rch, freqMap.getOrDefault(rch, 0)+1);
            currentMax = Math.max(currentMax, freqMap.get(rch));
            int currKLength = right-left+1-currentMax;
            if (currKLength > k){
                char lch = s.charAt(left);
                left++;
                freqMap.put(lch, freqMap.get(lch)-1);
                if (freqMap.get(lch)==0){
                    freqMap.remove(lch);
                }
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }


    public static void main(String[] args){
        String s = "AABABBBA";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }



}
