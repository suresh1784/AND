package algorithm.educative.arrays;

import java.util.ArrayList;
import java.util.List;

public class rotateArray {
    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        arr.add(50);
        arr.add(60);
        arr.add(70);
        arr.add(80);
        arr.add(90);
        arr.add(100);

        rotate_array(arr,3);
        System.out.println(arr);
    }

    static void rotate_array(List<Integer> arr, int n) {
        //TODO: Write - Your - Code
        int len = arr.size();

        n = n % len;
        if (n < 0) {

            n = n + len;
        }

        reverse(arr,0,len-1);
        reverse(arr, 0,n-1);
        reverse(arr, n,len-1);
    }


    static void reverse(List<Integer> arr, int start, int end){
        while (start<end){
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }

    }
}
