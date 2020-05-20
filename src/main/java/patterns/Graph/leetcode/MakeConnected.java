package patterns.Graph.leetcode;
import java.util.*;
public class MakeConnected {
    public static int makeConnected(int n, int[][] connections) {
       UnionFind uf = new UnionFind(n);
       int freeConnection = 0 ;

       for (int[] connection : connections){
           int i1 = connection[0];
           int i2 = connection[1];

           if(uf.isSameSet(i1,i2)){
               freeConnection++;
           }else {
               uf.unionSet(i1,i2);
           }
       }

       if (freeConnection >= uf.numSets-1){
          return uf.numSets-1;
       }else {
           return -1;
       }

    }



    static class UnionFind {                                              // OOP style
        private Vector<Integer> p, rank, setSize;
        private int numSets;

        public UnionFind(int N) {
            p = new Vector<Integer>(N);
            rank = new Vector<Integer>(N);
            setSize = new Vector<Integer>(N);
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
                int ret = findSet(p.get(i));
                p.set(i, ret);
                return ret;
            }
        }

        public Boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSet(int i, int j) {
            if (!isSameSet(i, j)) {
                numSets--;
                int x = findSet(i), y = findSet(j);
                // rank is used to keep the tree short
                if (rank.get(x) > rank.get(y)) {
                    p.set(y, x);
                    setSize.set(x, setSize.get(x) + setSize.get(y));
                } else {
                    p.set(x, y);
                    setSize.set(y, setSize.get(y) + setSize.get(x));
                    if (rank.get(x) == rank.get(y)) {
                        rank.set(y, rank.get(y) + 1);
                    }
                }
            }
        }

        public int numDisjointSets() {
            return numSets;
        }

        public int sizeOfSet(int i) {
            return setSize.get(findSet(i));
        }
    }

    public static void main(String[] args){
        int[][] in1 = {{0,1},{0,2},{1,2}}; //4 // 1
        int[][] in2 = {{0,1},{0,2},{0,3},{1,2},{1,3}}; // 6// 2
        int[][] in3 = {{0,1},{0,2},{0,3},{1,2}}; // 6 // -1
        int[][] in4 = {{0,1},{0,2},{3,4},{2,3}}; // 5 // 0
        //100 // 13
        int[][] in5 = {{17,51},{33,83},{53,62},{25,34},{35,90},{29,41},{14,53},{40,84},{41,64},{13,68},{44,85},{57,58},{50,74},{20,69},{15,62},{25,88},{4,56},{37,39},{30,62},{69,79},{33,85},{24,83},{35,77},{2,73},{6,28},{46,98},{11,82},{29,72},{67,71},{12,49},{42,56},{56,65},{40,70},{24,64},{29,51},{20,27},{45,88},{58,92},{60,99},{33,46},{19,69},{33,89},{54,82},{16,50},{35,73},{19,45},{19,72},{1,79},{27,80},{22,41},{52,61},{50,85},{27,45},{4,84},{11,96},{0,99},{29,94},{9,19},{66,99},{20,39},{16,85},{12,27},{16,67},{61,80},{67,83},{16,17},{24,27},{16,25},{41,79},{51,95},{46,47},{27,51},{31,44},{0,69},{61,63},{33,95},{17,88},{70,87},{40,42},{21,42},{67,77},{33,65},{3,25},{39,83},{34,40},{15,79},{30,90},{58,95},{45,56},{37,48},{24,91},{31,93},{83,90},{17,86},{61,65},{15,48},{34,56},{12,26},{39,98},{1,48},{21,76},{72,96},{30,69},{46,80},{6,29},{29,81},{22,77},{85,90},{79,83},{6,26},{33,57},{3,65},{63,84},{77,94},{26,90},{64,77},{0,3},{27,97},{66,89},{18,77},{27,43}};
        System.out.println(makeConnected(100, in5));
    }

}
