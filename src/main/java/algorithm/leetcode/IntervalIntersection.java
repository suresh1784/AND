package algorithm.leetcode;
import java.util.*;
public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0 ;
        int j = 0 ;
        int l1 = A.length;
        int l2 = B.length;
        List<List<Integer>> results = new ArrayList<>();
        while (i< l1 && j< l2){
            int a1 = A[i][0];
            int a2 = A[i][1];
            int b1 = A[j][0];
            int b2 = A[j][0];

            if (isIntersection(a1, a2, b1, b2)){
                int s1 = Math.min(a1, a2);
                int e1 = Math.min(b1, b2);
                int s2 = Math.max(a1, a2);
                int e2 = Math.max(b1, b2);
                a1 = s1;
                a2 = e1;
                b1 = s2;
                b2 = e2;
            }
            // add both the numbers
            List<Integer> result = new ArrayList<>();
            result.add(a1, a2);
            results.add(result);
            result = new ArrayList<>();
            result.add(b1, b2);
            results.add(result);


        }

        return (int[][])results.stream().toArray();
    }

    private boolean isIntersection(int a1, int a2, int b1, int b2){
        if ((a1<b2 && a1>b1)|| (b1<a2 && b1>a1))  {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
    }
}
