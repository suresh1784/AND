package patterns.mock;
import java.util.*;

public class TwoSumDuplicates {
//Hash Table: Time ~ O(N), Space ~ O(N)

    public static void main(String[] args){
        int[] input = {7 ,1,1,8,8, 1,6, 3,3, 6, 9 };
        int target = 9;
        System.out.println(twoSumv1(input, target));
    }

    public static List<List<Integer>> twoSum(int[] num, int target) {
        List<List<Integer>> listSet = new ArrayList<List<Integer>>();
        int n = num.length;
        if (n < 2)  return listSet;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key1 = num[i], key2 = target - num[i];
            while (map.containsKey(key2) && map.get(key2) > 0) {
                List<Integer> list = new ArrayList<Integer>();
                if (key1 < key2)    list = Arrays.asList(key1, key2);
                else                list = Arrays.asList(key2, key1);
              //  if (!listSet.contains(list))
                    listSet.add(list);
                map.put(key2, map.get(key2) - 1);
            }

                if (!map.containsKey(key1)) map.put(key1, 1);
                else                        map.put(key1, map.get(key1) + 1);

        }
        return listSet;
    }


    public static List<List<Integer>>twoSumv1(int[] num, int target){
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0 ; i < num.length ; i++){
            int key1 = num[i];
            int key2 = target-num[i];

            if (indexMap.containsKey(key2)){
                List<Integer> lists = indexMap.get(key2);
                for (int list : lists){
                    List<Integer> index = new ArrayList<>();
                    index.add(list);
                    index.add(i);
                    List<Integer> value1 = new ArrayList<>();
                    value1.add(num[list]);
                    value1.add(num[i]);
                //   if(! result.contains(index)){
                       result.add(value1);
                       index = new ArrayList<>();
                        value1 = new ArrayList<>();
                //    }
                } // for
            }
                List<Integer> indexs = new ArrayList<>();
                if (indexMap.containsKey(key1)){
                    indexs = indexMap.get(key1);
                }
                indexs.add(i);
                indexMap.put(key1, indexs);


        }// for

        System.out.println(result);
//        List<List<Integer>> values = new ArrayList<>();
//        for (List<Integer> list :  result){
//            List<Integer> value = new ArrayList<>();
//            value.add(num[list.get(0)]);
//            value.add(num[list.get(1)]);
//            values.add(value);
//        }
        return result;
    }// method
}
