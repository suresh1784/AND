package patterns.calculator;

import java.util.Stack;

public class BasicCalculatorIII {

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
        int currentNumber = 0 ;
        Stack<Pair> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len ; i++){
            char ch = s.charAt(i);

            if (Character.isWhitespace(ch) && (i!=len-1)){
                continue;
            }

            if (Character.isDigit(ch)){
                currentNumber = (currentNumber*10)+(ch-'0');
            }

            if (!Character.isDigit(ch) || i==len-1){
                if (ch =='('){
                    stack.push(new Pair(operator));
                    operator = '+';
                    continue;
                }

                if (operator =='+'){
                    stack.push(new Pair(currentNumber));
                }

                if (operator =='-'){
                    stack.push(new Pair(-1*currentNumber));
                }

                if (operator =='*'){
                    stack.push(new Pair(stack.pop().val*currentNumber));
                }

                if (operator =='/'){
                    stack.push(new Pair(stack.pop().val/currentNumber));
                }

                if (ch ==')'){
                    int res = 0 ;
                    while (!stack.isEmpty() && !stack.peek().isBrace){
                        res += stack.pop().val;
                    }

                    char op = stack.pop().operator;
                    if (op =='+'){
                        stack.push(new Pair(res));
                    }

                    if (op =='-'){
                        stack.push(new Pair(-1*res));
                    }

                    if (op =='*'){
                        stack.push(new Pair(stack.pop().val*res));
                    }

                    if (op =='/'){
                        stack.push(new Pair(stack.pop().val/res));
                    }

                }

                operator = ch;
                currentNumber = 0 ;
            }

        }
        int result = 0 ;
        while (!stack.isEmpty()){
            result+= stack.pop().val;
        }
        return  result;
    }

    public static void main(String[] args) {
        BasicCalculatorIII obj = new BasicCalculatorIII();
        String s1 = "1 + 1";
        System.out.println(s1 + " -->  "+obj.calculate(s1));

        String s2 = " 6-4 / 2 ";
        System.out.println(s2 + " -->  "+obj.calculate(s2));


        String s3 = "2*(5+5*2)/3+(6/2+8)";
        System.out.println(s3 + " -->  "+obj.calculate(s3));


        String s4 = "(2+6* 3+5- (3*14/7+2)*5)+3";
        System.out.println(s4 + " -->  "+obj.calculate(s4));

        String s5 =  "0";
        System.out.println(s5 + " -->  "+obj.calculate(s5));

    }
}
