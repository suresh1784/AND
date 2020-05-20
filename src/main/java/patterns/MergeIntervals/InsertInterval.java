package patterns.MergeIntervals;

import java.util.*;



class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();

        int start = newInterval.start;
        int end = newInterval.end;

        // 1 2 3 4 5 6 7 8 9
        // 1---3   5-----8
        //       4---------9


//        for (Interval interval : intervals){
//            if (( interval.start <= start &&interval.end >= start) || (interval.start <=end && interval.end >= end)
//                    || (interval.start <=  start && end <= interval.end ) || (start<= interval.start && interval.end <=end)){
//                start = Math.min(interval.start, start);
//                end = Math.max(interval.end, end);
//            }else {
//                mergedIntervals.add(new Interval(interval.start, interval.end));
//            }
//        }
//
//        mergedIntervals.add(new Interval(start, end));


        boolean isOnce = true;

        for (Interval interval : intervals){

            if (interval.start> end && isOnce){
                mergedIntervals.add(new Interval(start, end));
                isOnce = false;
            }

            if (interval.end < start || interval.start> end){
                mergedIntervals.add(new Interval(interval.start, interval.end));
            }else {
                start = Math.min(interval.start, start);
                end = Math.max(interval.end, end);
            }

        }


        if (isOnce){
            mergedIntervals.add(new Interval(start, end));
        }
      //  mergedIntervals.add(new Interval(start, end));
        //TODO: Write your code here
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
