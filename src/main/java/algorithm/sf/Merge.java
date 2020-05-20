package algorithm.sf;

public class Merge {
    public static int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][intervals[0].length];
        for (int[] interval: intervals){
            int start = interval[0];
            int end = interval[1];

        }

        return result;
    }


    public static void main(String[] args){
        //Input: [[1,3],[2,6],[8,10],[15,18]]
        //Output: [[1,6],[8,10],[15,18]]
        //Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(input);
        System.out.println(result);
    }
}
