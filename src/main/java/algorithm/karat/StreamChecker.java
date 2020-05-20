package algorithm.karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StreamChecker {

    TrieNode root;
    StringBuilder sb ;
    String str ;
    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        str = "";
        for (String word : words){
            TrieNode curr = root;
            int len = word.length()-1;
            for (int i = len ; i >= 0 ; i--){
                char ch = word.charAt(i);
                if (curr.childeren.get(ch)==null){
                    curr.childeren.put(ch, new TrieNode());
                }
                curr = curr.childeren.get(ch);
            }
            curr.startOfWord = true;
        }
    }

    public boolean search(String str){
        TrieNode curr = root;
        int len = str.length()-1;
        for (int i = len ; i>=0; i--){
        //for (char ch : str.toCharArray()){
            char ch = str.charAt(i);
            TrieNode node = curr.childeren.get(ch);

            if (node == null ){
                return false;
            }
            if (node.startOfWord){
                return true;
            }
            curr = node;
        }
        return false;
    }


    public boolean query(char letter) {
        if (sb.length() > 2000){
            sb.deleteCharAt(0);
        }
        sb.append(letter);

      //  str += letter;
       // System.out.println(sb.toString());
        boolean result = search(sb.toString());
      //  System.out.println(result);
        return result;
    }


    public static class TrieNode {
        boolean startOfWord;
        Map<Character, TrieNode> childeren;

        public TrieNode() {
            this.startOfWord = false;
            this.childeren = new HashMap<>();
        }
    }


    public static void main(String args[]) {
        String[] words = new String[3];
        words[0] = "cd";
        words[1] = "f";
        words[2] = "kl";
        StreamChecker streamChecker = new StreamChecker(words); // init the dictionary.
       streamChecker.query('a');          // return false
        streamChecker.query('b');          // return false
        streamChecker.query('c');          // return false
        streamChecker.query('d');          // return true, because 'cd' is in the wordlist
        streamChecker.query('e');          // return false
        streamChecker.query('f');          // return true, because 'f' is in the wordlist
        streamChecker.query('g');          // return false
        streamChecker.query('h');          // return false
        streamChecker.query('i');          // return false
        streamChecker.query('j');          // return false
        streamChecker.query('k');          // return false
        streamChecker.query('l');          // return true, because 'kl' is in the wordlist

    }

}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */