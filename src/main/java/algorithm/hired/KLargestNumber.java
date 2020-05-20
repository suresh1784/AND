package algorithm.hired;
import java.util.*;

public class KLargestNumber {


//    public static int findKthSmallestNumber(int[] nums, int k) {
//        return findKthSmallestNumberRec(nums, k, 0, nums.length - 1);
//    }

    public static long solution(long[] numbers, long k) {
        return findKthLargestNumberRec(numbers, k, 0, numbers.length - 1);
    }

    public static long findKthLargestNumberRec(long[] nums, long k, int start, int end) {
        int p = partition(nums, start, end);

        if (p == k - 1)
            return nums[p];

        if (p > k - 1) // search lower part
            return findKthLargestNumberRec(nums, k, start, p - 1);

        // search higher part
        return findKthLargestNumberRec(nums, k, p + 1, end);
    }

    private static int partition(long[] nums, int low, int high) {
        if (low == high)
            return low;

        long pivot = nums[high];
        for (int i = low; i < high; i++) {
            // all elements less than 'pivot' will be before the index 'low'
            if (nums[i] > pivot)
                swap(nums, low++, i);
        }
        // put the pivot in its correct place
        swap(nums, low, high);
        return low;
    }

    private static void swap(long[] nums, int i, int j) {
        long temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        long result = KLargestNumber.solution(new long[] { 1, 4, 3, 4, 2, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KLargestNumber.solution(new long[] { 1, 5, 12, 2, 11, 5 }, 5);
        System.out.println("Kth smallest number is: " + result);

        result = KLargestNumber.solution(new long[] { 5, 12, 11, -1, 12 }, 4);
        System.out.println("Kth smallest number is: " + result);
    }
}
