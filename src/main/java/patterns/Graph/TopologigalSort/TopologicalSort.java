package patterns.Graph.TopologigalSort;

import java.util.*;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        Map<Integer, Integer> degreeMap = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            Set<Integer> child = new HashSet<>();
            if (map.containsKey(from)) {
                child = map.get(from);
                child.add(to);
            } else {
                child.add(to);
            }
            map.put(from, child);

            degreeMap.put(to, degreeMap.getOrDefault(to, 0) + 1);
            if (!degreeMap.containsKey(from)) {
                degreeMap.put(from, 0);
            }
        }// for

        Queue<Integer> queue = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entrySet : degreeMap.entrySet()) {
            if (entrySet.getValue() == 0) {
                queue.offer(entrySet.getKey());
            }
        }

        while (!queue.isEmpty()) {
            int top = queue.poll();
            sortedOrder.add(top);
            Set<Integer> childs = new HashSet<>();
            if (map.containsKey(top)){
                childs = map.get(top);
            }

            for (int child : childs) {
                degreeMap.put(child, degreeMap.get(child) - 1);
                if (degreeMap.get(child) == 0) {
                    degreeMap.remove(child);
                    queue.offer(child);
                }
            }
        }

        // TODO: Write your code here
        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 }, new int[] { 0, 6 }  ,new int[] { 2, 0 } });
        System.out.println(result);
    }

    public  static Stack<Integer> stack ;
    public static int[] edge ;
    public static List<Integer> sort1(int vertices, int[][] edges) {
        stack = new Stack<>();
        edge = new int[vertices];
        Arrays.fill(edge, -1);
        boolean[] cycle = new boolean[vertices];
        boolean[] marked = new boolean[vertices];
        Map<Integer, Integer> degreeMap = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            Set<Integer> child = new HashSet<>();
            if (map.containsKey(from)) {
                child = map.get(from);
                child.add(to);
            } else {
                child.add(to);
            }
            map.put(from, child);

            degreeMap.put(to, degreeMap.getOrDefault(to, 0) + 1);
            if (!degreeMap.containsKey(from)) {
                degreeMap.put(from, 0);
            }
        }// for


        for (int[] edge : edges){
            int from = edge[0];
            if (!marked[from]) {
                dfs(from, map, marked, cycle);
            }

        }
        if (!cycleStack.isEmpty()){
            System.out.println("Cycle " + cycleStack);
        }
        Collections.reverse(stack);
        return new ArrayList<>(stack);
    }

 public static Stack<Integer> cycleStack = new Stack<>();
    public static void dfs (int vertex , Map<Integer, Set<Integer>> map, boolean[] marked, boolean[] cycle ){

        cycle[vertex] = true;
        marked[vertex] = true;
        Set<Integer> childs = new HashSet<>();
        if (map.get(vertex)!= null)
            childs = map.get(vertex);
        if (!cycleStack.isEmpty()){
            return;
        }
        for (int child : childs){
                if (!marked[child]) {
                    edge[child] = vertex;
                    dfs(child, map, marked, cycle);
                } else if (cycle[child]){
                    for (int x = vertex ; x != child ; x = edge[x]){
                        cycleStack.push(x);
                    }
                    cycleStack.push(child);
                    return ;
                }

            }
        cycle[vertex] = false;
        stack.push(vertex);
        }
}