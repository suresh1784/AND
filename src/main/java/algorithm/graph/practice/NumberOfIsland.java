package algorithm.graph.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfIsland {

    int[][] island;
    int noOfIsland ;
    UnionFind uf ;
    public NumberOfIsland(int[][] island){
        this.island = island;
        this.noOfIsland = 0;
        this.uf = new UnionFind(island.length * island[0].length);
        System.out.println("InConstructor " + uf.numDisjointSets());
    }


    public int addLand (int i , int j){
        noOfIsland = noOfIsland+1;
        int m = island.length;
        int n = island[0].length;
        island[i][j] = 1;
        for (Coordinates next : Arrays.asList(new Coordinates(i+1,j),new Coordinates(i,j+1),new Coordinates(i-1,j),new Coordinates(i,j-1))){
            if (next.r >=0 && next.r < m && next.c >=0 && next.c< n){
                int x = i*n+j;
                int y = next.r*n+next.c;
                if ((island[next.r][next.c] == 1) && (!uf.isSameSet(x, y))) {
                    uf.unionSet(x,y);
                    noOfIsland--;
                }
            }
        }

        return noOfIsland;
    }

    public static class Coordinates{
        Integer r;
        Integer c;
        public Coordinates(int r, int c){
         this.r = r;
         this.c = c;
        }
    }


    public  static void main(String[] args){

        int[][] island = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        NumberOfIsland ni = new NumberOfIsland(island);
        System.out.println("Number of Island "+ ni.addLand(0,0));
        System.out.println("Number of Island "+ ni.addLand(2,0));
        System.out.println("Number of Island "+ ni.addLand(1,0));

    }

    class UnionFind {                                              // OOP style
        private ArrayList<Integer> p, rank, setSize;
        private int numSets;

        public UnionFind(int N) {
            p = new ArrayList<Integer>(N);
            rank = new ArrayList<Integer>(N);
            setSize = new ArrayList<Integer>(N);
            numSets = N;
            for (int i = 0; i < N; i++) {
                p.add(i);
                rank.add(0);
                setSize.add(1);
            }
        }

        public int findSet(int i) {
            if (p.get(i) == i) return i;
            else {
                int ret = findSet(p.get(i)); p.set(i, ret);
                return ret; } }

        public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

        public void unionSet(int i, int j) {
            if (!isSameSet(i, j)) { numSets--;
                int x = findSet(i), y = findSet(j);
                // rank is used to keep the tree short
                if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
                else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
                    if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }
        public int numDisjointSets() { return numSets; }
        public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
    }

}
