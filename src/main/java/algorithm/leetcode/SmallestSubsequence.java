package algorithm.leetcode;

import java.util.*;

public class SmallestSubsequence {
    public static String smallestSubsequence(String text) {
        String retResult = "";
        String result = "";
        int length = 0;
        // form the map

        Map<Character, List<Integer>> map = new HashMap<>();
        char[] charText = text.toCharArray();
        for (int i = 0 ; i < charText.length; i++){
            char in = charText[i];
            if (map.containsKey(in)){
                map.get(in).add(i);
            }else {
                result = result+charText[i];
                length = i-0;
                List temp = new LinkedList();
                temp.add(i);
                map.put(in, temp);
            }
        }

        retResult = result;
        int end = 0 ;
        while(map.size()> 0){
          char firstChar  =  result.charAt(0);
          if (map.get(firstChar)!= null){
              map.get(firstChar).remove(0);
              if (map.get(firstChar).size()==0){
                  map.remove(firstChar);
                  break;
              }else {
                  end = Math.max(end, map.get(firstChar).get(0));
                  result = result.substring(1, result.length()) + firstChar;
                  int start = map.get(result.charAt(0)).get(0);
                  int newLength = end-start;
                  if (newLength < length){
                      retResult = result;
                  }
              }
          }else {
              break;
          }
        }

        return retResult;
    }

    public static void main(String[] args){
        String input1 = "cdadabcc"; //"adbc"
        String input2 = "abcd" ; //"abcd"
        String input3 = "ecbacba" ;// "eacb"
        String input4  = "leetcode"; // "letcod"


        String result = smallestSubsequence(input1);
        System.out.println(result);
    }
}
