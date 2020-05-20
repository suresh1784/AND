package algorithm.sf;
import java.util.*;

public class LadderLength {
    static class Word{
        String word;
        Integer length;
        public Word(String word, Integer length){
            this.word = word;
            this.length = length;
        }

    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(beginWord, 1));
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }

        if (!set.contains(endWord)){
            return 0;
        }
        while (!q.isEmpty()){
            Word top = q.poll();
            String word = top.word;
            Integer length = top.length;
            if(word.equals(endWord)){
                return length;
            }

            char[] wordCh = word.toCharArray();
            for (int i = 0 ; i < word.length(); i++){
                char old = wordCh[i];
                for (char ch = 'a' ;  ch <= 'z' ; ch++){

                    wordCh[i] = ch;
                    String curr = new String(wordCh);
                    if (set.contains(curr)){
                        set.remove(curr);
                        q.offer(new Word(curr, length+1));
                    }

                }
                wordCh[i] = old;
            }


        }

        return 0;
    }



    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        String[] arr =  {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(arr);
        System.out.println(ladderLength(beginWord, endWord, wordList));

        String[] arr1 = {"hot","dot","dog","lot","log"};
        List<String> wordList1 = Arrays.asList(arr1);
        System.out.println(ladderLength(beginWord, endWord, wordList1));

    }
}
