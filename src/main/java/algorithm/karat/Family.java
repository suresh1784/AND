package algorithm.karat;
import javax.print.DocFlavor;
import java.io.*;
import java.util.*;

// Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

// For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

// 1   2   4
//  \ /   / \
//   3   5   8
//    \ / \   \
//     6   7   10


// parentChildPairs = [
//     (1, 3), (2, 3), (3, 6), (5, 6),
//     (5, 7), (4, 5), (4, 8), (8, 10)
// ]

// Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.

// findNodesWithZeroAndOneParents(parentChildPairs) => [
//   [1, 2, 4],    // Individuals with zero parents
//   [5, 7, 8, 10] // Individuals with exactly one parent
// ]

// Acyclic

// parent -> Child
// Map<Integer, List<Integer>> parentChildMap
// // degree each eleme
// any elemt has zero degree are parent with no parent
// any degree with one is


// Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.

// Sample input and output:

// hasCommonAncestor(parentChildPairs, 3, 8) => false
// hasCommonAncestor(parentChildPairs, 5, 8) => true
// hasCommonAncestor(parentChildPairs, 6, 8) => true
// hasCommonAncestor(parentChildPairs, 1, 3) => false

// Map<Child , Set <Parent>>
// 1 --> 3
// 6 --> 3
// 8 --> 4


class Family {

    public static List<List<Integer>> findFamily(int[][] parentChildPairs){

        Map<Integer, Set<Integer>> parentMap = new HashMap<>();
        Map<Integer, Integer> degreeMap = new HashMap<>();




        for (int[] family : parentChildPairs){
            int parent = family[0];
            int child = family[1];

            degreeMap.put(parent, 0 );
            degreeMap.put(child , 0 );


        } // for



        for (int[] family : parentChildPairs){

            int parent = family[0];
            int child = family[1];


            if (parentMap.get(parent)!= null){

                parentMap.get(parent).add(child);
                degreeMap.put(child, degreeMap.get(child)+1);

            }else{
                parentMap.put(parent, new HashSet<>(child));
                degreeMap.put(child, degreeMap.get(child)+1);

            }


        }// for

        List<Integer> parent = new ArrayList<>();
        List<Integer> oneDegree = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()){
            int degree = entry.getValue();
            int element = entry.getKey();

            if (degree == 0 ){
                parent.add(element);

            }

            if (degree == 1){
                oneDegree.add(element);
            }

        }// for

        // System.out.println("Parents  "+parent );
        // System.out.println("oneDegree  "+oneDegree );

        List<List<Integer>> result = new ArrayList<>();
        result.add(parent);
        result.add(oneDegree);

        return result;
    }// findFamily

    public static boolean hasCommonAncestor(int[][] parentChildPairs, int a, int b){

        Map<Integer, Set<Integer>> parentMap = new HashMap<>();
        Map<Integer, Integer> degreeMap = new HashMap<>();
        Map<Integer, Set<Integer>> childMap = new HashMap<>();
        Map<Integer, Set<Integer>> rootChildMap = new HashMap<>();

        for (int[] family : parentChildPairs){

            int parent = family[0];
            int child = family[1];


            if (childMap.get(child)!= null){

                childMap.get(child).add(parent);

            }else{
                Set<Integer> set = new HashSet<>();
                set.add(parent);
                childMap.put(child, set);

            }

        }// for


        Set<Integer> aSet = new HashSet<>();
        dfs(childMap, a, aSet,rootChildMap);
        System.out.println("Next <<<<<<>>>>>>>>>");
        Set<Integer> bSet = new HashSet<>();
        dfs(childMap, b, bSet, rootChildMap);
        System.out.println(rootChildMap);
        for (int aParent : aSet){
            if(aParent != a && aParent != b) {
                if (bSet.contains(aParent)) {
                    System.out.println("Common parent " + aParent);
                    return true;
                }
            }
        }

        return false;

    }// CommonParent


    static int dfs (Map<Integer, Set<Integer>> childMap, int child , Set<Integer> result, Map<Integer, Set<Integer>> rootChildMap){
        Set<Integer> parents = childMap.get(child);
        if (parents == null){
            result.add(child);
            return child;
        }
        int child1 = 0;
        for (int parent : parents){
            child1 = dfs(childMap, parent, result, rootChildMap);
            System.out.println("child    -> "+ child );
            // System.out.println("parent   -> "+ parent );
            System.out.println("parent    -> "+ child1 );
            System.out.println("---------------------------");
            if (rootChildMap.get(child)!= null) {
                rootChildMap.get(child).add(child1);
            }else {
                Set<Integer> set = new HashSet<>();
                set.add(child1);
                rootChildMap.put(child, set);
            }

        }
        return child1;
    }

    public static void main(String[] args) {



        int[][] parentChildPairs = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {8, 10}
        };

     List<List<Integer>>  result = findFamily(parentChildPairs);
     System.out.println("Result "+ result);

        // hasCommonAncestor(parentChildPairs, 3, 8) => false
// hasCommonAncestor(parentChildPairs, 5, 8) => true
// hasCommonAncestor(parentChildPairs, 6, 8) => true
// hasCommonAncestor(parentChildPairs, 1, 3) => false

//        System.out.println("hasCommonAncestor(parentChildPairs, 3, 6) "+ hasCommonAncestor(parentChildPairs, 3, 6));
//        System.out.println("hasCommonAncestor(parentChildPairs, 3, 8) "+ hasCommonAncestor(parentChildPairs, 3, 8));
//        System.out.println("hasCommonAncestor(parentChildPairs, 5, 8) "+ hasCommonAncestor(parentChildPairs, 5, 8));
//        System.out.println("hasCommonAncestor(parentChildPairs, 6, 8) "+ hasCommonAncestor(parentChildPairs, 6, 8));
        System.out.println("hasCommonAncestor(parentChildPairs, 1, 3) "+ hasCommonAncestor(parentChildPairs, 6, 10));
 //       System.out.println("hasCommonAncestor(parentChildPairs, 1, 3) "+ hasCommonAncestor(parentChildPairs, 6, 10));

    }
}


/*
Your previous Markdown content is preserved below:

Welcome to the Interview!
 */
