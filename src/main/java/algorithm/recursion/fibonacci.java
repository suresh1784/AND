package algorithm.recursion;

public class fibonacci {
    public static void main (String[] args){
int fibLinear = fibLinear(10);
int fibTail = fibTail(10);
int fibNested = fnested(10,0,"main");
  //      System.out.println("fibLinear :  "+fibLinear);
    //    System.out.println("fibTail :  "+fibTail);
        System.out.println("fibNested :  "+fibNested);
    }


     static int fibLinear(int n){
        if (n==0){
            return 0;
        }

        if (n==1){
            return 1;
        }

        return fibLinear(n-1)+fibLinear(n-2);
     }

     static int fibTail(int n){
        return f1(n,0,1);
     }

    static int f1(int n, int a, int b )
    {

        if (n == 0) {
            System.out.println("a "+a);
            return a;
        }
        if (n == 1) {

            System.out.println("b "+b);
            return b;
        }
        return f1(n - 1, b, a + b);
    }


    static int fnested(int n, int s, String call){
        if (n==1 || n==2){
            System.out.println("Source base >> "+ call);
            System.out.println("s >> : "+ s);
            return 1+s;
        }
        System.out.println("Source  >> "+ call);
        return fnested(n-1, s+fnested(n-2,0, "fn"),"f1");

    }


}
