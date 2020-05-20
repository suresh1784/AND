package algorithm.onlineassesment.amazon;
import java.util.*;
public class FindPair {
    public int[] findPair(int[] nums , int target){
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = {-1,-1};
        int max = -1 ;
        for (int i = 0 ; i < nums.length ; i++){

            if (map.get(target-nums[i])==null){
                map.put(nums[i], i);
            }else {
                int otherIndex = map.get(target-nums[i]);
                int currMax = Math.max(nums[i], nums[otherIndex]);
                if (currMax> max){
                    result[0] = otherIndex;
                    result[1] = i;
                    max = currMax;
                }
            }
        }
        return result;
    }
}

