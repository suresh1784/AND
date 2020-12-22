package algorithm.leetcode;

public class GetMaximumGenerated {
    public int getMaximumGenerated(int n) {
        int[] m = new int[n+1];
        int max = 1 ;
        if (n==0){
            return 0;
        }

        if (n==1){
            return 1;
        }
        m[0] = 0;
        m[1] = 1;
        for (int i = 2; i <= n ; i++ ){
            if (i%2==0){
              m[i]=m[i/2];
            }else {

              m[i]= m[i/2]  +m[(i/2)+1];
            }

            max = Math.max(max, m[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int n1 = 7;
        int n2 = 2;
        int n3 = 3;
        GetMaximumGenerated get = new GetMaximumGenerated();
        int[] num = {n1, n2, n3};
        for (int n : num){
            System.out.println(n+"  "+get.getMaximumGenerated(n));
        }
    }
}
