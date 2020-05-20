package algorithm.onlineassesment.amazon;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

class OrangesRottingTest {

    @Test
    void testPositive(){
        OrangesRotting orangesRotting = new OrangesRotting();
        int[][] in = {{2,1,1},
                {1,1,0},
                {0,1,1}};
        int actual = orangesRotting.orangesRotting(in);
        int expected = 4;
        Assert.assertEquals(actual, expected);
       // assertThat(actual, is(expected));
    }

    @Test
    void testImpossible(){
        OrangesRotting orangesRotting = new OrangesRotting();
        int[][] in = {{2,1,1},
                {0,1,1},
                {1,0,1}};
        int actual = orangesRotting.orangesRotting(in);
        int expected = -1;
        Assert.assertEquals(actual, expected);
    //    assertThat(actual, is(expected));
    }

    @Test
    void testNoFresh(){
        OrangesRotting orangesRotting = new OrangesRotting();
        int[][] in = {{0,2}};
        int actual = orangesRotting.orangesRotting(in);
        int expected = 0;
        Assert.assertEquals(actual, expected);
    //    assertThat(actual, is(expected));
    }
}