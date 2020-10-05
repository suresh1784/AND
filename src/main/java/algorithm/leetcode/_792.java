package algorithm.leetcode;
import java.util.*;

public class _792 {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Queue<Integer>> map = new HashMap<>();
        for (int i = 0 ; i < S.length(); i++){
            char ch = S.charAt(i);
            if (!map.containsKey(ch)){
                Queue<Integer> q = new LinkedList<>();
                map.put(ch,q );
            }

            map.get(ch).offer(i);
        }


        return 0;
    }


    public static void main(String[] args) {

    }
}


//Example :
//Input:
//S = "abcde"
//words = ["a", "bb", "acd", "ace"]
//Output: 3
//Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace"
