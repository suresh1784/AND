package algorithm.onlineassesment.amazon;

import java.util.*;
public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words== null || words.length == 0){
            return null;
        }
        List<String> result = new ArrayList<>();
        // sort words
        Arrays.sort(words, (a,b)-> {
            if (a.length()==b.length()){
                return a.compareTo(b);
            }
            return Integer.compare(a.length(), b.length());

        });
        Set<String> preSet = new HashSet<>();
        for (String word: words){
            if (word.isEmpty()){
                continue;
            }
           if( dfs(word, preSet,0, new HashMap<>() )){
               result.add(word);
           }
           preSet.add(word);
        }

        return result;
    }


    public boolean dfs(String word, Set<String> dict, int index, Map<Integer, Boolean> map){
        if (map.containsKey(index)){
            return  map.get(index);
        }

        if (index == word.length()){
            return true;
        }

        for (int i = index+1; i<=word.length(); i++){
            String prefix = word.substring(index, i);
            if (dict.contains(prefix)){
                Boolean state = dfs(word, dict, i, map);
                if (state){
                    return true;
                }
            }
        }
        map.put(index, false);
        return map.get(index);
    }

    public List<List<String>> test(String searchWord, String[] words) {

    Trie trie = new Trie();
    for (String word : words){
       trie.add(word);
    }
    List<List<String>> result = trie.getConcatenatedWords(searchWord);
     //   System.out.println(result);
        return result;
    }

    class Trie{
        class TrieNode{
            boolean isEndOfWord;
            String word;
            Map<Character, TrieNode> children;
            public TrieNode(){
                isEndOfWord = false;
                children = new HashMap<>();
                word = null;
            }
        } // trieNode

        TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void add(String str){
            TrieNode curr = root;
            add(curr , str, 0);
        }

        public void add(TrieNode curr, String str, int level){
            if (level == str.length()){
                curr.isEndOfWord = true;
                curr.word = str;
                return;
            }

            TrieNode node = curr.children.get(str.charAt(level));
            if (node == null){
                curr.children.put(str.charAt(level), new TrieNode());
                node = curr.children.get(str.charAt(level));
            }

            add(node , str, level+1);
        }

        public List<List<String>> getConcatenatedWords(String str){
            List<List<String>> result = new ArrayList<>();
            TrieNode curr = root;
            TrieNode curr1 = root;
            search(curr , str , 0, result, new ArrayList<>(),  curr1);
            return result;
        }

        public void search(TrieNode curr, String str, int level, List<List<String>> result, List<String> lists , TrieNode curr1){
           if (curr == null){
               return ;
           }

            if (level == str.length()){
                if (curr.isEndOfWord){
                    lists.add(curr.word);
                    result.add(new ArrayList<>(lists));
                }

                return;
            }

            if (curr.isEndOfWord){
                TrieNode node = curr.children.get(str.charAt(level));

                if (node != null) {
                    search(node, str, level + 1, result, lists, curr1);
                    if (lists.size()>=1)
                    lists.remove(lists.size()-1);
                }

                lists.add(curr.word);
                TrieNode root = curr1.children.get(str.charAt(level));
                if (root != null) {
                    search(root, str, level + 1, result, lists, curr1);
                }
                lists.remove(lists.size()-1);
            }else {

                TrieNode node = curr.children.get(str.charAt(level));
                search(node, str, level + 1, result, lists, curr1);
            }

        }

    } // trie
}
