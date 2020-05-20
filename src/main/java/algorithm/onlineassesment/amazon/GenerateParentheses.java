package algorithm.onlineassesment.amazon;
import java.util.*;
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("",n,n,result);
        System.out.println(result);
        return result;
    }

    private void dfs(String str, int left , int right, List<String> result){
        if (right ==0 ){
            result.add(str);
            return;
        }

        if (left >0){
            dfs(str+"(", left-1, right, result);
        }

        if (right > left){
            dfs(str+")", left, right-1, result);
        }
    }
}
