package patterns.leetcode75.DyanamicProgramming;

public class UniquePaths {
    public static int uniquePaths(int m, int n) {


        if (m==0 ||  n==0){
            return 1;
        }


        int left =  m==0 ?0: uniquePaths(m , n-1);
        int right = n==0 ?0: uniquePaths(m-1, n);
        return left+right;
    }


    public static void main(String[] args){
        int m = 7;
        int n = 3;
        System.out.println(uniquePaths(m-1,n-1));
    }

}
