package algorithm.recursion;

public class PalindromeSubstring {
    public static void main(String[] args){
        String value = "abecdcef";
        char[] strChar = value.toCharArray();
     //   System.out.println(isPalindrome("abddba", 0, 5));
        System.out.println( longestPalindrome(value, 0, strChar.length));
    }

    public static String longestPalindrome(String str, int i, int j){
        if (i>j){
            return "";
        }

        String temp1 = str.substring(i,j);
        System.out.println(temp1);
        if (i>=str.length() || j <=0 ){
            return "";
        }
        if ( temp1.length() >1 && (temp1.charAt(0) == temp1.charAt(temp1.length()-1))  && isPalindrome(temp1,0,temp1.length()-1)){
            System.out.println("isPalindrome" +temp1);
            return str.substring(i,j);
        }

        String a1 = longestPalindrome(str, i+1, j);
        System.out.println("a1 : "+ a1);
        String a2 = longestPalindrome(str, i, j-1);
        System.out.println("a2 : "+a2);
        if (a1.length() > a2.length()){
            return a1;
        }else{
            return a2;
        }
    }


    public static  boolean isPalindrome(String str,int i , int j){
        if (i>=j){
            return true;
        }
        return (str.charAt(i)== str.charAt(j) && isPalindrome(str, i+1, j-1));
    }



}
