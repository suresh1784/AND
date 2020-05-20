package algorithm.recursion;

import java.util.Arrays;
import java.util.stream.Stream;

public class MultipleRecursion {
    public static void main(String[] args){
    int[] arr = new int[] {1,2,3,4, 5,6,7,8,9};
        int[] arr1 = new int[] {9,8,7,6,5,4,3,2,1};
//    boolean isSorted = isSorted(arr, 0);
//        System.out.println(isSorted);
//
//        boolean isSortedMultiple  = isSortedMultiple(arr, "init");
//        System.out.println(isSortedMultiple);

        int[] mergeSort = mergeSort(arr1);
       System.out.println(Arrays.toString(mergeSort));

       // int[] arr2 = new int[] {4,5,6,3,2,3,4,4,8};
        //System.out.printf("Occurance " + occuranceCount(4,arr2,3) );

        int[][] matrix = new int[][] {{0,1,1,1},
                                      {1,0,1,1},
                                      {1,0,1,1},
                                      {1,0,0,0}};

     //   System.out.println(mazePath(matrix,0,0));
    }


    static boolean mazePath(int[][] mat, int i, int j){
        if (i==mat[0].length-1 && j==mat.length-1){
            return true;
        }

        if (mat[i][j]==1){
            return false;
        }

        if ((mat[i][j] == 0)) {
            System.out.println("i : "+i +" j : "+j);
            return (mat[i][j] == 0) && (mazePath(mat, i, j + 1) || mazePath(mat, i + 1, j) || mazePath(mat, i + 1, j+1) );
        }

        return true;
    }

    static boolean isSorted(int[] arr,int i){
        if (i+2 >= arr.length){
            return arr[i] <= arr[i+1];
        }

        return (arr[i] <= arr[i+1]) && isSorted(arr, i+1);
    }

    static boolean isSortedMultiple(int[] arr, String call){
        System.out.println(call);
        int n = arr.length;
        if (n <= 1){
            return true;
        }

        System.out.println("n ---------------"+n);
        System.out.println(Arrays.toString(arr));
        System.out.println("arr[(n/2)-1]---------------"+arr[(n/2)-1]);
        System.out.println("arr[(n/2)]-----------------"+arr[(n/2)]);
        return isSortedMultiple(Arrays.copyOfRange(arr, 0,n/2), "1st") && ((arr[(n/2)-1])<= (arr[(n/2)])) && isSortedMultiple(Arrays.copyOfRange(arr,n/2, n), "2nd");

    }


    static int[] mergeSort(int[] arr){
        int n = arr.length;
        if (n<=1){
            return arr;
        }


        int[] a1 = mergeSort(Arrays.copyOfRange(arr,0, n/2));
        int[] a2 = mergeSort(Arrays.copyOfRange(arr ,n/2, n));
        System.out.println("a1 "+Arrays.toString(a1));
        System.out.println("a2 "+Arrays.toString(a2));

        return mergeRecursive(a1,a2,0,0);
    }


    public static <T> Object[] concatenate(T[] a, T[] b)
    {
        // Function to merge two arrays of
        // same type
        return Stream.of(a, b)
                .flatMap(Stream::of)
                .toArray();

        // Arrays::stream can also be used in place
        // of Stream::of in the flatMap() above.
    }

    static int[] con(int[] a, int[] b){
        int[] c = new int[a.length+b.length];
        int i = 0;
        for (i=0; i < a.length; i++){
            c[i] = a[i];
        }

        for (int j=i , k =0; k<b.length; k++,j++ ){
            c[j] = b[k];
        }
        return c;

    }

    static int[] mergeIterative(int[] a, int[] b){
        int[] c = new int[a.length+b.length];
        for (int i=0,j=0,k=0; i<a.length||j<b.length;k++) {
            if (a.length == i) {
                c[k] = b[j];
                j++;
            } else if (b.length == j) {
                c[k] = a[i];
                i++;
            } else if (a[i] > b[j]) {
                c[k] = b[j];
                j++;
            } else if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
            }
        }
        System.out.println("c ------ "+Arrays.toString(c));
        return c;

    }

    static int[] mergeRecursive(int[] a, int[] b, int i, int j ){
         if (a[i] <= b[j]){
            return con(new int[a[i]],mergeRecursive(a,b,i+1,j));
        }else if (a[i]>b[j]){
            return con(new int[b[j]],mergeRecursive(a,b,i,j+1));
        }else if (a.length <i){
            return Arrays.copyOfRange(b,j,b.length-1);
        }else if (b.length < j){
            return Arrays.copyOfRange(b,i,a.length-1);
        }
        return new int[0];
    }


    static int occuranceCount(int x, int[] arr, int i){
        if (arr.length == i){
            return 0;
        }

        return ((arr[i]==x)? 1 :0) + occuranceCount(x,arr,i+1);
    }
}


