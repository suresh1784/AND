package algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    static int max = 0;
    public static void main(String[] args){
        int[] w = {3,6,9,5};
        int[] v = {7,2,10,4};
        List<Integer> list = new ArrayList<Integer>();
        List<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();

        ks(w,v,list, result,15,  0,0,0);
        System.out.println("result : "+result);
        System.out.println("max : "+max);

    }

    public static void ks(int[] w, int[] v, List<Integer> list, List<ArrayList<Integer>> result, int t, int l,int currV ,int curW){
    if (l==w.length && curW<=t){
        System.out.println("currV "+currV);
        System.out.println("max "+max);
        max = Math.max(max,currV);
        result.add(new ArrayList<>(list));
        return;
    }else if (l<w.length) {

        for (int i = 0; i <= 1; i++) {
            list.add(i);
           // System.out.println(curW);
            curW = curW + (i*w[l]);
            currV = currV +(i*v[l]);
            ks(w, v, list, result, t, l + 1, currV, curW);
            list.remove(list.size() - 1);
        }
    }
    }


}
