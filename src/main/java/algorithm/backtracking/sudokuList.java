package algorithm.backtracking;
import java.util.*;

public class sudokuList {
    public static void main(String[] args){
        int[][] board1 = new int[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };

        List<List<Integer>> board  = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        List<Integer> r3 = new ArrayList<>();
        List<Integer> r4 = new ArrayList<>();
        List<Integer> r5 = new ArrayList<>();
        List<Integer> r6 = new ArrayList<>();
        List<Integer> r7 = new ArrayList<>();
        List<Integer> r8 = new ArrayList<>();
        List<Integer> r9 = new ArrayList<>();
        Collections.addAll(r1,3, 0, 6, 5, 0, 8, 4, 0, 0);
        Collections.addAll(r2,5, 2, 0, 0, 0, 0, 0, 0, 0);
        Collections.addAll(r3,0, 8, 7, 0, 0, 0, 0, 3, 1);
        Collections.addAll(r4,0, 0, 3, 0, 1, 0, 0, 8, 0);
        Collections.addAll(r5,9, 0, 0, 8, 6, 3, 0, 0, 5);
        Collections.addAll(r6,0, 5, 0, 0, 9, 0, 6, 0, 0);
        Collections.addAll(r7,1, 3, 0, 0, 0, 0, 2, 5, 0);
        Collections.addAll(r8,0, 0, 0, 0, 0, 0, 0, 7, 4);
        Collections.addAll(r9,0, 0, 5, 2, 0, 6, 3, 0, 0);
        Collections.addAll(board,r1,r2,r3,r4,r5,r6,r7,r8,r9);

        solveSudoku(board);
        System.out.println(board);



    }

    static boolean solveSudoku(List<List<Integer>> partialSolution){
        return solvePartialSolution(0,0,partialSolution);
    }

    static boolean solvePartialSolution(int i, int j, List<List<Integer>> partialSolution){

        if (i==partialSolution.size()){
            i=0;
            if (++j == partialSolution.get(i).size()){
                return true;
            }
        }

        if (partialSolution.get(i).get(j) != 0){
           return solvePartialSolution(i+1,j,partialSolution);
        }

        for(int a = 1; a<=partialSolution.size();++a){
            if (isValidValue(i,j,a,partialSolution)){
                partialSolution.get(i).set(j,a);
                if(solvePartialSolution(i+1,j,partialSolution)){
                    return true;
                }
            }
        }
        partialSolution.get(i).set(j,0);
        return false;
    }


    static boolean isValidValue(int i, int j, int val, List<List<Integer>> partialSolution){
        for (List<Integer> element : partialSolution){
            if (val == element.get(j)){
                return false;
            }
        }

        for (int k=0; k< partialSolution.size();++k){
            if (val == partialSolution.get(i).get(k)){
                return false;
            }
        }

        int regionSize = (int) Math.sqrt(partialSolution.size());
        int I = i/regionSize;
        int J = j/regionSize;

        for (int a=0; a< regionSize; ++a){
            for (int b=0; b< regionSize; ++b){

                if (val == partialSolution.get(regionSize*I+a).get(regionSize*J+b)){
                    return false;
                }
            }
        }



        return true;
    }


}
