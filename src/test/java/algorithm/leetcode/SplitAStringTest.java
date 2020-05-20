package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitAStringTest {
    SplitAString obj = new SplitAString();
    @Test
    void maxScore() {
        String s = "011101";
        int expected = 5;
        int actual = obj.maxScore(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void maxScore1() {
        String s = "00111";
        int expected = 5;
        int actual = obj.maxScore(s);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void maxScore2() {
        String s = "1111";
        int expected = 3;
        int actual = obj.maxScore(s);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void maxScore4() {
        String s = "";
        int expected = 0;
        int actual = obj.maxScore(s);
        Assert.assertEquals(expected, actual);
    }
    @Test
    void maxScore5() {
        String s = "00";
        int expected = 1;
        int actual = obj.maxScore(s);
        Assert.assertEquals(expected, actual);
    }
}