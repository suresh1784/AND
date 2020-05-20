package patterns.MergeIntervals;

import java.util.*;



class IntervalsIntersection {

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();

        int i = 0 ;
        int j = 0 ;

        while (i < arr1.length && j < arr2.length){
            Interval iInt = arr1[i];
            Interval jInt = arr2[j];
            if (iInt.start <= jInt.end && iInt.start >= jInt.start ){
                int start = Math.max(iInt.start, jInt.start);
                int end = Math.min(iInt.end, jInt.end);
                intervalsIntersection.add(new Interval(start, end));
            }else if (jInt.start <= iInt.end && jInt.start >= iInt.start ){
                int start = Math.max(iInt.start, jInt.start);
                int end = Math.min(iInt.end, jInt.end);
                intervalsIntersection.add(new Interval(start, end));
            }

            // next i , j
            if (iInt.end < jInt.end){
                i++;
            }else if (iInt.end < jInt.end){
                j++;
            } else {
                i++;
                j++;
            }
        }
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}

