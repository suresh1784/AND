package patterns.CyclicSort;

class FindDuplicate {

    public static int findNumber(int[] nums) {
        // TODO: Write your code here
        int i = 0 ;

        while (i <nums.length){
            int idx = nums[i]-1;
            if (nums[idx]!= nums[i]){
                swap(nums, idx, i);
            }else if (idx!=i && nums[idx]==nums[i]){
                return nums[i];
            }
            else {
                i++;
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
        System.out.println(FindDuplicate.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}