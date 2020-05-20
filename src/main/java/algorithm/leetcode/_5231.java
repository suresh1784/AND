
package algorithm.leetcode;

import java.util.*;


public class _5231 {
    public static void main(String[] args){
        String[] folder1 = {"/a","/a/b","/c/d","/c/d/e","/c/f"}; // ["/a","/c/d","/c/f"]
        String[] folder2 = {"/a","/a/b/c","/a/b/d"}; // ["/a"]
        String[] folder3 = {"/a/b/c","/a/b/ca","/a/b/d"}; // ["/a/b/c","/a/b/ca","/a/b/d"]
        System.out.println(removeSubfolders(folder2));
    }



    public static List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String f : folder){
            trie.put(f);
        }

        result = trie.getAllSubFolder();

        return result;
    } // removeSubfolders

    public static class Trie {
        static class TrieNode {
            boolean isEndOfFolder;
            String path;
            Map<String, TrieNode> childrens;

            private TrieNode() {
                this.isEndOfFolder = false;
                this.path = null;
                this.childrens = new HashMap<>();
            }
        }// TrieNode

        private TrieNode root;

        private Trie(){
            this.root = new TrieNode();
        }

        public void put(String str){
            TrieNode curr = root;
            if (!str.isEmpty() ) {
                String[] s = str.split("/");
                put(curr, s, 1, "");
            }
        }

        private static void put(TrieNode curr, String[] s , int level, String str){
            if (level == s.length){
                curr.path = str;
                curr.isEndOfFolder = true;
                return;
            }
            String key = s[level];
            TrieNode node = curr.childrens.get(key);
            if (node == null){
                curr.childrens.put(key, new TrieNode());
                node = curr.childrens.get(key);
            }

            put(node , s, level+1, str+"/"+key);

        }

        public List<String> getAllSubFolder(){
            TrieNode curr = root;
            List<String> result = new ArrayList<>();
            search(curr, result, 0);
            return result;
        }

        public static void search(TrieNode curr, List<String> result, int level){
            if (curr == null){
                return;
            }

            if (curr.isEndOfFolder){
                result.add(curr.path);
                return;
            }

            for (Map.Entry<String, TrieNode> entry : curr.childrens.entrySet()){
                String tstr = entry.getKey();
                search(entry.getValue(), result, level+1);
            }

        }

    } // Trie
}
