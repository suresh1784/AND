package algorithm.hakerrank.recursion;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArithmeticExpression {
static String res = null;
    static String arithmeticExpressions(int[] arr) {
        // Complete this function

        String expression = ""+arr[0];
        int value = arr[0];
        arithmeticExpression(arr, expression, value, 1);
        return res;


    }

    static Boolean arithmeticExpression1(int[] arr, String expression , int val, int pos){
        if (pos == arr.length ){
            if (val ==0){
                System.out.println("expression " +expression);
                res = expression;
                return true;
            }else {
                return false;
            }
        }

        if (pos > arr.length-1){
            return false;
        }



        else {

            if (arithmeticExpression(arr, (expression!=null ? (expression + " + " + arr[pos]) :  ""+ arr[pos]), (val + arr[pos])%101, pos + 1)) {
                return true;
            }
            if (arithmeticExpression(arr, (expression!=null ? (expression + " - " + arr[pos]) :  ""+ arr[pos]), (val - arr[pos])%101, pos + 1)) {
                return true;
            }
            if (arithmeticExpression(arr, (expression!=null ? (expression + " * " + arr[pos]) :  ""+ arr[pos]), (val * arr[pos])%101, pos + 1)) {
                return true;
            }
        }

            return false;

    }

    static Boolean arithmeticExpression(int[] arr, String expression , int val, int pos){
        if (pos == arr.length ){
            if (val ==0){
                //System.out.println("expression " +expression);
                res = expression;
                return true;
            }else {
                return false;
            }
        }

        if (pos > arr.length-1){
            return false;
        }



        else {

            if (arithmeticExpression(arr, (expression!=null ? (expression + " + " + arr[pos]) :  ""+ arr[pos]), (val + arr[pos])%101, pos + 1)|| (arithmeticExpression(arr, (expression!=null ? (expression + " - " + arr[pos]) :  ""+ arr[pos]), (val - arr[pos])%101, pos + 1) || (arithmeticExpression(arr, (expression!=null ? (expression + " * " + arr[pos]) :  ""+ arr[pos]), (val * arr[pos])%101, pos + 1)))) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {


        int[] arr = {55, 3, 45 ,33 ,25};

        String result = arithmeticExpressions(arr);
        System.out.println(result);

    }


}
