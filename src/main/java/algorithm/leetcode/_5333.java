package algorithm.leetcode;

import java.util.Arrays;
import java.util.*;

public class _5333 {

    public static int minSteps(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }

        for (char ch : t.toCharArray()){
            if(freqMap.containsKey(ch)){
                freqMap.put(ch, freqMap.get(ch)-1);
                if (freqMap.get(ch)==0){
                    freqMap.remove(ch);
                }
            }
        }

        int len = 0 ;

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            len += entry.getValue();
        }

        return len;
    }


    public static void main(String[] args){
       String s = "bab", t = "aba"; // 1

       String s2 = "leetcode", t2 = "practice"; // 5

        String s3 = "friend", t3 = "family" ; // 4

        String s4 = "", t4 = "";
        System.out.println(minSteps(s4,t4));

    }
}
