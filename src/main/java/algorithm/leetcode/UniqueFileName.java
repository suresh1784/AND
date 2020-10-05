package algorithm.leetcode;

import java.util.*;
public class UniqueFileName {
    public String[] getFolderNames(String[] names) {
       // Arrays.sort(names);
        String[] result = new String[names.length];
        int i = 0 ;
        Trie trie = new Trie();
        for (String name : names){
            result[i] = trie.put(name);
            i++;
        }
        return result;
    }

    private int getNextNum(HashSet<Integer> set, int num){
        while (set.contains(num)){
            num++;
        }
        return num;
    }


    public class Trie {
        class TrieNode{
            Boolean endOfWord;
            int num;
            Set<Integer> set;
            Map<Character,TrieNode> children;

            public TrieNode(){
                this.endOfWord = false;
                num = 1;
                set = new HashSet<>();
                this.children = new HashMap<>();
            }

        }// TrieNode

        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public String put(String str){
            TrieNode curr = root;
           return putRecursive(str, str.toCharArray(), 0 , curr);
        }

        public String putRecursive(String str, char[] chars, int level, TrieNode curr){
            if (level == chars.length){
                if (curr.endOfWord){

                }
                curr.endOfWord = true;
                if (level > 0 && chars[level-1]==')'){
                    int st = str.lastIndexOf('(');
                    String num = str.substring(st+1,level-1 );
                 

                }
                return str;
            }

            char ch = chars[level];
            TrieNode node = curr.children.get(ch);
            if (node == null){
                curr.children.put(ch, new TrieNode() );
            }
            node = curr.children.get(ch);
           return  putRecursive(str, chars, level+1, node);
        }
    }
}
