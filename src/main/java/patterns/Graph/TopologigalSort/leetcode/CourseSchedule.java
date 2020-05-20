package patterns.Graph.TopologigalSort.leetcode;

import java.util.*;
public class CourseSchedule {


    public static boolean canFinish(int numCourses, int[][] prerequisites) {

       boolean[] stack = new boolean[numCourses];
       boolean[] marked = new boolean[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites){
            List<Integer> list = new ArrayList<>();
            if (graph.containsKey(p[0])){
                list = graph.get(p[0]);
            }
            if (!list.contains(p[1])){
                list.add(p[1]);
                graph.put(p[0], list);
            }
        } // for

        System.out.println(graph);
        if (prerequisites.length==0){
            return true;
        }
        int parent = prerequisites[0][0];
        for (Map.Entry<Integer, List<Integer>> entrySet: graph.entrySet()){
            if (!marked[entrySet.getKey()]){
                if (!dfs(graph, entrySet.getKey(), stack, marked)){
                    return false;
                }
            }
        }

        return true;
    } // canFinish



    static  boolean dfs(Map<Integer, List<Integer>> graph, int parent, boolean[] stack, boolean[] marked){
        if (graph.containsKey(parent)){
            stack[parent] = true;
            marked[parent] = true;
            List<Integer> children = graph.get(parent);
            for (Integer child : children){
               if (!marked[child]) {
                   if (!dfs(graph, child, stack, marked)){
                       return false;
                   }
               } else if (stack[child]){
                   return false;
               }
            } // for

            stack[parent] = false;
        }
        return true;
    } // dfs


    public static void main(String[] args){
    int[][] in1 =  {{2,0},{1,0},{3,1},{3,2},{1,3}};
        System.out.println(canFinish(4, in1));
    }
}
