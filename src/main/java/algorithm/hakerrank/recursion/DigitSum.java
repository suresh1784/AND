package algorithm.hakerrank.recursion;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DigitSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = "861568688536788";
        int k = 100000;
        int result = digitSum(n, k);
        System.out.println(result);
        in.close();
    }

    static int digitSum(String n, int k) {
        // Complete this function
        String regex = "[0-9]+";
        if (n != null && n.matches(regex) && k>0) {
            BigInteger sum = new BigInteger(n) ;
            sum = sum.multiply(new BigInteger(String.valueOf(k)));
            return superDigit(sum).intValue();
        }else
        {
            return 0;
        }
    }

        static BigInteger superDigit(BigInteger num) {

        if (num.compareTo(new BigInteger("10")) == -1) {
            return num;
        }
        BigInteger l = new BigInteger("0");
         l =  num.mod(new BigInteger("10")).add( superDigit(num.divide(new BigInteger("10"))));
         if (l.compareTo(new BigInteger("10")) == -1) {
             return l;
         }else {
             l =  (l.mod(new BigInteger("10")).add(superDigit(l.divide(new BigInteger("10")))));
             return l;
         }


        }//


}
