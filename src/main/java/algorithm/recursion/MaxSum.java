package algorithm.recursion;

public class MaxSum {



    public static int dp1(int[] a){
        int max = a[0] ;
        int current = a[0] ;

        for (int i = 1; i < a.length; i++){
            current = Math.max(current +a[i], a[i]);
            max = Math.max(max, current);
        }
        return max ;
    }
    public static int max = 0 ;

    public static int dp2(int[] a, int level){
        int sum1 = 0 ;
        int sum2 = 0 ;

        if (level == 0){
            max = a[0];
            return a[0] ;
        }


        if (level < 0 ){
            return 0;
        }




        sum1 = a[level]+ dp2(a, level-1);
        sum2 = Math.max ( sum1 , a[level]);
        max = Math.max(max, sum2);
        return sum2;
    }



    public static void main(String[] args){
        int[] input = {2,1,-3,4,-1,2,1,-5,4};
        int dp1 = dp1(input);
        System.out.println(dp1);

        System.out.println("--------------------------");
        int dp2 = dp2(input, input.length-1);
        System.out.println(max);

    }

}
