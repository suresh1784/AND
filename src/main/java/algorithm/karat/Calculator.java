package algorithm.karat;

import java.io.*;
import java.util.*;

/*


You are building an educational website and want to create a simple calculator for students to use. The calculator will only allow addition and subtraction of non-negative integers.

We also want to allow parentheses in our input. Given an expression string using the "+", "-", "(", and ")" operators like "5+(16-2)", write a function to parse the string and evaluate the result.

Sample output:
  calculate("5+16-((9-6)-(4-2))+1") => 21
  calculate("22+(2-4)") => 20
  calculate("6+9-12") => 3
  calculate("((1024))") => 1024


 */




class Calculator {


    public static int calculate(String input){

        // operator

        // get the digit

        char[] inChar = input.toCharArray();
        int length = inChar.length;
        int value  = 0 ;
        Stack<Integer> NumStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();

        int result = 0 ;
        int temp = 0 ;
        char operator = 'a';


        for (int i = 0 ; i < length ; i++){

            if (Character.isDigit(inChar[i])){
                int val = inChar[i] -'0';
                //   System.out.println("val "  +val );
                temp = temp*10 + val;

            }else {
                System.out.println("temp "  +temp );
                if (operator == '+'){
                    result = result + temp ;
                } else if (operator == '-'){
                    result = result - temp;
                }else {
                    result = temp;
                }

                temp = 0 ;
            } // temp = 100

            if (inChar[i]== '+'){
                operator = '+';

            } //

            if (inChar[i]== '-'){
                operator = '-';

            }// if

            if (inChar[i]== '('){ // result = 21 operator = -


                NumStack.push(result);
                operStack.push(operator);
                result = 0 ;
                operator = '+';
            }

            if (inChar[i]== ')'){
                //  result = 3
                while (!NumStack.isEmpty()){
                    char temOper = operStack.pop();
                    int tempVal = NumStack.pop();
                    if (temOper =='+'){
                        result = result + tempVal ;
                    }else if (operator == '-'){
                        result = result - tempVal;

                    }else{
                        result = temp;

                    }// else
                }// While
            }

        }// for

        //  System.out.println(temp);
        NumStack.push(temp);
        if (operator == '+'){
            result = result + temp ;
        } else if (operator == '-'){
            result = result - temp;

        }else{
            result = temp;
        }






        //   System.out.println("result " +result );
        return result ;
    }//calculate


// calculate("5+16-((9-6)-(4-2))+1") => 21
//  calculate("22+(2-4)") => 20
//  calculate("6+9-12") => 3
//  calculate("((1024))") => 1024


    public static void main(String[] args) {
        String expression2_1 = "5+16-((9-6)-(4-2))+1";
        String expression2_2 = "22+(2-4)";
        String expression2_3 = "6+9-12";
        String expression2_4 = "((1024))";
        int result = calculate(expression2_4);
        System.out.println(result);

    }
}
