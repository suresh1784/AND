package algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    public static void main(String[] args) {
        String input = "0204451881";
        palindromePartitioning(input);
    }

    static List<List<String>> palindromePartition(String input) {
        List<List<String>> result = new ArrayList<>();
        recc(input, 0, new ArrayList<>(), result);
        System.out.println(result);
        return result;
    }

    static void recc(String input, int offset, List<String> list, List<List<String>> result) {
        if (offset == input.length()) {
            result.add(new ArrayList<>(list));
            return;
        }


        for (int i = offset + 1; i <= input.length() - 1; i++) {
            String prefix = input.substring(offset, i);
            if (isPalindrome(prefix, 0, prefix.length() - 1)) {
                list.add(prefix);
                recc(input, i, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str, int i, int j) {
        if (i >= j) {
            return true;
        }
        return (str.charAt(i) == str.charAt(j) && isPalindrome(str, i + 1, j - 1));
    }

    public static List<List<String>> palindromePartitioning(String input) {
        List<List<String>> result = new ArrayList<>();
        directedPalindromePartitioning(input, 0, new ArrayList<String>(), result);
        System.out.println(result);
        return result;
    }

    private static void directedPalindromePartitioning(
            String input, int offset, List<String> partialPartition, List<List<String>> result) {
        if (offset == input.length()) {
            result.add(new ArrayList<>(partialPartition));
            return;
        }
        for (int i = offset + 1; i <= input.length(); ++i) {
            String prefix = input.substring(offset, i);
            if (isPalindrome(prefix)) {
                partialPartition.add(prefix);
                directedPalindromePartitioning(input, i, partialPartition, result);
                partialPartition.remove(partialPartition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String prefix) {
        for (int i = 0, j = prefix.length() - 1; i < j; ++i, --j) {
            if (prefix.charAt(i) != prefix.charAt(j)) {
                return false;
            }
        }
        return true;


    }


}