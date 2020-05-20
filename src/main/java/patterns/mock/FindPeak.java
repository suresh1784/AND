package patterns.mock;

public class FindPeak {

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums) {
        if (nums.length == 0){
            return -1;
        }

//        if (nums.length == 0){
//            return 0;
//        }

        return findPeakElement(nums, 0 , nums.length-1);
    }

    private static int findPeakElement(int[] nums, int left , int right){

        if (left == right){
            if (left >0 && left < nums.length-1 && nums[left]> nums[left+1]){
                return left;
            }
            return -1;
        }

        int mid = left + (right-left)/2;
        if (nums[mid]>nums[mid+1]){
          return  findPeakElement(nums, left , mid);
        }

        return  findPeakElement(nums, mid+1 , right);

    }
}

