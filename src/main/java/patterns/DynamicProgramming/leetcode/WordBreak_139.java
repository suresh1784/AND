package patterns.DynamicProgramming.leetcode;
import java.util.*;

public class WordBreak_139 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() > 0) {
            return wordBreak(s, wordDict, 0);
        }else {
            return false;
        }
    }

    public static boolean wordBreak(String s, List<String> wordDict, int level){
        if (s.length() ==0){
            return true;
        }
        for (int j = level+1; j <= s.length();  j++){
            String prefix = s.substring(level, j);
            if (wordDict.contains(prefix)){
               if( wordBreak(s.substring(j), wordDict, 0)){
                   return true;
               }
            }
        }

        return false;

    }


    public static void main(String[] args){
        String s = "leetcode";
        String[] sArray = {"leetc", "ode"};
        List<String> wordDict = Arrays.asList( sArray);
        System.out.println(wordBreak(s, wordDict));
    }
}
