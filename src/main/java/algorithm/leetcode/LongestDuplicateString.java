package algorithm.leetcode;

public class LongestDuplicateString {
    static String result = "";
    public static String longestDupSubstring(String S) {
        helper(S.toCharArray(), 0 , 0 , "");
        //    System.out.println(result );
        return result;
    }

    public static void  helper(char[] s , int i1 , int i2,  String temp){

        if (i1== s.length || i2 == s.length){
            if (temp.length() > result.length()){
                result = temp;
                //  System.out.println("temp "+ temp);
            }

            return ;
        }


        if (i1!= i2 && s[i1] == s[i2]){

            helper(s, i1+1, i2+1, temp+s[i1]);
        }

        helper(s, i1+1, i2,  temp);
        helper (s, i1, i2+1,  temp);

    }

    public static void main (String[] args){

        String s = "abananaabananaa";
        System.out.println(longestDupSubstring(s));
    }

}
