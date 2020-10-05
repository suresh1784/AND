package algorithm.leetcode;

public class MinOperations1 {
    public static int minOperations(String[] logs) {
        int count = 0 ;
        for (String log : logs){
            if (log.equals("../") && count> 0){
                count--;
            }else if (log.equals("../")){
                continue;
            }
            else if (log.equals("./")){
                continue;
            }else {
                count++;
            }
        }
        return count;
    }
//["./","../","./"]
    public static void main(String[] args) {
String[] in = {"./","../","./"};
        System.out.println(minOperations(in));
    }
}
