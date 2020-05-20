package patterns.leetcode75.Arrays;

public class FindMinRotatedArray {
    public static int findMin(int[] nums) {
        if (nums==null || nums.length==0){
            return -1;
        }
    return nums[findMin(nums, 0 , nums.length-1 )];
    }


    public static int findMin(int[] nums, int left , int right){
        if (left >= right){
            if (left >=0){
                System.out.println("left "+left);
                return left;
            }
            return -1;
        }
        int mid = left+(right-left)/2;
        if (mid > 0 && nums[mid - 1] > nums[mid]) {
            return mid;
        }


        if (nums[mid] > nums[right]){
            return findMin(nums, mid+1, right);
        }

        return findMin(nums, left,mid-1 );
    }


    public static void main(String[] args){
        int[] in1 = {5,6,7,8,8,8,8,1,1,1,2,2,3,4};
        int[] in = {2,2,2,0,2};
        System.out.println(findMin(in));

    }
}
