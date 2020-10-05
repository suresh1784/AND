package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProductPathTest {
    MaxProductPath maxProductPath = new MaxProductPath();
    @Test
    void maxProductPath() {
        int[][] grid ={{-1,-2,-3},
                {-2,-3,-3},
                {-3,-3,-2}};
        int expected = -1;
        int actual = maxProductPath.maxProductPath(grid);
        Assert.assertEquals(expected,actual);
    }


    @Test
    void maxProductPath1() {
        int[][] grid ={{1,-2,1},
                {1,-2,1},
                {3,-4,1}};
        int expected = 8;
        int actual = maxProductPath.maxProductPath(grid);
        Assert.assertEquals(expected,actual);
    }



    @Test
    void maxProductPath2() {
        int[][] grid ={{1, 3},
                {0,-4}};
        int expected = 0;
        int actual = maxProductPath.maxProductPath(grid);
        Assert.assertEquals(expected,actual);
    }


    @Test
    void maxProductPath3() {
        int[][] grid ={{1, 4,4,0},
                {-2, 0,0,1},
                { 1,-1,1,1}};
        int expected = 2;
        int actual = maxProductPath.maxProductPath(grid);
        Assert.assertEquals(expected,actual);
    }

}