package patterns.BinarySearch;

public class BinarySearchTemplateOne {

    public static void main(String[] args){
        // for sqrt
//        int[] sqrt = {25, 9, 16, 4};
//        for (int i :sqrt){
//            System.out.println(mySqrt(i));
//        }
//
//        for (int i = 1  ;i <= 100 ; i++ ) {
//            System.out.println(i+" sqrt "+mySqrt(i));
//        }

        // for rotated search array
        int[] input = {4,5,6,7,0,1,2};
        System.out.println(3+ " " +rotatedSearch(input, 3));
        for (int i : input){
            System.out.println(i+ " " +rotatedSearch(input, i));
        }
    }

    /**
     * Rotated Search
     */

    public static int rotatedSearch(int[] nums, int target) {
        return rotatedSearch(nums, target, 0 , nums.length-1);
    }

    public static int rotatedSearch(int[] nums, int target, int left , int right) {
       if (left > right){
           return -1;
       }

       int mid = (left+right)/2;
       if (nums[mid]== target){
           return mid;
       }

       if (nums[left]<= target && target <= nums[mid-1]){
           return rotatedSearch(nums, target, left, mid-1);
       }

       if (nums[mid+1]<= target && target <= nums[right]){
           return rotatedSearch(nums, target, mid+1, right);
       }

       if (nums[mid]< nums[left]){
           return rotatedSearch(nums, target, left, mid-1);
       }

       if (nums[mid]>nums[right]){
           return rotatedSearch(nums, target, mid+1, right);
       }

       return -1;
    }


    /**
     * Square Root
     * @param x
     * @return
     */
    // SQRT

    public static int mySqrt(int x) {
        return mySqrt(x, 1 , x/2);

    }
    //floor of square root value

    public static int mySqrt(int target, int left , int right){
        if (left > right){
            return right;
        }

        int mid = (left+right)/2;

        if (mid*mid== target){
            return mid;
        }

        if (target < mid*mid){
            return mySqrt(target, left, mid-1);
        }else {
            return mySqrt(target, mid+1, right);
        }
    }

    // perfect Square
    public static int mySqrt(int x, int y){



        if (y*y == x){
            return y;
        }

        if (x <  y*y ){
            return mySqrt(x,y-1);
        }else {
            return mySqrt(x,y+1);
        }
    }


}
