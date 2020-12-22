package patterns.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        int i = 0  , j = 0 ;

        while (i < slots1.length && j < slots2.length){
            int start1 = slots1[i][0];
            int end1 = slots1[i][1];

            int start2 = slots2[j][0];
            int end2 = slots2[j][1];

            if ((start2<=start1 && start1<end2) || (start1<=start2 && start2<end1)){
                int start = Math.max(start1, start2);
                int end = Math.min(end1, end2);
                if ((end-start) >=duration){
                    result.add(start);
                    result.add(start+duration);
                }
            }

            if (end1 < end2){
                i++;
            } else if (end2 < end1){
                j++;
            } else {
                i++;
                j++;

            }
        }
        return  result;
    }

    public static void main(String[] args) {
        MeetingScheduler meetingScheduler = new MeetingScheduler();

        int[][] slots1 = {{10,50},{60,120},{140,210}};
        int[][] slots2 = {{0,15},{60,70}};
        int duration = 8 ;

       List<Integer> result = meetingScheduler.minAvailableDuration(slots1, slots2, duration);
        System.out.println(result);
    }
}
