package algorithm.leetcode;
import java.util.*;

public class MaxProbability {

    class Pair{
        int edge;
        double prob;

        public Pair(int edge, double prob){
            this.edge = edge;
            this.prob = prob;
        }
    }

    class Distance{
        int start;
        int end;
        public Distance(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Distance)) return false;
            Distance distance = (Distance) o;
            return start == distance.start &&
                    end == distance.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        Map<Integer, Double> distance = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Double.compare(b.prob, a.prob));

        for (int i = 0 ; i < succProb.length ; i++){
            int[] edge = edges[i];
            double succPro = succProb[i];

            int first = edge[0];
            int second = edge[1];

            if (!graph.containsKey(first)){
                graph.put(first, new ArrayList<>());
            }
            graph.get(first).add(new Pair(second, succPro));

            if (!graph.containsKey(second)){
                graph.put(second, new ArrayList<>());
            }
            graph.get(second).add(new Pair(first, succPro));

            if (!distance.containsKey(first))
            distance.put(first, 0.000);
            if (!distance.containsKey(second))
            distance.put(second, 0.000);
        }

        distance.put(start, 1.000);

        pq.offer(new Pair(start,1));
        Set<Distance> visited = new HashSet<>();
        while (!pq.isEmpty()){
            Pair top =  pq.poll();
            int edge = top.edge;
            double prob = top.prob;

            if (start != edge && prob < distance.get(edge)){
                continue;
            }

           List<Pair> children =  graph.get(edge);
           for (Pair child : children){

               int childEdge = child.edge;
               double childProb = child.prob;
               if (!visited.contains(new Distance(edge, childEdge)) && distance.get(edge)*childProb > distance.get(childEdge)){
                   visited.add(new Distance(edge, childEdge));
                   visited.add(new Distance(childEdge, edge));
                   distance.put(childEdge,distance.get(edge)*childProb );
                   pq.offer(new Pair(childEdge, distance.get(childEdge)));
               }

           }

        }
        return distance.get(end);
    }
}
