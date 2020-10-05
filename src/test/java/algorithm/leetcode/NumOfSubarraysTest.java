package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class NumOfSubarraysTest {
    NumOfSubarrays numOfSubarrays = new NumOfSubarrays();
    @Test
    void numOfSubarrays() {
        int[] arr = {1,3,5};
        int e = 4;
        int a = numOfSubarrays.numOfSubarrays(arr);
        Assert.assertEquals(e,a);
    }

    @Test
    void numOfSubarrays1() {
        int[] arr = {2,4,6};
        int e = 0;
        int a = numOfSubarrays.numOfSubarrays(arr);
        Assert.assertEquals(e,a);
    }

    @Test
    void numOfSubarrays2() {
        int[] arr = {1,2,3,4,5,6,7};
        int e = 16;
        int a = numOfSubarrays.numOfSubarrays(arr);
        Assert.assertEquals(e,a);
    }

    @Test
    void numOfSubarrays3() {
        int[] arr = {100,100,99,99};
        int e = 4;
        int a = numOfSubarrays.numOfSubarrays(arr);
        Assert.assertEquals(e,a);
    }

    @Test
    void numOfSubarrays4() {
        int[] arr = {7};
        int e = 1;
        int a = numOfSubarrays.numOfSubarrays(arr);
        Assert.assertEquals(e,a);
    }
}