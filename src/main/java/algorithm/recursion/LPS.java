package algorithm.recursion;

public class LPS{
    public static void main(String[] args) {
        String s = "abmlqmba";//args[0];
        if (s != null){
            char[] ch = s.toCharArray();
            int m = ch.length;

            int result = LPS(ch, 0 , m-1);
            System.out.println("result "+result);

        } //if
    } // main


    public static int LPS(char[] s , int i , int j ){
        if (i==j || i > j ){
            return 0;
        }// if

        if (s[i] == s[j]){
            return LPS(s , i+1, j-1) +2;
        } // if

        else {
            return Math.max (LPS(s, i+1, j), LPS(s, i, j-1));

        } //else

    } // LPS


}// class