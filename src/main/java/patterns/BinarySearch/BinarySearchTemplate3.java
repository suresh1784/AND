package patterns.BinarySearch;

public class BinarySearchTemplate3 {

    public static void main(String[] args){
    int[] nums ={1,2,3,2,1};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
    return  findPeakElement(nums, 0 , nums.length-1);
    }

    public static int findPeakElement(int[] nums, int left, int right) {
        if (left >= right){
            return nums[left];
        }

        int mid = (left+right)/2;



        if (nums[mid+1] > nums[mid]){
            return findPeakElement(nums, mid+1, right);
        }
        return findPeakElement(nums, left, mid);

    }
}
