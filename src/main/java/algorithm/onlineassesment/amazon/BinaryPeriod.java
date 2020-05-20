package algorithm.onlineassesment.amazon;

public class BinaryPeriod {
    public static int binaryPeriod(int n){
        int[] d = new int[30];
        int i = 0 ;
        while (n>0 ){
            d[i]= n%2;
            n=n/2;
            i++;
        }

        System.out.println(d);
        int left = 0 ;
        int right = 1;
        int temRight = 1;
        while (right < d.length){
            if (d[left]==d[right]){
                left++;
                right++;
            }else {
                right = temRight+1;
                temRight = right;
                left =0;
            }
        }

        return temRight+1;
    }

    public static void main(String[] args) {
        System.out.printf("Result "+binaryPeriod(955));
    }
}
