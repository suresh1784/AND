package algorithm.hakerrank.recursion;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PowerSum {
    static int res = 0;

    static void powerSum(int x, int n, int pos) {
        // Complete this function
        if (x==0 ){

            res++;
            return ;
        }

        if (x<=0){
            return ;
        }

        for (int i = pos; Math.pow(i, n) <= x;i++){
            powerSum(x-((int)Math.pow(i,n)), n, i+1);
        }


    }




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //
//        int X = in.nextInt();
//        int N = in.nextInt();

        int X = 100;
        int N = 3;
        int pos = 1 ;
         powerSum(X, N ,pos);
        System.out.println("result "+res);

        in.close();
    }
}
