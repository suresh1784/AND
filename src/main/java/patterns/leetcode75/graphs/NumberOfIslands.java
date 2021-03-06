package patterns.leetcode75.graphs;


import java.util.Arrays;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        if (grid== null || grid.length == 0 || grid[0].length==0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (grid[i][j]=='1'){
                    count ++;
                    int ans = dfs(grid,new Coordinate(i,j));
                    System.out.println("Number of 1 s " +ans);
                }
            }
        }

        return count;
    }


    public static int dfs(char[][] grid, Coordinate c){

        int x = c.x;
        int y= c.y;
        int ans = 1;
        grid[x][y]= '0';
        for (Coordinate next : Arrays.asList(new Coordinate(x+1,y),new Coordinate(x,y+1),
                new Coordinate(x-1,y),new Coordinate(x,y-1) )){
            if (next.x>=0 && next.x < grid.length &&  next.y >=0 && next.y < grid[0].length && grid[next.x][next.y]=='1') {
                ans += dfs(grid, next) ;
            }
        }
        return ans;
    }



    public static class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        char[][] grid = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','1'},
                {'0','0','0','1','1'}};

        System.out.println(numIslands(grid));
    }
}


