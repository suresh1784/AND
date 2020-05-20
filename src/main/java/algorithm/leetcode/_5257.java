package algorithm.leetcode;

import java.util.Arrays;

public class _5257 {


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
      int[][]  grid = {{1,1,1,1,1,1,1,0},
                        {1,0,0,0,0,1,1,0},
                        {1,0,1,0,1,1,1,0},
                        {1,0,0,0,0,1,0,1},
                        {1,1,1,1,1,1,1,0}};
        System.out.println(closedIsland(grid));
    }



    public static int closedIsland(int[][] grid) {
    int islandCount = 0 ;
    int m = grid.length;
    int n = 0 ;
    if (m>=1){
        n = grid[0].length;
    }


    for (int i = 0 ; i < m ; i ++){
       if (grid[i][0] == 0 ){
           dfs(grid, i , 0);
       }
    }
    for (int j = 0 ; j < n ; j ++){
        if (grid[0][j] == 0 ){
            dfs(grid, 0 , j);
        }
    }
        for (int i = 0 ; i < m ; i ++){
            if (grid[i][n-1] == 0 ){
                dfs(grid, i , n-1);
            }
        }
        for (int j = 0 ; j < n ; j ++){
            if (grid[m-1][j] == 0 ){
                dfs(grid, m-1 , j);
            }
        }

    for (int i = 0 ; i < m ; i++){
        for (int j = 0 ; j < n ; j++){

            if (grid[i][j]== 0 ){
                    islandCount++;
                dfs(grid, i , j);
            }
        }
    }

    return islandCount;
    }

    public static void dfs(int[][] grid, int i , int j ){

        grid[i][j]=2;

        for (Coordinates next : Arrays.asList(new Coordinates(i+1, j ), new Coordinates(i, j+1 ), new Coordinates(i-1, j ), new Coordinates(i, j-1 ))){
            if (next.r >= 0 && next.r<grid.length && next.c >= 0 && next.c < grid[0].length && grid[next.r][next.c]==0){
                dfs(grid, next.r, next.c);
            }
        }


    }

}
