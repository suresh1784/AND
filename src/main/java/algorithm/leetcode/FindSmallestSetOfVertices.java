package algorithm.leetcode;
import java.util.*;
public class FindSmallestSetOfVertices {
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> zeroDegree = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();

        for (List<Integer> edge : edges){
            int parent = edge.get(0);
            int child = edge.get(1);
            childSet.add(child);
            if (!childSet.contains(parent)) {
                zeroDegree.add(parent);
            }

            if (zeroDegree.contains(child)){
               zeroDegree.remove(child);
            }
        } // for

        return new ArrayList<>(zeroDegree);
    } //

    public static void main(String[] args) {
        List<Integer> in1 = Arrays.asList(0,1);
        List<Integer> in2 = Arrays.asList(0,2);
        List<Integer> in3 = Arrays.asList(2,5);
        List<Integer> in4 = Arrays.asList(3,4);
        List<Integer> in5 = Arrays.asList(4,2);
        List<List<Integer>> in = Arrays.asList(in1, in2, in3 , in4 ,in5);
        System.out.println(findSmallestSetOfVertices(6, in));

        List<Integer> in11 = Arrays.asList(0,1);
        List<Integer> in21 = Arrays.asList(2,1);
        List<Integer> in31 = Arrays.asList(3,1);
        List<Integer> in41 = Arrays.asList(1,4);
        List<Integer> in51 = Arrays.asList(2,4);
        List<List<Integer>> in_1 = Arrays.asList(in11, in21, in31 , in41 ,in51);
        System.out.println(findSmallestSetOfVertices(5, in_1));
    }


}
