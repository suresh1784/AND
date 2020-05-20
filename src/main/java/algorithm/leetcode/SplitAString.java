package algorithm.leetcode;

public class SplitAString {
    public int maxScore(String s) {
        int ones = 0 ;
        int zeros = 0 ;


        for (char ch : s.toCharArray()){
            if (ch=='1'){
                ones++;
            }else {
                zeros++;
            }
        }
        int maxTotal =0;
        int currTotal = 0 ;
        int currZeros = 0 ;
        for (int i = 0 ; i < s.length()-1; i++){
          if (s.charAt(i)=='1'){
              ones--;
          }else {
              currZeros++;
          }
          currTotal = currZeros+ones;
          if (currTotal> maxTotal){
             maxTotal = currTotal;
          }

        }

        return maxTotal;
    }
}
