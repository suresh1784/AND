package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogsCroakingTest {
        FrogsCroaking frogsCroaking = new FrogsCroaking();
    @Test
    void minNumberOfFrogs() {
        String s = "croakcroak";
        int expected = 1;
        int actual = frogsCroaking.minNumberOfFrogs(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void minNumberOfFrogs1() {
        String s = "crcoakroak";
        int expected = 2;
        int actual = frogsCroaking.minNumberOfFrogs(s);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void minNumberOfFrogs2() {
        String s = "croakcrook";
        int expected = -1;
        int actual = frogsCroaking.minNumberOfFrogs(s);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void minNumberOfFrogs3() {
        String s = "croakcroa";
        int expected = -1;
        int actual = frogsCroaking.minNumberOfFrogs(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void minNumberOfFrogs4() {
        String s = "croakkaorc";
        int expected = -1;
        int actual = frogsCroaking.minNumberOfFrogs(s);
        Assert.assertEquals(expected, actual);
    }


}