package algorithm.onlineassesment.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinConnectingCities {

    public int minimumCost(int N, int[][] connections) {
        UnionFind1 u = new UnionFind1(N);
        Arrays.sort(connections, (a,b)-> Integer.compare(a[2],b[2]));
        int minCost = 0 ;
        for (int[] conn : connections){
            if(!u.isSameSet(conn[0], conn[1])){
                u.unionSet(conn[0],conn[1]);
                minCost+= conn[2];
            }
        }
        if (u.size==1){
            return minCost;
        }else {
            return -1;
        }
    }

    //

    public class UnionFind1 {
        Map<Integer, Integer> parent;
        Map<Integer, Integer> rank;
        int size;
        public UnionFind1(int n){
            parent = new HashMap<>();
            rank = new HashMap<>();
            size = n;
            for (int i = 1 ; i <= n ; i++){
                parent.put(i, i );
                rank.put(i , 1);
            }
        }

        public int findSet(int val){
            if (val == parent.get(val)){
                return val;
            }else {
                int root = findSet(parent.get(val));
                parent.put(val, root);
                return root;
            }
        }

        public boolean isSameSet(int v1, int v2){
            if (findSet(v1)==findSet(v2)){
                return true;
            }
            return false;
        }

        public void unionSet(int v1, int v2){
            if (isSameSet(v1,v2)){
                return;
            }else{
                size--;
                int p1 = findSet(v1);
                int p2 = findSet(v2);
                int r1 = rank.get(p1);
                int r2 = rank.get(p2);

                if (r1>r2){
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

    //
}
