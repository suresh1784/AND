package algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class _5305 {
    static class Pair {
        int value;
        int level;

        public Pair (int value , int level){
            this.value = value;
            this.level = level;
        }
    }
    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> result = new ArrayList<>();
        Set<Integer> friend = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(id, 0));
        visited.add(id);
        int l = 0 ;

        while (!q.isEmpty()){
            Pair top = q.poll();
            int currValue = top.value;
            int currLevel = top.level;

            if (currLevel== level){
                friend.add(currValue);
            }
            if (currLevel> level+1){
                break;
            }

            int[] f = friends[currValue];
            for (int i : f){
                if (!visited.contains(i)){
                    visited.add(i);
                    q.offer(new Pair(i, currLevel+1));
                }

            }
        }// while

        Map<String, Integer> freqMap = new HashMap<>();
        Iterator<Integer> iter = friend.iterator();
        while (iter.hasNext()){
            int f = iter.next();
            List<String> movies = watchedVideos.get(f);
            for (String movie : movies){
                freqMap.put(movie, freqMap.getOrDefault(movie,0)+1);
            }

        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.getValue(),b.getValue()));
        for (Map.Entry<String, Integer> entrySet : freqMap.entrySet()){
            pq.offer(entrySet);
        }

        while (!pq.isEmpty()){
            result.add(pq.poll().getKey());
        }

        return result;
    }

    public static void main(String[] args){
        int[][] friends = {{1,2},{0,3},{0,3},{1,2}};
        String[][] stringArray = {{"A", "B"}, {"C"}, {"B","C"}, {"D"}};
        List<List<String>> watchedVideos = Arrays.stream(stringArray)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        int id = 0 ;
        int level = 4 ;

        List<String> result = watchedVideosByFriends(watchedVideos, friends, id, level);
        System.out.println(result);


    };
}
