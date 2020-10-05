package algorithm.leetcode;
import java.util.*;
public class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> closed = new Stack<>();

        for (int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if (ch=='('){
                open.push(i);
            }else if (ch==')'){
                if (!open.isEmpty()){
                    open.pop();
                }else {
                    closed.push(i);
                }
            }
        }// for

        StringBuilder sb = new StringBuilder();

        for (int i= s.length()-1 ; i >=0 ; i --){
            if (!open.isEmpty() && open.peek()==i){
                open.pop();
                continue;
            }else if (!closed.isEmpty() && closed.peek()==i){
                closed.pop();
                continue;
            } else{
                sb.insert(0, s.charAt(i));
            }


        }

        return sb.toString();
    }
}
