package algorithm.leetcode;

public class _552 {
    public static int checkRecord(int n) {
        return helper(n, 0 , 0 , 0 , 0, false, false);
    }

    public static int helper(int n , int curr, int a, int l , int p, boolean isLateone, boolean isLatetwo){


        if (a>1){
            return 0;
        }

        if (curr==n){
            return 1;
        }

        if (l>=2 && isLatetwo){
           return helper(n, curr+1, a+1, l , p, false, false)+
                    helper(n, curr+1, a, l, p+1, false, false);
        }else {
            return helper(n, curr+1, a+1, l , p, false, false)+helper(n, curr+1, a, l+1 , p, true, isLateone)+
                    helper(n, curr+1, a, l, p+1, false, false);
        }


    }

    public static void main(String[] args) {
        System.out.println(checkRecord(5));
    }

}
