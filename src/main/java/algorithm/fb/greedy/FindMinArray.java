package algorithm.fb.greedy;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMinArray {
    private class Pair {
        int value;
        int index;
        public Pair (int value, int index){
            this.value = value;
            this.index = index;
        }
    }
    int[] findMinArray(int[] arr, int k) {
        // Write your code here
        int[] result = new int[arr.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        for (int i = 0; i < Math.min(k + 1, arr.length); i++) {
            pq.offer(new Pair(arr[i], i));
        }
        int count = 0;
        int i = 0;
        PriorityQueue<Pair> pq1 = new PriorityQueue<>((a,b)-> Integer.compare(a.index, b.index));
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            if (count + top.index  <= k) {
                result[i] = top.value;
                i++;
                count += top.index ;
            } else {
                pq1.offer(top);
            }
        }

        while (!pq1.isEmpty()){
            Pair top = pq1.poll();
            result[i]= top.value;
            i++;
        }

        if (k+1 < arr.length){
            for (int j = k+1; j < arr.length ; j++ ){
                result[i]= arr[j];
            }
        }

        return result;
    }













    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int n_1 = 3, k_1 = 2;
        int[] arr_1 = {5, 3, 1};
        int[] expected_1 = {1, 5, 3};
        int[] output_1 = findMinArray(arr_1,k_1);
        check(expected_1, output_1);

        int n_2 = 5, k_2 = 3;
        int[] arr_2 = {8, 9, 11, 2, 1};
        int[] expected_2 = {2, 8, 9, 11, 1};
        int[] output_2 = findMinArray(arr_2,k_2);
        check(expected_2, output_2);

        int n_3 = 5, k_3 = 3;
        int[] arr_3 = {7, 6, 9, 2, 1};
        int[] expected_3 = {2 ,7 ,6 ,9 ,1};
        int[] output_3 = findMinArray(arr_3,k_3);
        check(expected_3, output_3);

        int n_4 = 5, k_4 = 23;
        int[] arr_4 = {9,4,3,8,9,5,7,2,3,4,7,8,5,6,3,5,4,0,8};
        int[] expected_4 = {0,3,4,5,9,8,9,7,2,3,4,7,8,5,6,3,5,4,8};
        int[] output_4 = findMinArray(arr_4,k_4);
        check(expected_4, output_4);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new FindMinArray().run();
    }
}
