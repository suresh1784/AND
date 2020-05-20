package algorithm.onlineassesment.amazon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumMinimumPathTest {
    MaximumMinimumPath maximumMinimumPath = new MaximumMinimumPath();
    @Test
    void maximumMinimumPath() {
        int[][] in = {{5,4,5},{1,2,6},{7,4,6}};
        int expected = 4;
        int actual = maximumMinimumPath.maximumMinimumPath(in);
        assertEquals(expected, actual);
    }

    @Test
    void maximumMinimumPath1() {
        int[][] in = {{2,2,1,2,2,2},{1,2,2,2,1,2}};
        int expected = 2;
        int actual = maximumMinimumPath.maximumMinimumPath(in);
        assertEquals(expected, actual);
    }

    @Test
    void maximumMinimumPath2() {
        int[][] in = {{3,4,6,3,4},{0,2,1,1,7},{8,8,3,2,7},{3,2,4,9,8},{4,1,2,0,0},{4,6,5,4,3}};
        int expected = 3;
        int actual = maximumMinimumPath.maximumMinimumPath(in);
        assertEquals(expected, actual);
    }

    @Test
    void maximumMinimumPath3() {
        int[][] in = {{7,5,3},{2,0,9},{4,5,9}};
        int expected = 3;
        int actual = maximumMinimumPath.maximumMinimumPath(in);
        assertEquals(expected, actual);
    }
}