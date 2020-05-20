package patterns.twopointers;

class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {

        int start = 0 ;
        int end = arr.length-1;

        while (start < end){
            if (arr[start]+arr[end] < targetSum){
                start++;
            } else if (arr[start]+arr[end] > targetSum){
                end--;
            }else{

                return new int[] {start, end};
            }

        }
        // TODO: Write your code here
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}