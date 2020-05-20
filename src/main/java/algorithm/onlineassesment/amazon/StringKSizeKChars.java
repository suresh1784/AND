package algorithm.onlineassesment.amazon;
import java.util.*;
public class StringKSizeKChars {
    public List<String>  subStringKSizeKChars(String s, int k){
        HashSet<String> result = new HashSet<>();
        int left = 0 ;
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0 ; right < ch.length; right++){
            Character rCh = ch[right];
            map.put(rCh, map.getOrDefault(rCh, 0)+1);

                while (map.size() > k || right - left+1 >k){
                    Character lVal = ch[left++];
                    map.put(lVal , map.get(lVal)-1);
                    if (map.get(lVal)==0){
                        map.remove(lVal);
                    }
                }

                if (map.size()==k && right-left+1 ==k){
                    result.add(s.substring(left, right+1));
                    Character lVal = ch[left++];
                    map.put(lVal , map.get(lVal)-1);
                    if (map.get(lVal)==0){
                        map.remove(lVal);
                    }
                }

        }

        return new ArrayList<>(result);
    }
}
