package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountVowelStrings {
    public  int count = 0 ;
    public int countVowelStrings(int n) {
        char[] ch = {'a','e','i','o','u'};

        List<String> result = new ArrayList<>();
       count = 0 ;
         helper(n,0, ch, result, "", 0);
       // System.out.println(result);
       // System.out.println(count);
         return count;
    }

    private void helper(int n , int index, char[] chars, List<String> result, String str, int strCount){
      if (strCount== n){
        //  result.add(str);
          count++;
          return;
      }



      for (int i = index; i<chars.length; i++){
          helper(n,i, chars, result, str+chars[i], strCount+1);
      }

    }

    public static void main(String[] args) {
        int n = 1;
        CountVowelStrings countVowelStrings = new CountVowelStrings();
        System.out.println(countVowelStrings.countVowelStrings(n));
    }
}
