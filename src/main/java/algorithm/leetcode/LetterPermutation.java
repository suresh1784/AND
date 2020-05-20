package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterPermutation {
//    public int numTilePossibilities(String tiles) {
//
//    }


    public static void dfs(char[] input , int level , List<Character> list , List<List<Character>> result){
        if (level >= input.length){
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(input[level]);
        dfs(input, level+1, list, result);
        list.remove(list.size()-1);
        dfs(input, level+1, list, result);

    }

    public static void main(String args[]){
        String input = "AAB";
        String input2 = "AAABBC";

        List<Character> list = new ArrayList<>();
        List<List<Character>> result = new ArrayList<>();
        dfs (input.toCharArray(), 0 , list, result);
        System.out.println(result);
    }
}
