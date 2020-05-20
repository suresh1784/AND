package algorithm.leetcode;

public class _5291 {

    public static void main(String[] args){
       int[] in =  {12,345,2,6,7896};
       int[] in1 = {555,901,482,1771};
       // System.out.println(isEven(1));
        System.out.println(  findNumbers(in1));
    }

    public static int findNumbers(int[] nums) {
        int count = 0 ;
        for (int num : nums){
            if (isEven(num))
                count++;
        }
        return count;
    }

    public static boolean isEven(int num){
        int count = 0 ;
        while (num >= 1){
            count ++;
            num = num/10;
        }
      //  System.out.println(count);
        return (count%2==0);
    }
}
