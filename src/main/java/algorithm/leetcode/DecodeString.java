package algorithm.leetcode;
import java.util.*;
public class DecodeString {
    static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        int num = -1 ;

        for (int i = 0 ; i < s.length(); i++){
            char ch1 = s.charAt(i);
            String ch = ch1+"";
            if (Character.isAlphabetic(ch1)){
                stack1.push(ch);
            }else if (Character.isDigit(ch1)){
                stack2.push(ch);
            } else if (ch1 == '['){
                stack1.push(ch);
                stack2.push(ch);
            }else if (ch1 == ']'){
                // compute
                // get String
                String str = "";
                while (!stack1.isEmpty()){
                    String top = stack1.pop();

                    if (top.equals("[")){
                        break;
                    }
                    str = top+str;
                }
                stack2.pop();
                String numStr = "";
                while (!stack2.isEmpty() && !stack2.peek().equals("[")){
                    String top = stack2.pop();
                    numStr = top+numStr;
                }

                int count = Integer.parseInt(numStr);
                System.out.println(count);
                System.out.println(str);
                StringBuilder temp = new StringBuilder();
                while (count > 0 ){
                    temp.append(str);
                    count--;
                }

                stack1.push(temp.toString());
            }
        }
        System.out.println(stack1);
        StringBuilder result = new StringBuilder();
        while (!stack1.isEmpty()){
            result.insert(0,stack1.pop());
        }

        return result.toString();
    }


    public static void main(String[] args) {
//        System.out.println(decodeString("4[ab]"));
//        System.out.println(decodeString("zz1[ab]yyz"));
        System.out.println(decodeString("zzz2[b3[ab]tt]"));
    }

}
