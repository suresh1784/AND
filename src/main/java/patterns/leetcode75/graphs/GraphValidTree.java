package patterns.leetcode75.graphs;

/** 261
 * Given n nodes labeled from 0 to n-1
 * and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 */
import java.util.*;
// create adjacent graph
// and check if the graph has a cycle or not

public class GraphValidTree {
    static Map<Integer, Boolean> marked;

    public static Boolean getHasCycle() {
        return hasCycle;
    }

    public static void setHasCycle(Boolean hasCycle) {
        GraphValidTree.hasCycle = hasCycle;
    }

    static Boolean hasCycle;
    public static boolean validTree(int n, int[][] edges) {
        setHasCycle(false);
        marked = new HashMap<>();
        if (edges==null || edges.length ==0 || edges[0].length==0){
            if (n==1){
                return true;
            }
            return false;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges){
            int val1 = edge[0];
            int val2 = edge[1];
            if (graph.get(val1)== null){
                graph.put(val1, new ArrayList<>());
            }

            if (graph.get(val2)== null){
                graph.put(val2, new ArrayList<>());
            }
            marked.put(val1, false);
            marked.put(val2, false);
            graph.get(val1).add(val2);
            graph.get(val2).add(val1);
        }
        int source = edges[0][0];

       int connectedCount =  dfs(graph, source);

        return !getHasCycle() && connectedCount == n;
    }

    public static int dfs(Map<Integer, List<Integer>> graph, int source){
        marked.put(source, true);

        List<Integer> children = new ArrayList<>();
        if (graph.get(source)!= null){
            children = graph.get(source);
        }
        int ans = 1;
        for (int child : children){
            if (!marked.get(child) ) {
                graph.get(child).remove((Integer)source); // way to find the undirected graph /// refer 261 solution
                ans += dfs(graph, child) ;
            }else if (child != source){
                setHasCycle(true);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int n = 5;
        int[][] edges = {{0,1}, {1,2}, {2,3},  {1,4}};
        System.out.println("valid Tree "+validTree(n, edges));

    }
}
