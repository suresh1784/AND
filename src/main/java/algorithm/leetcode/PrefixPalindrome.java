package algorithm.leetcode;
import java.util.*;
public class PrefixPalindrome {
    public static String stripePalindrome(String s){
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

        System.out.println(map);
        int i = 0 ;
        while (i < s.length()){
            char ch = s.charAt(i);
            List<Integer> list = map.get(ch);

            for (int j = list.size()-1; j >=0 ; j--){
                int jval = list.get(j);
                if (jval-i< 2){
                    return s.substring(i);
                  //  break;
                }
                if (isPalindrome(s, i, jval)){
                    i = jval+1;
                    break;
                }
            }
        }
        return "";
    }

    public static boolean isPalindrome(String s, int start , int end){
        if (end-start < 2){
            return false;
        }
        while (start < end){
            if (s.charAt(start)!= s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(stripePalindrome("aaalabcbdc"));
    }

}
