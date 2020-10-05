package algorithm.leetcode;

import java.util.*;

public class MaxUniqueSplit {
    public static int maxUniqueSplit(String s) {
        int i = 0 ;
        int j=  s.length()-1;

        char[] chars = s.toCharArray();
        Set<String> set = new HashSet<>();
        while (i<=j){
            StringBuilder s1 = new StringBuilder();
            StringBuilder e1 = new StringBuilder();
            s1.append(chars[i]);
            e1.insert(0,chars[j]);
            int start = i ;
            int end = j;

            while (set.contains(s1.toString()) && i <=j){
                i++;
                s1.append(chars[i]);

            }
            set.add(s1.toString());
            i++;

            while (set.contains(e1.toString()) && i <=j){
                j--;
                e1.insert(0,chars[j]);

            }

            set.add(e1.toString());

            j--;
        }
        return set.size();
    }

    public static void main(String[] args) {
        String s = "aa";
        System.out.println(maxUniqueSplit(s));
    }
}
