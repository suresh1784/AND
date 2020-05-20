package patterns.slidingwindow.leetcode;

import java.util.*;

public class MaxNumOccSubstring_5293 {
    public static void main(String[] args){
       String s = "aababcaab";
       String s1 = "abcde";
       String s2 = "aaaa";
        String s3 = "aaaaacbc";

        String s4 = "bbacbadadc";

       int maxLetters = 2;
       int minSize = 1;
       int maxSize = 1;
        System.out.println(maxFreq(s4, maxLetters, minSize, maxSize));
        System.out.println(maxFreqv1(s4, maxLetters, minSize, maxSize));

    }

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> freqMap = new HashMap<>();

        int left = 0 ;
        String str = "";
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int right = 0 ; right < s.length(); right++ ){
            char rChar = s.charAt(right);
            charFreq.put(rChar, charFreq.getOrDefault(rChar, 0)+1);
            str = s.substring(left, right+1);

            while (charFreq.size() > maxLetters || str.length() > maxSize ) {
                char lChar = s.charAt(left);
                left++;
                charFreq.put(lChar, charFreq.get(lChar)-1);
                if (charFreq.get(lChar)==0){
                    charFreq.remove(lChar);
                }
                str = s.substring(left, right+1);
            }
            if (str.length() >= minSize && str.length()<= maxSize && charFreq.size()<=maxLetters){
                int ll = left;
                while (ll <= right && charFreq.size()<=maxLetters && s.substring(ll,right+1).length() >= minSize){
                    str = s.substring(ll, right+1);
                    freqMap.put(str, freqMap.getOrDefault(str, 0)+1);
                    ll++;
                }

            }
        }

        int result = 0 ;
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()){
            if (entry.getValue() > result){
                result = entry.getValue();
            }
        }
        return result;
    }

    public static int maxFreqv1(String s, int maxLetters, int minSize, int maxSize) {
        int maxFreq = 0;
        for (int size = minSize; size <= maxSize; size++) {
            maxFreq = Math.max(maxFreq, getMaxFreqWithThisSize(s, maxLetters, size));
        }
        return maxFreq;
    }

    private static int getMaxFreqWithThisSize(String str, int maxLetters, int size) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= str.length() - size; i++) {
            String substring = str.substring(i, i + size);
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < substring.length(); j++) {
                set.add(substring.charAt(j));
                if (set.size() > maxLetters) {
                    break;
                }
            }
            if (set.size() <= maxLetters) {
                map.put(substring, map.getOrDefault(substring, 0) + 1);
            }
        }
        int max = 0;
        for (String key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        return max;
    }
}
