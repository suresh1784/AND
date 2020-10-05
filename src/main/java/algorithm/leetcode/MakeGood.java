package algorithm.leetcode;
import java.lang.Math;
public class MakeGood {
    public String makeGood(String s) {
        return helper(s);
    }

    private String helper(String s){

        if (s.length()==0){
            return "";
        }


        for (int i = 1 ; i < s.length() ; i++){
            if (isSameDiffCase(s.charAt(i-1), s.charAt(i))){
                String newString = s.substring(0, i-1)+s.substring(i+1);
                return helper(newString);
            }
        }
        return s;
    }

    private static boolean isSameDiffCase(char ch1, char ch2){
        int diff = Math.abs((int) ch1 - (int) ch2);
        if (diff == 32){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] array = {"leEeetcode",  "abBAcC" ,"s"};

        MakeGood mk = new MakeGood();

     //   System.out.println(isSameDiffCase('A', 'a'));
        for (String s: array) {
            System.out.println(mk.makeGood(s));
        }
    }
}
