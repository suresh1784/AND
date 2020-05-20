package algorithm.backtracking;

//import sun.jvm.hotspot.memory.LinearAllocBlock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SubSet {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        List<List<Integer>> result1 = new ArrayList<>();
        input.add(0);
        input.add(1);
        input.add(2);
        int[] arr = {3,4,5,2,5,9,7};
     //   result1 = bfs(arr);
        powerSet(result1,list1,input,0);
     //   combinations(5,2, result1, new ArrayList<Integer>(),1);
     //   int target = 10;
    //    subSet(arr,list,result,3,1);
       // binarySubSet(list,result,3,0);
      //  targetSum(arr,list,result,0,target,0);
        System.out.println(result1);
    }

    static class Node {
        ArrayList<Integer> one;
        int idx;
        Node() {one = new ArrayList<Integer>();}
        Node(int i) { idx = i; }
    }
    private static List<List<Integer>> bfs(int[] nums) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> all = new ArrayList<>();
        q.offer(new Node());
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n.idx == nums.length) {
                all.add(n.one);
            } else {
                Node n1 = new Node(n.idx+1);
                n1.one = new ArrayList<Integer>(n.one);
                n1.one.add(nums[n.idx]);
                // reuse this Node
                n.idx++;
                q.offer(n);
                q.offer(n1);
            }
        }
        return all;
    }

    static void combinations(int n, int k, List<List<Integer>> result, List<Integer> list, int level){
        if ( list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = level; i <= n; i++){
            list.add(i);
            combinations(n,k,result,list,i+1);
            list.remove(list.size()-1);
        }
    }

    static void subSet(int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result, int n, int pos){
// base case // can work without this...
        if (pos-1 ==n){
            return;
        }

        for (int i = pos; i <=n; i++){
            list.add(i);
            result.add(new ArrayList<>(list));
            subSet(arr,list,result, n ,i+1);
            list.remove(list.size()-1);
        }

    }



    static void binarySubSet(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result, int n, int level){
// base case // can work without this...
        if (level ==n){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i <2; i++){
            list.add(i);
            binarySubSet(list,result, n ,level+1);
            list.remove(list.size()-1);
        }

    }


    static void powerSet(List<List<Integer>> result, List<Integer> list, List<Integer> input, int level){
        if (level == input.size()){
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(input.get(level));
        powerSet(result,list,input,level+1);
        list.remove(list.size()-1);
        powerSet(result,list,input,level+1);

    }


    static void targetSum(int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result , int pos , int target, int currentSum){
        if (currentSum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        if (currentSum >target){
            return;
        }

        for (int i =pos; i< arr.length && currentSum+arr[i] <= target;i++){
            list.add(arr[i]);
            targetSum(arr,list,result,i+1,target,currentSum+arr[i]);
                    list.remove(list.size()-1);
        }

    }



}
