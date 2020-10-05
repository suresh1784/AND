package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumSubmatTest {
    NumSubmat numSubmat = new NumSubmat();
    @Test
    void numSubmat() {
        int[][] mat = {{1,0,1},{1,1,0},{1,1,0}};
        int expected = 13;
        int actual = numSubmat.numSubmat(mat);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void numSubmat1() {
        int[][] mat = {{0,1,1,0},{0,1,1,1},{1,1,1,0}};
        int expected = 24;
        int actual = numSubmat.numSubmat(mat);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void numSubmat2() {
        int[][] mat = {{1,1,1,1,1,1}};
        int expected = 21;
        int actual = numSubmat.numSubmat(mat);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void numSubmat3() {
        int[][] mat = {{1,0,1},{0,1,0},{1,0,1}};
        int expected = 5;
        int actual = numSubmat.numSubmat(mat);
        Assert.assertEquals(expected, actual);
    }
}