package algorithm.leetcode;

public class _5248 {

    public static void main(String[] args){
    int[] nums = {1,1,2,1,1}; // k = 3;
     int[] nums0 = {2,4,6}; //  k=1;
    int[] nums1 = {2,2,2,1,2,2,1,2,2,2}; // k = 2
        System.out.println(numberOfSubarrays(nums1,2));

    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int oddCount = 0;
        int left = 0 ;
        int subsetCount = 0 ;
        int right = 0 ;

       while (right < nums.length){
            if (nums[right]%2==1){
                oddCount++;
            }

            if (oddCount>=k){
                System.out.println("right ");
                subsetCount++;
            }
            while (oddCount>=k && ((nums[right]%2==1)|| right==nums.length-1)){
                if (nums[left]%2==1){
                    oddCount--;
                }
                if (oddCount>=k){
                    System.out.println("left ");
                    subsetCount++;
                }
                left++;
            }
            right++;
        }
        return subsetCount;
    }



}
