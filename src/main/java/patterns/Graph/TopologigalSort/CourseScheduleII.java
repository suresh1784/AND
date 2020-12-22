package patterns.Graph.TopologigalSort;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> degreeMap = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0 ; i < numCourses; i++){
            degreeMap.putIfAbsent(i, 0);
        }

        for (int[] course : prerequisites){
            int child = course[0];
            int parent = course [1];
            degreeMap.put(child, degreeMap.getOrDefault(child, 0)+1);
            degreeMap.putIfAbsent(parent, 0);
            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(parent).add(child);
        }

    //    System.out.println("DegreeMap "+degreeMap);
    //    System.out.println("graph "+graph);

        Queue<Integer> q = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()){
            if (entry.getValue()==0){
                q.add(entry.getKey());
            }
        }

        while (!q.isEmpty()){
            int top = q.poll();
            res.add(top);
            if (graph.containsKey(top)) {
                List<Integer> children = graph.get(top);
                for (int child : children) {
                    if (degreeMap.containsKey(child))
                        degreeMap.put(child, degreeMap.get(child) - 1);

                    if (degreeMap.get(child) == 0) {
                        q.offer(child);
                    }
                }
            }
        }


        if (res.size()!= numCourses){
            return new int[]{};
        }
      //  System.out.println(res);
        int[] res1 = new int[res.size()];
        for (int i = 0 ; i < res.size() ; i++){
            res1[i] = res.get(i);
        }
        return res1;
    }


    public static void main(String[] args) {
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        System.out.println("result --> " + courseScheduleII.findOrder(numCourses1, prerequisites1));

        int numCourses2 = 4;
        int[][] prerequisites2 = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println("result --> " + courseScheduleII.findOrder(numCourses2, prerequisites2));

        int numCourses3 = 2;
        int[][] prerequisites3 = {};
        System.out.println("result --> " + courseScheduleII.findOrder(numCourses3, prerequisites3));
    }
}
