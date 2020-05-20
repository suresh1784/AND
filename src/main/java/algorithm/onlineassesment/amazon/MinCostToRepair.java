package algorithm.onlineassesment.amazon;

import java.util.*;

public class MinCostToRepair {
    public int minimumCost(int N, int[][] edges, int[][] newEdges) {
        UnionFind u = new UnionFind(N);
        Set<String> broken = new HashSet<>();
        for (int[] edge : newEdges){
            if (edge[0]<edge[1]){
                broken.add(edge[0]+"_"+edge[1]);
            }else {
                broken.add(edge[1]+"_"+edge[0]);
            }
        }

        for (int[] edge : edges){
            String str = "";
            if (edge[0]<edge[1]){
                str = edge[0]+"_"+edge[1];
            }else {
               str = edge[1]+"_"+edge[0];
            }
            if (broken.contains(str)){
                continue;
            }
            if (!u.isSameSet(edge[0], edge[1])){
                u.unionSet(edge[0], edge[1]);
            }
        }
        Arrays.sort(newEdges, (a,b)-> Integer.compare(a[2], b[2]) );
        int cost = 0 ;
        for (int[] edge : newEdges){
            if (!u.isSameSet(edge[0], edge[1])){
                u.unionSet(edge[0], edge[1]);
                cost += edge[2];
            }
        }

        return u.size==1? cost : -1;
    }

    public class UnionFind{
        Map<Integer, Integer> parent ;
        Map<Integer, Integer> rank;
        int size;
        public UnionFind(int n){
            parent = new HashMap<>();
            rank = new HashMap<>();
            size = n;
            for (int i = 1; i <= n ; i++){
                parent.put(i, i);
                rank.put(i, 1);
            }
        }


        public int findSet(int i){
            if (i == parent.get(i)){
                return i;
            }else {
                int root = findSet(parent.get(i));
                parent.put(i,root);
                return root;
            }
        }

        public boolean isSameSet(int v1, int v2){
            if (findSet(v1)== findSet(v2)){
                return true;
            }

            return false;
        }

        public void unionSet(int v1, int v2){
            if (!isSameSet(v1,v2)){
                size--;
                int p1 = findSet(v1);
                int p2 = findSet(v2);
                int r1 = rank.get(p1);
                int r2 = rank.get(p2);

                if (r1> r2){
                    parent.put(p2, p1);
                }else {
                    parent.put(p1,p2);
                    if (r1==r2){
                        rank.put(p2, rank.get(p2)+1);
                    }
                }
            }
        }

    }
}
