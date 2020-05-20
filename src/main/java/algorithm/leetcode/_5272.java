package algorithm.leetcode;

import java.util.Arrays;
import java.util.*;

public class _5272 {
    public static void main (String[] args ){
        int[][] grid1 = {{},{}};
        int[][] grid2 = {{},{}};
        int[][] grid3 ={{1,1,1,0},
                        {0,1,0,0},
                        {0,1,0,0},
                        {0,0,0,1}};
        int[][] grid4 = {{0,0,1,0,1},
                         {0,1,0,1,0},
                         {0,1,1,1,0},
                         {1,0,0,1,1},
                         {0,0,1,1,0}};

        System.out.println(countServers(grid3));
    }


    public static int countServers(int[][] grid) {
    int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int count = 0 ;
        Integer[][] visited = new Integer[m][n];
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (grid[i][j]==1 && visited[i][j]==null) {
                    int currCount = bfs(grid, i, j, visited) ;
//                    System.out.println(" i , j " + i + " " + j);
//                    System.out.println("currCount " + currCount);
                    if (currCount >1)
                    count = count + currCount;
                }
            }
        }
        return count;
    }




    public static int bfs (int[][] grid , int i , int j , Integer[][] visited) {
    Queue<Coordinates> q = new LinkedList<>();
    q.offer(new Coordinates(i, j));
    visited[i][j]= 1;
    int count = 1;
    while (!q.isEmpty()){
        Coordinates top = q.poll();
        int x = top.x;
        while (x < grid.length){
            if (grid[x][top.y]== 1 && visited[x][top.y]== null){
                count++;
                visited[x][top.y]=1 ;
//                System.out.println("--------------------------- ");
//                System.out.println("x "+ x);
//                System.out.println("top.y  "+ top.y);
//                System.out.println("--------------------------- ");
                q.offer(new Coordinates(x, top.y));
            }
            x++;
        }
        x--;
        while (x >=0){
//            System.out.println("???????--------------------------- ");
//            System.out.println("x "+ x);
//            System.out.println("top.y  "+ top.y);
//            System.out.println("--------------------------- ");
            if (grid[x][top.y]== 1 && visited[x][top.y]== null){
                count++;
                visited[x][top.y]=1 ;

                q.offer(new Coordinates(x, top.y));
            }
            x--;
        }
        x++;
        int y = top.y;
        while (y < grid[0].length){
            if (grid[top.x][y]== 1 && visited[top.x][y]== null){
                count++;
                visited[top.x][y]=1 ;
//                System.out.println("--------------------------- ");
//                System.out.println("top.x "+ top.x);
//                System.out.println("y  "+ y);
//                System.out.println("--------------------------- ");
                q.offer(new Coordinates(top.x, y));
            }
            y++;
        }
        y--;
        while (y >= 0 ){
            if (grid[top.x][y]== 1 && visited[top.x][y]== null){
                count++;
                visited[top.x][y]=1 ;
//                System.out.println("--------------------------- ");
//                System.out.println("top.x "+ top.x);
//                System.out.println("y  "+ y);
//                System.out.println("--------------------------- ");
                q.offer(new Coordinates(top.x, y));
            }
            y--;
        }
        y++;
    }
    return count;
    }

    public static class Coordinates {
        int x;
        int y;

        Coordinates(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
