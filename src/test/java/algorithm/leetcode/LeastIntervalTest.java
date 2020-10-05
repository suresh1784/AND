package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeastIntervalTest {
    LeastInterval leastInterval = new LeastInterval();
    @Test
    void leastInterval() {
        char[] t = {'A','A','A','B','B','B'};
        int n = 2;
        int expected = 8 ;
        int actual = leastInterval.leastInterval(t, n);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void leastInterval1() {
        char[] t = {'A','A','A','B','B','B'};
        int n = 0;
        int expected = 6 ;
        int actual = leastInterval.leastInterval(t, n);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void leastInterval2() {
        char[] t = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        int expected = 16 ;
        int actual = leastInterval.leastInterval(t, n);
        Assert.assertEquals(expected, actual);
    }



}