package algorithm.leetcode;
import java.util.*;
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        Arrays.sort(costs, (a, b) -> {
            return Integer.compare( a[0] - a[1],b[0] - b[1]);
        });

        for (int i = 0 ; i < costs.length/2; i++){
            int val = costs[i][0];
        //    System.out.println("A "+val);
            sum += val;
        }

        for (int i = costs.length/2 ; i < costs.length; i++){
            int val = costs[i][1];
          //  System.out.println("B "+val);
            sum += val;
        }

        return sum;
    }

    public static void main(String[] args) {
       int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
       TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
        System.out.println(twoCityScheduling.twoCitySchedCost(costs));
    }
}
