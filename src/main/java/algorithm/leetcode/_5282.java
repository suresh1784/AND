package algorithm.leetcode;

import java.util.*;

public class _5282 {

    public static void main (String[] args){
        int[][] i1 = {{0,0}, {0,1}};
        System.out.println(minFlips(i1));
    }

    public static int minFlips(int[][] mat) {
        int m = mat.length;
        if (m == 0) {
            return -1;
    }
        int n = mat[0].length;

        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int result = minFlipsRecursive(mat,m, n, set, map);

        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }//

  public static  int  minFlipsRecursive(int[][] mat, int m , int n, HashSet<String> set, HashMap<String, Integer> dp ){
        if (matSum(mat)==0){
           // System.out.println("------->>><<<<<");
            return 0;
        }

        String t = "";
        for(int i = 0; i < n; i++){
          for(int j = 0; j < m; j++){
              t += Integer.toString(mat[i][j]);
          }
        }

        if(dp.containsKey(t)){
            return dp.get(t);
        }

      if(set.contains(t)) return Integer.MAX_VALUE;
      set.add(t);
        int min = Integer.MAX_VALUE;

        for (int a = 0 ; a < mat.length ; a++){
            for (int b = 0 ; b < mat[0].length ; b++){
                mat = flipNeighbour(mat,a,b);
                int count  = minFlipsRecursive(mat, m, n, set, dp);
                if(count != Integer.MAX_VALUE)
                min = Math.min(count, min)+1;
             //   System.out.println("min "+min);
                mat = flipNeighbour(mat,a,b);
            }
        }

      set.remove(t);
      dp.put(t, min);

        return min;
  }

  public static int[][] flipNeighbour(int[][] mat , int i , int j){
        mat[i][j] = mat[i][j]==0 ? 1: 0;
        if (i-1 >= 0 ){
            mat[i-1][j] = mat[i-1][j]==0 ? 1: 0;
        }

        if (i+1< mat.length){
            mat[i+1][j] = mat[i+1][j]==0 ? 1: 0;
        }

      if (j-1 >= 0 ){
          mat[i][j-1] = mat[i][j-1]==0 ? 1: 0;
      }

      if (j+1< mat[0].length){
          mat[i][j+1] = mat[i][j+1]==0 ? 1: 0;
      }

        return mat;
  }


  public static int matSum(int[][] mat){
        int sum = 0 ;

        for (int i = 0 ; i < mat.length ; i++){
            for (int j = 0 ; j < mat[0].length ; j++){
                sum += mat[i][j];
            }
        }
        return sum;
  }

}
