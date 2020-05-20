package algorithm.leetcode;

import java.util.HashMap;
import java.util.*;

public class IsAlienSorted {
    public static void main (String[] args){
        String[] words = {"hello","leetcode"} ;
         String order = "hlabcdefgijkmnopqrstuvwxyz";

        String[] words1 = {"word","world","row"};
        String order1 = "worldabcefghijkmnpqstuvxyz";


        String[] words2 = {"apple","app"};
        String order2 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(isAlienSorted(words2, order2));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        int index = 0 ;
        for (char ch : order.toCharArray()) {
            orderMap.put(ch, index);
            index++;
        }

        for (int i = 1 ; i < words.length ; i++){
            if (!isSorted(words[i-1], words[i], orderMap)){
                return false;
            }
        }

        return true;
    }


    public static boolean isSorted (String s1 , String s2 , Map<Character, Integer> orderMap){
        int i = 0 ; int j = 0 ;
        while (i < s1.length() && j < s2.length()){
            if (s1.charAt(i)== s2.charAt(j)){
                i++;
                j++;
            } else if (orderMap.get(s1.charAt(i)) < orderMap.get(s2.charAt(j))){
                return true;
            } else if (orderMap.get(s1.charAt(i)) > orderMap.get(s2.charAt(j))){
                return false;
            }
        }

        if (s2.length() < s1.length()){
            return false;
        }

        return true;
    }

}
