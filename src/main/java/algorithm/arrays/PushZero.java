package algorithm.arrays;

/* Java program to push zeroes to back of array */
import java.io.*;

class PushZero
{
    // Function which pushes all zeros to end of an array.
    static void pushZerosToEnd(int arr[], int n)
    {
        int count = 0;
        int size = arr.length-1;
        for (int i = 0; i <=size; i++){
            if (arr[i] != 0){

                arr[count++] = arr[i];
            }
        }

        while (count <=size){
            arr[count++]=0;
        }
    }

    /*Driver function to check for above functions*/
    public static void main (String[] args)
    {
        int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;
        pushZerosToEnd(arr, n);
        System.out.println("Array after pushing zeros to the back: ");
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
}
/* This code is contributed by Devesh Agrawal */

