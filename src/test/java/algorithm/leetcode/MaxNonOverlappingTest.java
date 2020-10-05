package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.PrinterMakeAndModel;

import static org.junit.jupiter.api.Assertions.*;

class MaxNonOverlappingTest {
    MaxNonOverlapping mn = new MaxNonOverlapping();
    @Test
    void maxNonOverlapping() {
        int[] nums = {1,1,1,1,1};
        int target = 2;
        int e = 2 ;
        int a = mn.maxNonOverlapping(nums, target);
        Assert.assertEquals(e, a);
    }

    @Test
    void maxNonOverlapping2() {
        int[] nums = {-1,3,5,1,4,2,-9};
        int target = 6;
        int e = 2 ;
        int a = mn.maxNonOverlapping(nums, target);
        Assert.assertEquals(e, a);
    }


    @Test
    void maxNonOverlapping3() {
        int[] nums = {-2,6,6,3,5,4,1,2,8};
        int target = 10;
        int e = 3 ;
        int a = mn.maxNonOverlapping(nums, target);
        Assert.assertEquals(e, a);
    }


    @Test
    void maxNonOverlapping4() {
        int[] nums = {0,0,0};
        int target = 0;
        int e = 3 ;
        int a = mn.maxNonOverlapping(nums, target);
        Assert.assertEquals(e, a);
    }

    @Test
    void maxNonOverlapping5() {
        int[] nums = {2,2,3,-2,2,-3,3,-2,1,3};
        int target = 2;
        int e = 4 ;
        int a = mn.maxNonOverlapping(nums, target);
        Assert.assertEquals(e, a);
    }

}