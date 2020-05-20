package algorithm.leetcode;

import java.util.*;
public class LargestValsFromLabels {

    public static int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

        if (values.length==0){
            return 0;
        }

        if (num_wanted == 0 ){
            return 0 ;
        }

        if (use_limit == 0 ){
            return 0;
        }

        Map<String, Integer> m = new HashMap<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int label :labels ){
            map.put(label, 0);
        }


        return dfs(values, labels, num_wanted, use_limit, map, 0, m, 0, -1);
    }

    public static int dfs (int[] values, int[] labels, int num_wanted, int use_limit, Map<Integer, Integer> map, int level, Map<String, Integer> m, int labelCount, int label){

        if (m.get(num_wanted+"_"+level+"_"+labelCount+"_"+label)!= null){
            return m.get(num_wanted+"_"+level+"_"+labelCount+"_"+label);
        }

        if (level>= values.length){
            return 0;
        }

        int with = 0 ;
        labelCount = map.get(labels[level]);
        if (num_wanted>=1 && labelCount < use_limit) {
            map.put(labels[level],labelCount+1 );
          //  System.out.println(values[level]);
            with = values[level] + dfs(values, labels, num_wanted - 1, use_limit, map, level + 1, m, labelCount+1, labels[level]);
            map.put(labels[level],labelCount);
        }
        int without = dfs(values, labels, num_wanted,use_limit, map, level+1 , m,labelCount, labels[level] );
            String key = num_wanted+"_"+level+"_"+labelCount+"_"+label;
            m.put(key, Math.max(with, without));
        return m.get(key);
       // return Math.max(with, without);

    }


    public static void main(String[] args){

        int[] values = {5,4,3,2,1};
        int[] labels = {1,1,2,2,3};
        int num_wanted = 3;
        int use_limit = 1;  // 9

        System.out.println("Result 0 "+largestValsFromLabels(values, labels, num_wanted, use_limit));

        int[] values1 = {5,4,3,2,1};
        int[] labels1 = {1,3,3,3,2};
        int num_wanted1 = 3;
        int use_limit1 = 2; // 12

       System.out.println("Result 1 "+largestValsFromLabels(values1, labels1, num_wanted1, use_limit1));

        int[] values2 = {9,8,8,7,6};
        int[] labels2 = {0,0,0,1,1};
        int num_wanted2 = 3;
        int use_limit2 = 1; // 16

        System.out.println("Result 2 "+largestValsFromLabels(values2, labels2, num_wanted2, use_limit2));

        int[] values3 = {9,8,8,7,6};
        int[] labels3 = {0,0,0,1,1};
        int num_wanted3 = 3;
        int use_limit3 = 2; // 24

        System.out.println("Result 3 "+largestValsFromLabels(values3, labels3, num_wanted3, use_limit3));

        int[] values4 = {2,1,5,2,8};
        int[] labels4 = {2,0,2,2,2};
        int num_wanted4 = 3;
        int use_limit4 = 2; // 14

        System.out.println("Result 3 "+largestValsFromLabels(values4, labels4, num_wanted4, use_limit4));

        int[] values5 = {5,54,99,76,64,35,70,99,58,47,35,69,58,92,59,97,14,31,30,12,26,13,7,16,3,75};
        int[] labels5 = {1,2,2,4,1,0,4,4,0,2,4,1,3,3,5,3,5,1,0,2,4,4,1,3,4,2};
        int num_wanted5 = 13;
        int use_limit5 = 4; // 14

        System.out.println("Result 5 "+largestValsFromLabels(values5, labels5, num_wanted5, use_limit5));



    }
}
