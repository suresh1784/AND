package algorithm.onlineassesment.amazon;
import java.util.*;
public class Maze {

    public static class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze==null || maze.length==0){
            return false;
        }
        Queue<Coordinate> q = new LinkedList<>();
        q.offer(new Coordinate(start[0], start[1]));
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]]= true;
        while (!q.isEmpty()){
            Coordinate top = q.poll();

            if (top.x == destination[0] && top.y == destination[1]){
                return true;
            }

            for (Coordinate next : Arrays.asList(getDown(top, maze),getLeft(top,maze), getUp(top,maze), getRight(top,maze))){
                if (!visited[next.x][next.y]){
                    visited[next.x][next.y]=true;
                  q.offer(next);
                }
            }

        }
        return false;
    }

    Coordinate getDown(Coordinate c, int[][] maze){
        int m = maze.length;
        int n = maze[0].length;
        int x = c.x;
        int y = c.y;
        while (x >= 0 && x < m && maze[x][y]==0){
            x++;
        }
        x--;
        return new Coordinate(x,y);
    }

    Coordinate getUp(Coordinate c, int[][] maze){
        int m = maze.length;
        int n = maze[0].length;
        int x = c.x;
        int y = c.y;
        while (x >= 0 && x < m && maze[x][y]==0){
            x--;
        }
        x++;
        return new Coordinate(x,y);
    }

    Coordinate getLeft(Coordinate c, int[][] maze){
        int m = maze.length;
        int n = maze[0].length;
        int x = c.x;
        int y = c.y;
        while (y >= 0 && y < n && maze[x][y]==0){
            y--;
        }
        y++;
        return new Coordinate(x,y);
    }

    Coordinate getRight(Coordinate c, int[][] maze){
        int m = maze.length;
        int n = maze[0].length;
        int x = c.x;
        int y = c.y;
        while (y >= 0 && y < n && maze[x][y]==0){
            y++;
        }
        y--;
        return new Coordinate(x,y);
    }

}
