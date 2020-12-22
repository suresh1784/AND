package algorithm.leetcode;
import java.util.*;

public class MinimumIncompatibility {
    public static int minimumIncompatibility(int[] nums, int k) {
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int num : nums){
            freqCount.put(num , freqCount.getOrDefault(num,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()){
            if (entry.getValue() > k){
                return -1;
            }

            list.add(entry.getKey());
        }
        list.sort((a,b)-> Integer.compare(a,b));

        int count = 0 ;
        boolean forward = true;

        while (list.size()>0){
            List<Integer> removes = new ArrayList<>();
            if (forward) {
                int i = 0 ;
                while (i< list.size()){

                }

            }else {
                for (int i = list.size()-1; i>=0  ; i--) {

                }
            }
            for (int remove : removes){
                list.remove(remove);
            }
        }

        int result = -1;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6,3,8,1,3,1,2,2};
        int k = 4;
        System.out.println(minimumIncompatibility(nums, k));
    }
}
