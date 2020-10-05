package algorithm.leetcode;

import java.util.HashMap;
import java.util.*;

public class IsTransformable {
    public boolean isTransformable(String s, String t) {
        Map<Integer, Integer> degree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Queue<Integer>> indexList = new ArrayList<>();
        List<Integer> indexCount = new ArrayList<>();

        for (int i = 0 ; i <= 9 ; i++){
            Queue q = new LinkedList<>();
            indexList.add(q);
            indexCount.add(0);
        }

        if (s.length() != t.length()){
            return false;
        }

        char[] sChar = s.toCharArray();
        char[] tChat = t.toCharArray();
        int length = s.length();

        for (int i = 0 ; i < length ; i++ ){
            char ch = sChar[i];
            int val = Character.getNumericValue(ch);
            indexCount.set(val, indexCount.get(val)+1);
            indexList.get(val).offer(i);

            if (degree.get(i)== null){
                degree.put(i , 0);
            }
            degree.put(i , getPrevCount(val, indexCount));

           if( graph.get(i)==null){
               graph.put(i , new ArrayList<>());
           }

         //  graph.get(i).add()
        }




        return true;
    }


    private int getPrevCount (int val,List<Integer> indexCount ){
        int count = 0 ;
        for (int i = 0 ; i < val ; i++){
         count+=indexCount.get(i);
        }
        return count;
    }
}
