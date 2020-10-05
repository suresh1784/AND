package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeSumTest {
RangeSum rangeSum = new RangeSum();
    @Test
    void rangeSum() {
        int[] nums = {1,2,3,4};
        int n = 4;
        int left = 1;
        int right = 5;
        int e = 13;
        int a = rangeSum.rangeSum(nums, n, left, right);
        Assert.assertEquals(e,a);
    }

    @Test
    void rangeSum1() {
        int[] nums = {1,2,3,4};
        int n = 4;
        int left = 3;
        int right = 4;
        int e = 6;
        int a = rangeSum.rangeSum(nums, n, left, right);
        Assert.assertEquals(e,a);
    }


    @Test
    void rangeSum2() {
        int[] nums = {1,2,3,4};
        int n = 4;
        int left = 1;
        int right = 10;
        int e = 50;
        int a = rangeSum.rangeSum(nums, n, left, right);
        Assert.assertEquals(e,a);
    }


    @Test
    void rangeSum3() {
        int[] nums = {1,2,3,4};
        int n = 4;
        int left = 1;
        int right = 5;
        int e = 13;
        int a = rangeSum.rangeSum(nums, n, left, right);
        Assert.assertEquals(e,a);
    }
}