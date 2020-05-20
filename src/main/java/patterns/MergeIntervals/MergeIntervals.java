package patterns.MergeIntervals;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals, (a, b)-> Integer.compare(a.start, b.start));
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        // TODO: Write your code here

        int start = intervals.get(0).start ; //1
        int end = intervals.get(0).end ; // 4

// 0 1 2 3 4 5 6 7 8 9
//   1-----4
//     2-----5
//               7---9


        for (Interval interval : intervals){
            if (interval.start<= end){
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
            }else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }


        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}