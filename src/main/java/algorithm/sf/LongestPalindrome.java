package algorithm.sf;

import java.util.*;
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null){
            return null;
        }

        if (s.equals("")){
            return "";
        }

        System.out.println("length "+findLPSLengthRecursive(s, 0 , s.length()-1));

        return null;

    }


    private static int findLPSLengthRecursive(String st, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        // every string with one character is a palindrome
        if (startIndex == endIndex) {
            System.out.println(startIndex);
            return 1;
        }

        // case 1: elements at the beginning and the end are the same
        if (st.charAt(startIndex) == st.charAt(endIndex)) {
            int remainingLength = endIndex - startIndex - 1;

            // check if the remaining string is also a palindrome
            if (remainingLength == findLPSLengthRecursive(st, startIndex + 1, endIndex - 1))
                return remainingLength + 2;
        }

        // case 2: skip one character either from the beginning or the end
        int c1 = findLPSLengthRecursive(st, startIndex + 1, endIndex);
        int c2 = findLPSLengthRecursive(st, startIndex, endIndex - 1);
        return Math.max(c1, c2);
    }


    public static void main(String[] arg){
        String input1 = "babad";
        System.out.println(input1 + " " +longestPalindrome(input1));
        String input2 = "cbbd";
        System.out.println(input2 + " " +longestPalindrome(input2));
    }
}
