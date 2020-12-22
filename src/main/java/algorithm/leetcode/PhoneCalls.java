package algorithm.leetcode;
import java.util.*;
public class PhoneCalls {

    public static class Interval {
        int start;
        int end;
        int duration;
        int volume;
        int diff;
        public Interval(int start, int duration, int volume) {
            this.start = start;
            this.end = start + duration;
            this.duration = duration;
            this.volume = volume;
            this.diff = volume-duration;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    ", duration=" + duration +
                    ", volume=" + volume +
                    '}';
        }
    }

    //         System.out.println(start);
    //        System.out.println(duration);
    //        System.out.println(volume);

    public static int phoneCalls(List<Integer> start, List<Integer> duration, List<Integer> volume) {

        List<Interval> intervals = new ArrayList<>();
        for (int i = 0 ; i < start.size() ; i++){
            intervals.add(new Interval(start.get(i), duration.get(i), volume.get(i)));
        }

        Collections.sort(intervals, (a,b)-> Integer.compare(b.diff, a.diff));
        Interval curr1 = intervals.get(0);
        Collections.sort(intervals, (a,b)-> Integer.compare(a.start, b.start));



       // System.out.println(intervals);
        Set<Integer> visited = new HashSet<>();

        int maxVolume = 0 ;

       // for (int i = 0 ; i < intervals.size() ; i++){
            Interval curr = curr1;
            int currVolume = curr.volume ;
            for (int j = 1; j < intervals.size() ; j++){
                // check if overlap
                Interval check = intervals.get(j);

                if (curr.end < check.start){
                   currVolume +=  check.volume;
                   curr = check;
                }

            }

            maxVolume = Math.max(maxVolume, currVolume);
      //  }


        return maxVolume;
    }

    public static void main(String[] args) {
        List<Integer> start = Arrays.asList(10, 5,15,18,30);
        List<Integer> duration = Arrays.asList(30, 12, 20 , 35, 35);
        List<Integer> volume = Arrays.asList(50,51,20,25,10);
        System.out.println(phoneCalls(start, duration, volume));
    }


//    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->
//            Integer.compare((volume.get(b)-duration.get(b)), (volume.get(a)-duration.get(a))));
//
//        for (int i = 0 ; i < duration.size() ; i++){
//        pq.offer(i);
//    }

    //            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->
//            Integer.compare((volume.get(b)-duration.get(b)), (volume.get(a)-duration.get(a))));
//
//        while ()
//                System.out.println(pq);
//        return 0;
}
