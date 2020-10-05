package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSumTwoNoOverlapTest {
    MaxSumTwoNoOverlap maxSumTwoNoOverlap = new MaxSumTwoNoOverlap();
    @Test
    void maxSumTwoNoOverlap() {
        int[] A = {0,6,5,2,2,5,1,9,4};
        int L = 1, M = 2;

        int e = 20;
        int a = maxSumTwoNoOverlap.maxSumTwoNoOverlap(A,L,M);
        Assert.assertEquals(e, a);
    }


    @Test
    void maxSumTwoNoOverlap1() {
        int[] A = {3,8,1,3,2,1,8,9,0};
        int L = 3, M = 2;

        int e = 29;
        int a = maxSumTwoNoOverlap.maxSumTwoNoOverlap(A,L,M);
        Assert.assertEquals(e, a);
    }

    @Test
    void maxSumTwoNoOverlap2() {
        int[] A = {2,1,5,6,0,9,5,0,3,8};
        int L = 4, M = 3;

        int e = 31;
        int a = maxSumTwoNoOverlap.maxSumTwoNoOverlap(A,L,M);
        Assert.assertEquals(e, a);
    }
}