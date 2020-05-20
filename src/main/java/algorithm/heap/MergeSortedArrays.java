package algorithm.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArrays {

    public static void main(String[] args){
        List<List<Integer>> input  = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        List<Integer> r3 = new ArrayList<>();

        Collections.addAll(r1,3,5,7);
        Collections.addAll(r2,0,6);
        Collections.addAll(r3,0,6,28);

        Collections.addAll(input,r1,r2,r3);
        System.out.println(mergeSortedArrays(input));
        System.out.println(input);
    }

    static List<Integer> mergeSortedArrays(List<List<Integer>> input){
      //  PriorityQueue<Integer> q = new PriorityQueue<>(input.size(), (a,b) -> (a-b));
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> result = new ArrayList<>();
        for (List<Integer> list:input){
            for (int i: list){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            result.add(q.poll());
        }
        return result;
    }
}
