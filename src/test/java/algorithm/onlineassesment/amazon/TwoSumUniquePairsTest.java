package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumUniquePairsTest {

    @Test
    void uniquePairs() {
        int[] in = {1, 1, 2, 45, 46, 46};
        int target = 47;
        TwoSumUniquePairs twoSumUniquePairs = new TwoSumUniquePairs();
        int actual = twoSumUniquePairs.uniquePairs(in, target);
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    void uniquePairs1() {
        int[] in = {1, 1};
        int target = 2;
        TwoSumUniquePairs twoSumUniquePairs = new TwoSumUniquePairs();
        int actual = twoSumUniquePairs.uniquePairs(in, target);
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    void uniquePairs2() {
        int[] in = {1, 5, 1, 5};
        int target = 6;
        TwoSumUniquePairs twoSumUniquePairs = new TwoSumUniquePairs();
        int actual = twoSumUniquePairs.uniquePairs(in, target);
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }
}