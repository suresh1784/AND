package algorithm.onlineassesment.amazon;

import java.util.*;

public class SubarraysWithKDistinct {
    public int subarraysWithKDistinct(int[] A, int K) {
        int count = 0 ;
        int left = 0 ;
        Map<Integer, Integer>  freqMap = new HashMap<>();
        for (int right = 0 ; right < A.length ; right++){
            int rVal = A[right];
            freqMap.put(rVal, freqMap.getOrDefault(rVal, 0)+1);
            while (freqMap.size() > K){
                int lVal = A[left++];
                freqMap.put(lVal, freqMap.get(lVal)-1);
                if (freqMap.get(lVal)==0){
                    freqMap.remove(lVal);
                }
            }
            Map<Integer, Integer> tempMap = new HashMap<>(freqMap);
            int l = left;
            while (freqMap.size()==K && left <=right){
                count++;
                int lVal = A[left++];
                freqMap.put(lVal, freqMap.get(lVal)-1);
                if (freqMap.get(lVal)==0){
                    freqMap.remove(lVal);
                }
            }
            freqMap = tempMap;
            left = l;


        }
        return count ;
    }
}
