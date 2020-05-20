package algorithm.backtracking;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args){
        String input = "((1+2)+3)+5";
        int reuslt = calculate(input);
        System.out.println(reuslt);;
    }


    static int calculate (String s){
        if (s.isEmpty() || s== null){
            return 0;
        }
        int sum = 0 ;
        if (s.contains("(") || s.contains(")")){
            String oldString = s;
            int start = s.indexOf("(");
            int end = s.lastIndexOf(")");

            System.out.println("start "+start  + " end  "+ end );
            String temp = s.substring(start+1,end);
            System.out.println("temp  "+ temp);
            int m = calculate(temp);
            System.out.println("m "+m);
            sum= calculate(oldString.substring(0,start)+m+oldString.substring(end+1, s.length()));
            System.out.println("n "+sum);

        }else {
            return evaluate(s);
        }

        return sum;
    }

    static int evaluate (String s){
        System.out.println("Inside evaluate "+ s);
        if (s.length() < 2){
            return Integer.parseInt(s);
        }
        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()){
            if (Character.isDigit(c)){
                if (!stack.isEmpty()){

                    if (stack.peek().equals('+') || stack.peek().equals('-')){
                        char operator =  stack.pop();
                        char value1 = stack.pop();
                        if (operator == '+'){
                            int sum = Character.getNumericValue(value1) + Character.getNumericValue(c);
                            stack.push((char)sum);
                        }
                    }
                }else {
                    stack.push(c);
                }
            }else {
                stack.push(c);
            }

        }

        return stack.pop();
    }
}
