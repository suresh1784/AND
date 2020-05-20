package algorithm.leetcode;

import java.util.Arrays;
import java.util.*;

public class _5383 {
    public static class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numOfWays(int n) {
       int[][] m =  new int [n][3] ;
       Integer[][] dp = new Integer[n+1][4];
       Map<String , Integer> map = new HashMap<>();
       return numOfWays(0, 0 , n, m, map , 0);
    }

    public int numOfWays(int r, int c , int n , int[][] m,  Map<String , Integer> map, int val){
        String str = r+"_"+c+"_"+val;
//        if (map.get(str)!= null){
//            return  map.get(str);
//        }

        if (c==3){
            c=0;
            r++;
            if(r==n){
                return 1;
            }
        }



        int count = 0;
        for (int i : Arrays.asList(1,2,3)){
            if (isValid(m , r, c, i, n)){
                m[r][c]=i;
                count+= numOfWays(r,c+1, n , m,map, i);
                m[r][c]=0;
            }
        }
       // m[r][c]=0;
        //String str = r+"_"+c+"_"+val;
        map.put(str, count);
        return map.get(str);
    }

    public boolean isValid(int[][] m, int r , int c, int val , int n ){
        for (Coordinate next : Arrays.asList(new Coordinate(r+1, c),new Coordinate(r, c+1) ,
        new Coordinate(r-1, c), new Coordinate(r, c-1))){
            if (next.x >= 0  && next.y >= 0 && next.x < n && next.y < 3){
                if (m[next.x][next.y]==val){
                    return false;
                }
            }
        }
        return true;
    }
}
