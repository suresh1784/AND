package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {
    StringCompression stringCompression = new StringCompression();
    @Test
    void getLengthOfOptimalCompression0() {
        String s = "aaabcccd";
        int k = 2;
        int e = 4;
        int a = stringCompression.getLengthOfOptimalCompression(s,k);
        Assert.assertEquals(e,a);
    }

    @Test
    void getLengthOfOptimalCompression1() {
        String s = "aabbaa";
        int k = 2;
        int e = 2;
        int a = stringCompression.getLengthOfOptimalCompression(s,k);
        Assert.assertEquals(e,a);
    }

    @Test
    void getLengthOfOptimalCompression2() {
        String s = "aaaaaaaaaaa";
        int k = 0;
        int e = 3;
        int a = stringCompression.getLengthOfOptimalCompression(s,k);
        Assert.assertEquals(e,a);
    }

    // "llllllllllttttttttt"
    //1

    @Test
    void getLengthOfOptimalCompression3() {
        String s = "llllllllllttttttttt";
        int k = 1;
        int e = 4;
        int a = stringCompression.getLengthOfOptimalCompression(s,k);
        Assert.assertEquals(e,a);
    }
}