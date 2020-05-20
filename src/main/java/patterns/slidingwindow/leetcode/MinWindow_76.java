package patterns.slidingwindow.leetcode;

import java.util.HashMap;

import java.util.*;
public class MinWindow_76 {
    public static String minWindow(String s, String t) {
        String result = "";
        Map<Character, Integer>  map = new HashMap<>();
        for (char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int left = 0 ;
        int length = 0 ;
        int min = s.length();
        int start = -1 ;
        int end = -1;
        for (int right = 0 ; right < s.length(); right++){
            char rChar = s.charAt(right);
            if (map.containsKey(rChar)){
                map.put(rChar, map.get(rChar)-1);
                if (map.get(rChar)>=0){
                    length ++;
                }
            }

            while (length >= t.length()){
                int currDiff = right - left;
                System.out.println("------------------");
                System.out.println("left "+ left  + " right "+right);
                System.out.println("String "+s.substring(left,right+1));
                System.out.println(" CurrDiff " +currDiff);
                if (currDiff< min){
                    min = currDiff;
                    start = left;
                    end = right;
                }
                char lChar = s.charAt(left);
                left++;
                if (map.containsKey(lChar)){
                    map.put(lChar, map.get(lChar)+1);
                    if (map.get(lChar)>0){
                        length--;
                    }
                }
            }
        }
        if (s.length() < t.length() || start == -1){
            return "";
        }


        return s.substring(start,end+1);
    }

    public static void main(String[] args){
       String S = "ADOBECODEBANC";
       String T = "ABC";

        String S1 = "a";
        String T1 = "aa";

        String S2 = "a";
        String T2 = "b";

        String S3 = "cabwefgewcwaefgcf";
        String T3 = "cae";

        String S4= "bba";
        String T4 = "ab";

        System.out.println(minWindow(S,T));
    }
}
