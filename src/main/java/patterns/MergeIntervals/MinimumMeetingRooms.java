package patterns.MergeIntervals;

import java.util.*;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class Endpoint {
    int time;
    boolean isStart;

    public Endpoint(int time , boolean isStart){
        this.time = time;
        this.isStart = isStart;
    }
}

class MinimumMeetingRooms {

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
    meetings.sort((a,b)-> Integer.compare(a.start, b.start));

    int count = 0 ;
    PriorityQueue<Meeting> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.end, b.end));

    for (Meeting meeting : meetings){
        if (pq.isEmpty()){
            pq.offer(meeting);
        } else {
            while (!pq.isEmpty() && pq.peek().end <= meeting.start){
                pq.poll();
            }
            pq.offer(meeting);
        }
        count = Math.max(count, pq.size());
    }

    return count;
    } // findMinimumMeetingRooms

    public static int findMinimumMeetingRoomsv1(List<Meeting> meetings) {
        List<Endpoint>  E = new ArrayList<>();
        for (Meeting meeting : meetings ){
            E.add(new Endpoint(meeting.start, true));
            E.add(new Endpoint(meeting.end, false));
        }

        E.sort((a,b) ->{
            if (a.time != b.time){
                return Integer.compare(a.time, b.time);
            }else {
                if (a.isStart && !b.isStart){
                    return 1;
                }else if (b.isStart && !a.isStart){
                    return -1;
                }
            }

            return 0;
        });
        int count = 0 ;
        int maxCount = 0;
        for (Endpoint e : E){
            if (e.isStart){
                count++;
            }else {
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}
