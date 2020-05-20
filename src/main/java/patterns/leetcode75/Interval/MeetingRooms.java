package patterns.leetcode75.Interval;
import java.util.*;
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1 ; i < intervals.length ; i++){
            int start1 = intervals[i][0];
            int end1 = intervals[i][1];

            if (end > start1){
                return false;
            }
        }
        return true;
    }
}
