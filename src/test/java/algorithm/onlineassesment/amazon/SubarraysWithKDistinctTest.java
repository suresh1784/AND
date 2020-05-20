package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraysWithKDistinctTest {

    @Test
    void subarraysWithKDistinct() {
        int[] in = {1,2,1,2,3};
        int expected = 7 ;
        int k = 2;
        SubarraysWithKDistinct subarraysWithKDistinct = new SubarraysWithKDistinct();
        int actual = subarraysWithKDistinct.subarraysWithKDistinct(in, k);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void subarraysWithKDistinct1() {
        int[] in = {1,2,1,3,4};
        int expected = 3 ;
        int k = 3;
        SubarraysWithKDistinct subarraysWithKDistinct = new SubarraysWithKDistinct();
        int actual = subarraysWithKDistinct.subarraysWithKDistinct(in, k);
        Assert.assertEquals(expected,actual);
    }
}