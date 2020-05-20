package patterns.leetcode75.graphs;
import java.util.*;

public class PacificAtlantic {
    public static class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix==null || matrix.length ==0 || matrix[0].length==0){
            return result;
        }
        int m  = matrix.length;
        int n = matrix[0].length;
        Queue<Coordinate> qPacific = new LinkedList<>();
        Queue<Coordinate> qAtlantic = new LinkedList<>();
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];

        for (int i = 0 ; i < m ; i++){
            pVisited[i][0] = true;
            aVisited[i][n-1]=true;
            qPacific.offer(new Coordinate(i,0));
            qAtlantic.offer(new Coordinate(i,n-1));
        }

        for (int i = 0 ; i < n ; i++){
            pVisited[0][i] = true;
            aVisited[m-1][i]=true;
            qPacific.offer(new Coordinate(0,i));
            qAtlantic.offer(new Coordinate(m-1,i));
        }

        bfs(qPacific, pVisited,matrix);
        bfs(qAtlantic, aVisited, matrix);

        for (int i = 0 ; i < m ; i ++){
            for (int j = 0 ; j < n ; j++){
                if (pVisited[i][j]&&aVisited[i][j]){
                    int[] val = {i,j};
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
     return result;

    }//

    public static void bfs(Queue<Coordinate> q , boolean[][] visited , int[][] matrix){
        while (!q.isEmpty()){
            Coordinate top = q.poll();
            int x = top.x;
            int y = top.y;

            for (Coordinate next : Arrays.asList(new Coordinate(x+1,y),new Coordinate(x,y+1),
                    new Coordinate(x,y-1),new Coordinate(x-1,y))){

                    if (next.x < 0 || next.y < 0 || next.x >= matrix.length || next.y >= matrix[0].length ||visited[next.x][next.y] || matrix[next.x][next.y] < matrix[x][y]) {
                        continue;
                    }

                    visited[next.x][next.y]= true;
                    q.offer(new Coordinate(next.x,next.y));
            }
        }

    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,2,3,5},
                          {3,2,3,4,5},
                          {2,4,5,3,1},
                          {6,7,1,4,5},
                          {5,1,1,2,4}};
        System.out.println(pacificAtlantic(matrix));
    }

}
