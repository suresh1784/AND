package algorithm.onlineassesment.amazon;
import java.util.*;
public class MaximumMinimumPath {
    private static class Coordinate{
        int x;
        int y ;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int maximumMinimumPath(int[][] A) {
        if (A==null || A.length==0){
            return 0;
        }

        int m = A.length;
        int n = A[0].length;
        int maxMinPath = A[0][0];
        PriorityQueue<Coordinate> pq = new PriorityQueue<>((a,b)-> Integer.compare(A[b.x][b.y], A[a.x][a.y]));
        pq.offer(new Coordinate(0,0));
        boolean[][] visited = new boolean[m][n];

        while (!pq.isEmpty()){
          Coordinate top = pq.poll();
          int x = top.x;
          int y = top.y;
          visited[x][y] = true;
          maxMinPath = Math.min(maxMinPath, A[x][y]);
          if (x==m-1 && y ==n-1){
              return maxMinPath;
          }

          for (Coordinate next : Arrays.asList(new Coordinate(x+1,y), new Coordinate(x,y+1), new Coordinate(x-1,y), new Coordinate(x,y-1))){
              if (next.x >= 0 && next.x< m && next.y >=0 && next.y < n && !visited[next.x][next.y]){
                  pq.offer(next);
              }
          }

        }
        return maxMinPath;
    }
}
