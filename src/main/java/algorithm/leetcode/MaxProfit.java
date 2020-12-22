package algorithm.leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxProfit {
    private static int modulo = 1000000007;
    public int maxProfit1(int[] inventory, int orders) {
        int result = 0 ;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        for (int in : inventory){
            pq.add(in);
        }
        int k = 0 ;
        while (!pq.isEmpty()){
            int top = pq.poll();
            int temp = (result+top)%modulo;
            result = temp;
            k++;
            if (k ==orders){
                break;
            }
            if (top-1 >0){
                pq.add(top-1);
            }
        }
        return result;
    }

    public int maxProfit(int[] inventory, int orders) {
    int result = 0;
    Arrays.sort(inventory);
    int len = inventory.length;
    int k = 0 ;
    for (int i = len-1 ; i >= 0 ; i--){
        int curr = inventory[i];
        int prev = 0 ;
        if (i-1>=0){
            prev = inventory[i-1];
        }

        if (k == orders){
            break;
        }
    }

    return result;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] in1 = {2,5};
        int o1 = 4;
        System.out.println(maxProfit.maxProfit(in1, o1));

        int[] in2 = {3,5};
        int o2 = 6;
        System.out.println(maxProfit.maxProfit(in2, o2));
        int[] in3 = {2,8,4,10,6};
        int o3 = 20;
        System.out.println(maxProfit.maxProfit(in3, o3));
        int[] in4 = {1000000000};
        int o4 = 1000000000;
        System.out.println(maxProfit.maxProfit(in4, o4));


    }
}
