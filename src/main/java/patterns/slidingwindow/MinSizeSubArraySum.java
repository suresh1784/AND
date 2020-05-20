package patterns.slidingwindow;

class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        // TODO: Write your code here
        int start = 0 ;
        int length = 0 ;
        int sum = 0 ;
        int minLength = Integer.MAX_VALUE;

        for (int end = 0 ; end < arr.length ; end++){
            sum+=arr[end];
            while (sum>=S) {

                if (sum==S) {
                    length = end - start;
                    minLength = Math.min(minLength, length+1);
                }
                sum = sum-arr[start];
                start++;

            }

        }

        return minLength;
    }


    public static int findMinSubArrayv1(int S, int[] arr) {
        int currSum = 0 ;
        int left = 0 ;
        int right = 0 ;
        int minLength = arr.length;

        while (right < arr.length){
            currSum += arr[right];
            while (currSum >= S){
                minLength = Math.min(minLength, right-left+1);
                currSum = currSum - arr[left];
                left++;
            }
            right++;
        }
        return minLength;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArrayv1(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArrayv1(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArrayv1(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
