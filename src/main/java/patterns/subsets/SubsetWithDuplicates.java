package patterns.subsets;

import java.util.*;

class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets1(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int start = 0 ;
        int end = 0 ;

        subsets.add(new ArrayList<>());
        for (int j = 0 ; j < nums.length; j++){

            if (j>0 && nums[j]==nums[j-1]){
              start = end;
            }
            end = subsets.size();
            for (int i = start; i< end ; i++){
                List<Integer> newSet = new ArrayList<>(subsets.get(i));
                newSet.add(nums[j]);
                subsets.add(newSet);
            }
        }


        return subsets;
    }

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> lists = new ArrayList<>();
        dfs(nums,0 , lists,subsets);
      //  permutation(nums, subsets, lists, 0);
        return subsets;
    }

    static void dfs(int[] nums,int level, List<Integer> lists, List<List<Integer>> subsets ){

        for (int i= level ; i< nums.length; i++){
            if(i>level&&nums[i]==nums[i-1]) continue;
            lists.add(nums[i]);
            subsets.add(new ArrayList(lists));
            dfs(nums, i+1, lists, subsets);
            lists.remove(lists.size()-1);
        }
    }

    static void permutation(int[] arr, List<List<Integer>> res,List<Integer> list, int j){
        for (int i = j ; i< arr.length; i++){
            list.add(arr[i]);
            res.add(new ArrayList(list));
            permutation(arr, res,list,i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets1(new int[] { 1, 2, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 2, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets1(new int[] { 1, 3, 3 ,4});
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3,4 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets1(new int[] { 1, 5, 3, 3 , 7});
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 , 7});
        System.out.println("Here is the list of subsets: " + result);
    }
}
