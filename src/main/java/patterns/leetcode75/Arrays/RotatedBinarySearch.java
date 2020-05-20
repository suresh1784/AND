package patterns.leetcode75.Arrays;

public class RotatedBinarySearch {
    public static int search(int[] nums, int target) {
        if (nums== null || nums.length==0){
            return -1;
        }
        return search(nums, target, 0 , nums.length-1);
    }

    public static int search (int[] nums, int key , int left , int right){
        if (left > right){
            return -1;
        }

        int mid  = left +(right-left/2);
        if (nums[mid]==key){
            return mid;
        }

        if (nums[mid]> nums[left] && nums[mid]>key){
            return  search(nums, key , left, mid-1);
        } else if (nums[mid]< nums[right] && key > nums[mid]){
            return search(nums, key, mid+1, right);
        } else if (nums[mid]>nums[right]){
            return search(nums, key , mid+1, right);
        } else {
            return  search(nums, key , left, mid-1);
        }
    }

    public static void main(String[] args){
        int[] in1 = {4,5,6,7,0,1,2};
        System.out.println(search(in1, 3));

    }
}
