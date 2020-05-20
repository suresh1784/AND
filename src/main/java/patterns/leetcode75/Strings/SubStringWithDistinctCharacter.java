package patterns.leetcode75.Strings;
import java.util.*;

public class SubStringWithDistinctCharacter {
    public static int lengthOfLongestSubstring(String s, int k) {
        int max = 0 ;
        int left = 0 ;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0 ; right < s.length() ; right ++){
            char rVal = s.charAt(right);

            if (map.get(rVal)== null){
                map.put(rVal, 1);
            }else{
                map.put(rVal, map.get(rVal)+1);
            }

            while (map.get(rVal)==k+1){
                char lVal = s.charAt(left);
                map.put(lVal, map.get(lVal)-1);  //  ,2
                if (map.get(lVal)==0){
                    map.remove(lVal);
                }
                left++;
            }

            if (map.get(rVal)<=k){
                int currMax = right - left+1;
                if (currMax > max){
                    max = currMax;
                }
            }
        }


        return max;
    }

    public static void main(String[] args){
        String str = "eceba";
        System.out.println(lengthOfLongestSubstring(str, 1));
    }
}
