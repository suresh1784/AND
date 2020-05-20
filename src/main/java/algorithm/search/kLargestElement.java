package algorithm.search;
import java.util.*;

public class kLargestElement{

    private static class Compare {

        private static class GreaterThan implements Comparator<Integer>{
            public int compare(Integer a, Integer b) {
                return (a > b)? -1 :(a.equals(b))? 0 : 1;
            }
        }

        public static final GreaterThan GREAER_THAN = new GreaterThan();
    }

    public static void main(String[] args){
        List<Integer> input = new ArrayList<>();
        input.add(6);
        input.add(3);
        input.add(2);
        input.add(1);
        input.add(5);
        input.add(4);
        System.out.println("Input : " +input);
        System.out.println(findKthLargest(input, 4) );
    }

    public static int findKthLargest(List<Integer> input , int k){
        return findKthLargest(input, k , Compare.GREAER_THAN);
    }


    public static int findKthLargest(List<Integer> input , int k, Comparator<Integer> comp){
       int i = 0;
       int j = input.size()-1;
       Random r = new Random(0);

       while (i<=j){
           int pivot_indx = r.nextInt(j-i+1)+i;
           int newPivot_indx = partitionArounfPivot(input,pivot_indx,comp,i, j) ;
           if (newPivot_indx == k-1){
               return input.get(newPivot_indx);
           }
           else if (newPivot_indx < k-1){
               i=newPivot_indx+1;
           }else{
               j=newPivot_indx-1;
           }
       }
    return -1;
    }

    static int partitionArounfPivot(List<Integer> input , int pivot, Comparator<Integer> comp, int i, int j){
        int pivotValue = input.get(pivot);
        Collections.swap(input, pivot, j);
        int newPivotIndex = i;
        for (int k=i; k<j; k++){
            if (comp.compare(input.get(k), pivotValue) < 0){
                Collections.swap(input,k, newPivotIndex++);
            }
        }
        Collections.swap(input, newPivotIndex, j);
        System.out.println("Pivot  "+pivotValue+"  "+input);
        return newPivotIndex;
    }






}


