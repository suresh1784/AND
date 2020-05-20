package algorithm.karat;

import java.util.*;

public class MaximumRectagleHistogram {
    public static void main(String[] args){
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,2,3,4,3,2,0,1));
        System.out.println(findArea(input));

    }


    static int findArea(List<Integer> input){
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < input.size(); i ++ ){
            if (!stack.isEmpty()){
                int peek = stack.peek();
                int curr = input.get(i);

                if (peek <= curr){
                    stack.push(i);
                }else {
                    while (stack.peek() > curr) {
                        int currIndex = stack.pop();
                        int width = i - currIndex;
                        int height = input.get(currIndex);
                        int area = height * width;
                        maxArea = Math.max(maxArea, area);
                    }
                    stack.push(i);
                }

            }else {
                stack.push(i);
            }
        }

        return maxArea;
    }
}
