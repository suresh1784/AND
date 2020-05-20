package patterns.mock;

import java.util.*;

public class ThreeSumSmaller {
    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);


        int count = 0 ;

        for (int i = 0 ; i < nums.length ; i++){
            int t1 = target - nums[i];
            for (int j = i+1; j < nums.length ; j++){
                int t2 = t1 - nums[j];
                for (int k = j+1; k< nums.length ; k++){
                    int t3 = t2-nums[k];
                    if (t3>=1){
                        count++;
                    }
                }
            }
        }

    return count;
    }



    public static void main(String[] args){
    int[] in = {-2,0,1,3,4};
        System.out.println(threeSumSmaller(in, 2));

    }
}
