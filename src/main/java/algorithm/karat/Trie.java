package algorithm.karat;

import java.sql.SQLOutput;
import java.util.*;

public class Trie {
    public static class TrieNode {
        boolean endOfWord;
        List<String> word;
        String completeWord;
        Map<Character, TrieNode> childeren;

        public TrieNode() {
            this.endOfWord = false;
            this.completeWord = null;
            this.word = new ArrayList<>();
            this.childeren = new HashMap<>();
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode curr = root;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (curr.childeren.get(ch) == null) {
                curr.childeren.put(ch, new TrieNode());
                curr.word.add(s);
            }
            curr = curr.childeren.get(ch);
        }

        curr.endOfWord = true;
        curr.completeWord = s;
        curr.word.add(s);
    }


    public List<String> search(String search) {
        TrieNode curr = root;
        for (char ch : search.toCharArray()) {
            TrieNode node = curr.childeren.get(ch);
            if (node == null) {
                return null;
            }
            curr = node;
        }

        return curr.word;
    }

    public Boolean searchAbb(String search) {
        TrieNode curr = root;
        List<String> results = new ArrayList<>();
        String result = searchdfs(search, curr, 0, 0, results);
        if (result != null)
            System.out.println("Result " + results);
        return result != null;
    }


    public String searchdfs(String search, TrieNode curr, int level, int loop, List<String> results ) {
        if (curr == null ){
            return null;
        }

        if (loop !=0){
            for(Map.Entry<Character,TrieNode> entry : curr.childeren.entrySet()){

              return searchdfs(search, entry.getValue() , level, loop-1, results );
            }
        }


        if (curr.endOfWord && level == search.length()) {
            System.out.println(curr.completeWord);
            results.add(curr.completeWord);
            return curr.completeWord;
        }

        if (level == search.length()) {
            return null;
        }

        char ch = search.charAt(level);
        if (Character.isLetter(ch)) {

            return  searchdfs(search, curr.childeren.get(ch), level + 1, 0, results);
        } else if (Character.isDigit(ch)) {
            int tmp = 0 ;
            while(level<search.length() && Character.isDigit(search.charAt(level))) {
                tmp = tmp * 10 + Character.getNumericValue(ch);
                level++;
            }
            return searchdfs(search, curr, level , tmp, results);
        }
        return null;
    }


    public static void main(String args[]) {
        Trie trie = new Trie();
        trie.insert("Mousse");
        trie.insert("Mouse");
        trie.insert("Mopse");
        trie.insert("MouseHClick");
        trie.insert("MouseHandler");
        trie.insert("MouseClickHandler");
        trie.insert("MouseHandlerType");
        System.out.println(trie.search("Mouse"));
       // System.out.println(trie.searchAbb("Mouse"));
        System.out.println(trie.searchAbb("Mo2e"));
        System.out.println(trie.searchAbb("1o2e"));
    }

}
