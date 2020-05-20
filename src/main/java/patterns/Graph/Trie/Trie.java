package patterns.Graph.Trie;

import java.util.*;

public class Trie {
    class TrieNode{
        Boolean endOfWord;
        Map<Character, TrieNode> children;

        public TrieNode(){
            this.endOfWord = false;
            this.children = new HashMap<>();
        }

    }// TrieNode

    TrieNode root;
    public Trie() {
    root = new TrieNode();
    }

    public void put(String str){
        TrieNode curr = root;
        putRecursive(str.toCharArray(), 0 , curr);
    }

    public void putRecursive(char[] chars, int level, TrieNode curr){
        if (level == chars.length){
            curr.endOfWord = true;
            return;
        }

        char ch = chars[level];
        TrieNode node = curr.children.get(ch);
        if (node == null){
            curr.children.put(ch, new TrieNode() );
        }
        node = curr.children.get(ch);
        putRecursive(chars, level+1, node);
    }

    public boolean search(String str){
        TrieNode curr = root;
        return searchRecursive(str.toCharArray(), 0 , curr);
    }

    public boolean searchRecursive(char[] chars, int level , TrieNode curr){
        if (level == chars.length){
            return curr.endOfWord;
        }

        char ch = chars[level];
        TrieNode node = curr.children.get(ch);
        if (node == null ){
            return false;
        }
        return searchRecursive(chars, level+1, node);
    }


    public List<String> prefixSearch(String str){
        List<String> result = new ArrayList<>();
        TrieNode curr = root;
        prefixSearchRecursive(curr, str.toCharArray(), 0, result, "");
        return result;
    }

    public void prefixSearchRecursive(TrieNode curr, char[] chars, int level , List<String> lists , String temp) {
        if (curr.endOfWord){
            if (temp.length() >= 1)
            lists.add(temp);
        }

        if (curr== null){
            return;
        }

        if (level < chars.length){
            char ch = chars[level];
            TrieNode node = curr.children.get(ch);
            if (node == null){
                return;
            }else {
                prefixSearchRecursive(node, chars, level+1, lists, temp+ch);
            }
        } else {
            for(Map.Entry<Character, TrieNode> entrySet : curr.children.entrySet()){
                prefixSearchRecursive(entrySet.getValue(), chars, level, lists, temp+entrySet.getKey());
            }
        }
    }


    public List<String> wildCardSearch(String str){
        System.out.println("Input "+ str);
        TrieNode curr = root;
        List<String> result = new ArrayList<>();
        wildCardSearchRecursive(curr, str.toCharArray(),0, result, "");
        return result;
    }

    public static void wildCardSearchRecursive(TrieNode curr, char[] chars, int level , List<String> result, String temp){

        if (curr == null){
            return;
        }

        if (level == chars.length && curr.endOfWord){
            result.add(temp);
            return;
        }

        if (level == chars.length){
            return ;
        }

        char ch = chars[level];
        if (ch == '*'){
            for (Map.Entry<Character, TrieNode> entrySet : curr.children.entrySet()){
                wildCardSearchRecursive(entrySet.getValue(), chars, level+1, result, temp+entrySet.getKey());
            }
        } else {
            wildCardSearchRecursive(curr.children.get(ch), chars, level+1, result, temp+ch);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
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
//        trie.delete("banana");
        System.out.println(trie.search("banana"));
        System.out.println(trie.search("banaa"));
        System.out.println(trie.prefixSearch("ba"));
        System.out.println(trie.prefixSearch("ban"));
//        System.out.println(trie.kSearch("ba"));
//        System.out.println(trie.kSearch("be"));
        System.out.println(trie.wildCardSearch("ba*a*a"));
        System.out.println(trie.wildCardSearch("be*t*r"));
        System.out.println(trie.wildCardSearch("b*pst"));
        System.out.println(trie.wildCardSearch("b*nan*s"));
        System.out.println(trie.wildCardSearch("******"));
        System.out.println(trie.wildCardSearch("*******"));
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

    }// Main

    }// Trie




