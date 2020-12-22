package algorithm.leetcode;

public class fareEstimator {
    double[] fareEstimator(int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) {
        int len = cost_per_minute.length;
        double[] result = new double[len];
        for (int i = 0 ; i < len ; i++){
            double val = ((cost_per_minute[i])*((double)ride_time))+((cost_per_mile[i] * (double)ride_distance));
            result[i]= val;
        }
        return result;
    }
}
