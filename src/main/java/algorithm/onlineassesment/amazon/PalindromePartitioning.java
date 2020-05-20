package algorithm.onlineassesment.amazon;
import java.util.*;
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        return dfs(s, 0 , new HashMap<>());
    }

    private List<List<String>> dfs(String s,  int index, Map<Integer, List<List<String>>> map){
        if (map.containsKey(index)){
            return map.get(index);
        }
        List<List<String>> res = new ArrayList<>();
        if (index== s.length()){
            List<String> list = new LinkedList<>();
            res.add(new ArrayList<>(list));
        }

        for (int i = index+1; i <= s.length() ; i++){
            String prefix = s.substring(index, i);
            if (isPalindrome(prefix.toCharArray(), 0 , prefix.length()-1)){
                List<List<String>> lists = dfs(s, i, map);
                for (List<String> l : lists){
                    l.add(0,prefix);
                    res.add(new ArrayList<>(l));
                    l.remove(l.size()-1);
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(char[] ch, int start , int end){
        while (start<=end){
            if (ch[start]!= ch[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
