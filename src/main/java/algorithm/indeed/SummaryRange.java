package algorithm.indeed;

import java.util.*;

public class SummaryRange {

    static List<String>  summaryRange(int[] num){
        List<String> res = new ArrayList<>();

        int start = num[0];
        int end = num[0];
        String temp = "";


        for (int i = 1; i < num.length; i++){
            if (num[i]-end == 1){
                end = num[i];

                if (i == num.length-1){

                        temp = start+" --> "+end;
                        res.add(temp);

                }
            }else{
                temp = start+" --> "+end;
                res.add(temp);
                start = num[i];
                end = num[i];

            }
        }


        return res;

    }

    public static void main (String[]  args){
        int[] nums = {0,1,2, 4,5,7 , 18, 19 };
        System.out.println(summaryRange(nums));
    }
}
