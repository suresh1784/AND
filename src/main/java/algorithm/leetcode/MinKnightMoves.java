package algorithm.leetcode;
import java.util.*;
public class MinKnightMoves {
    public class Coordinates{
        int x;
        int y ;

        public Coordinates(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public class Value {
        Coordinates coor;
        int len;

        public Value(Coordinates coor, int len){
            this.coor = coor;
            this.len = len;
        }
    }
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<Value>  q = new LinkedList<>();
        q.offer(new Value(new Coordinates(0,0) , 0));
        Set<String> visited = new HashSet<>();
        visited.add("0_0");
        while (!q.isEmpty()){
            Value top = q.poll();
            int c = top.coor.x;
            int r = top.coor.y;

            int len = top.len;

            if (c==x && r==y){
                return len;
            }

            for (Coordinates next : Arrays.asList(new Coordinates(c+1, r+2), new Coordinates(c-1, r+2), new Coordinates(c+1, r-2), new Coordinates(c-1, r-2), new Coordinates(c+2, r+1), new Coordinates(c-2, r+1), new Coordinates(c+2, r-1), new Coordinates(c-2, r-1))){
                String str = next.x+"_"+next.y;
                if (x>= -1 && y>=-1 && !visited.contains(str) ){
                    visited.add(str);
                    q.offer(new Value(next, len+1));
                }
            }
        }
        return -1;
    }
}
