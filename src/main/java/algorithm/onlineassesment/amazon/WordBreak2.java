package algorithm.onlineassesment.amazon;
import java.util.*;
public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);
        List<String> result = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> res = dfs(s, dict, result, "", 0, map);
        System.out.println(res);
                return res;
    }
    private List<String> dfs(String s, Set<String> dict, List<String> result,String curr, int index, Map<Integer, List<String>> map){
        if (map.containsKey(index)){
            return map.get(index);
        }
        LinkedList<String> res = new LinkedList<>();
        if (index == s.length()){
            //result.add(curr);
           // return result;
            res.add("");
            return res;
        }

        for (int i = index+1; i <= s.length();i++ ){
            String prefix = s.substring(index, i);
            if (dict.contains(prefix)){
               List<String> list =  dfs(s, dict, result, curr+(curr.length()>=1? " ":"")+prefix , i, map);
                System.out.println("Prefix "+ prefix+" list "+list);
                for (String l : list){

                    res.add(prefix + (l.isEmpty()? "":" ")+ l);
                }
            }
        }
        map.put(index, res);
        return res;
    }

    public List<List<String>> wordBreak1(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);
        List<String> result = new ArrayList<>();
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> res = dfs1(s, dict, result, "", 0, map);
      //  System.out.println(res);
        return res;
    }
    private List<List<String>> dfs1(String s, Set<String> dict, List<String> result,String curr, int index, Map<Integer, List<List<String>>> map){
        if (map.containsKey(index)){
            return map.get(index);
        }
        List<List<String>> res = new LinkedList<>();

        if (index == s.length()){
            List<String> list = new ArrayList<>();
            res.add(list);
            return res;
        }

        for (int i = index+1; i <= s.length();i++ ){
            String prefix = s.substring(index, i);
            if (dict.contains(prefix)){
                List<List<String>> lists =  dfs1(s, dict, result, curr+(curr.length()>=1? " ":"")+prefix , i, map);
                System.out.println("Prefix "+ prefix+" list "+lists);
                for (List<String> l: lists){
                    l.add(0,prefix);
                    res.add(new ArrayList<>(l));
                    l.remove(l.size()-1);
                }
            }
        }
        map.put(index, res);
        return res;
    }
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        WordBreak2 wordBreak2 = new WordBreak2();
        List<List<String>> actual = wordBreak2.wordBreak1(s,wordDict);
        System.out.println(actual);
    }
}
