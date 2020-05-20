package algorithm.leetcode;

public class _50 {


    /**
     * 50. Pow(x, n)
     *
     * Implement pow(x, n).

     Example 1:

     Input: 2.00000, 10
     Output: 1024.00000

     Example 2:

     Input: 2.10000, 3
     Output: 9.26100
     */

    public static void main (String[] args){
        System.out.println(myPow(2.1,3));
        System.out.println(myPow(2,10));
        System.out.println(fastPow(2.1,3));
        System.out.println(fastPow(2,10));
    }


    public static double myPow(double x, int n) {

    if (n>=1) {
        return myPow(x, n - 1) * x;
    }
    else {
        return 1;
    }
    }

    public static double fastPow(double x, int n){
        if (n==0){
            return 1;
        }
      if  (n%2==0){
         return fastPow(x,n/2)*fastPow(x,n/2);
      }else {
          return fastPow(x,n-1)*x;
      }
    }


}
