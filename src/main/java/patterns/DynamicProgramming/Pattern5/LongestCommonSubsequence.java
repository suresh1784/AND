package patterns.DynamicProgramming.Pattern5;

import java.io.IOException;

public class LongestCommonSubsequence {


        public int findLCSLength(String s1, String s2) {
            Integer[][] dp = new Integer[s1.length()+1][s2.length()+1];
         //   int result =  findLCSLength(s1, s2, 0, 0, "", dp);
            int result =  findLCSLength(s1, s2, s1.length(), s2.length(),  dp);
            return result;
        }

//        public static int findLCSLength1(String s1, String s2, int i , int j, String result, Integer[][] dp ){
//            if (s1.length()==i || s2.length()== j){
//                return 0;
//            }
//
//            if (dp[i][j]==null) {
//
//                if (s1.charAt(i) == s2.charAt(j)) {
//                    return 1 + findLCSLength(s1, s2, i + 1, j + 1, result + s1.charAt(i), dp);
//                }
//
//                int c1 = findLCSLength(s1, s2, i, j + 1, result, dp);
//                String st1 = result;
//                int c2 = findLCSLength(s1, s2, i + 1, j, result, dp);
//                String st2 = result;
//
//                int max = Math.max(c1, c2);
//                dp[i][j]=max;
//            }
//            return  dp[i][j];
//        }


    public static int findLCSLength(String s1, String s2, int m , int n, Integer[][] dp ){
        if (m==0 || n== 0){
            dp[m][n]=0;
            return 0;
        }

        if (dp[m][n]==null) {

            if (s1.charAt(m-1) == s2.charAt(n-1)) {
                return 1 + findLCSLength(s1, s2, m-1, n-1, dp);
            }

            int c1 = findLCSLength(s1, s2, m, n-1,  dp);
            int c2 = findLCSLength(s1, s2, m-1, n,  dp);

            int max = Math.max(c1, c2);
            dp[m][n]=max;
        }
        return  dp[m][n];
    }

//    public static void main(String[] args) throws IOException {
//        String line = "XMJYAUZ;MZJAWXU";
//        System.out.println(longestCommonSequence(line));
//
//    }

    public static String longestCommonSequence(String input){
        String[] str = input.split(";");
        String s1 = str[0];
        String s2 = str[1];

        if (s1== null || s2== null){
            return "";
        }
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        String result = "";
        int maxLength = 0 ;
        for (int i = 1; i<=s1.length(); i++){
            for (int j = 1; j <= s2.length(); j++){
                if (s1.charAt(i-1)== s2.charAt(j-1)){
                    dp[i][j]= 1+dp[i-1][j-1];
                }else {
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        System.out.println(maxLength);
        // reconstruct
        return reconstruct(s1.length(), s2.length(), s1.toCharArray(), s2.toCharArray(), dp);

    }//longestCommonSequence

    public static String reconstruct(int i, int j , char[] a , char[] b, int[][] dp){
        if (i==0 || j ==0){
            return "";
        }
        else if (a[i-1]==b[j-1]){
            return reconstruct(i-1, j-1, a, b, dp)+a[i-1];
        }else if (dp[i][j]== dp[i-1][j]){
            return reconstruct(i-1, j , a, b, dp);
        } else {
            return reconstruct(i, j-1 , a, b, dp);
        }
    }



    public static void main(String[] args) {
            LongestCommonSubsequence lcs = new LongestCommonSubsequence();
            System.out.println(lcs.findLCSLength("abdca", "cbda"));
            System.out.println(lcs.findLCSLength("passport", "ppsspt"));
        }

}
