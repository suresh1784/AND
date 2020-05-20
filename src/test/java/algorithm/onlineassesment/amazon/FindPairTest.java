package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPairTest {

    @Test
    void findPair() {
        int[] nums= {1, 10, 25, 35, 60};
        int target = 60;
        int[] expected = {2,3};
        FindPair findPair = new FindPair();
        int[] actual = findPair.findPair(nums, target);
        Assert.assertArrayEquals(actual, expected);
    }

    @Test
    void findPair1() {
        int[] nums= {20, 50, 40, 25, 30, 10};
        int target = 60;
        int[] expected = {1,5};
        FindPair findPair = new FindPair();
        int[] actual = findPair.findPair(nums, target);
        Assert.assertArrayEquals(actual, expected);
    }

    @Test
    void findPair2() {
        int[] nums= {50, 20, 10, 40, 25, 30};
        int target = 60;
        int[] expected = {0,2};
        FindPair findPair = new FindPair();
        int[] actual = findPair.findPair(nums, target);
        Assert.assertArrayEquals(actual, expected);
    }

    @Test
    void findPair3() {
        int[] nums= {1,2};
        int target = 60;
        int[] expected = {-1,-1};
        FindPair findPair = new FindPair();
        int[] actual = findPair.findPair(nums, target);
        Assert.assertArrayEquals(actual, expected);
    }

    @Test
    void findPair4() {
        int[] nums= {0,0,30};
        int target = 30;
        int[] expected = {1,2};
        FindPair findPair = new FindPair();
        int[] actual = findPair.findPair(nums, target);
        Assert.assertArrayEquals(actual, expected);
    }

    @Test
    void findPair5() {
        int[] nums= {0,0};
        int target = 0;
        int[] expected = {0,1};
        FindPair findPair = new FindPair();
        int[] actual = findPair.findPair(nums, target);
        Assert.assertArrayEquals(actual, expected);
    }

}