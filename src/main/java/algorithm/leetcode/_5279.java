package algorithm.leetcode;

public class _5279 {
    public static int subtractProductAndSum(int n) {

        int sum = 0 ;
        int prod = 1;
        int r = 0 ;
        while (n>0){
            r = n%10;
            n =n/10;
            sum += r;
            prod *= r;
        }

        return prod - sum;
    }


    public static void main(String[] args){
      int n1 = 234;
      int n2 = 4421;
        System.out.println(subtractProductAndSum(n1));

    }
}
