package patterns.leetcode75.Strings;

import java.util.*;
public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int left = 0 ;
        int k = p.length();
        int matched = 0;
        Map<Character,Integer> freqMap = new HashMap<>();
        for (char ch : p.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }
        for (int right = 0 ; right < s.length(); right++){
        Character rch = s.charAt(right);
        if (freqMap.get(rch)!=null){
            freqMap.put(rch, freqMap.get(rch)-1);
            if (freqMap.get(rch)==0){
                matched++;
            }

            if (matched== freqMap.size()){
                result.add(left);
            }


            if (right >= k-1){
                Character lch = s.charAt(left++);
                if (freqMap.get(lch)!=null){
                    if (freqMap.get(lch)==0){
                        matched--;
                    }
                    freqMap.put(lch, freqMap.get(lch)+1);
                }
            }

        }


        }// for
        return result;
    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        List<Integer> resultIndices = new ArrayList<Integer>();
        // our goal is to match all the characters from the map with the current window
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // decrement the frequency of the matched character
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0)
                    matched++;
            }

            if (matched == charFrequencyMap.size()) // have we found an anagram?
                resultIndices.add(windowStart);

            if (windowEnd >= pattern.length() - 1) { // shrink the window
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    // put the character back
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return resultIndices;
    }

    public static void main(String[] args){
        String s= "cbaebabacd" ;
        String p = "abc";
        System.out.println(findAnagrams(s, p));
        System.out.println(findStringAnagrams(s,p));
    }
}
