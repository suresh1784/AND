package algorithm.leetcode;

public class _5241 {

    public static void main (String[] args){
        int n = 13;
        int m = 13;
        for (int i = 1; i <= n ; i++ ){
            for (int j = 1 ; j <= m ; j++){
                System.out.println("n "+i + " m "+j + "result " +tilingRectangle(i , j ));
            }
        }
     //   System.out.println("n "+5 + " m "+8 + " result " +tilingRectangle(5 , 8 ));
        System.out.println("n "+11 + " m "+13 + " result " +tilingRectangle(11 , 13 ));
    }


    public static int tilingRectangle(int n, int m) {
        if (m==n ){
            return 1;
        }
        if (n > m ){
            int temp = m;
            m = n;
            n = temp;
        }
        int result = m*n;

        result = dfs(n, m);
      //  System.out.println(" result "+result);
        return result;
    }

    public static int dfs(int n , int m){
        if (m ==1 && n == 1){
            return 1;
        }

        if (m==1 || n ==1){
            if (m==1){
                return n;
            }else {
                return m;
            }
        }



        if (m==n){
            return 1;
        }

        int count1 = 0 ;
        int count2 = 0;
        int count3 = 0 ;
        for (int i = n; i>=1; i++){
            if (i == n){
                if (i <= m) {
                    if (m-n <= n) {
                        count1 += dfs(m - n, n) + 1;
                    } else {
                        count1 += dfs(n, m-n) + 1;
                    }
                }
            } else {
                //count2 += Math.min(dfs(n-i, m)+dfs(i, m-i), dfs(n-i, i)+dfs(n, m-i));
            }
//            System.out.println("count1 "+count1);
//            System.out.println("count2 "+count2);
//            count3 = Math.min(count1, count2);
//            System.out.println("count3 "+count3);
        }

        return count1;
    }
}
