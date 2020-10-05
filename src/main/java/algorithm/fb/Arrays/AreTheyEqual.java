package algorithm.fb.Arrays;
import java.util.*;

public class AreTheyEqual {
    public static boolean areTheyEqual(int[] target, int[] arr){
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int len = target.length;
        if (len!= arr.length){
            return false;
        }
        for (int i = 0 ; i < len ; i++){
            int val1 = target[i];
            int val2 = arr[i];

            if (map1.containsKey(val2)){
                map1.put(val2, map1.get(val2)-1);
                if (map1.get(val2)==0){
                    map1.remove(val2);
                }
            }else {
                map2.put(val2, map2.getOrDefault(val2, 0)+1);
            }

            if (map2.containsKey(val1)){
                map2.put(val1, map2.get(val1)-1);
                if (map2.get(val1)==0){
                    map2.remove(val1);
                }
            }else {
                map1.put(val1, map1.getOrDefault(val1, 0)+1);
            }
        }

        return map1.size()==0 && map2.size()==0;
    }


    public static void main(String[] args) {
        int[] target = {1};
        int[] arr = {1};
        boolean result = areTheyEqual(target, arr);
        System.out.println(result);
    }

    boolean isReverse (int[] target, int[] arr, int start , int end){
        while (start <= end){
            if (target[start] == arr[end] && target[end]== arr[start]){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }
}
