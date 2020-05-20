package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestHappyStringTest {
    LongestHappyString longestHappyString = new LongestHappyString();
    @Test
    void longestDiverseString() {
        int a = 1, b = 1, c = 7;
        String expected= "ccaccbcc";
        String actual = longestHappyString.longestDiverseString(a,b,c);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void longestDiverseString1() {
        int a = 2, b = 2, c = 1;
        String expected= "aabbc";
        String actual = longestHappyString.longestDiverseString(a,b,c);
        Assert.assertEquals(expected,actual);
    }


    @Test
    void longestDiverseString2() {
        int a = 7, b = 1, c = 0;
        String expected= "aabaa";
        String actual = longestHappyString.longestDiverseString(a,b,c);
        Assert.assertEquals(expected,actual);
    }
}