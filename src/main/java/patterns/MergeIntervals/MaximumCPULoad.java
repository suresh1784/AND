package patterns.MergeIntervals;

import java.util.*;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

class LoadPoint{
    int time;
    boolean isStart;
    int load;

    public LoadPoint(int time, boolean isStart, int load){
        this.time = time;
        this.isStart = isStart;
        this.load = load;
    }
};

class MaximumCPULoad {

    // try priority queue.

    public static int findMaxCPULoad(List<Job> jobs) {
        List<LoadPoint> L = new ArrayList<>();
        for (Job job : jobs){
            L.add(new LoadPoint(job.start, true, job.cpuLoad));
            L.add(new LoadPoint(job.end, false, job.cpuLoad));
        }

        L.sort((a, b)->{
            if (a.time != b.time){
                return Integer.compare(a.time, b.time);
            } else {
                if (a.isStart && !b.isStart){
                    return -1;
                } else if (b.isStart && !a.isStart){
                    return 1;
                }
            }
            return 0;
        });


        int maxLoad = 0 ;
        int currLoad = 0 ;
        for (LoadPoint l : L){
         if (l.isStart){
             currLoad += l.load;
         } else if (!l.isStart){
             currLoad -= l.load;
         }
         maxLoad = Math.max(currLoad,maxLoad);
        }
        return maxLoad;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}