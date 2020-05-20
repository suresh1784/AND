package patterns.leetcode75.graphs;

import java.util.*;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int removingNodesCount = 0 ;
        Map<Integer, Integer> degree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        // graph
        for (int[] prerequisite : prerequisites){
            int child = prerequisite[0];
            int parent = prerequisite[1];

            if (!graph.containsKey(parent)){
              graph.put(parent, new ArrayList<>());
            }
            List<Integer> children = graph.get(parent);
            children.add(child);
            graph.put(parent, children);
        }

        // degree
        for (int[] prerequisite : prerequisites){
            int child = prerequisite[0];
            int parent = prerequisite[1];

            degree.putIfAbsent(parent, 0);
            degree.put(child, degree.getOrDefault(child, 0)+1);
        }

        int degreeCount = degree.size();
        // source of queue
        for (Map.Entry<Integer, Integer> entry : degree.entrySet()){
            if (entry.getValue()==0){
                q.offer(entry.getKey());
            }
        }

        while (!q.isEmpty()){
            Integer top = q.poll();

            List<Integer> children = new ArrayList<>();
            if (graph.get(top)!=null){
                children =graph.get(top);
            }

            for (int child : children){
                degree.put(child, degree.get(child)-1);
                removingNodesCount++; // removing nodes count***
                if (degree.get(child)==0){
                    q.offer(child);
                }
            }
        }

        System.out.println( " removingNodesCount "+ removingNodesCount);
        System.out.println( " numCourses "+ numCourses);
        System.out.println("prerequisites.length "+ prerequisites.length);


        return removingNodesCount == prerequisites.length;
    }

    public static void main(String[] args){
        int n = 3;
        int[][] prerequistes = {{1,0}, {0,2} ,{2,3},{1,3}};
     //   int[][] prerequistes = {{1,0}};
     //   int[][] prerequistes = {};
        System.out.println(canFinish(n,prerequistes));
    }
}
