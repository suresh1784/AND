package patterns.DynamicProgramming.Pattern5;

public class LongestPalindromicSubsequence {

    public int findLPSLength(String st) {
        return findLPSLengthRecursive(st, 0, st.length()-1);
    }

    static int findLPSLengthRecursive(String s, int start, int end){
        if (start >= end ){
            if (start == end && s.charAt(start)== s.charAt(end)){
                return 1;
            }
            return 0;
        }

        if (s.charAt(start)== s.charAt(end)){
            return 2+findLPSLengthRecursive(s, start+1, end-1);
        }

        int c1 = findLPSLengthRecursive(s, start+1, end);
        int c2 = findLPSLengthRecursive(s, start, end-1);
        return Math.max(c1, c2);
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}
