package algorithm.leetcode;
import java.util.*;
public class BeautyMatrix {
    public static void main(String[] args) {
        int[][] in = {{1,2,2,3}, {3,4,10,4}, {2,10,1,2}, {5,4,4,5}};
        beautyMatrix(in);
    }

    static int[][] beautyMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        List<Pair> list = new ArrayList<>();

        for (int i = 0 ; i < m ; i=i+2){
            for (int j = 0 ; j< n ; j=j+2){
                List<Integer> list1 = new ArrayList<>();
                list1.add(matrix[i][j]);
                list1.add(matrix[i][j+1]);
                list1.add(matrix[i+1][j]);
                list1.add(matrix[i+1][j+1]);
                list.add(new Pair(i,j, list1));
            }
        }

        list.sort((a,b)-> {
            if (Integer.compare(a.missingNum,b.missingNum)==0){
                return a.index-b.index;
            }
            return a.missingNum-b.missingNum;
        });

        System.out.println("List -> "+list);
       
        int[][] result = new int[m][n];
            int index =0 ;
            for (int i = 0 ; i < m ; i=i+2){
                for (int j = 0 ; j< n ; j=j+2) {
                    List<Integer> list2 = list.get(index).list;
                    result[i][j] = list2.get(0);
                    result[i][j+1] = list2.get(1);
                    result[i+1][j] = list2.get(2);
                    result[i+1][j+1] = list2.get(3);
                    index++;
                }

            }


    return result;
    }

    static class Pair{
        int i;
        int j;
        int index;
        List<Integer> list;
        int missingNum ;

        public Pair(int i , int j , List<Integer> list){
            this.i = i ;
            this.j = j ;
            this.index = i*10+j;
            this.list = list;
            this.missingNum = getMissingNum(list);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "i=" + i +
                    ", j=" + j +
                    ", index=" + index +
                    ", set=" + list +
                    ", missingNum=" + missingNum +
                    '}';
        }

        int getMissingNum(List<Integer> list){
            for (int i = 1 ; i <=5 ; i++){
                if (!list.contains(i)){
                    return i;
                }
            }
            return -1;
        }
    }


}
