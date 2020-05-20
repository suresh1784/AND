package patterns.DFS;
import java.util.*;
public class RemoveInvalidParentheses {

    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        removeInvalidParentheses(s,result);
        return result;
    }


    static void removeInvalidParentheses(String s, List<String> result){
        if (isValid(s)){
            if (!result.contains(s)){
                if (result.size()==0) {
                    result.add(s);
                }else {
                    if (result.get(0).length() == s.length()){
                        result.add(s);
                    }
                    if (result.get(0).length() < s.length()){
                        result.clear();
                        result.add(s);
                    }
                }
            }

            return;
        }

        for (int i = 0 ; i < s.length() ; i++){
            String temp = s.substring(0,i)+s.substring(i+1);
          //  System.out.println("temp "+temp);
            removeInvalidParentheses(s.substring(0,i)+s.substring(i+1), result );
        }
    }






    static boolean isValid(String s){
        int count = 0 ;
        for (char ch : s.toCharArray()){
            if (ch == '('){
                count++;
            }else if (ch == ')'){
                count --;
            }

            if (count <0){
                return false;
            }
        }

        return count ==0;
    }


    public static List<String> bfs(String s) {
    List<String> result = new ArrayList<>();
    Queue<String> q = new LinkedList<>();
    q.offer(s);

    while(!q.isEmpty()){
        String top = q.poll();
        if (isValid(top)) {
            if (result.size() == 0)
                result.add(top);

            if (result.size() > 0) {
                if (top.length() == result.get(0).length()) {
                    if(!result.contains(top))
                    result.add(top);
                } else {

                    break;
                }
            } // if
        }
            for (int i = 0 ; i < top.length() ; i++){
                String temp = top.substring(0,i)+top.substring(i+1);
                System.out.println(temp);
                q.offer(temp);
            }

    }

    return result;
    }

    public static void main(String[] args){
        System.out.println("Recursive "+removeInvalidParentheses("()())()"));
        System.out.println("BFS "+bfs("()())()"));
    }
}
