package patterns.DynamicProgramming.Pattern5;

public class LongestIncreasingSubsequence {
    public int findLISLength(int[] nums) {
        return 0;
    }


    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(lis.findLISLength(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(lis.findLISLength(nums));
    }
}
