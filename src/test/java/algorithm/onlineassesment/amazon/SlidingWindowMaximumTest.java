package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowMaximumTest {
    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
    @Test
    void maxSlidingWindow() {
        int[] in = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] expected = {3,3,5,5,6,7};
        int[] actual = slidingWindowMaximum.maxSlidingWindow(in, k);
        Assert.assertEquals(expected, actual);
    }
}