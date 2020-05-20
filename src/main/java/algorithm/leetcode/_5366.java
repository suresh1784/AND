package algorithm.leetcode;

import java.util.*;
public class _5366 {

    public static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
         }
    }

    public static boolean hasValidPath(int[][] grid) {

        Map<Integer, List<Integer>> map  = new HashMap<>();
        map.put(1,new ArrayList<>(Arrays.asList(3,4)));
        map.put(2,new ArrayList<>(Arrays.asList(5,6)));
        map.put(3,new ArrayList<>(Arrays.asList(2,5,6)));
        map.put(4,new ArrayList<>(Arrays.asList(2,5,6)));
        map.put(5,new ArrayList<>(Arrays.asList(2,3,4)));
        map.put(6,new ArrayList<>(Arrays.asList(2,3,4)));
        if (grid == null || grid.length==0 || grid[0].length == 0){
            return false;
        }

        int m = grid.length;
        int n = grid.length;
        Queue<Coordinate> q = new LinkedList<>();
        q.offer(new Coordinate(0,0));

        while (!q.isEmpty()){
            Coordinate top = q.poll();
            int x = top.x;
            int y = top.y;
            if (x==m-1 && y==n-1){
                return true;
            }
            int i = grid[x][y];

            Coordinate next = getNext(i, top);
            if (map.get(i).contains(grid[next.x][next.y])){
                q.offer(next);
            }

        }
        return false;
    }



    public static Coordinate getNext(int i, Coordinate next){
        if (i<0 || i>6){
            return null;
        }
        Map<Integer, Coordinate> map = new HashMap<>();
        int x = next.x;
        int y = next.y;

        map.put(1, new Coordinate(x,y+1));
        map.put(2, new Coordinate(x+1,y));
        map.put(3, new Coordinate(x+1,y)); //
        map.put(4, new Coordinate(x+1,y));
        map.put(5, new Coordinate(x,y-1)); //
        map.put(6, new Coordinate(x,y+1));
       return  map.get(i);
    }


    public static void main(String[] args){
        int[][] grid =   {{2,4,3},{6,5,2}};
        System.out.println(hasValidPath(grid));
    }
}
