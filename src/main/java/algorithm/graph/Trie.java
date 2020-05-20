package algorithm.graph;
import java.util.*;

public class Trie {
    static class TrieNode{
        boolean isEndOfWord;
        List<String>  words;
        Queue<String>  kWords;
        String word;
        Map<Character, TrieNode> childrens;
        private TrieNode(){
            this.isEndOfWord = false;
            this.kWords = new LinkedList<>();
            this.words = new ArrayList<>();
            this.word = null;
            this.childrens = new HashMap<>();
        }

        private void addKwords(String s, int k){
            if (kWords.size() >= k){
                kWords.poll();
            }
            kWords.add(s);
        }
    }

    private TrieNode root;
    private int k;

    private Trie(int k){
        this.root = new TrieNode();
        this.k = k;
    }


    public void put(String s){
        TrieNode curr = root;
        put(curr, s, 0, k);
    }

    private static void put(TrieNode curr, String s , int level, int k){
        if (level == s.length()){
            curr.word = s;
            curr.isEndOfWord = true;
            return;
        }
        TrieNode node = curr.childrens.get(s.charAt(level));
        if (node == null){
           curr.childrens.put(s.charAt(level), new TrieNode());
           node = curr.childrens.get(s.charAt(level));
        }


        node.words.add(s);
        node.addKwords(s,k);

        put(node , s, level+1, k);

    }

    public void delete(String s){
        TrieNode curr = root;
        delete(curr, s, 0);
    }

    private static void delete(TrieNode curr, String s, int level){

        if (curr.isEndOfWord && level==s.length()){
            curr.isEndOfWord = false;
            return;
        }

        if (curr==null || level > s.length()){
            return;
        }



        delete(curr.childrens.get(s.charAt(level)), s, level+1);

    }

    public void update (String s, String T){

    }


    public boolean search(String s){
        TrieNode curr = root;
        return search(curr, s, 0);
    }

    private static boolean search(TrieNode curr, String s, int level){
        if (curr== null){
            return false;
        }

        if (level == s.length()){
            return curr.isEndOfWord;
        }


        return search(curr.childrens.get(s.charAt(level)), s, level+1);
    }

    public List<String> prefixSearch(String s){
        List<String> result = new ArrayList<>();
        TrieNode curr = root;
        prefixSearch(curr,s,0,"", result);
        return result;
    }

    private static void prefixSearch(TrieNode curr, String s , int level, String temp, List<String> result){

        if (curr == null){
            return;
        }

        if (curr.isEndOfWord){
            result.add(temp);
        }

        if (level>= s.length()){
            for (Map.Entry<Character, TrieNode> entry : curr.childrens.entrySet()){
                char tch = entry.getKey();
                prefixSearch(entry.getValue(), s, level, temp+tch, result);
            }
        }else {
            char ch = s.charAt(level);
            prefixSearch(curr.childrens.get(ch), s, level + 1, temp + ch, result);
        }


    }


    public List<String> prefixSearch1(String s){
        TrieNode curr = root;
        for (char ch: s.toCharArray()){
            TrieNode node = curr.childrens.get(ch);
            if (node == null){
                return null;
            }
            curr = node;
        }
        return curr.words;
    }

    public Queue<String> kSearch(String s){
        TrieNode curr = root;
        for (char ch: s.toCharArray()){
            TrieNode node = curr.childrens.get(ch);
            if (node == null){
                return null;
            }
            curr = node;
        }
        return curr.kWords;
    }

    public List<String> wildCardSearch(String s){
        TrieNode curr = root;

        List<String> result = new ArrayList<>();
        wildCardSearch(curr,s,0,result,"");
        return result;
    }

    private static void wildCardSearch(TrieNode curr, String s, int level, List<String> result, String temp ){
        if (level == s.length() && curr.isEndOfWord ){
            result.add(temp);
            return;
        }

        if (curr== null){
            return;
        }

        if (level >= s.length()){
            return;
        }

            char ch = s.charAt(level);
            if (ch == '*') {
                for (Map.Entry<Character, TrieNode> entry : curr.childrens.entrySet()) {
                    char tch = entry.getKey();
                    wildCardSearch(curr.childrens.get(tch), s, level + 1, result, temp + tch);
                }
            } else {
                wildCardSearch(curr.childrens.get(ch), s, level + 1, result, temp + ch);
            }

    }

    public static String longestPrefix;
    public String longestPrefix(String s){
        List<String> result = new ArrayList<>();
        TrieNode curr = root;
        longestPrefix = "";
        longestPrefix(curr, s,0, result);
        return longestPrefix;
    }

    private static void longestPrefix(TrieNode curr, String s, int level, List<String> result){
        if (curr == null){
            return;
        }

        if (curr.isEndOfWord){
            result.add(curr.word);
            if (!curr.word.equals(s)){
                if (curr.word.length() > longestPrefix.length()){
                    longestPrefix = curr.word;
                }
            }
        }

        if (curr.isEndOfWord && curr.word.equals(s)){
            return ;
        }



        char ch = s.charAt(level);
        longestPrefix(curr.childrens.get(ch),s,level+1, result );
    }


    public List<String> longestCommonPrefix(String s){
        List<String> result = new ArrayList<>();
        TrieNode curr = root;
        longestPrefix = "";
        longestCommonPrefix(curr, s,0, result,"");
        System.out.println(longestPrefix);
        return result;
    }

    private static void longestCommonPrefix(TrieNode curr, String s, int level, List<String> result, String temp){
        if (curr == null){
            return;
        }

        if (curr.isEndOfWord){
            result.add(curr.word);
            if (!curr.word.equals(s)){
                if (curr.word.length() > longestPrefix.length()){
                    longestPrefix = curr.word;
                }
            }
        }

        if (level>= s.length()){
            return;
        }

        if (curr.isEndOfWord && curr.word.equals(s)){
            return ;
        }



        char ch = s.charAt(level);
        longestCommonPrefix(curr.childrens.get(ch),s,level+1, result , temp+ch);
        for (Map.Entry<Character, TrieNode> entry : curr.childrens.entrySet()){
            char tch = entry.getKey();
            longestCommonPrefix(entry.getValue(),s,level+1, result,temp+tch );
        }
    }

    public Queue<String> sort(){
        return null;
    }

    public static void main(String[] args){
        Trie trie = new Trie(3);
        long start = System.currentTimeMillis();
        trie.put("banana");
        trie.put("bapapa");
        trie.put("bananas");
        trie.put("best");
        trie.put("bandid");
        trie.put("besters");
        trie.put("bapnana");
        trie.put("bapnanas");
        trie.put("bepst");
        trie.put("bapndid");
        trie.put("bepsters");
        trie.put("better");
        trie.put("beator");
        System.out.println(trie.search("banana"));
        trie.delete("banana");
        System.out.println(trie.search("banana"));
//        System.out.println(trie.search("banaa"));
        System.out.println(trie.prefixSearch1("ba"));
        System.out.println(trie.prefixSearch("ba"));
//        System.out.println(trie.kSearch("ba"));
//        System.out.println(trie.kSearch("be"));
//        System.out.println(trie.wildCardSearch("ba*a*a"));
//        System.out.println(trie.wildCardSearch("be*t*r"));
//        System.out.println(trie.wildCardSearch("b*pst"));
//        System.out.println(trie.wildCardSearch("b*nan*s"));
//        System.out.println(trie.wildCardSearch("******"));
//        System.out.println(trie.wildCardSearch("*******"));
//        trie.put("128.168.192");
//        trie.put("128.168.194");
//        trie.put("128.168.144");
//        trie.put("128.168.145");
//        trie.put("128.168");
//        trie.put("128.168.244");
      //  System.out.println(trie.longestPrefix("128.168.194"));
      //  System.out.println(trie.longestCommonPrefix("128.168.144"));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
