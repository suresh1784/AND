package algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

public class NumOfSubarrays {
    public int numOfSubarrays(int[] arr) {
        List<Integer> list = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        helper(arr, 0, 0, list, lists, sumList);
        System.out.println(lists);
        System.out.println(sumList);
        return sumList.size();
    }

    public void helper(int[] arr, int sum,int  i , List<Integer> list,List<List<Integer>> lists, List<Integer> sumList ){
        if (i >= arr.length){

            if (sum%2==1){
                lists.add(new ArrayList<>(list));
                sumList.add(sum);
            }

            return;
        }
        list.add(arr[i]);

        helper(arr, sum+arr[i], i+1, list, lists, sumList);
        list.remove(list.size()-1);
        helper(arr, sum, i+1, list, lists, sumList);
    }
}
