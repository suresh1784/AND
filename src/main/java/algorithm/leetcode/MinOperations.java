package algorithm.leetcode;

public class MinOperations {
    public static int minOperations(int[] nums) {
        int maxEven = 0 ;
        int evenOperation = 0 ;
        int numOfOdd = 0 ;
        int length = nums.length-1;
        int max = 0 ;
        int ones = 0 ;
        int zeros = 0 ;
        int result = 0 ;
        int numOfEven = 0 ;
        for (int num : nums){
            max = Math.max(max, num);
            if (num==1){
                ones+=1;
            }

             if (num==0){
                zeros+=1;
            }
            else {
                if (num % 2 == 1) {
                    numOfOdd += 1;
                } else {
                    numOfEven += 1;
                }
            }
        }
        if (max%2==0){
            maxEven = max;
        }else{
            maxEven = max-1;
        }

        double c = Math.log(maxEven)/Math.log(2);
        evenOperation = (int) c;

        numOfEven+= numOfOdd-ones;
        result = numOfEven+evenOperation+numOfOdd;
        return result;

    }

    public static void main(String[] args) {
//        int[] num1 = {0,5};
//        System.out.println(minOperations(num1));
//        int[] num2 = {2,2};
//        System.out.println(minOperations(num2));
//        int[] num3 = {4,2,5};
//        System.out.println(minOperations(num3));
//        int[] num4 = {3,2,2,4};
//        System.out.println(minOperations(num4));
//        int[] num5 = {0,2,4,8,16};
//        System.out.println(minOperations(num5));
//        int[] num6 = {1000000000};
//        System.out.println(minOperations(num6));
//
        double ans = Math.pow(2,42);
        System.out.println(ans);
        double c = Math.log(1000000000)/Math.log(2);

        System.out.println(c);
        System.out.println(getOperationCount(1000000000));
    }

    private static int getOperationCount(int value){
        int count = 0 ;
        while (value >1){
            value = value/2;
            count++;
        }
        return count;
    }
}
