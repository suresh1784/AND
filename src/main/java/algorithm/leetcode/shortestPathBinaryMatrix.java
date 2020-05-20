package algorithm.leetcode;

import java.util.*;

public class shortestPathBinaryMatrix {


    public static int shortestPathBinaryMatrix(int[][] grid) {

    Queue<Coordinates> q = new LinkedList<>();
    q.offer(new Coordinates(0,0, 1 ));
    int minPath = 0 ;

    int m = grid.length-1;
        if (m==0 ){
            return -1;
        }
    int n = m==0? 0 : grid.length-1;

        if (m==0 || n == 0 ){
            return -1;
        }

        if (grid[0][0]==1){
            return -1;
        }
    Boolean[][] visited = new Boolean[m+1][n+1];


    visited[0][0] = true;
    while (!q.isEmpty()){
        Coordinates top = q.poll();
        if (top.r == m && top.c == n){
            return top.length;
        }

        int x = top.r;
        int y = top.c;
        int length = top.length;

        for (Coordinates next : Arrays.asList(new Coordinates(x+1, y), new Coordinates(x, y+1), new Coordinates(x, y-1), new Coordinates(x-1, y),
                                     new Coordinates(x+1, y+1), new Coordinates(x-1, y-1), new Coordinates(x+1, y-1), new Coordinates(x-1, y+1))){

            if (next.r >= 0 && next.r <= m && next.c >= 0 && next.c <=n && visited[next.r][next.c]== null && grid[next.r][next.c]==0){
                visited[next.r][next.c]= true;
                q.offer(new Coordinates(next.r,next.c, length+1));
            }

        }


    }

    return -1;
    }


    /**
     * Coordinates Class
     */
    public static class Coordinates{
        Integer r;
        Integer c;
        Integer length;
        public Coordinates(int r, int c, int length){
            this.r = r;
            this.c = c;
            this.length = length;
        }

        public Coordinates(int r, int c){
            this.r = r;
            this.c = c;
        }
    }


    public static void main(String[] args){
    int[][] input1 = {{0,1},{1,0}};
    int[][] input2 =   {{0,0,0},{1,1,0}, {1,1,0}};
        System.out.println("Result Input1 "+shortestPathBinaryMatrix(input1));
        System.out.println("Result Input1 "+shortestPathBinaryMatrix(input2));
    }


}


