package patterns.mock;

public class IsPowerOfTwo {
    public static boolean isPowerOfTwo(int n) {

        return isPowerOfTwoRecursive(n);
    }

    public static boolean isPowerOfTwoRecursive(int n){
        if (n==0){
            return false;
        }
    if (n==1){
        return true;
    }
    if (n==2){
        return true;
    }

    return (n%2==0) && isPowerOfTwoRecursive(n/2);

    }

    public static void main(String[] args){
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(218));
    }
}
