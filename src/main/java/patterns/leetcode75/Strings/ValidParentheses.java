package patterns.leetcode75.Strings;
import java.util.*;
public class ValidParentheses {
    public static boolean isValid(String s) {
    Map<Character, Character> map = new HashMap<>();
    map.put('}','{');
        map.put(']','[');
        map.put(')','(');
    Stack<Character> stack = new Stack<>();
    for (char ch : s.toCharArray() ){
        if (!map.containsKey(ch)){
            stack.push(ch);
        }else{
                if (stack.isEmpty() || stack.pop()!=map.get(ch)){
                    return false;
                }
        }
    }
    return stack.isEmpty();
    }

    public static void main(String[] args){
        String in = "]";
        System.out.println(isValid(in));
    }
}
