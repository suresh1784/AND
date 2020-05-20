package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubStringVowelsTest {
    LongestSubStringVowels longestSubStringVowels = new LongestSubStringVowels();
    @Test
    void longestSubStringVowels() {
        String s = "earthproblem";
        int expected = 3;
        int actual = longestSubStringVowels.longestSubStringVowels(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void longestSubStringVowels1() {
        String s = "letsgosomewhere";
        int expected = 2;
        int actual = longestSubStringVowels.longestSubStringVowels(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void longestSubStringVowels3() {
        String s = "baannaabddab";
        int expected = 2;
        int actual = longestSubStringVowels.longestSubStringVowels(s);
        Assert.assertEquals(expected, actual);
    }
}