package algorithm.onlineassesment.amazon;


import java.util.*;

public class UnionFind {
    Map<Integer, Integer> parent;
    Map<Integer, Integer> rank;
    int size;
    public UnionFind(int n){
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
            int r1 = rank.get(v1);
            int r2 = rank.get(v2);

            if (r1>r2){
                parent.put(v2, p1);
            }else {
                parent.put(v1,p2);
                if (r1==r2){
                    rank.put(v2, rank.get(v2)+1);
                }
            }
        }
    }

}
