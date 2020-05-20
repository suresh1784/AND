package algorithm.backtracking;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, "hot", "dog","dot",  "lot", "log", "cog");
        List<List<String>> result = findLadders(beginWord, endWord, wordList);
          System.out.println(result);
        System.out.println(isOneLetter("dog", "lot"));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        result.add(wordList);

        recc(beginWord, endWord, wordList, result, new ArrayList<String>(), 0, 0);
        return result;

    }

    static void recc1(String beginWord, String endWord, List<String> wordList, List<List<String>> result, List<String> intermediate, int level, int pos) {
        if (beginWord == endWord) {
            result.add(new ArrayList<>(intermediate));
            return;
        }

        for (int i = 0; i < wordList.size(); i++) {
            String temp = wordList.get(i);
            System.out.println(beginWord +" : " +temp + " : " +isOneLetter(beginWord,temp));
            if (isOneLetter(beginWord, wordList.get(i))) {
                if (!intermediate.contains(wordList.get(i))) {
                    intermediate.add(wordList.get(i));
                    recc1(wordList.get(i), endWord, wordList, result, intermediate, level + 1, i + 1);
                    intermediate.remove(intermediate.size() - 1);
                }
            }
        }


    }


    static void recc(String beginWord, String endWord, List<String> wordList, List<List<String>> result, List<String> intermediate, int level, int pos){
        if (beginWord.equalsIgnoreCase(endWord)){
            result.add(new ArrayList<>(intermediate));
            return;
        }
        char[] word = beginWord.toCharArray();
        for (int i = 0; i < word.length; i++){
            char old = word[i];
            for (char c = 'a' ; c<='z'; c++){
                word[i] = c;
                String newWord = new String(word);
                if (wordList.contains(newWord) && !intermediate.contains(newWord)){
                    intermediate.add(newWord);
                    recc(newWord, endWord, wordList, result, intermediate, level+1, i+1);
                    intermediate.remove(intermediate.size()-1);
                }

            }
         word[i]=old;
        }

    }

    static boolean isOneLetter(String a, String b) {

        char[] ach = a.toCharArray();
        char[] bch = b.toCharArray();

        if (ach.length != bch.length) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < ach.length; i++) {
            if (ach[i] != bch[i]) {
                count = count + 1;
            }
            if (count >= 2) {
                return false;
            }
        }

        if (count == 1) {
            return true;
        }

        return false;
    }
}
