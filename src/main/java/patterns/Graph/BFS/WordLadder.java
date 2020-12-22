package patterns.Graph.BFS;

import java.util.*;

public class WordLadder {

    public static class Word{
        int length;
        String str;
        public Word(String str, int length){
            this.length = length;
            this.str = str;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(beginWord, 1));
        Set<String> set = new HashSet<>();
        set.addAll(wordList);
        while (!q.isEmpty()){
            Word top = q.poll();
            String s = top.str;
             // if
            if (s.equals(endWord)){
                return top.length;
            }

            for (int i = 0 ; i <top.str.length(); i++) {
                for (char ch = 'a'; ch < 'z'; ch++) {
                   // char newCh = (char) (ch+'a');
                    char newCh = ch;
                    String newWord = s.substring(0, i)+newCh+ s.substring(i+1);

                    if (set.remove(newWord)) {

                        q.offer(new Word(newWord, top.length + 1));
                    }
                }
            }
        } // while
        return 0;
    }

    public static void main(String[] args){
        Set<String> dict = new HashSet<>();
        String[] dictArray = {"hot","dot","dog","lot","log","cog"};
        dict.addAll(Arrays.asList(dictArray));
        List<String> wordList = Arrays.asList(dictArray);
        String beginWord = "hit";
        String endWOrd = "cog";
        int result = ladderLength(beginWord, endWOrd, wordList);
        System.out.println("Result "+result);
    }
}
