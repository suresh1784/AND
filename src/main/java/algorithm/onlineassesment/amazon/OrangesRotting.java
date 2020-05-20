package algorithm.onlineassesment.amazon;

import java.util.*;

public class OrangesRotting {
    private static  class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static class Level{
        Coordinate c;
        int level ;
        public Level(Coordinate c , int level ){
            this.c = c;
            this.level = level;
        }
    }
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 ){
            return 0;
        }
        Queue<Level> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (grid[i][j]==2){
                    q.offer(new Level(new Coordinate(i,j),0));
                }
            }
        }
        int time = 0;
        while (!q.isEmpty()){
            Level top = q.poll();
            if (top.level > time){
                time = top.level;
            }

            int x = top.c.x;
            int y = top.c.y;

            for (Coordinate next : Arrays.asList(new Coordinate(x+1, y), new Coordinate(x, y+1),
            new Coordinate(x-1, y), new Coordinate(x, y-1))){
                if (next.x>=0 && next.x< m && next.y >=0 && next.y < n && grid[next.x][next.y]==1){
                    grid[next.x][next.y]= 2;
                    q.offer(new Level(next,top.level+1));
                }
            }
        }

        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (grid[i][j]==1){
                    return -1;
                }
            }
        }

    return  time;
    }
}
