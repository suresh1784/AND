package algorithm.leetcode;

import java.util.*;

public class _5280 {

    public static void main(String[] args){
        int[] i1 = {3,3,3,3,3,1,3};
        int[] i2 = {2,1,3,3,3,2};
        System.out.println(groupThePeople(i1));
    }


    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        List<List<Integer>> results = new ArrayList<>();


        for (int i = 0 ; i < groupSizes.length ; i++){
            int groupSize = groupSizes[i];
            List<Integer> list = new ArrayList<>();
            if (groupMap.containsKey(groupSize)){
             list = groupMap.get(groupSize);
            }
            list.add(i);
            groupMap.put(groupSize, list);
        }

        for (Map.Entry<Integer, List<Integer>> entrySet : groupMap.entrySet()){
            if (entrySet.getValue().size() == entrySet.getKey()){
                results.add(new ArrayList<>(entrySet.getValue()));
            }else {
                List<Integer> lists = entrySet.getValue();
                List<Integer> result = new ArrayList<>();
                int count = 0 ;
                for (int list : lists){
                    count++;
                    result.add(list);
                    if (count == entrySet.getKey()){
                        results.add(new ArrayList<>(result));
                        result = new ArrayList<>();
                        count = 0 ;
                    }
                }
            }
        }

        return results;
    } //
}
