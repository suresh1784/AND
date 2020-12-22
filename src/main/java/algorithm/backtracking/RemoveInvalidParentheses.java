package algorithm.backtracking;
import java.util.*;
import java.util.stream.Collectors;

public class RemoveInvalidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int openCount = 0;
        int closeCount = 1;

        String braces = "(()()))()";
        helper(braces, 0, openCount, closeCount ,  result );
        Set<String> set = new HashSet<>(result);
        System.out.println(result);
        return set.stream().collect(Collectors.toList());
    }

    static void helper(String braces, int i , int openCount, int closedCount, List<String> result){
        if (openCount==0 && closedCount ==0){
            if (isValid(braces))
            result.add(braces);
            return;
        }

        if (i>=braces.length()){
            return;
        }

        if (braces.charAt(i)!= '('|| braces.charAt(i)!=')'){
            helper(braces, i+1, openCount, closedCount, result);
        }

        String s = braces.substring(0, i) + braces.substring(i + 1);
        if (braces.charAt(i)=='(' && openCount>0){
                String val = s;
                helper(val, i, openCount-1, closedCount, result);
        }

        if (braces.charAt(i)==')' && closedCount>0){
                String val =s;
                helper(val, i, openCount, closedCount-1, result);
        }
    }

   static boolean isValid(String braces){
        int count = 0 ;
        int i = 0 ;
        while (i<braces.length()){
            if (braces.charAt(i) == '(') {
                count++;
            }else if (braces.charAt(i) == ')'){
                if (count >0){
                    count--;
                }else{
                    return false;
                }
            }
            i++;
        }

        return count==0;
    }

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses(""));
        System.out.printf(""+isValid("()(())"));
    }
}
