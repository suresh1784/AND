package patterns.DynamicProgramming.leetcode;

import java.util.*;

public class JumpGameIII {

    public static boolean canReach(int[] arr, int start) {
        int m = arr.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] visited = new boolean[m];

        while (!q.isEmpty()){
            Integer top = q.poll();
            visited[top] = true;
            if (arr[top]==0){
                return true;
            }

            int left = top - arr[top];
            int right = top + arr[top];
            if (left>=0 && !visited[left] ){
                q.add(left);
            }
            if (right < m && !visited[right]){
                q.add(right);
            }
        }

    return false;
    }


    public static void main(String[] args){
        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;
        int start1 = 0 ;
        int[] arr2 = {3,0,2,1,2};
        int start2 = 2;
        System.out.println(canReach(arr, start1));
    }
}
