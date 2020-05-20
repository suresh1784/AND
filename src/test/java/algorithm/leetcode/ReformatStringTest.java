package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReformatStringTest {
ReformatString reformatString = new ReformatString();
    @Test
    void reformat() {
        String s = "a0b1c2";
        String expected = "0a1b2c";
        String actual = reformatString.reformat(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void reformat1() {
        String s = "leetcode";
        String expected = "";
        String actual = reformatString.reformat(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void reformat2() {
        String s = "1229857369";
        String expected = "";
        String actual = reformatString.reformat(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void reformat3() {
        String s = "covid2019";
        String expected = "c2o0v1i9d";
        String actual = reformatString.reformat(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void reformat4() {
        String s = "ab123";
        String expected = "1a2b3";
        String actual = reformatString.reformat(s);
        Assert.assertEquals(expected, actual);
    }
}