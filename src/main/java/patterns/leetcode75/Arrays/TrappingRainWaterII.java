package patterns.leetcode75.Arrays;

import java.util.*;
public class TrappingRainWaterII {

    public static int trapRainWaterV1(int[][] heightMap) {
        int sum = 0 ; 
        if (heightMap==null || heightMap.length == 0 || heightMap[0].length== 0){
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        int[][] r1 = new int[m][n];
        int currMax = 0 ; 
        for (int i = 0 ; i < m ; i++){
            currMax =0;
            for (int j = 0 ; j < n ; j++){
                int currVal = heightMap[i][j];
                if (currVal > currMax){
                    currMax = currVal;
                }
                
                r1[i][j] = currMax-currVal;
            } // for
            currMax = 0 ;
            for (int j = n-1; j >=0 ; j--){
                int currVal = heightMap[i][j];
                if (currVal > currMax){
                    currMax = currVal;
                }

                r1[i][j] = Math.min(r1[i][j], currMax-currVal);
            }// for 
            
            
        }// for
        
        
        for (int j = 0 ; j < n ; j++){
            currMax = 0;
            for (int i = 0 ; i < m ; i++){
                int currVal = heightMap[i][j];
                if (currVal > currMax){
                    currMax = currVal;
                }
                r1[i][j] = Math.min(r1[i][j], currMax-currVal);
            }
            currMax = 0 ;
            for (int i = m-1; i >=0 ; i--){
                int currVal = heightMap[i][j];
                if (currVal > currMax){
                    currMax = currVal;
                }
                r1[i][j] = Math.min(r1[i][j], currMax-currVal);
                sum += r1[i][j];
            }
        }
        return sum ; 
    }
    public static class Coordinate{
        int height;
        int x ;
        int y ;
        public Coordinate(int x , int y, int height){
         this.x = x;
         this.y = y;
         this.height = height;
        }
    }

    public static int trapRainWater(int[][] heightMap) {
        int sum = 0 ;
        if (heightMap==null || heightMap.length == 0 || heightMap[0].length== 0){
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
    PriorityQueue<Coordinate> q = new PriorityQueue<Coordinate>((a,b)-> Integer.compare(a.height, b.height));
    for (int i = 0 ; i < m ; i++ ){
        for (int j = 0 ; j < n ; j++){
            if (i == 0 || j == 0 || i == m-1 || j == n-1){
                q.offer(new Coordinate(i,j,heightMap[i][j]));
                visited[i][j]= true;
            }
        }
    }// for

     while (!q.isEmpty()){
         Coordinate top = q.poll();
         int height = top.height;
         int x = top.x;
         int y = top.y;
         for (Coordinate next : Arrays.asList(new Coordinate(x+1, y, 0), new Coordinate(x, y+1, 0),
                 new Coordinate(x-1, y, 0),new Coordinate(x, y-1, 0))){
             if (next.x >=0 && next.x< m  && next.y >= 0 && next.y < n && !visited[next.x][next.y]){
                 int nextHeight = heightMap[next.x][next.y];
//                 if (height-nextHeight>0){
//                  //   System.out.println("X "+x + " Y "+ y + " Next x "+ next.x+ " next y "+next.y+" height " +height+  " nextHeight "+nextHeight + " diff "+(height-nextHeight));
//                 }
                 sum += Math.max(0, height-nextHeight);
                 visited[next.x][next.y] = true;
                 next.height = Math.max(height,nextHeight );
                 q.offer(next);
             }
         }
     }

     return sum;
    }

    public static void main(String[] args){
      int[][] height =  {{1,4,3,1,3,2},
              {3,2,1,3,2,4},
              {2,3,3,2,3,1}};
        System.out.println(trapRainWater(height));
    }
}
