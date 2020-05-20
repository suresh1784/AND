package algorithm.leetcode;

public class _5352 {

    public static String generateTheString(int n) {
        int a = 0;
        int b = 0;
        int c = 0;
        if (n%2==0){
            a = n-1;
             b = 1;
            c = 0 ;
        }else {
             a = n-2;
             b = 1;
            c = 1;
        }

        if (n==0){
            b=0 ;
        }

        if (n==1){
            c=0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < a ; i++){
           sb.append("a");
        }

        for (int i = 0 ; i < b ; i++){
            sb.append("b");
        }

        for (int i = 0 ; i < c ; i++){
            sb.append("c");
        }

        return sb.toString();
    }

    public static void main(String[] args){
        for (int i = 0 ; i <= 500; i++){
            System.out.println( "i " +  i  + " " + generateTheString(i));
        }
    }
}
