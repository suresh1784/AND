package algorithm.leetcode;

public class ThousandSeparator {
    public static String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        int r = n%1000;
        int d = n/1000;
        while (d>0){
            String rem = String.format("%3s", Integer.toString(r)).replace(' ', '0');
            sb.insert(0, rem);
            sb.insert(0,'.');
            r = d%1000;
            d = d/1000;
        }

        sb.insert(0,Integer.toString(r));
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(thousandSeparator(987));
        System.out.println(thousandSeparator(1234));
        System.out.println(thousandSeparator(123456789));
        System.out.println(thousandSeparator(0));
        System.out.println(thousandSeparator(1000));
        System.out.println(thousandSeparator(1000000001));

    }
}
