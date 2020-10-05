package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetMaxLenTest {
    GetMaxLen getMaxLen = new GetMaxLen();
    @Test
    void getMaxLen() {
        int[] nums = {1,-2,-3,4};
        int expected = 4;
        int actual = getMaxLen.getMaxLen(nums);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void getMaxLen1() {
        int[] nums = {0,1,-2,-3,-4};
        int expected = 3;
        int actual = getMaxLen.getMaxLen(nums);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void getMaxLen2() {
        int[] nums = {-1,-2,-3,0,1};
        int expected = 2;
        int actual = getMaxLen.getMaxLen(nums);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void getMaxLen3() {
        int[] nums = {-1,2};
        int expected = 1;
        int actual = getMaxLen.getMaxLen(nums);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getMaxLen4() {
        int[] nums = {1,2,3,5,-6,4,0,10};
        int expected = 4;
        int actual = getMaxLen.getMaxLen(nums);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getMaxLen5() {
        //[1000000000,1000000000]
        int[] nums = {1000000000,1000000000};
        int expected = 2;
        int actual = getMaxLen.getMaxLen(nums);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void getMaxLen6() {
        //[1000000000,1000000000]
        int[] nums = {1,1};
        int expected = 2;
        int actual = getMaxLen.getMaxLen(nums);
        Assert.assertEquals(expected, actual);
    }

    //



    @Test
    void getMaxLen7() {
        //[-16,0,-5,2,2,-13,11,8]
        int[] nums = {-16,0,-5,2,2,-13,11,8};
        int expected = 6;
        int actual = getMaxLen.getMaxLen(nums);
        Assert.assertEquals(expected, actual);
    }
}