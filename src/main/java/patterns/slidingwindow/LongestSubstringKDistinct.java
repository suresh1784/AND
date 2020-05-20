package patterns.slidingwindow;

import java.util.*;

class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        // TODO: Write your code here
        int start = 0 ;
        int minLength = Integer.MAX_VALUE;
        int maxLength = 0 ;
        int length = 0 ;

        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0 ; end < str.length(); end++){

            if (map.get(str.charAt(end))!=null){

                map.put(str.charAt(start), map.get(str.charAt(start))+1);
            }else {
                map.put(str.charAt(end), 1);
            }

            while(map.size()>k) {
                length = end - start;
                minLength = Math.min(length, minLength);
                maxLength = Math.max(length, maxLength);
                map.put(str.charAt(start), map.get(str.charAt(start))-1);
                if (map.get(str.charAt(start))==0)
                map.remove(str.charAt(start));
                start++;
            }
        }

        return maxLength;
    }

    public static int findLengthv1(String str, int k) {
        // TODO: Write your code here
        int left = 0 ;
        Map<Character, Integer>  map = new HashMap<>();
        int right = 0 ;
        int count = 0 ;
        int maxLength = -1 ;
        while (right < str.length()){
            Character ch = str.charAt(right);
            if (!map.containsKey(ch)){
                map.put(ch, 1);
                count++;
            }else {
                map.put(ch, map.get(ch)+1);
            }

            while (count > k ){
                maxLength = Math.max(maxLength, right-left);
                Character ch1 = str.charAt(left);
                if (map.containsKey(ch1)){
                    map.put(ch1, map.get(ch1)-1);
                    count --;
                    if (map.get(ch1)==0){
                        map.remove(ch1);
                    }
                }
                left++;
            } // while

            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLengthv1("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLengthv1("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLengthv1("cbbebi", 3));

    }
}
