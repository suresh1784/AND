package algorithm.recursion;

public class Reverse {

    public static void main (String[] args){
        int[] nums = {10,20,30,40,50,60};
       // reverse(nums,0);
      //  reverse1(nums, nums.length-1);
        System.out.println(reverseString("abcde"));
    }//main


    static void reverse(int[] nums ,int pos){
        if (pos == nums.length){
            return ;
        }

       reverse(nums, pos+1);
        int val = nums[pos];
        System.out.println(val);

    } //reverse

    static int reverse1(int[] nums ,int pos){
        if (pos >= 0 ){
            return nums[pos];
        }



       return  reverse1(nums, pos-1);



    } //reverse

    static String reverseString(String s){
        if(s.toCharArray().length == 1){
            return s;
        }
        return reverseString(s.substring(1,s.length()))+s.charAt(0);
    }
}//Reverse
