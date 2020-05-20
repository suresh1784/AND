package patterns.leetcode75.graphs;

import java.util.*;

public class NumberOfConnectedComponents {
    static boolean[] marked ;
    public static int countComponents(int n, int[][] edges) {
        marked = new boolean[n] ;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges){
            int val1 = edge[0];
            int val2 = edge[1];
            if (graph.get(val1)==null){
                graph.put(val1, new ArrayList<>());
            }

            if (graph.get(val2)==null){
                graph.put(val2, new ArrayList<>());
            }

            graph.get(val1).add(val2);
            graph.get(val2).add(val1);
        }

        int count = 0 ;
        for (int i = 0 ; i< n; i++ ){
            if (!marked[i]){
                count++;
                dfs(graph, i);
            }

        }
        return count;
    }

    public static void dfs(Map<Integer, List<Integer>> graph, int source){
        marked[source] = true;
        List<Integer> children = new ArrayList<>();
        if (graph.get(source)!=null){
            children = graph.get(source);
        }

        for (Integer child : children){
            if (!marked[child]){
         //       graph.get(child).remove((Integer) source);
                dfs(graph, child);
            }
        }
    }

    public static void main(String[] args){
        int[][] edges = {{0,1},{1,2},{2,3},{3,4}};
        System.out.println(countComponents(5, edges));
    }
}
