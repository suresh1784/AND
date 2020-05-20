package algorithm.recursion;

public class SubsetSum{

    public static void main(String[] args) {
        int [] nums = {8, 6, 7, 5, 3, 10, 9};//{8, 6, 7, 5, 3, 10, 9}
        int [] nums1 =  {11, 6, 5, 2, 7, 13, 12};
        for (int i = 0 ; i < nums.length-1; i++){
            if (isSubset(nums1, 15, nums1[i], i+1)){
                System.out.println("isSubsetSum is true");
                break;
            }
        }//for

        Boolean result = isSubset1(nums1, 15, 0);
        System.out.println("result " +result);

    } //main

    public static Boolean isSubset1(int[] nums, int target  , int pos){

        if (pos>= nums.length){
            return false;
        }

        if (target == 0){
            return true;
        }

        if (target < 0){
            return false;
        }


        if (target >= nums[pos]){
            return isSubset1(nums, target,pos+1 ) || isSubset1(nums, target-nums[pos],  pos+1);
        }else{
            return isSubset1(nums, target,pos+1 );
        }

    }// isSubset

    public static Boolean isSubset(int[] nums, int target, int currval , int pos){

        if (pos>= nums.length){
            return false;
        }

        if (target == 0){
            return true;
        }

        if (target < 0){
            return false;
        }


        if (target >= currval){
            return isSubset(nums, target, nums[pos],pos+1 ) || isSubset(nums, target-currval, nums[pos], pos+1);
        }else{
            return isSubset(nums, target, nums[pos],pos+1 );
        }

    }// isSubset

}