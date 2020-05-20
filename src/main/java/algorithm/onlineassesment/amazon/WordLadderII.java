package algorithm.onlineassesment.amazon;
import java.util.*;
public class WordLadderII {
    public class Word{
        String word;
        int length;
        public Word( String word, int length ){
            this.length = length;
            this.word = word;
        }
    }

    Map<String, List<String>> parent;
    public WordLadderII(){
        parent = new HashMap<>();
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new LinkedList<>();
        Queue<Word> q = new LinkedList<>();
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        if (!dict.contains(endWord)){
            return result;
        }
        q.offer(new Word(beginWord, 0) );
        parent.put(beginWord, null);
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Word word = q.poll();
            if (word.length > min ){
                break;
            }
            if (word.word.equals(endWord)){
               min = word.length;
               continue;
            }
            char[] currWord = word.word.toCharArray();
            for (int j = 0 ; j < currWord.length; j++) {
                char oldChar = currWord[j];
                for (char i = 'a'; i <= 'z'; i++) {
                currWord[j]= i;
                String currStr = new String(currWord);
                    if (dict.contains(currStr)){
                        if (parent.get(currStr)== null){
                            parent.put(currStr, new ArrayList<>());
                        }
                        parent.get(currStr).add(word.word);
                        q.offer(new Word(currStr, word.length+1));
                        if(!currStr.equals(endWord)){
                            dict.remove(currStr);
                        }

                    }
                }
                currWord[j]= oldChar;
            }

        }

        System.out.println(parent);

        dfs(parent, result, new LinkedList<>(), beginWord, endWord);
        List<List<String>> res = dfs1(parent, result, new LinkedList<>(), beginWord, endWord);
        System.out.println(res);
     //   System.out.println(result);
        return result;
    }

    private void dfs(Map<String, List<String>> parent, List<List<String>> result, List<String> list, String startWord, String endWord){
        if (endWord.equals(startWord)){
            list.add("cog");
            result.add(new LinkedList<>(list));
            return;
        }
        List<String> parents = parent.get(endWord);
        for (String p : parents){
            list.add(0 , p);
            dfs(parent, result, list, startWord, p);
            list.remove(list.size()-1);
        }
    }

    private List<List<String>> dfs1(Map<String, List<String>> parent, List<List<String>> result, List<String> list, String startWord, String endWord){

        List<List<String>> res = new ArrayList<>();

        if (endWord.equals(startWord)){
            List<String> li = new LinkedList<>();
            //li.add("cog");
            res.add(new LinkedList<>(li));
            return res;
        }
        List<String> parents = parent.get(endWord);
        for (String p : parents){

            List<List<String>> lists = dfs1(parent, result, list, startWord, p);
            for (List<String> l : lists){
                l.add(p);
                res.add(new ArrayList<>(l));
                l.remove(l.size()-1);
            }
        }
     //   System.out.println("res "+res);
        return res;
    }
}
