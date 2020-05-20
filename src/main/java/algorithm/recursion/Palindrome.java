package algorithm.recursion;

public class Palindrome {
    public static void main(String[] args){
        System.out.printf(isPalindrome("abecba").toString());
    }

    static Boolean isPalindrome(String s){
        if (s.length() ==0  || s.length() == 1){
           return true;
        }
        return ((s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1,s.length()-1))));
    }

}
