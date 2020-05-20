package patterns.mock;
import java.util.*;

public class FindDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int right = 0 ;
        List<Integer> result = new ArrayList<>();
        while (right < nums.length){
            if (right != nums[right]-1 && nums[right]-1 != nums[nums[right]-1]-1){
                swap(nums, right, nums[right]-1);
            }else {
                right++;
            }
        }

        System.out.println(nums);

        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i]!=i+1){
                result.add(i+1);
            }
        }

        return result;
    }


    public static int[] swap(int[] input , int i , int j){
      //  System.out.println("i "+i + " j "+j) ;
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
        return input;
    }


    public static void main(String[] args){
       int[] input =  {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(input));
    }

}
