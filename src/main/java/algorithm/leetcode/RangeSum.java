package algorithm.leetcode;

import java.util.*;

public class RangeSum {
    private class Pair {
        int i;
        int j;

        public Pair(int i , int j){
            this.i = i ;
            this.j = j ;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return (i == pair.i &&
                    j == pair.j) ||(j == pair.i &&
                    i == pair.j) ;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        int sum = 0 ;
        Arrays.sort(nums);
        int[] nums1 = new int[n+1];
        nums1[0] = 0;
        for (int i = 0; i < n; i++)
            nums1[i+1] = nums[i];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Integer.compare(nums1[a.i]+nums1[a.j],nums1[b.i]+nums1[b.j] ));

        if (n <=1){
            if (n==0){
                return 0;
            }
            return nums[0];
        }

        int i = 0;
        int j = 1;

        pq.offer(new Pair(i,j));
        Set<Pair> set = new HashSet<>();
        set.add(new Pair(i,j));
        List<Integer> sumList = new ArrayList<>();
        List<Pair> sumPair = new ArrayList<>();
        while (!pq.isEmpty()){
            Pair top = pq.poll();
            int currSum = nums1[top.i]+nums1[top.j];
            sumList.add(currSum);
            sumPair.add(top);
            if (sumList.size() > right){
                break;
            }
            Pair p1 = new Pair(top.i+1,top.j);
            Pair p2 = new Pair(top.i,top.j+1);
            if (!set.contains(p1) && p1.i!=p1.j) {
                pq.offer(p1);
                set.add(p1);
            }

            if (!set.contains(p2) && p2.i!=p2.j) {
                pq.offer(p2);
                set.add(p1);
            }
        }
        int index = 1 ;
        int totalSum = 0 ;
        for (int val : sumList){
            if (index >= left){
                totalSum += val;
            }

            if (index == right){
                break;
            }
        }

        return totalSum;
    }
}
