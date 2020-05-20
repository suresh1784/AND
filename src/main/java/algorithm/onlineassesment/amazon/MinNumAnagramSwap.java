package algorithm.onlineassesment.amazon;

import java.util.*;
import java.util.LinkedList;

public class MinNumAnagramSwap {
    public int minSwap(String s1, String s2){
        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        int index = 0 ;
        for (Character ch : s2.toCharArray()){
            if (s1.charAt(index)!= ch){
                if (map.get(ch)==null){
                    map.put(ch , new LinkedList<Integer>());
                }
                map.get(ch).addLast(index);
            } // if
            index++;
        }

        int result =  minSwap(s1.toCharArray(), s2.toCharArray(), 0 , 0 , map);
        System.out.println(result);
        return result;
    } // minSwap

    public int minSwap(char[] s1, char[] s2, int i , int j, Map<Character, LinkedList<Integer>> map){
        if (i >= s1.length){
            return 0;
        }

        if (map.size()==0){
            return 0;
        }

        if (s1[i]==s2[j]){
            return minSwap(s1, s2, i+1, j+1, map);
        }

        int c1 = 0 ;
        // i // j
        int min = Integer.MAX_VALUE;
        int idx = 0 ;
        while ( map.get(s1[i]) != null && map.get(s1[i]).size()!= 0 ){
             int currIndex = map.get(s1[i]).removeFirst(); // e
             map.get(s2[j]).removeFirst(); // a
            if (map.get(s2[j]).size()==0){
                map.remove(s2[j]);
            }
            if (map.get(s1[i]).size()==0){
                map.remove(s1[i]);
            }

             if (s2[j]!=s1[currIndex]){
                 map.get(s2[j]).addLast(currIndex);
             }
            char temp = s2[j];
            s2[j]= s2[currIndex];
            s2[currIndex] = temp;
             idx++;
             c1 = minSwap(s1, s2, i+1, j+1, map);
             min = Math.min(c1, min)+1;
        }
       // int c2 = minSwap(s1, s2, i+1 , j+1 , map);
        return min;
    }


}
