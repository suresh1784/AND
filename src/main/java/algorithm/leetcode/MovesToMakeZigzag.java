package algorithm.leetcode;

public class MovesToMakeZigzag {

    public static int movesToMakeZigzag(int[] nums) {
        int[] temp = new int[nums.length];
        temp = nums.clone();
        int evenCount = getCount(nums, 0);
        int oddCount = getCount(temp, 1);
        return Math.min(evenCount, oddCount);
    }


    public static int getCount(int[] nums, int index){
        int count = 0;
        int length = nums.length-1;
        while (index <=length ){
            if (index+1<=length && nums[index]<= nums[index+1]){
                count = count+1+(nums[index+1]-nums[index]);
                nums[index+1] = nums[index]-1;
            }
            if (index-1>= 0 && nums[index-1]>=nums[index]){
                count = count+1+(nums[index-1]-nums[index]);
                nums[index-1]= nums[index]-1;
            }
            index= index+2;
        }
        return count;
    }

    public static void main(String[] args){
        int[] in1 = {1,2,3};
        System.out.println(movesToMakeZigzag(in1));
        int[] in2 = {9,6,1,6,2};
        System.out.println(movesToMakeZigzag(in2));
    }
}
