package patterns.DynamicProgramming.Pattern5;

import java.util.Arrays;

public class LongestPalindromicSubstring {


    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }

    public int findLPSLength(String st) {
       return findLPSLength(st, 0 , st.length()-1);
    }

    public static int findLPSLength(String s1,int start , int end ){
        if (start > end ){
            return 0;
        }
      if (s1.charAt(start)== s1.charAt(end)){
          if (findLPSLength(s1, start+1, end-1)== end-start-1){
               return end-start-1+2;
          }
      }

       int c1 =  findLPSLength(s1, start+1, end);
        int c2 =  findLPSLength(s1, start, end-1);
        return Math.max(1,Math.max(c1,c2));
    }

    public static String longestPalindrome(String s) {
        String result = "";
        int[][] dp = new int[s.length()][s.length()] ;
        Arrays.fill(dp,0);

        for (int i = 0 ; i < s.length(); i++){
            for (int j = i; j<s.length(); j++){
                if (i==j){
                    dp[i][j]=1;
                    continue;
                }

            }
        }
        return result;
    }
}
