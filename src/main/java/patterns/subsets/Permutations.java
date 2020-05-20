package patterns.subsets;

import java.util.*;

class Permutations {

    public static List<List<Integer>> findPermutations1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lists = new ArrayList<>();
        for (int i : nums){
            lists.add(i);
        }
        // TODO: Write your code here
        dfs(nums,0, result,lists );
        return result;
    }

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(new ArrayList<>());

        for (int num : nums){
            int n = q.size();
            for (int j = 0 ; j < n ; j++) {
                List<Integer> top = q.poll();
                for (int i = 0; i <= top.size(); i++) {
                    List<Integer> newPermutation = new ArrayList<>(top);
                    newPermutation.add(i, num);
                    if (newPermutation.size()== nums.length){
                        result.add(new ArrayList<>(newPermutation));
                    }else {
                        q.offer(newPermutation);
                    }
                }
            }
        }


        return result;
    }



    static void dfs(int[] nums, int level, List<List<Integer>> result,List<Integer> list ){
    if (level == list.size()){
        result.add(new ArrayList<>(list));
        return;
    }

    for (int i = level; i < nums.length; i++){
        Collections.swap(list,i , level);
        dfs(nums, level+1, result, list);
        Collections.swap(list,i , level);

    }

    }





    static int[] swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        return nums;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
