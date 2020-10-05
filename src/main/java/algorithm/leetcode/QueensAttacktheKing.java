package algorithm.leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class QueensAttacktheKing {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Coordinates>  set = new HashSet<>();
        int rmax = king[0];
        int cmax = king[1];

        for (int[] queen : queens){
            rmax = Math.max(rmax,queen[0]);
            cmax = Math.max(cmax, queen[1]);
            set.add(new Coordinates(queen[0],queen[1]));
        }
        Queue<Coordinates> q = new LinkedList<>();
        q.offer(new Coordinates(king[0],king[1]));

        List<Coordinates> directions = new ArrayList<>();
        directions.addAll(Arrays.asList(new Coordinates(1,0),new Coordinates(0,1), new Coordinates(-1,0), new Coordinates(0,-1),
        new Coordinates(1,1),new Coordinates(-1,-1),new Coordinates(-1,1),new Coordinates(1,-1)));
        int index = 1;
        int x = king[0];
        int y = king[1];
        while (!directions.isEmpty()){

            Iterator<Coordinates> iterator = directions.iterator();
            while (iterator.hasNext()){
                Coordinates direction = iterator.next();
                Coordinates next = new Coordinates(x+(direction.r*index), y+(direction.c*index));

                if (set.contains(next)){
                    List<Integer> coor = new ArrayList();
                    coor.add(next.r);
                    coor.add(next.c);
                    result.add(coor);
                    iterator.remove();

                }

                if (next.r < 0 || next.c < 0 || next.r > rmax || next.c > cmax){
                    iterator.remove();
                }


            }
            index++;

        }

        return result;

    }

    public static class Coordinates{
        int r;
        int c;

        public Coordinates(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinates)) return false;
            Coordinates that = (Coordinates) o;
            return r == that.r &&
                    c == that.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}
