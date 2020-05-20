package algorithm.onlineassesment.amazon;
import java.util.*;
public class TimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stackTime = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, 0);
        for (String log : logs){
            String[] sArray = log.split(":");
            if (sArray[1].equals("start")){
                if (stackIndex.empty()){
                    stackIndex.push(Integer.parseInt(sArray[0]));
                    stackTime.push(Integer.parseInt(sArray[2]));
                }else {
                    int currTime = Integer.parseInt(sArray[2]);
                    result[stackIndex.peek()]+= currTime-stackTime.pop();
                    stackIndex.push(Integer.parseInt(sArray[0]));
                    stackTime.push(Integer.parseInt(sArray[2]));
                }
            }else {

                if (stackIndex.peek()== Integer.parseInt(sArray[0])){
                   int currIndex = stackIndex.pop();
                   int currTime = Integer.parseInt(sArray[2]);
                       result[currIndex] += currTime - stackTime.pop() + 1;

                   stackTime.push(Integer.parseInt(sArray[2]));
                }
            }
        }

        return result;
    }
}
