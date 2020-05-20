package patterns.leetcode75.Strings;

public class isPalindrome {
    public static boolean isPalindrome(String s) {
        if (s==null ){
            return false;
        }
        return isPalindrome(s.toLowerCase().toCharArray(), 0, s.length()-1);
    }

    static boolean isPalindrome(char[] ch, int left, int right){
        if (left >=right){
            return true;
        }
        if (!Character.isAlphabetic(ch[left])){
           return isPalindrome(ch, left+1, right);
        }

        if (!Character.isAlphabetic(ch[right])){
            return isPalindrome(ch, left, right-1);
        }

         if (ch[left]!=ch[right]){
             return false;
         }

        return isPalindrome(ch, left+1, right-1);

    }

    public static void main(String[] args){
      String s = "0P";
        System.out.println(isPalindrome(s));
    }
}
