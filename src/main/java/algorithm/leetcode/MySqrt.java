package algorithm.leetcode;

public class MySqrt {

    public static void main(String[] args){
        // 2147395599

        System.out.println(mySqrt(2147395599));
    }
    public static int mySqrt(int x) {
        int left = 0;
        int right = x/2;

        while (left < right){
            int mid = (left+right)/2;

            if (mid*mid == x){
                return mid;
            }

            if (x< mid*mid){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return left;
    }

}
