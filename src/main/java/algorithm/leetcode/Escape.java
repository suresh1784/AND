package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;


public class Escape {
    public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        // source target // BFS
        Set<Long> blockedList = new HashSet<>();
        Set<Long> unBLockList = new HashSet<>();
        Set<Long> visitedList = new HashSet<>();
        for (int[] block : blocked){
            long val = (block[0]*(1000000))+block[1];
        blockedList.add(val);
        }

        int xLimit = 1000000;
        int count = 0 ;

        for (int[] block : blocked){
            long val = (block[0]*(1000000))+block[1];
           int r = block[0];
           int c = block[1];
            for (Coordinates next : Arrays.asList(new Coordinates(r+1,c),new Coordinates(r,c+1),
                                        new Coordinates(r-1,c),new Coordinates(r,c-1))) {
                int x = next.r;
                int y = next.c;
                long X = (next.r*(1000000))+next.c;
                if (x >= 0 && x < xLimit && y >= 0 && y < xLimit && !blockedList.contains(X)){
                    unBLockList.add(X);
                }
            }
        }


        Queue<Coordinates> q = new LinkedList();
        long coordinate = (source[0]*(1000000))+source[1];
        q.add(new Coordinates(source[0],source[1]));
        visitedList.add(coordinate);

        long targerCoodinate = (target[0]*(1000000))+target[1];

        while (!q.isEmpty()){
            count++;
            Coordinates top = q.poll();
            long topCoordinate = (top.r*(1000000))+top.c;
            int r = top.r;
            int c = top.c;
            if (topCoordinate == targerCoodinate || unBLockList.size()==0 || count ==200){
                return true;
            }

            for (Coordinates next : Arrays.asList(new Coordinates(r+1,c),new Coordinates(r,c+1),
                    new Coordinates(r-1,c),new Coordinates(r,c-1))) {

                int x = next.r;
                int y = next.c;
               // System.out.println("x " +x + " y "+ y);


                long X = (x*(1000000))+y;
                if (x >= 0 && x < xLimit && y >= 0 && y < xLimit && !blockedList.contains(X) && !visitedList.contains(X)){
                    if (unBLockList.contains(X)){
                        unBLockList.remove(X);
                    }
                    visitedList.add(X);

                    q.offer(next);
                }
            }
        }
        return false;
    }


    public static class Coordinates{
        int r;
        int c;
        public Coordinates(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj){
            Coordinates coordinates = (Coordinates)obj;
          if (this.r == coordinates.r && this.c == coordinates.c) {
              return true;
          }
          return false;
        }

    }




    public static void main(String[] args){
        int[][] blocked = {{691938,300406},{710196,624190},{858790,609485},{268029,225806},{200010,188664},{132599,612099},{329444,633495},{196657,757958},{628509,883388}};
        int[] source = {655988,180910};
        int[] target = {267728,840949};

//[[691938,300406],[710196,624190],[858790,609485],[268029,225806],[200010,188664],[132599,612099],[329444,633495],[196657,757958],[628509,883388]]
//[655988,180910]
//[267728,840949]

        boolean result = isEscapePossible(blocked, source, target);
        System.out.println(result);
    }
}
