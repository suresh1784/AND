package patterns.Graph.TopologigalSort;

import java.util.*;

class SequenceReconstruction {
    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
        List<Integer> sortedOrder = new ArrayList<>();
        Map<Integer, Integer> degreeMap = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] sequence : sequences){
            for (int i = 1 ; i < sequence.length; i++){
                int parent = sequence[i-1];
                int child = sequence[i];
                List<Integer>  children = new ArrayList<>();
                if (graph.containsKey(parent)){
                    children = graph.get(parent);
                }
                if (!children.contains(child)){
                    children.add(child);
                    graph.put(parent, children);
                    degreeMap.put(child, degreeMap.getOrDefault(child, 0 )+1);
                    if (!degreeMap.containsKey(parent)){
                        degreeMap.put(parent, 0);
                    }
                }
            }
        } // for

        Queue<Integer> source = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entrySet : degreeMap.entrySet()){
            if (entrySet.getValue() ==0 ){
                source.add(entrySet.getKey());
            }
        }

        int count = 0 ;
        while (!source.isEmpty()){
            if (source.size()>1){
                return false;
            }

            Integer top = source.poll();
            if (top != originalSeq[count]){
                return false;
            }
            sortedOrder.add(top);
            count++;
            List<Integer> children = new ArrayList<>();
            if (graph.containsKey(top)){
                children = graph.get(top);
            }

            for (int child : children){
                degreeMap.put(child, degreeMap.get(child)-1);
                if (degreeMap.get(child)==0){
                    source.add(child);
                }
            }

        }


        return sortedOrder.size() == degreeMap.size();
    }

    public static void main(String[] args) {
        boolean result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
                new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
                new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[] { 3, 1, 4, 2, 5 },
                new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
        System.out.println("Can we uniquely construct the sequence: " + result);
    }
}