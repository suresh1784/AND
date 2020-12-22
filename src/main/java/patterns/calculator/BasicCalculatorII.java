package patterns.calculator;

import java.util.Stack;
//https://leetcode.com/problems/basic-calculator-iii/discuss/113592/Development-of-a-generic-solution-for-the-series-of-the-calculator-problems
public class BasicCalculatorII {
    public int calculate(String s) {
    int result = 0 ;
    char operator = '+';
    int currentNumber = 0;
    if (s.length()==0 || s == null){
        return currentNumber;
    }
    Stack<Integer> stack = new Stack<>();
    for (int i = 0 ; i < s.length() ; i++){
        char ch = s.charAt(i);
        if (Character.isWhitespace(ch) && i != s.length()-1){
            continue;
        }
        if (Character.isDigit(ch)){
            currentNumber = (currentNumber*10)+ (ch-'0');
        }

        if (!Character.isDigit(ch) || i == s.length()-1){

            if (operator =='+'){
                stack.push(currentNumber);
            }

            if (operator =='-'){
                stack.push(-currentNumber);
            }

            if (operator == '/'){
                stack.push(stack.pop()/currentNumber);
            }

            if (operator == '*'){
                stack.push(stack.pop()*currentNumber);
            }

            if (i!= s.length()-1)
            operator = ch;

            currentNumber = 0 ;
        }
    }


    while (!stack.isEmpty()){
        result += stack.pop();
    }

    return result;
    }

    public static void main(String[] args) {
        BasicCalculatorII obj = new BasicCalculatorII();
//        String s1 = "43+2*4";
//        System.out.println( s1 + " " + obj.calculate(s1));
//        String s2 = "13/2";
//        System.out.println( s2 + " " + obj.calculate(s2));
//        String s3 = " 3+5 / 2 ";
//        System.out.println( s3 + " " + obj.calculate(s3));
        String s4 = " 3/2 ";
        System.out.println( s4 + " " + obj.calculate(s4));

    }
}
