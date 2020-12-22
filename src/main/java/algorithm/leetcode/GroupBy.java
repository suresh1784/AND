package algorithm.leetcode;
import java.util.*;
public class GroupBy {
    String[][] groupingDishes(String[][] dishes) {
        Map<String, List<String>> map = new HashMap<>();


        for (String[] dish : dishes){
            for (int i = 1; i < dish.length ; i++){
                String di = dish[0];
                String in = dish[i];
                map.putIfAbsent(in , new ArrayList<>());
                map.get(in).add(di);
            }
        }
        Map<String, List<String>> map1 = new HashMap<>();
        PriorityQueue<Map.Entry<String, List<String>>> pq =
                new PriorityQueue<>((a,b)-> a.getKey().compareTo(b.getKey()));
        for ( Map.Entry<String, List<String>> entry : map.entrySet()){
            List<String> list = entry.getValue();
            if (list.size() >=2){
                map1.put(entry.getKey(), entry.getValue());
            }
        }

        System.out.println(map1);

        String[][] result = new String[map.size()][];
        int index = 0 ;
        for (Map.Entry<String, List<String>> entry : map1.entrySet()){
            List<String> list = entry.getValue();

            String[] str = new String[list.size()+1];
            str[0] = entry.getKey();
            for (int i = 0 ; i < list.size() ; i++){
                str[i+1] = list.get(0);
            }
            result[index]= str;
            index++;
        }
        return result;
    }

}
