package algorithm.leetcode;
import java.util.*;
public class MostCompetitive {

    public static class Pair {
        int val ;
        int index;
        public Pair(int val , int index){
            this.val = val ;
            this.index = index;
        }
    }
    public static int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length-1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> {
            if (Integer.compare(a.val, b.val)==0){
                return Integer.compare(a.index, b.index);
            }

            return Integer.compare(a.val, b.val);
        });
        for (int i = 0 ; i < nums.length ; i++){
            pq.offer(new Pair(nums[i], i));
        }
        int count = k ;
        PriorityQueue<Pair> resPq = new PriorityQueue<Pair>((a,b)-> Integer.compare(a.index, b.index));
        int startIndex = 0 ;
        while (!pq.isEmpty() && resPq.size() < k){
            Pair top = pq.poll();
            int currIndex = top.index;
            if (currIndex >= startIndex) {
                if (len - currIndex + 1 >= count) {
                    startIndex = currIndex;
                    count--;
                }

                resPq.offer(top);
            }
        }

        int[] result = new int[k];

        for (int i =0 ; i < k ; i++){
            result[i] = resPq.poll().val;
        }
        return result;
    }

    public static void main(String[] args) {
       int[] nums = {2,4,3,3,5,1,4,9,0,9,9,9};
       int k = 4;

        int[] num1 = {84,10,71,23,66,61,62,64,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71};
        int k1 = 24;

       int[] result = mostCompetitive(num1, k1);
       for (int i : result) {
           System.out.printf(" "+i);
       }
    }


    public static class Interval{
        int event;
        boolean isStart;
        int start;
        boolean isA;

        public Interval(int event, boolean isStart, boolean isA){
            this.event = event;
            this.isStart = isStart;
            if (isStart){
                start = 0;
            }else {
                start = 1;
            }
            this.isA = isA;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "event=" + event +
                    ", isStart=" + isStart +
                    ", start=" + start +
                    ", isA=" + isA +
                    '}';
        }
    }


}
