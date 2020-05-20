package patterns.leetcode75.Strings;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s==null || s.length() ==0){
            return "";
        }
        int left = 0 , right = 0 , max = 0 ;
        for (int i = 0 ; i < s.length() ; i++){
            int[] r1 = getPalindrome(s.toCharArray(), i, i);
            int[] r2 = new int[2];
            if (i+1<s.length()) {
                r2 =  getPalindrome(s.toCharArray(), i, i + 1);
            }
            int currMax1 = r1[1]-r1[0];
            int currMax2 = r2[1]-r2[0];
            if (Math.max(currMax1,currMax2) > max){
                if (currMax1 > currMax2){
                    left = r1[0];
                    right = r1[1];
                    max = currMax1;
                }else {
                    left = r2[0];
                    right = r2[1];
                    max = currMax2;
                }
            }
        }
        return s.substring(left, right+1);
    }


    static int[] getPalindrome(char[] ch , int left , int right){
        int[] result = new int[2];
            while (left >=0 && right < ch.length && ch[left] == ch[right]) {
                result[0]= left;
                result[1]=right;
                left--;
                right ++;


            }
        return result;
        }



    public static void main(String[] args){
        String s = "";
        System.out.println(longestPalindrome(s));
    }
}
