package patterns.DynamicProgramming.leetcode;

public class MinPalindromeInsertions {
    public static int minInsertions(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return minInsertionsRecursive(s.toCharArray(), 0 , s.length()-1, dp);

    }


    public static int minInsertionsRecursive(char[] ch , int i, int j, Integer[][] dp){
        if (i >= j){
            return 0;
        }

        if (dp[i][j]!= null){
            return dp[i][j];
        }

        if (ch[i]== ch[j]){
            dp[i][j]= minInsertionsRecursive(ch, i+1, j-1, dp);
            return dp[i][j];
        }

        int c2 = minInsertionsRecursive(ch, i+1, j, dp)+1;
        int c3 = minInsertionsRecursive(ch , i, j-1, dp)+1;
        dp[i][j] = Math.min(c2, c3);
        return dp[i][j];
    }

// Have to work on this ????
    public static int minInsertionsv1(String st) {
        if (st.length()==0){
            return 0;
        }
        int[][] dp = new int[st.length()][st.length()];

        // every sequence with one element is a palindrome of length 1
        for (int i = 0; i < st.length(); i++)
            dp[i][i] = 0;

        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                // case 1: elements at the beginning and the end are the same
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    dp[startIndex][endIndex] = dp[startIndex + 1][endIndex - 1];
                } else { // case 2: skip one element either from the beginning or the end
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1])+1;
                }
            }
        }
        return dp[0][st.length() - 1];
    }

    public static void main(String[] args){
        String[] s1 = {"zzazz","mbadm", "leetcode", "g", "no", ""};
        for (String s : s1){
            System.out.println(s + " Output " + minInsertions(s));
        }
    }
}
