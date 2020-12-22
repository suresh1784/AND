package patterns.Multithread;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Demonstration {

    private static int SIZE = 25;
    private static Random random = new Random(System.currentTimeMillis());
    private static int[] input = new int[SIZE];

    static private void createTestData() {
        for (int i = 0; i < SIZE; i++) {
            input[i] = random.nextInt(10000);
        }
    }

    static private void printArray(int[] input) {
        System.out.println();
        for (int i = 0; i < input.length; i++)
            System.out.print(" " + input[i] + " ");
        System.out.println();
    }

    public static void main( String args[] ) throws ExecutionException, InterruptedException {
        createTestData();

        System.out.println("Unsorted Array");
        printArray(input);
        long start = System.currentTimeMillis();
        (new MultiThreadedMergeSort()).mergeSort(0, input.length - 1, input);
        long end = System.currentTimeMillis();
        System.out.println("\n\nTime taken to sort = " + (end - start) + " milliseconds");
        System.out.println("Sorted Array");
        printArray(input);
    }
}

class MultiThreadedMergeSort {

    private volatile int SIZE = 25;
    private int[] input = new int[SIZE];
    private int[] scratch = new int[SIZE];
    ExecutorService executorService = Executors.newFixedThreadPool(15);
    void mergeSort(final int start, final int end, final int[] input) throws ExecutionException, InterruptedException {

        if (start == end) {
            return;
        }

        final int mid = start + ((end - start) / 2);
         executorService.submit(() -> {
             try {
                 mergeSort(start, mid, input);
             } catch (ExecutionException e) {
                 e.printStackTrace();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }).get();
        executorService.submit(() -> {
            try {
                mergeSort(mid + 1, end,  input);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).get();

        // sort first half
//        Thread worker1 = new Thread(new Runnable() {
//
//            public void run() {
//                mergeSort(start, mid, input);
//            }
//        });
//
//      //  executorService.submit(()-> mergeSort(start, mid, input));
//
//        // sort second half
//        Thread worker2 = new Thread(new Runnable() {
//
//            public void run() {
//                mergeSort(mid + 1, end, input);
//            }
//        });
//
//        // start the threads
//        worker1.start();
//        worker2.start();
//
//        try {
//
//            worker1.join();
//            worker2.join();
//        } catch (InterruptedException ie) {
//            // swallow
//        }

        // merge the two sorted arrays
        int i = start;
        int j = mid + 1;
        int k;

        for (k = start; k <= end; k++) {
            scratch[k] = input[k];
        }

        k = start;
        while (k <= end) {

            if (i <= mid && j <= end) {
                input[k] = Math.min(scratch[i], scratch[j]);

                if (input[k] == scratch[i]) {
                    i++;
                } else {
                    j++;
                }
            } else if (i <= mid && j > end) {
                input[k] = scratch[i];
                i++;
            } else {
                input[k] = scratch[j];
                j++;
            }
            k++;
        }
    }
}
