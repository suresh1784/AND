package patterns.mock;
//Uber Online

import java.util.*;
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length){
            return false;
        }

        for (int i = 0 ; i < pattern.length() ; i++ ){
            Character ch = pattern.charAt(i);
            String s = strArray[i];
            if (map.containsKey(ch)){
                String p = map.get(ch);
                if (p.equals(s)){

                }else {
                    return false;
                }
            } else {
                if (set.contains(s)){
                    return false;
                }
                set.add(s);
                map.put(ch, s);
            }
        }

        return true;
    }


    public static void main(String[] args){
       String pattern1 = "abba", str1 = "dog cat cat dog"; // true
       String  pattern2 = "abba", str2 = "dog cat cat fish" ; // false
       String  pattern3 = "aaaa", str3 = "dog cat cat dog"; // false
        String pattern4 = "abba", str4 = "dog dog dog dog"; // false

        System.out.println(wordPattern(pattern4, str4));
    }
}
