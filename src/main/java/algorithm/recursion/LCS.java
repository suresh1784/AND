package algorithm.recursion;


/**
 * Longest Common Subsequence
 */

public class LCS {

    private static String s1 = null;
    private static String s2 = null;
    private static Integer m = 0;
    private static Integer n = 0;

    public static void main(String[] args) {
        s1 = "abcd";//args[0];
        s2 = "adcd";//args[1];
        if (s1 != null && s2 != null) {
            char[] s = s1.toCharArray();
            char[] t = s2.toCharArray();
            m = s.length;
            n = t.length;

            int result = lcs(s, t, 0, 0);
            System.out.println("result " + result);
        } //end if

    } // end main


    public static int lcs(char[] s, char[] t, int i, int j) {

        if (i == m || j == n) {
            return 0;

        }//if

        if (s[i] == t[j]) {
            System.out.println("s[" + i + "] : " + s[i] + " t[" + j + "] : " + t[j]);
            i++;
            j++;
            return (lcs(s, t, i, j)) + 1;

        }// -- if

        else {
            System.out.println(" >> s[" + i + "] : " + s[i] + " t[" + j + "] : " + t[j]);

            return Math.max(lcs(s, t, i + 1, j), lcs(s, t, i, j + 1));
        } //else

    }// end lcs


} //end LCS