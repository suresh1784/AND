package algorithm.leetcode;

public class WaysToMakeFair {
    public static int waysToMakeFair(int[] nums) {
        int len = nums.length;
        int[] odd1 = new int[len];
        int[] odd2 = new int[len];
        int[] even1 = new int[len];
        int[] even2 = new int[len];



        odd1[0] = nums[1];
        even1[0] = nums[0];

        for (int i = 1 ; i < len; i++){
            if (i%2==0){
                even1[i] = even1[i-1]+nums[i];
                odd1[i] = odd1[i-1];
            }else {
                even1[i] = even1[i-1];
                odd1[i] = odd1[i-1]+nums[i];
            }
        }

        for (int i = len-2 ; i >=0; i-- ){
            if (i%2==0){
                even2[i] = even2[i+1]+nums[i];
                odd2[i] = odd2[i+1];
            }else {
                even2[i] = even2[i+1];
                odd2[i] = odd2[i+1]+nums[i];
            }
        }
        int result = 0 ;
        int oddSum = 0 ;
        int evenSum = 0 ;
        for (int i = 0 ; i < len ; i++){
            if (i%2==0){

            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
