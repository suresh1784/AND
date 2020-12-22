package patterns.calculator;

//https://leetcode.com/problems/basic-calculator-iii/discuss/113592/Development-of-a-generic-solution-for-the-series-of-the-calculator-problems

import netscape.security.UserTarget;

import java.util.Stack;

public class BasicCalculator {

    public class Pair {
        int val;
        boolean isBrace;
        char operator;

        public Pair(int val){
            this.val = val;
            this.isBrace = false;
            operator = '+';

        }

        public Pair(char operator){
            this.val = 0;
            this.isBrace = true;
            this.operator = operator;
        }
    }

    public int calculate(String s) {
        char operator = '+';
        int val = 0 ;
        int len = s.length();
        Stack<Pair> stack = new Stack<>();
        for (int i = 0 ; i < len ; i++){
            char ch = s.charAt(i);
            if (Character.isWhitespace(ch) && (i!=len-1)){
                continue;
            }
            if (Character.isDigit(ch)){
                val = (val*10)+int2Char(ch);
            }

            if (!Character.isDigit(ch) || (i==len-1)){

                if (ch=='('){
                    stack.push(new Pair(operator));
                    operator ='+';
                    continue;
                }

                if (operator=='+'){
                    stack.push(new Pair(val));
                }

                if (operator=='-'){
                    stack.push(new Pair(-1*val));
                }


                if (ch==')'){
                    int res = 0 ;
                    while(!stack.isEmpty() && !stack.peek().isBrace){
                      res += stack.pop().val;
                    }
                   char op = stack.pop().operator;
                    if (op=='-'){
                        stack.push(new Pair(-1*res));
                    }else {
                        stack.push(new Pair(res));
                    }
                }


                    operator = ch;
                    val = 0;

            }
        }

        int result = 0;
        while (!stack.isEmpty()){
            result += stack.pop().val;
        }
    return result;
    }

    public char int2Char(int val){
        return (char) (val-'0');
    }

    public static void main(String[] args) {
        BasicCalculator obj = new BasicCalculator();
        String s1 = "1 + 1";
        System.out.println(s1+ " -- > "+obj.calculate(s1) );

        String s2 = " 2-1 + 2 ";
        System.out.println(s2+ " -- > "+obj.calculate(s2) );


        String s3 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(s3+ " -- > "+obj.calculate(s3) );
        String s4 = "2147483647";
        System.out.println(s4+ " -- > "+obj.calculate(s4) );
        String s5 =
                "2-(5-6)";
        System.out.println(s5+ " -- > "+obj.calculate(s5) );

    }
    public int calculate1(String s) {
        char operator = '+';
        int currentNumber = 0;
        boolean isOperator = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if (Character.isWhitespace(ch) && i!= s.length()-1){
                continue;
            }

            if (Character.isDigit(ch)){
                currentNumber = (currentNumber*10)+ (ch-'0');
            }

            if (!Character.isDigit(ch) || i==s.length()-1){

                if (ch == '('){
                    stack.push(ch);
                    continue;
                }

                if (operator == '+'){

                    stack.push((char)(currentNumber+'0'));
                }

                if (operator =='-'){

                    stack.push((char)((-1*currentNumber)+'0'));
                }

                if (ch == ')'){
                    int res = 0 ;
                    while (!stack.isEmpty() && stack.peek()!='('){
                        int val = stack.pop()-'0';
                        res += val;
                    }
                //    System.out.println(res);
                    stack.pop();
                    stack.push((char)(res+'0'));
                }
                if (i!= s.length()-1) {
                    isOperator = true;
                    operator = ch;
                    currentNumber = 0;
                }
            }
        }
        if (!isOperator){
            return currentNumber;
        }
        int result = 0 ;
        while (!stack.isEmpty()){
            int val = stack.pop()-'0';
            result += val;
        }

        return result;
    }



}
