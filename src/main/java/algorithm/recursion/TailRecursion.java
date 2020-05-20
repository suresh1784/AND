package algorithm.recursion;

public class TailRecursion {

    public static void main(String[] args){
        Boolean b = isDigitLinear(12345, 5);
        System.out.println(b);
        Boolean c = isDigitTail(12345, 5);
        System.out.println(c);

    }

    static boolean isDigitLinear(int n, int d){
        if (n<10){

            return (n==d);
        }
        System.out.println("L n : " +n);
        return ((n%10 == d) | isDigitLinear(n/10, d));
    }


    static boolean isDigitTail(int n, int d){
        if (n<10){

            return (n==d);
        }

        if ((n%10 == d)){
            return true;
        }
        System.out.println("T n : " +n);
        System.out.println("(n%10 == d) "+(n%10 == d));
        return (isDigitTail(n/10, d));
    }
}
