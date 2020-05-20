package patterns.Graph.TopologigalSort;

import java.util.*;

class MinimumHeightTrees {
    public static List<Integer> findTrees(int nodes, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();

        Map<Integer, Integer>  degreeMap = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges){
            int v1 = edge[0];
            int v2 = edge[1];

            List<Integer> children1 = new ArrayList<>();
            if (graph.containsKey(v1)){
                children1 = graph.get(v1);
            }
            if (!children1.contains(v2)){
                degreeMap.put(v2, degreeMap.getOrDefault(v2,0)+1);
                children1.add(v2);
                graph.put(v1,children1);
            }

            List<Integer> children2 = new ArrayList<>();
            if (graph.containsKey(v2)){
                children2 = graph.get(v2);
            }
            if (!children2.contains(v1)) {
                degreeMap.put(v1, degreeMap.getOrDefault(v1,0)+1);
                children2.add(v1);
                graph.put(v2, children2);
            }
        }
        Queue<Integer> source = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entrySet : degreeMap.entrySet()){
          if (entrySet.getValue() ==1){
              source.add(entrySet.getKey());
          }
        }

        int totalNodes = nodes;
        while (totalNodes > 2 && !source.isEmpty()){
            totalNodes -= source.size();
            int size = source.size();
            for (int i = 0 ; i < size ; i++){
                Integer top = source.poll();
                List<Integer> lists = new ArrayList<>();
                if (graph.containsKey(top)){
                    lists = graph.get(top);
                }

                for (int list : lists){
                    degreeMap.put(list, degreeMap.get(list)-1);
                    if (degreeMap.get(list)==1){
                        source.add(list);
                    }
                }
            }

        }
        minHeightTrees.addAll(source);
        return minHeightTrees;
    }

    public static void main(String[] args) {
        List<Integer> result = MinimumHeightTrees.findTrees(5,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
                new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
        System.out.println("Roots of MHTs: " + result);
    }
}