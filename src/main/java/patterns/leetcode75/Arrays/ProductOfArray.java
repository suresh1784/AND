package patterns.leetcode75.Arrays;

public class ProductOfArray {

    public static int[] productExceptSelf(int[] nums) {
        int[] r1 = new int[nums.length];
        int n = nums.length;
        r1[0] = 1;
        for (int i = 1 ; i < n ; i++){
            r1[i]= r1[i-1]*nums[i-1];
        }
        int[] r2 = new int[n];
        r2[n-1]= 1;
        int lastUsed = 1;
        for (int i = n-2; i >= 0; i--){
            r2[i]= r2[i+1]*nums[i+1];
        }

        for (int i = 0 ; i < n ; i ++){
            r2[i] = r2[i]*r1[i];
        }

        return r2;
    }

    //  1 2 3 4
    //  1 1 2 6
    //  24 12  4 1

    public static void main(String[] args){
        int[] in = {1,2,3,4};
        int[] r = productExceptSelf(in);
        for (int r1: r) {
            System.out.println(r1);
        }
        System.out.println(r.toString());
    }
}


