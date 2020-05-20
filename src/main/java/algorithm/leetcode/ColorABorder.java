package algorithm.leetcode;
import java.util.*;

public class ColorABorder {
    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length;
        int n = 0 ;
        if (m>=1){
            n = grid[0].length;
        }

        int[][] visited = new int[m][n];

        int parentColor = grid[r0][c0];

        if (parentColor == color){
            return grid;
        }

        Queue<Coordinates> q = new LinkedList<>();
        q.offer(new Coordinates(r0,c0));
        if (r0 == 0 || r0 == m-1 || c0 == 0 || c0 == n-1) {
            visited[r0][c0]= 1;
            grid[r0][c0] = color;
        }

        while(!q.isEmpty()) {
        Coordinates top = q.poll();
        int r = top.r;
        int c = top.c;
            for (Coordinates next : Arrays.asList(new Coordinates(r+1,c),new Coordinates(r,c+1),
            new Coordinates(r-1,c),new Coordinates(r,c-1))){
                int x = next.r;
                int y = next.c;
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y]== parentColor && visited[x][y]!= 1){
                    if (x == 0 || x == m-1 || y == 0 || y == n-1) {
                        grid[x][y] = color;
                    }
                    grid[x][y] = color;
                    visited[x][y]= 1;
                 q.offer(next);
                }
            }
        }

    return grid;
    }


    public static class Coordinates {
        int r;
        int c;

        public Coordinates(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args){
        int[][] grid = {{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}};
        int r = 1 ;
        int c = 3 ;
        int color = 1;
        int[][] result = colorBorder(grid, r, c, color);
        System.out.println(result);
    }

//[[1,2,1,2,1,2],[2,2,2,2,1,2],[1,2,2,2,1,2]]
//1
//3
//1


//out [[1,1,1,1,1,2],[1,2,2,2,1,2],[1,1,1,1,1,2]]
//exp [[1,1,1,1,1,2],[1,2,1,1,1,2],[1,1,1,1,1,2]]
}
