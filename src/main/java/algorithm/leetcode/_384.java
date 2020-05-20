package algorithm.leetcode;

import java.util.*;

public class _384 {
    int[] shuffleArray;
    int[] orginalArray;
    List<List<Integer>> permutation;
    public _384(int[] nums) {
        orginalArray = nums;
        shuffleArray = nums;
        permutation = getPermutationOfArray(nums);
        System.out.println("Size "+permutation.size());
        System.out.println(permutation);

    }

    public List<List<Integer>> getPermutationOfArray(int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<List<Integer>>  q = new LinkedList<>();
        q.offer(list);
        for (int num : nums) {
            int n = q.size();
            for (int j = 0 ; j < n ; j++){
                List<Integer> top = q.poll();
                for (int i = 0 ; i <= top.size(); i++){
                    List<Integer> l = new ArrayList<>(top);
                    l.add(i, num);
                    if (l.size()==nums.length){
                        results.add(l);
                    }else {
                        q.offer(l);
                    }
                }
            }
        }

        return  results;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        shuffleArray = orginalArray;
        return shuffleArray;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int v1 = (int) (Math.random() * permutation.size());
        if (permutation.size()>0 ) {
            return permutation.get(v1).stream().mapToInt(i -> i).toArray();
        }else {

            return shuffleArray;
        }
    }

    public static void main(String[] args){
        int[] num = {1,2,3,4,5,6,7,8,9,10,11,12};
        _384 obj = new _384(num);
        System.out.println(Arrays.asList(obj.reset()));
        System.out.println(Arrays.asList(obj.shuffle()));
        System.out.println(Arrays.asList(obj.reset()));
        System.out.println(Arrays.asList(obj.shuffle()));
        System.out.println(Arrays.asList(obj.shuffle()));
        System.out.println(Arrays.asList(obj.reset()));
    }
}
