package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _5383Test {
    _5383 obj = new _5383();
    @Test
    void numOfWays1() {
        int n = 1;
        int actual = obj.numOfWays(n);
        int expected = 12;
        Assert.assertEquals(expected,actual);
    }
    @Test
    void numOfWays2() {
        int n = 2;
        int actual = obj.numOfWays(n);
        int expected = 54;
        Assert.assertEquals(expected,actual);
    }

    @Test
    void numOfWays3() {
        int n = 3;
        int actual = obj.numOfWays(n);
        int expected = 246;
        Assert.assertEquals(expected,actual);
    }
    @Test
    void numOfWays4() {
        int n = 7;
        int actual = obj.numOfWays(n);
        int expected = 106494;
        Assert.assertEquals(expected,actual);
    }
    @Test
    void numOfWays5() {
        int n = 5000;
        int actual = obj.numOfWays(n);
        int expected = 30;
        Assert.assertEquals(expected,actual);
    }

}