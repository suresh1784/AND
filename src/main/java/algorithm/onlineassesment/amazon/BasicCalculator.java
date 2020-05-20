package algorithm.onlineassesment.amazon;
import java.util.*;
public class BasicCalculator {
    public int basicCalculator(String in){
        Stack<String> number = new Stack<>();
        Stack<Character> operator = new Stack<>();

        String[] split =in.split(" ");

        for (String s : split){
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                operator.push(s.charAt(0));
            }else if (s.equals(")")){
                Character oper = operator.pop();
                int add  = 0 ;
                int mul = 1;
                while (!number.isEmpty()){
                   String top = number.pop();
                   if (top.equals("(")){
                       if (oper.equals('*') || oper.equals('/')){
                           number.push(Integer.toString(mul));
                       }else {
                           number.push(Integer.toString(add));
                       }
                       break;
                   }else {
                       if (oper.equals('*') || oper.equals('/')){
                           mul*= Integer.parseInt(top);
                       }else {
                           add+= Integer.parseInt(top);
                       }
                   }

                }
            }else {
                number.push(s);
            }
        }

        return Integer.parseInt(number.pop()) ;
    }


}
