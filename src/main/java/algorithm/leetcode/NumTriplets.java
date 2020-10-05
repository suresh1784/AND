package algorithm.leetcode;

import java.util.*;


public class NumTriplets {
    public static int numTriplets(int[] nums1, int[] nums2) {
        //
        int result = 0 ;
        Map<Long, Integer> mapSquareCount1 = new HashMap<>();
        Map<Long, Integer> mapSquareCount2 = new HashMap<>();

        // Type 1

        for (int num : nums1){
            long square = (long)(num*num);
            mapSquareCount1.put(square, mapSquareCount1.getOrDefault(square, 0)+1);
        }

        System.out.println("mapSquareCount1 "+mapSquareCount1);

        for (int i = 0 ; i < nums2.length ; i++){
            for (int j = i+1 ; j < nums2.length ; j++ ){
                long product = (long)(nums2[i]*nums2[j]);
                if (mapSquareCount1.containsKey(product)){
                    System.out.println("num2 "+i + "    "+j);
                    int currCount = mapSquareCount1.get(product);
                    result +=currCount;
                }
            }
        }


        // Type 2

        for (int num : nums2){
            long square = (long)(num*num);
            mapSquareCount2.put(square, mapSquareCount2.getOrDefault(square, 0)+1);
        }
        System.out.println("mapSquareCount2 "+mapSquareCount2);

        for (int i = 0 ; i < nums1.length ; i++){
            for (int j = i+1 ; j < nums1.length ; j++ ){
                long product = (long)(nums1[i]*nums1[j]);
                if (mapSquareCount2.containsKey(product)){
                    System.out.println("num1 "+i + "    "+j);
                    int currCount = mapSquareCount2.get(product);
                    result +=currCount;
                }
            }
        }


        return result ;
    }


    public static void main(String[] args) {
        int[] nums1 = {4,7,9,11,23};
        int[] nums2 = {3,5,1024,12,18};

    //    System.out.println(numTriplets(nums1, nums2));

        int[] nums3 = {43024,99908};

        int[] nums4 ={1864};

        System.out.println(numTriplets(nums3, nums4));

    }
}
