package patterns.slidingwindow;

import java.util.*;

class NoRepeatSubstring {
    public static int findLength(String str) {
        // TODO: Write your code here
        int left =0;
        int right = 0 ;
        int maxLength = 0 ;
        Map<Character, Integer> indexMap = new HashMap<>();
        while (right < str.length()){
            Character ch1 = str.charAt(right);
            if (!indexMap.containsKey(ch1)){
                indexMap.put(ch1, right);
            } else {
                maxLength = Math.max(maxLength, right-left);
                left = indexMap.get(ch1)+1;
            }
            right ++;
        }// while

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}