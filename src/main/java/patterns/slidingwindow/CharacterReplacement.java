package patterns.slidingwindow;
import java.util.*;

public class CharacterReplacement {



    public static int characterReplacement(String s, int k) {

        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0 , len = s.length();
        int max = 0 , currentMax = 0 ;
        for (int right = 0 ; right < len; right++){
            char rch = s.charAt(right);
            freqMap.put(rch, freqMap.getOrDefault(rch, 0)+1);
            currentMax = Math.max(currentMax, freqMap.get(rch));
            int currKLength = right-left+1-currentMax; // findCurrK length
            if (currKLength > k){
                char lch = s.charAt(left);
                left++;
                freqMap.put(lch, freqMap.get(lch)-1);
                if (freqMap.get(lch)==0){
                    freqMap.remove(lch);
                }
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }


    public static int findLengthv1(String str, int k) {
        int left = 0 ;
        int maxLength = 0 ;
        int count = 0;
        int maxRepCount = 0 ;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int right = 0 ; right < str.length(); right++){
            Character ch1 = str.charAt(right);
            if (freqMap.containsKey(ch1)){
                freqMap.put(ch1, freqMap.get(ch1)+1);
            }else {
                freqMap.put(ch1, 1);
            } // if else

            maxRepCount = Math.max(maxRepCount, freqMap.get(ch1));

            if (right-left+1-maxRepCount > k){
                if(freqMap.containsKey(str.charAt(left))){
                    freqMap.put(str.charAt(left) ,freqMap.get(str.charAt(left))-1 );
                    if (freqMap.get(str.charAt(left))==0){
                        freqMap.remove(str.charAt(left));
                    }
                }
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1 );
        }
        return maxLength;
    } // findLengthV1




        public static void main(String[] args) {
            System.out.println(CharacterReplacement.characterReplacement("aabccbb", 2));
            System.out.println(CharacterReplacement.characterReplacement("abbcb", 1));
            System.out.println(CharacterReplacement.characterReplacement("abccde", 1));
            System.out.println(CharacterReplacement.characterReplacement("aabccbbabacdbbbbbbbbbde", 4));
            System.out.println(CharacterReplacement.findLengthv1("aabccbb", 2));
            System.out.println(CharacterReplacement.findLengthv1("abbcb", 1));
            System.out.println(CharacterReplacement.findLengthv1("abccde", 1));
            System.out.println(CharacterReplacement.findLengthv1("aabccbbabacdbbbbbbbbbdemmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmlmnp", 4));
        }

}
