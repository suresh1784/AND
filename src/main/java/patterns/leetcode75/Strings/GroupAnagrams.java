package patterns.leetcode75.Strings;
import java.util.*;
public class GroupAnagrams {
    public static  List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] sortedStr = s.toCharArray();
            Arrays.sort(sortedStr);
            String sorted = new String(sortedStr);
            if(map.get(sorted)==null){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }

        result.addAll(map.values());
        return result;
    }


    // n
    public static void main(String[] args){
    String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input));
    }
}
