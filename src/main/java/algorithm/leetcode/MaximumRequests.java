package algorithm.leetcode;

import java.util.*;

public class MaximumRequests {
    public int maximumRequests(int n, int[][] requests) {
        Map<Integer, Integer> incomingMap = new HashMap<>();
        Map<Integer, Integer> outgoingMap = new HashMap<>();
        int result = 0 ;
        for (int[] request : requests){
            int in = request[0];
            int out = request[1];

            incomingMap.put(in, incomingMap.getOrDefault(in, 0)+1);
            outgoingMap.put(out, outgoingMap.getOrDefault(out, 0)+1);

        }

        System.out.println("IncomingMap "+incomingMap);
        System.out.println("OutgoingMap "+outgoingMap);
        for (int i = 0 ; i < n ; i++){
            if (incomingMap.containsKey(i)&& outgoingMap.containsKey(i))
            result += Math.min(incomingMap.get(i), outgoingMap.get(i));
        }
        return result;
    }
}
