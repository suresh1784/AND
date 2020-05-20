package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinNumAnagramSwapTest {
    MinNumAnagramSwap minNumAnagramSwap = new MinNumAnagramSwap();
    @Test
    void minSwap() {
        String s1 = "abc";
        String s2 = "bac";
        int expected = 1;
        int actual = minNumAnagramSwap.minSwap(s1,s2);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void minSwap1() {
        String s1 = "aabcdeer";
        String s2 = "aebcedra";
        int expected = 3;
        int actual = minNumAnagramSwap.minSwap(s1,s2);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void minSwap2() {
        String s1 = "aabcdeerabc";
        String s2 = "aebcedrabac";
        int expected = 4;
        int actual = minNumAnagramSwap.minSwap(s1,s2);
        Assert.assertEquals(expected,actual);
    }
}