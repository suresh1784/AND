package algorithm.leetcode;

import java.security.PublicKey;
import java.util.Objects;
import java.util.*;

public class MaxProductPath {
    private static int mod = 1000000007;
    private class Coordinates{
        int x ;
        int y ;

        public Coordinates(int x, int y ){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinates)) return false;
            Coordinates that = (Coordinates) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    private class Pair{
        Coordinates coordinates;
        int value;

        public Pair(Coordinates coordinates, int value){
            this.coordinates = coordinates;
            this.value = value;
        }
    }


    public int maxProductPath(int[][] grid) {
        Map<Coordinates, Integer> maxProd = new HashMap<>();
        Map<Coordinates, Integer> minProd = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Integer.compare(Math.abs(a.value), Math.abs(b.value)));

        int m = grid.length;
        if (grid.length==0){
            return -1;
        }
        int n = grid[0].length;

        if (m==0 || n==0 ){
            return -1;
        }
        pq.offer(new Pair(new Coordinates(0, 0), grid[0][0]));
        maxProd.put(new Coordinates(0,0), grid[0][0]);
        minProd.put(new Coordinates(0,0), grid[0][0]);
        boolean[][] visited =new boolean[m][n];
        while (!pq.isEmpty()){
            Pair top = pq.poll();

            Coordinates c = top.coordinates;
            int product = top.value;

            if (maxProd.get(c)!= null && product < maxProd.get(c) && minProd.get(c)!= null && product > minProd.get(c)){
                continue;
            }
            int x = c.x;
            int y = c.y;
            for (Coordinates next : Arrays.asList(new Coordinates(x+1, y), new Coordinates(x, y+1))){
                if (next.x>=0 && next.x<m && next.y>=0 && next.y<n){
                    int currProd = product*grid[next.x][next.y];
                    currProd= currProd%mod;

                    if (maxProd.get(next)!= null ){
                        if ( currProd > maxProd.get(next)) {
                            maxProd.put(next, currProd);
                            pq.offer(new Pair(next, maxProd.get(next)));
                        }
                    }else{
                        maxProd.put(next, currProd);
                        pq.offer(new Pair(next, maxProd.get(next)));
                    }

                    if (minProd.get(next)!= null ){
                        if ( currProd < minProd.get(next)) {
                            minProd.put(next, currProd);
                            pq.offer(new Pair(next, minProd.get(next)));
                        }
                    }else{
                        minProd.put(next, currProd);
                        pq.offer(new Pair(next, minProd.get(next)));
                    }
                }
            }
        }
        int maxProdValue = maxProd.get(new Coordinates(m-1, n-1));
        if (maxProdValue <0){
            return -1;
        }
        return maxProdValue;
    }
}
