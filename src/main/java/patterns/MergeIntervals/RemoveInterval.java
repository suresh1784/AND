package patterns.MergeIntervals;

import java.util.*;

public class RemoveInterval {
    public static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
    List<List<Integer>> result = new ArrayList<>();

    int removeStart = toBeRemoved[0];
    int removeEnd = toBeRemoved[1];

    for (int[] interval : intervals){
        int currStart = interval[0];
        int currEnd = interval[1];

        if (currStart < removeStart && currEnd <= removeStart){

            result.add(Arrays.asList(currStart, currEnd));
        }else if (currStart >= removeEnd){
            result.add(Arrays.asList(currStart, currEnd));
        } else if (currStart < removeStart && currEnd > removeEnd) {
            result.add(Arrays.asList(currStart, removeStart));
            result.add(Arrays.asList(removeEnd, currEnd));
        } else if ((currStart < removeStart && removeStart < currEnd && currEnd < removeEnd)  ){
            result.add(Arrays.asList(currStart, removeStart));
        } else if ((removeStart < currStart && currStart < removeEnd && currEnd > removeEnd)){
            result.add(Arrays.asList(removeEnd, currEnd));
        } else if (currStart == removeStart  && currEnd > removeEnd){
            result.add(Arrays.asList(removeEnd, currEnd));
        } else if (currEnd== removeEnd && currStart < removeStart){
            result.add(Arrays.asList(currStart, removeStart));
        }
    }
    return result;

    }

    public static void main (String[] args){
        int[][] intervals = {{0,2},{3,4},{5,7}};
        int[] toBeRemoved = {1,6};

        int[][] intervals1 ={{0,5}};
        int[] toBeRemoved1 = {2,3};

        int[][] intervals2 ={{0,100}};
        int[] toBeRemoved2 = {0,50};

        System.out.println(removeInterval(intervals2, toBeRemoved2));
    }
}
