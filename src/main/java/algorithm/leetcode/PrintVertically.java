package algorithm.leetcode;

import java.util.*;

public class PrintVertically {
    public static List<String> printVertically(String s) {
        List<String> result = new ArrayList<>();
        String[] sArray = s.split(" ");
        // find the longest word length
        // max , index;
        Map<Integer, Integer> index = new HashMap<>();
        int length = 0 ;
        for (int i = 0 ; i < sArray.length ; i++){
            String sWord = sArray[i];
            int currLength = sWord.length();
            index.put(currLength, i);
            length = Math.max(length, currLength);
        }

//        for (int i = 0 ; i < length ; i++){
//            result.add("");
//        }

        for (int i = 0 ; i < length ; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0 ; j < sArray.length ; j++){
//                if (index.get(i) != null && index.get(i)==j+1){
//                    break;
//                }
                if (i < sArray[j].length()) {
                    sb.append(sArray[j].charAt(i));
                }else {
                    sb.append(" ");
                }
            }

            while (sb.charAt(sb.length()-1)==' '){
                sb.deleteCharAt(sb.length()-1);
            }
            result.add(sb.toString());
        }
        return result;
    }


    //"TBONTB"
    //"OEROOE"
    //"   T"
    public static void main(String[] args) {
    String  s = "TO BE OR NOT TO BE";
    String s1 = "HOW ARE YOU";
    String s2 = "CONTEST IS COMING";
    //["CIC","OSO","N M","T I","E N","S G","T"]
        System.out.println(printVertically(s2));
    }
}
