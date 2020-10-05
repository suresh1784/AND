package algorithm.leetcode;

public class _796 {

    public static void main (String[] args){
        String A = "abcde";
        String B = "abced";
        System.out.println("IsRotate : "+ rotateString(A, B));
    }
    public static boolean rotateString(String A, String B) {
        if (A.length() == B.length()){
            return recRotString(A.toCharArray(), B.toCharArray(), 0, 0, 0, 0);
        }
        else {
            return false;
        }
    }


    public static boolean recRotString(char[] s, char[] t, int pos1, int pos2, int l, int m){

        if (pos1 >= s.length){
            pos1 = pos1-s.length;
        }

        if (pos2 >= t.length){
            pos2 = pos2-t.length;
        }

        if (s[pos1] == t[pos2] && l+1 == s.length){

            return true;
        } else if (s[pos1] != t[pos2] && l+1 == s.length){
            return false;
        }
        else {
            if (s[pos1] == t[pos2]) {

                return true && recRotString(s, t, pos1 + 1, pos2 + 1, l+1, 0); //
            } else {


                return false || recRotString(s, t, pos1 + 1, 0, 0, m+1);
            }
        }



    }
}
