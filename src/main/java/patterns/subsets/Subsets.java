package patterns.subsets;

import java.util.*;

class Subsets {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // TODO: Write your code here
      //  dfs(nums, 0,list , subsets);
        subsets = bfs(nums);
        return subsets;
    }


    static  List<List<Integer>> bfs (int[] nums ){
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        for (int num : nums){
            int size = subsets.size();
            for (int i = 0 ; i < size; i++ ){
                List<Integer> newSet = new ArrayList<>(subsets.get(i)); //
                newSet.add(num);
                subsets.add(newSet);
            }
        }

        return subsets;

    }


    static void  dfs (int[] nums, int level,List<Integer> list ,List<List<Integer>> subsets){

        if (level == nums.length){
            subsets.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[level]);

        dfs(nums, level+1, list, subsets);
        list.remove(list.size()-1);
        dfs(nums, level+1, list, subsets);

    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}