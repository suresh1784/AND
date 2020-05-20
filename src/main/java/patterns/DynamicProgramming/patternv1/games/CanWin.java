package patterns.DynamicProgramming.patternv1.games;

import java.util.*;
//https://leetcode.com/problems/flip-game-ii/
//https://leetcode.com/problems/flip-game-ii/discuss/73962/Share-my-Java-backtracking-solution
public class CanWin {
    public static Map<String, Boolean> map = new HashMap<>();
    public static boolean canWin1(String s){
        if (map.get(s)!=null){
            return map.get(s);
        }

        if (s.length() < 2){
            map.put(s, false);
            return false;
        }

        for (int i = 0 ; i < s.length() ; i++){
            if (s.startsWith("++", i)){
                String t = s.substring(0,i)+"--"+s.substring(i+2);
              //  System.out.println(t);
                if (!canWin1(t)){
                    map.put(s, true);
                    return true;
                }
            }

        }
        map.put(s, false);
        return false;
    }


    public static boolean canWin(String s) {
    map = new HashMap<>();
    return canWindfs(s);
    }
        public static boolean canWindfs(String s) {
            if (map.get(s) != null) {
                return map.get(s);
            }

            if (s.length() < 2) {
                map.put(s, false);
                return false;
            }

            if (!isFlippable(s)){
                System.out.println("Inside Flippable");
                map.put(s, false);
                return false;
            }

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i-1)=='+'&&s.charAt(i)=='+'){
                    if(!canWindfs(flip(s,i))){
                        map.put(s, true);
                        return true;
                    }else {
                        map.put(s, false);
                    }
                }
            }
            map.put(s, false);
            return false;
        }

        static boolean isFlippable(String s){
            for (int i = 1; i < s.length() ; i++){
                if (s.charAt(i-1)=='+'&&s.charAt(i)=='+'){
                    return true;
                }
            }
            return false;
        }

        static String flip(String str, int i){
        char[] ch = str.toCharArray();
        ch[i-1]= '-';
        ch[i]= '-';
        return new String(ch);
        }


    public static void main(String[] args){
        String s = "------+";
        System.out.println(canWin1(s));
        System.out.println(canWin(s));

    }
}
