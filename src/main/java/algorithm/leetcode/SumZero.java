package algorithm.leetcode;

public class SumZero {
    public static int[] sumZero(int n) {
        int[] result = new int[n];
        int count = 1 ;
        int m = 0 ;
        if (n%2==0){
            m = n;
        }else {
            m = n-1;
            result[n-1] = 0 ;
        }

        for (int i = 0 ; i < m ; i=i+2){
            result[i] = count;
            result[i+1] = -count;
            count++;
        }

        return result;
    }

    public static void main(String[] args){
        int n = 1;
       int[] result = sumZero(n);
       for (int i : result){
           System.out.println(i);
       }
    }
}
