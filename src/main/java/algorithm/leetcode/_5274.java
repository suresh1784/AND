package algorithm.leetcode;

import java.util.Arrays;

public class _5274 {
    public static void main(String[] args){

        System.out.println(numWays(4,3));
    }

    public static int numWays(int steps, int arrLen) {
        Integer[][] a = new Integer[steps+1][arrLen+1];
        return numWaysRecursive(steps, arrLen, 0, a);
    }

    public static int numWaysRecursive(int steps, int arrLen, int pos, Integer[][] a){
        if (a[steps][pos]!= null){
            return a[steps][pos];
        }

        if (steps == 0 && pos == 0 ){
            return 1;
        }

        if (steps == 0){
            return 0;
        }

        int count = 0 ;
        for (Coordinates next : Arrays.asList(new Coordinates(pos+1),new Coordinates(pos-1), new Coordinates(pos) )){
            if (next.x >= 0 && next.x < arrLen){
                count += numWaysRecursive(steps-1, arrLen, next.x, a);
            }
        }
        a[steps][pos] =  count;
        return count;
    }

    public static class Coordinates {
        int x;
        Coordinates(int x){
            this.x = x;
        }
    }
}
