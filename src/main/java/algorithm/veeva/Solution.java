package algorithm.veeva;

import java.io.*;
import java.util.*;

/**
 * Given:
 * <p>
 * 1) Map<String, List<String>> dependentMap that provides
 * the mapping for a given column to its dependents (if
 * any). For example:
 * [E -> A]
 * [A -> B, C]
 * [B -> A, C, D]
 * [C -> E]
 * <p>
 * In this case B and C are dependents of A, and E is a dependent of C. You
 * can assume that a column cannot depend   * on itself.
 * <p>
 * 2) Method setValue (String column, int value) that associates a column
 * to the specified value.
 * <p>
 * <p>
 * ============================================
 * Goal: implement method setDependentValues (String column, int value)
 * using RECURSION with the following
 * conditions:
 * - Set starting column with provided value
 * - Set all column’s dependents with value+1. Apply the same logic to
 * their dependents (if any).
 * - Each dependent column found must be set only the first time it is
 * encountered.
 * <p>
 * Example:
 * Calling setDependentValues (A, 1) with the map above results in these
 * values:
 * A  1
 * B  2
 * C  2
 * D  3
 * E  3
 */

class Solution {
    private static Map<String, List<String>> dependentMap = new HashMap<>();
    private static List<DependentValue> dependentValues = new LinkedList<>();
    static int tempVal = 0;
    //** my code
    private static HashMap<String, Integer> tMap = new HashMap<String, Integer>();
    private static HashSet<String> tSet = new HashSet<>();
    static Queue<String> q = new LinkedList<>();


    private static class DependentValue {
        private final String column;
        private final int value;

        public DependentValue(String column, int value) {
            this.column = column;
            this.value = value;
        }

        public String getColumn() {
            return column;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        dependentMap.put("E", Arrays.asList("F","B"));
        dependentMap.put("F", Arrays.asList("A"));
        dependentMap.put("A", Arrays.asList("B", "C"));
        dependentMap.put("B", Arrays.asList("A", "C", "D"));
        dependentMap.put("C", Arrays.asList("E"));

        setDependentValues("A", 1);
        for (DependentValue dependentValue : dependentValues) {
            System.out.println(dependentValue.getColumn() + dependentValue.getValue());
        }
    }

    public static void setValue(String column, int value) {
        dependentValues.add(new DependentValue(column, value));
    }
    static LinkedList<String> result = new LinkedList<>();
    public static void setDependentValues(String column, int value) {

        // Do the actual work here
      //  System.out.println(column +" :----- "+ value);
        setValue(column,value);
        tMap.put(column,value);
      //  recc(column, value+1) ;
        Set<String>  visited = new HashSet<>();
        dfs(column,value, visited);
        System.out.println(result);
    }



    static void dfs (String column, int level, Set<String> visited){
       // if ()

        visited.add(column);
        List<String> list = dependentMap.get(column);
        if (list!=null) {
            for (int i = 0; i < list.size(); i++) {
                if (!visited.contains(list.get(i))) {
                    dfs(list.get(i), level + 1, visited);
                }
            }
        }
        System.out.println(column +" "+level);
        result.addFirst(column);

    }

    static void recc(String column, int level) {
        if (dependentMap.get(column) == null || tSet.contains(column)) {
            return;
        } else {


            tSet.add(column);


            for (String s : dependentMap.get(column)) {
                if (!tSet.contains(s)) {
                    q.add(s);
                    tSet.add(s);
                    tMap.put(s, level);
                    setValue(s,level);
               //     System.out.println(s + " :----- " + level);

                }

            }

            while (!q.isEmpty()) {
                String s = q.poll();
                tSet.remove(s);
                recc(s, tMap.get(s) + 1);

            }


        }
    }




    static void setDependentValue(String column, int value, int pos, Set<String> set, Queue<String> q, List list) {

    if ( (!set.isEmpty() && list.size()+1 <= pos)){
        return;
    } else if (!set.contains(column) ){
        set.add(column);
        q.add(column);
        setValue(column, value);
        System.out.println("column "+column +" value " + value);
    } else if (!set.contains(column) ){


    }



    if ( !set.isEmpty() && (list != null && list.size() > 0 && list.size() > pos ) ) {
        setDependentValue(list.get(pos).toString(), value, pos + 1, set, q, list);
    }



        while (!q.isEmpty()) {
            list = dependentMap.get(q.poll());
            pos = 0;
            setDependentValue(list.get(pos).toString(), value + 1, pos+1, set, q, list);

        }



    }

    /**
     *  Column value pos set
     *      A   1     0   null
     *
     */

    public static void setDependentValuesNonRec(String column, int value) {


        Queue<String> q = new LinkedList<>();
        q.add(column);
        tSet.add(column);
        tMap.put(column, value);
        setValue(column, value);

        while (!q.isEmpty()) {

            String currVal = q.poll();
            value = tMap.get(currVal) + 1;
            List<String> list = dependentMap.get(currVal);


            if (list != null) {
                for (int j = 0; j < list.size(); j++) {
                    if (!tSet.contains(list.get(j))) {
                        q.add(list.get(j));

                        setValue(list.get(j), value);
                        tMap.put(list.get(j), value);
                        tSet.add(list.get(j));
                    }
                }
            }

        }


    }


}

/**
 * setDepVal(A, 1)
 * tempMap contain A - temp ()
 * tempVal = 1
 * list = (B, C)
 * tempMap = ((A,1))
 * LOOP (B,C)
 * B
 * setDepVal(B, 2)
 * tempMap contain B
 * tempVal = 2
 * list = (A, C, D)
 * tempMap = ((A,1),(B,2))
 * LOOP (A, C, D)
 * A
 */


/**
 *void breadth_first(Node root):
 *   Queue q;
 *   q.push(root);
 *   breadth_first_recursive(q)
 *
 * void breadth_first_recursive(Queue q):
 *   if q.empty() return;
 *
 *   Node n = q.pop()
 *   print "Node: ", n
 *   if (n.left) q.push(n.left)
 *   if (n.right) q.push(n.right)
 *   breadth_first_recursive(q)
 **/