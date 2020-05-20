package patterns.leetcode75.Arrays;

public class RotatedBinarySearchDuplicates {
    public static boolean helper(int[] nums, int start, int end, int target) {
        if (start > end)
            return false;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target)
            return true;
        if (nums[start] <= nums[mid]) {
            if (target >= nums[start] && target < nums[mid])
                return helper(nums, start, mid - 1, target);
            else
                return helper(nums, mid + 1, end, target);
        } else if (nums[start] >= nums[mid]) {
            if (target > nums[mid] && target <= nums[end])
                return helper(nums, mid + 1, end, target);
            else
                return helper(nums, start, mid - 1, target);
        } else {
            if (nums[start]==nums[mid] && nums[mid] == nums[end]) // in this case, the smaller or larger values (compare to nums[mid]) can be in either side
                return helper(nums, start++, mid - 1, target) || helper(nums, mid + 1, end--, target);
        }
        return false;
    }


    public static boolean search(int[] nums, int target) {
        return helper(nums, 0, nums.length-1, target);
    }

    public static void main(String[] args){
        int[] in1 = {4,5,6,7,0,1,2};
        System.out.println(search(in1, 3));

    }
}
