package patterns.TopKelements;
import java.util.*;

public class KthSmallestElement {
    public static void main(String[] args) {
        int result = KthSmallestElement.findKthSmallestNumberV4(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestElement.findKthSmallestNumberV4(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestElement.findKthSmallestNumberV4(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }


//    Kth Smallest Number (hard)
//================================
//
//    Given an unsorted array of numbers, find Kth smallest number in it.
//
//    Please note that it is the Kth smallest number in the sorted order, not the Kth distinct element.
//
//// Input: [1, 5, 12, 2, 11, 5], K = 3
//// Output: 5
//// Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].



//    Different Ways :
//
//            ## Using Sorting
//
//    Time Complexity  - n o(logn) for
//    sorting and then constant time for
//    retriving the K the element && Space Complexity - constant


    public static int findKthSmallestNumberV1(int[] nums, int k) {
        Arrays.sort(nums);
        if (k < nums.length){
            return nums[k-1];
        }
        return -1;
    }

//----------------------------------------------------------
//
//        ## Using Max Heap
//    Time Complextity - n log K (always main the K elements and
//            keep removing the max Elements from the heap) good for group of elements
//    Space  - K

    public static int findKthSmallestNumberV2(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for (int i = 0 ; i < k ; i++){
            maxHeap.offer(nums[i]);
        }
        int count = 0 ;
        while (count+k < nums.length){
            if (nums[count+k]<maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(nums[count+k]);
            }
            count++;
        }

        if (maxHeap.size()==k){
            return maxHeap.peek();
        }

        return -1;
    }


//-----------------------------------------------------------
//        ## Using Min Heap
//    Time Complexity - k log n (similar to Max Heap in the reverse way)
//    Space - K

    public static int findKthSmallestNumberV3(int[] nums, int k) {

        return -1;
    }
//
//----------------------------------------------------------------
//        ## Using Partition of Quick Sort
//    Time Complexity - best case - O(n) worst case o(n^2)
//    Space - constant

    public static int findKthSmallestNumberV4(int[] nums, int k) {

        return nums[quickSortRecursive(nums, k , 0 , nums.length-1)];
    }

    static int quickSortRecursive(int[] nums, int k , int left , int right){
        int p = quickSortPartition(nums,left ,right);
        if (p==k-1){
            return p;
        }
        if (p > k-1){
            return quickSortRecursive (nums, k , left, p-1);
        }else {
            return quickSortRecursive (nums, k , p+1, right);
        }

    }

    static int quickSortPartition(int[] nums, int start, int end){
        int left = start;
        int pivotValue = nums[start];
        swap(nums, left, end);
        for (int right = start; right <= end ; right++){
            if (nums[right] < pivotValue){
                swap(nums, left,right);
                left++;
            }
        }

        swap(nums,end,left);
        return left;

    }

    static int[] swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

//---------------------------------------------------------------
//
//        ## Using Randomized Partitioning Scheme of Quicksort
    public static int findKthSmallestNumberV5(int[] nums, int k) {

        return -1;
    }

//---------------------------------------------------------------
//
//        ## Using the Median of Medians
//    Time & Space Complexity
    public static int findKthSmallestNumberV6(int[] nums, int k) {

        return -1;
    }



}
