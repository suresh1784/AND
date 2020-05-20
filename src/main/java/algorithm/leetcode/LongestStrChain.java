package algorithm.leetcode;

import java.sql.SQLOutput;
import java.util.Arrays;

public class LongestStrChain {

    public static int longestStrChain(String[] words) {
        Integer[][] dp = new Integer[words.length][words.length+1];
        Arrays.sort(words,(a,b)-> {return a.length() - b.length();});
    return longestStrChainRecursive( words, -1 , 0, dp);
    }

    public static int longestStrChainRecursive(String[] words, int prevIndex , int currIndex, Integer[][] dp){
        if (currIndex == words.length){
            return 0;
        }

        if (dp[currIndex][prevIndex+1]==null) {
            int with = 0;
            String word1 = null;

             if (prevIndex>=0){
                 word1 =  words[prevIndex];
             }
            String word2 = words[currIndex];
            boolean isOneEdit = isOneEdit(word1,word2 );
       //     System.out.println("word1 "+word1 +" word2 "+word2 + " isOneEdit "+ isOneEdit);
            if (prevIndex== -1 || isOneEdit) {
                with = 1 + longestStrChainRecursive(words, currIndex, currIndex + 1, dp);
            }

            int without = longestStrChainRecursive(words, prevIndex, currIndex + 1, dp);
            dp[currIndex][prevIndex+1] = Math.max(with, without);
        }
        return dp[currIndex][prevIndex+1];
    } //


    static boolean isOneEdit(String word1, String word2){

        if (word1==null){
            return false;
        }
        if (word1.length()+1==word2.length()){
            int i = 0 ;
            int j = 0 ;
            int count = 0 ;
            while (j < word2.length() ){
                if (j==word2.length()-1){
                    if (count==0){
                        return true;
                    }
                }
                if (word1.charAt(i)== word2.charAt(j)){
                    i++;
                    j++;
                }else {
                    j++;
                    count++;
                    if (count >1){
                        return false;
                    }
                }
            }
            if (count==1){
                return true;
            }

        }else {
            return false;
        }
        return false;
    }

    private static boolean isW1PredW2(String w1, String w2){
        if (w1==null || w2 ==null){
            return false;
        }
        if (w2.length() - w1.length() != 1){
            return false;
        }
        int i = 0, j = 0;
        while (i < w1.length() && j < w2.length()){
            if (w1.charAt(i) != w2.charAt(j)){
                if (i != j){
                    return false;
                }
                j++;
            } else {
                j++;
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String[] input= {"a","b","ba","bca","bda","bdca"};
        String[] input1 = {"rigih","iid","idisd","rigihta","hfmeqzxki","idid","idisajd","rifgihta","hfmeqzki","rigi","idisjd","hfsmeqzxki","idisaojd","rigiht"};
       String[] input2 = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        int result = longestStrChain(input2);
      System.out.println(result);
   //     System.out.println( isOneEdit("rigih", "rigiht"));
    }
}
