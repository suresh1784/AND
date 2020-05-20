package algorithm.onlineassesment.amazon;
import java.util.*;
public class CriticalConnections {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, Integer> parentMap = new HashMap<>();
        Map<Integer, Integer> numMap = new HashMap<>();
        Map<Integer, Integer> lowMap = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<List<Integer>> bridges = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (List<Integer> conn : connections){
            int val1 = conn.get(0);
            int val2 = conn.get(1);
            if (graph.get(val1)==null){
                graph.put(val1, new ArrayList<>());
            }
            List<Integer> list1 =graph.get(val1);
            list1.add(val2);
            if (graph.get(val2)==null){
                graph.put(val2, new ArrayList<>());
            }
            List<Integer> list2 =graph.get(val2);
            list2.add(val1);
        } // for

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()){
            int root = entry.getKey();
            if (!visited.contains(root)) {
                visited.add(root);
                parentMap.put(root, root);
                dfs(parentMap, numMap, lowMap, graph, n, bridges, root, visited);
            }
        }

        return bridges;

    } // method
    public int time;
    void dfs( Map<Integer, Integer> parentMap, Map<Integer, Integer> numMap,
              Map<Integer, Integer> lowMap ,Map<Integer, List<Integer>> graph, int n
            ,List<List<Integer>> bridges , int u, Set<Integer> visited){
        numMap.put(u, time);
        lowMap.put(u, time);
        //System.out.println(time);
        time++;
       // System.out.println(time);

        List<Integer> children = graph.get(u);
        for (int v : children){
            if (!visited.contains(v)){
                parentMap.put(v, u);
                visited.add(v);
                dfs(parentMap, numMap, lowMap, graph, n, bridges, v, visited);
                //bridges
                if (numMap.get(u) < lowMap.get(v)){
                    bridges.add(Arrays.asList(u,v));
                }

                lowMap.put(u , Math.min(lowMap.get(u), lowMap.get(v)));
            }else {
                if (v != parentMap.get(u)){
                    lowMap.put(u , Math.min(lowMap.get(u), numMap.get(v)));
                    /**
                     * below put also works .. but numMap.get is best//
                     */
                   // lowMap.put(u , Math.min(lowMap.get(u), lowMap.get(v)));
                }
            } // else
        }// for
    } // dfs
}
