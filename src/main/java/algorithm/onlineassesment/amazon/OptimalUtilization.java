package algorithm.onlineassesment.amazon;
import java.util.*;
public class OptimalUtilization {
    public List<int[]> optimalUtilization(List<int[]> a, List<int[]> b, int target){
        List<int[]> result = new ArrayList<>();
        a.sort((v1,v2)-> Integer.compare(v1[1],v2[1]));
        b.sort((v1,v2)-> Integer.compare(v1[1],v2[1]));
        int i = 0 ;
        int j = b.size()-1;
        int diff = Integer.MAX_VALUE;
        while (i < a.size() && j >= 0 ){
            int currSum = a.get(i)[1]+b.get(j)[1];
            if (currSum <= target && target-currSum <= diff){
                if (target-currSum == diff ){
                    int[] value = {a.get(i)[0], b.get(j)[0]};
                    result.add(value);
                }else {
                    diff = target-currSum;
                    result = new ArrayList<>();
                    int[] value = {a.get(i)[0], b.get(j)[0]};
                    result.add(value);
                }
                i++;
            }else {
                j--;
            }
        }

        return result;
    }
}
