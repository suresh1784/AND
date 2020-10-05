package algorithm.leetcode;

import javax.swing.plaf.IconUIResource;

public class CountOdds {
    public static  int countOdds(int low, int high) {
        int length = high-low-1;
        if (high==low){
            return (high%2);
        }

        if (high%2 == 1 || low%2==1){
            return length/2+(high%2)+(low%2);
        }else {
            return length/2+1;
        }

    }

    public static void main(String[] args) {
        int low = 3;
        int high = 7;

        System.out.println(countOdds(low, high));

        int low1 = 2;
        int high1 = 6;

        System.out.println(countOdds(low1, high1));

        int low2 = 8;
        int high2 = 10;

        System.out.println(countOdds(low2, high2));

        int low3 = 2;
        int high3 = 7;

        System.out.println(countOdds(low3, high3));

        int low4 = 11;
        int high4 = 11;

        System.out.println(countOdds(low4, high4));

        int low5 = 12;
        int high5 = 12;

        System.out.println(countOdds(low5, high5));

    }

}
