package patterns.slidingwindow;

import java.util.*;
public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> result = new ArrayList<>();
        int left = 0 ;
        int matched = 0 ;

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : pattern.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }
        for (int right = 0 ; right < str.length() ; right++){
            char rChar = str.charAt(right);
            if (freqMap.containsKey(rChar)){
                freqMap.put(rChar, freqMap.get(rChar)-1);
                if (freqMap.get(rChar)>=0){
                    matched++;
                }
            }

// Pattern length
            if (matched==pattern.length()){
                result.add(left);
            }

            if (right >= pattern.length()-1){
                char lChar = str.charAt(left);
                left++;

                if (freqMap.containsKey(lChar)){
                    if (freqMap.get(lChar)>=0) {
                        matched --;
                    }
                    freqMap.put(lChar, freqMap.get(lChar)+1);

                }
            }




        }
        return result;
    }




    public static List<Integer> findStringAnagramsv1(String str, String pattern) {
        List<Integer> result = new ArrayList<>();
        int left = 0 ;
        int count = 0 ;

        Map<Character, Integer> freqMap = new HashMap<>();
        for (Character ch : pattern.toCharArray()){
            if (freqMap.containsKey(ch)){
                freqMap.put(ch, freqMap.get(ch)+1);
            }else {
                freqMap.put(ch,1);
            }
        }

        for (int right = 0 ; right < str.length(); right ++){
            Character ch1 = str.charAt(right);
            if (freqMap.containsKey(ch1)){
                freqMap.put(ch1, freqMap.get(ch1)-1);
                if (freqMap.get(ch1)==0){
                    count++;
                }
            } // if
// freqMap
            if (count == freqMap.size()){
                result.add(left);
            }

            if (right >= pattern.length()-1){
                Character ch2 = str.charAt(left++);
                if (freqMap.containsKey(ch2)){
                    if (freqMap.get(ch2)==0){
                        count--;
                    }
                    freqMap.put(ch2, freqMap.get(ch2)+1);
                }
            } // if
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagramsv1("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
        System.out.println(StringAnagrams.findStringAnagramsv1("abbcabc", "abc"));
    }


}
