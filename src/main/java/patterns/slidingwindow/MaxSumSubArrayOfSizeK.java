package patterns.slidingwindow;

class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArrayV1(int k, int[] arr) {
        // TODO: Write your code here
       int start = 0 ;
       int sum = 0 ;
       int max = -1;

       for (int end = 0 ; end < arr.length ; end++){
           sum += arr[end];
           if (end >= k-1){
               max = Math.max(max, sum);
               sum = sum-arr[start];
               start++;
           }
       }

       return max;

    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int left = 0 ;
        int right = 0 ;
        int sum = 0;
        int maxSum = 0 ;
        while (right < arr.length){
            sum += arr[right];
            if (right >= k-1){
                maxSum = Math.max(sum,maxSum);
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return maxSum;
    } // findMaxSumSubArray

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}