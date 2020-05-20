package algorithm.Rally;

import java.math.BigInteger;

public class StringAddition {


    public static String stringAddition(String s1, String s2){
        int len1 = s1.length()-1;
        int len2 = s2.length()-1;
        int carry = 0 ;
        int digit = 0 ;
        StringBuilder sb = new StringBuilder();

        while (len1>=0 || len2>=0){
            int val1 = 0;
            int val2 = 0 ;

            if (len1>=0){
               val1 = Character.getNumericValue(s1.charAt(len1));
               len1--;
            }


            if (len2>=0){
                val2 = Character.getNumericValue(s2.charAt(len2));
                len2--;
            }

            int sum = val1+val2+carry;
            digit = sum%10;
            carry = sum/10;

            sb.insert(0, digit);

        }
        if (carry ==1)
        sb.insert(0, carry);
        return sb.toString();
    }


    public static String stringMultiplication(String num1, String num2){
        StringBuilder sb1 = new StringBuilder();
        sb1.append("0");
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int carry = 0 ;

        for (int i = len1 ; i >=0 ; i--){
            int count = len1-i;
            StringBuilder sb = new StringBuilder();
            while (count > 0) {
                sb.insert(0,0);
                count--;
            }
            int val1 = Character.getNumericValue(num1.charAt(i)); // 3
            for (int j = len2 ; j > 0 ; j--){
                int val2 = Character.getNumericValue(num2.charAt(j)); //154
                int val3 = val1*val2;
                val3 += carry;
                int digit = val3%10;
                carry = val3/10;
                sb.insert(0 , digit);
            }
            System.out.println(sb.toString());
            sb1 = new StringBuilder(stringAddition(sb1.toString(),sb.toString()));

        }


        return sb1.toString();
    }



    public static void main(String[] args){
        String num1 = "2121212121342424";
        String num2 = "42749872184712094172904";


        BigInteger bi1 = new BigInteger(num1);
        BigInteger bi2 = new BigInteger(num2);
        BigInteger bi3 = bi1.multiply(bi2);

        System.out.println(bi3.toString());

        String result = stringAddition(num1, num2);
       // System.out.println(result);

        String multiply = stringMultiplication(num1, num2);
        System.out.println(multiply);

    }



}
