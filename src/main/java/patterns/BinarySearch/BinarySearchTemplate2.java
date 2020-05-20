package patterns.BinarySearch;

public class BinarySearchTemplate2 {

    public static void main(String[] args){

        // minimum in rotated array
//        int[] input = {7, 6, 5, 4 , 3, 2 , 1};
//        int[] input1 = {4, 5, 6, 7 ,8,  1, 2, 3, 4};
//        System.out.println(findMin(input1));
//        System.out.println(findMinIterative(input1));

        // peak

        int[] peak1 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(peak1));
    }

    /**
     * Find Peak
     */

    public static int findPeakElement(int[] nums){
        return findPeakElement(nums, 0, nums.length-1);
    }

    public static int findPeakElement(int[] nums, int left, int right){
        if (left == right){
            if (left >0 && left < nums.length-1){
                return left;
            }
            return right;  // ********
        }



        int mid = (left+right)/2;
        if (nums[mid]>nums[mid+1]){
            return findPeakElement(nums, left, mid);
        }
        return findPeakElement(nums, mid+1, right);

    }



    /**
     * Find Min in iterative
     */

    public static int findMinIterative(int[] nums) {

        int left = 0 ;
        int right = nums.length-1;

        while (left < right){
            int mid = (left+right)/2;
            if (nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }

            if (nums[mid]> nums[right]){
                left = mid+1;
            }else {
                right = mid;
            }
        }

        return -1;
    }



    /**
     * Minimum in rotated array
     * Recursive Solution
     */

    public static int findMin(int[] nums) {
        return findMin(nums, 0 , nums.length-1);
    }


    public static int findMin(int[] nums, int left , int right){
        if (left > right){
            return nums[left];
        }

        int mid = (left+right)/2;

        if (nums[mid]>nums[mid+1]){
            return nums[mid+1];
        }

        if (nums[mid] > nums[right]){
            return findMin(nums, mid+1, right);
        }else {
            return findMin(nums, left, mid-1);
        }
    }




}
