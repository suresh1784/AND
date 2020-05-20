package patterns.slidingwindow;


import java.util.*;

class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdabca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }


    public static String findSubstring(String str, String pattern) {
        int left = 0 ;
        int count = 0 ;
        int startIndex = 0 ;
        int endIndex = 0 ;
        int minLength = str.length();

        Map<Character, Integer> freqMap = new HashMap<>();
        for (Character ch : pattern.toCharArray()){
            if (freqMap.containsKey(ch)){
                freqMap.put(ch, freqMap.get(ch)+1);
            }else {
                freqMap.put(ch,1);
            }
        }

        for (int right = 0 ; right < str.length(); right++){
            Character ch1 = str.charAt(right);
            if (freqMap.containsKey(ch1)){
                freqMap.put(ch1, freqMap.get(ch1)-1);
                if (freqMap.get(ch1)>=0){
                    count ++;
                }
            }

            while ( count == pattern.length() ){
                if (count == pattern.length()){
                    int length = right-left+1;
                    if (length < minLength){
                        minLength = length;
                        startIndex = left;
                        endIndex = right;
                     //   System.out.println("startIndex "+startIndex);
                     //   System.out.println("endIndex "+endIndex);
                    }
                }// if
                Character ch2 = str.charAt(left);
                if (freqMap.containsKey(ch2)){
                    if (freqMap.get(ch2)>=0){
                        count--;
                    }
                    freqMap.put(ch2, freqMap.get(ch2)+1);
                }

                left++;
            }// while
        }
        return str.substring(startIndex,endIndex+1);

    } // findSubstring
}
