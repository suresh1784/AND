package algorithm.recursion;

public class QuiclSelection {
    public static void main(String[] args){
        int [] arr =new int[] {4,8,3,6,2,4,5,2,10,3,12};
        int pivot = 3;
        int lower = 4;
        int upper = arr.length-1;
        System.out.println(hoarePartion(arr, upper, lower));

    }

    static int hoarePartion(int[] arr, int lower, int upper){

        // pre processing

        int middle = (lower+upper)/2;
        int pivot = arr[middle];
        arr[middle] = arr[lower];
        arr[lower] = pivot;
        int leftIndex = 1;
        int rightIndex = arr.length-1;
        // f call
        int right = f1(arr, pivot,  leftIndex+1 , rightIndex);
        arr[lower] = arr[right];
        arr[right] = pivot;
        return right;

    }

    static int f1(int[] arr, int pivot,int leftIndex,int rightIndex){

        //base  case
        if (leftIndex > rightIndex){
            return rightIndex;
        }

        if (arr[leftIndex] <= pivot) {
           return  f1(arr, pivot,leftIndex + 1, rightIndex);
        }
        if (arr[rightIndex] >= pivot) {
            return f1(arr, pivot,  leftIndex, rightIndex - 1);
        }

        int temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = temp ;
        int right = f1(arr, pivot, leftIndex+1, rightIndex-1);
        return  right;
    }


    static int quickSelect(int[] arr, int lower,int upper, int k){
        if (lower == upper){
            System.out.println("Inside Base "+arr[lower]);
           return  arr[lower];
        }

        int pivot_Index = hoarePartion(arr, lower, upper);
        if (pivot_Index == k-1){
            return arr[pivot_Index];
        }
        if (k-1 > pivot_Index){
            return quickSelect(arr, pivot_Index+1, upper, k);
        }

       else
            return quickSelect(arr, lower, pivot_Index-1, k);
    }
}
