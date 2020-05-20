package patterns.CyclicSort;

class MissingNumber {

    public static int findMissingNumber(int[] nums) {
        // TODO: Write your code here
        int i = 0 ;

        while (i < nums.length){
            if (nums[i]<nums.length && nums[i]!= nums[nums[i]]){
                swap(nums, i , nums[i]);
            }else {
                i++;
            }
        }

        int result = -1;
        for (int k= 0 ; k < nums.length; k++){
           if (nums[k]!= k ){
               return k;
           }
        }
        return -1;
    }


    public static void swap(int[] nums, int i , int j ){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }

    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}