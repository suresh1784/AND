package patterns.Graph.TopologigalSort;

import java.util.*;

class TaskScheduling {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        Map<Integer, Integer> dependencyMap = new HashMap<>();
        Map<Integer, Set<Integer>> relationMap = new HashMap<>();

        for (int[] prerequisite : prerequisites){
            int from = prerequisite[0];
            int to = prerequisite[1];

            dependencyMap.put(to, dependencyMap.getOrDefault(to,0)+1);
            if (!dependencyMap.containsKey(from)){
               dependencyMap.put(from, 0);
            }
            Set<Integer> child = new HashSet<>();
            if (relationMap.containsKey(from)){
                child = relationMap.get(from);
            }
            child.add(to);
            relationMap.put(from , child);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entrySet : dependencyMap.entrySet()){
                if (entrySet.getValue()==0){
                    queue.add(entrySet.getKey());
                }
        }
        int count = 0 ;
        while (!queue.isEmpty()){
            int top = queue.poll();
            count++;
            Set<Integer> set = new HashSet<>();
            if (relationMap.containsKey(top)){
                set = relationMap.get(top);
            }
            for (int child : set){
                dependencyMap.put(child, dependencyMap.get(child)-1);
                if (dependencyMap.get(child)==0){
                    queue.offer(child);
                }

            }
        }
        System.out.println("tasks " + tasks + " count "+ count);
        return tasks== count;
    }

    public static void main(String[] args) {

        boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}