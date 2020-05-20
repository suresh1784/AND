package algorithm.onlineassesment.amazon;

import java.util.*;

public class LongestSubStringVowels {
    public int longestSubStringVowels(String s){
    Set<Character> set = new HashSet<>();
    set.addAll(Arrays.asList('a','e','i','o','u'));
    int i = 0 ;
    int j = s.length()-1;
    int start = 0 ;
    int end = 0 ;

    while (set.contains(s.charAt(i))){
        start++;
        i++;
    }

    while (set.contains(s.charAt(j))){
        start ++;
        j--;
    }

    int mid = longestStringVowels(s.substring(i, j+1), set);
        System.out.println("mid"+mid);
    return mid+start;

    }

    public int longestStringVowels(String s, Set<Character> set){
        System.out.println(s);
        int max = 0 ;
        int count = 0 ;
        for (char ch : s.toCharArray()){
            if (set.contains(ch)){
                count++;
                if (max< count){
                    max = count;
                }
            }else {
                count = 0 ;
            }
        }
        return max;
    }
}
