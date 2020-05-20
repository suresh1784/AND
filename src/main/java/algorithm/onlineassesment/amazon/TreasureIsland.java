package algorithm.onlineassesment.amazon;
import java.util.*;
public class TreasureIsland {
    private static class Coordinate{
        int x;
        int y ;
        public Coordinate(int x , int y ){
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length ==0){
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][]  visited = new boolean[m][n];
        Queue<Coordinate> q = new LinkedList<>();
        for (int i = 0 ; i < m ; i ++){
            for (int j = 0 ; j < n ; j++){
                if (matrix[i][j]==0){
                    visited[i][j]=true;
                    q.offer(new Coordinate(i,j));
                }
            }
        }

        while (!q.isEmpty()){
            Coordinate top =  q.poll();
            int x = top.x ;
            int y = top.y;

            for (Coordinate next : Arrays.asList(new Coordinate(x+1,y),new Coordinate(x,y+1),
                    new Coordinate(x-1,y),new Coordinate(x,y-1))){
                if (next.x >=0 && next.x < m && next.y >=0 && next.y <n
                        && !visited[next.x][next.y]&&matrix[next.x][next.y]==1){
                    matrix[next.x][next.y] = matrix[x][y]+1;
                    q.offer(new Coordinate(next.x, next.y));
                    visited[next.x][next.y] = true;
                }
            }
        }
        return matrix;
    }
}
