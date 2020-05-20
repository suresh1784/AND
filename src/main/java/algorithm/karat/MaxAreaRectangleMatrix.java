package algorithm.karat;

import java.util.*;

public class MaxAreaRectangleMatrix {
    public static void main(String args[]){
        int input[][] = {{1,1,1,0},
                {1,1,1,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,0,1},
                {1,1,1,1}};

        int maxRectangle = maxArea(input);
        System.out.println("Max rectangle is of size " + maxRectangle);
        assert maxRectangle == 8;
    }

    public static int maxArea(int[][] input){
    int maxArea = 0 ;
    List<Integer> temp = new ArrayList<>();
    int m = input.length;
    int n = input[0].length;
    for (int i = 0 ; i < m; i++){
        for(int j = 0 ; j < n; j++){
            if (input[i][j]==0){
                if (i==0){
                    temp.add(0);
                }
                 temp.set(j,0);
            } else {
                if (i==0){
                    temp.add(input[i][j]);
                }
                temp.set(j , temp.get(j)+input[i][j]);
            }
        }// inner for
        int area = findArea(temp);
        maxArea = Math.max(area, maxArea);
    }

    return maxArea;
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
