package algorithm.leetcode;

import java.util.*;

public class _5354 {

    public static class Time{
        int time;
        int id;

        public Time (int id , int time){
            this.time = time;
            this.id = id;
        }
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Time>> map = new HashMap<>();

        for (int i = 0 ; i < manager.length ; i++){
            if (manager[i]>=0) {
                if (map.containsKey(manager[i])) {
                    List<Time> times = map.get(manager[i]);
                    times.add(new Time(i, informTime[manager[i]]));
                    map.put(manager[i], times);
                } else {
                    List<Time> times = new ArrayList<>();
                    times.add(new Time(i, informTime[manager[i]]));
                    map.put(manager[i], times);
                }
            }

        }
        int max = 0;
        Queue<Time> q = new LinkedList<>();
        q.offer(new Time(headID, 0));


        while (!q.isEmpty()){
            Time time = q.poll();
            int currTime = time.time;
            int currId = time.id;

            if (map.containsKey(currId)){
                List<Time> tLists = map.get(currId);
                for (Time tItem : tLists){
                    q.offer(new Time(tItem.id, tItem.time+currTime));
                }
            }else {
                if (max < currTime){
                    max = currTime;
                }
            }
        }

        return max;



    }

    public static void main(String[] args){
//        int n = 15, headID = 0;
//        int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6}, informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};

//       int  n = 4, headID = 2;
//       int[] manager = {3,3,-1,2}, informTime = {0,0,162,914};

//       int  n = 7, headID = 6;
//       int[] manager = {1,2,3,4,5,6,-1}, informTime = {0,6,5,4,3,2,1};

//        int n = 6, headID = 2;
//        int[] manager = {2,2,-1,2,2,2}, informTime = {0,0,1,0,0,0};

        int n = 1, headID = 0;
        int[] manager = {-1}, informTime = {0};

        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }
}
