package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumSplitsTest {
    NumSplits numSplits = new NumSplits();
    @Test
    void numSplits() {
        String s = "aacaba";
        int e = 2;
        int a = numSplits.numSplits(s);
        Assert.assertEquals(e,a);
    }

    @Test
    void numSplits1() {
        String s = "abcd";
        int e = 1;
        int a = numSplits.numSplits(s);
        Assert.assertEquals(e,a);
    }

    @Test
    void numSplits2() {
        String s = "aaaaa";
        int e = 4;
        int a = numSplits.numSplits(s);
        Assert.assertEquals(e,a);
    }

    @Test
    void numSplits4() {
        String s = "acbadbaada";
        int e = 2;
        int a = numSplits.numSplits(s);
        Assert.assertEquals(e,a);
    }
}