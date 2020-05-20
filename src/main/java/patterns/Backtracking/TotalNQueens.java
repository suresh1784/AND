package patterns.Backtracking;

import java.util.*;

public class TotalNQueens {


    public static int totalNQueens(int n) {
        List<List<Integer>>  queens = new ArrayList<>();
        List<Integer> queen = new ArrayList<>();
        totalNQueensRecursive(n,queen, queens, 0);
        System.out.println(queens);
        return queens.size();
    }



   public  static void  totalNQueensRecursive(int n,List<Integer> queen,List<List<Integer>>  queens, int r){
      if (r == n){
        queens.add(new ArrayList<>(queen));
        return;
      }

      for (int c = 0 ; c < n ; c++){
          queen.add(c);
          if (isValid( queen)) {
              totalNQueensRecursive(n, queen, queens, r + 1);
          }
          queen.remove(queen.size()-1);
      }

    }

    private static boolean isValid(List <Integer> colPlacement) {
        int rowID = colPlacement.size() - 1;
        for (int i = 0; i < rowID; ++i) {
            int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowID));
            if (diff == 0 || diff == rowID - i){
                return false;
            }
        }
        return true;
    }




    public static void main(String[] args){
        System.out.println(totalNQueens(8));
    }



}
