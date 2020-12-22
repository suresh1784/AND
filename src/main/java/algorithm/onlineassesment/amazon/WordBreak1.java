package algorithm.onlineassesment.amazon;

import java.util.*;

public class WordBreak1 {

    public static boolean isWordBreak(List<String> A , List<String> B){
        Set<String> wordSet = new HashSet<>(A);
        Map<String, Boolean> map = new HashMap<>();
        for (String word : B) {
            System.out.println(map);
            if (!helper(word, wordSet, map)){
                return false;
            }
        }
        return true;
    }

    static boolean helper(String word, Set<String> wordSet,Map<String, Boolean> map ){
        if (word.length() ==0){
            return true;
        }

        if (map.containsKey(word)){
            System.out.println("Mem -> "+word);
            return map.get(word);
        }

        for (int i = 0 ; i < word.length() ; i++){
            String prefix = word.substring(0,i+1);
            if (wordSet.contains(prefix)){
               if( helper(word.substring(i+1),wordSet , map)){
                   map.put(prefix, true);
                   return true;
               }
               else {
                   map.put(prefix, false);
               }
            }else {
                map.put(prefix, false);
            }
        }
        map.put(word, false);
        return false;
    }

    public static void main(String[] args) {
        List<String> A = Arrays.asList("one", "two", "three", "oneon");
        List<String> B = Arrays.asList("oneonetwo", "three", "onethree", "oneo");
        System.out.println(isWordBreak(A, B));

    }
}
