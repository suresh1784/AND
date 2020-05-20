package patterns.Graph.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class Solution {
   static  List<Integer> dfsNum = Arrays.asList(-1,-1,-1,-1,-1,-1,-1,-1,-1);

    static List<Integer> val0 =Arrays.asList(1);
    static  List<Integer> val1 =Arrays.asList(0,2,3);
    static  List<Integer> val2 =Arrays.asList(1,3);
    static  List<Integer> val3 =Arrays.asList(1,2,4);
    static  List<Integer> val4 =Arrays.asList(3);
    static  List<Integer> val5 =Arrays.asList();
    static List<Integer> val6 =Arrays.asList(7,8);
    static List<Integer> val7 =Arrays.asList(6);
    static List<Integer> val8 =Arrays.asList(6);
    static List<List<Integer>> graph = Arrays.asList(val0,val1,val2,val3,val4,val5,val6,val7,val8);
    public static void main(String[] args){




        int m = graph.size()-1;

        for (int i=0;i<m;i++){
            if (dfsNum.get(i)==-1) {
                //dfs(i);
                bfs(i);
                System.out.printf("\n");
            }
        }


    }

    static void dfs(int u){
        System.out.printf(" %d", u);
        dfsNum.set(u,1);
        List<Integer> val = graph.get(u);
        for(Integer i: val){
            if (dfsNum.get(i) == -1) {
                dfs(i);
            }
        }
    }

    static void bfs(int u){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addFirst(u);
        System.out.println(u);
        dfsNum.set(u,1);
        while(!q.isEmpty()){
          int i =  q.poll();
          List<Integer> val = graph.get(i);
            for(Integer j: val) {
                if (dfsNum.get(j) == -1) {
                    System.out.println(j);
                    dfsNum.set(j,1);
                q.addFirst(j);
            }
            }
        }

        }

}
