package algorithm.recursion;

public class PascalTriangle {

    public static void main(String[]  args){
        pascal(5, 0, 0 );
    }

    static void pascal(int n, int k, int l){
        if (n==1)
        {
            return ;
        }
        for (int i = 0; i <=k; i++){

            System.out.println("value of i : "+i);
            System.out.println("value of n  ---- : "+n);
            pascal(n-1, k+1, l);
        }
    }
}
