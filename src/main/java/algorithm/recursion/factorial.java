package algorithm.recursion;

public class factorial {

    public static void main(String[] args){
        int n = 10 ;
        int factorialLinear = factorialLinear(10);
        int factoricalTail = factorialTail(10);
        System.out.println("Linear :  "+factorialLinear);
        System.out.println("Tail :  "+factoricalTail);

    }

    public static int factorialLinear(int n){
        if (n==0 || n==1){
            return 1;
        }
        return n*factorialLinear(n-1);
    }



    public static int factorialTail(int n){
        int a ;
        return f1(n,1);
    }

    public static int f1(int a, int b ){
        if (a==1 ||a==0){
            System.out.println(b);
            return b;
        }

        return f1(a-1, a*b);
    }


}
