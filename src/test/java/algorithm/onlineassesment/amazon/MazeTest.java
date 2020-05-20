package algorithm.onlineassesment.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MazeTest {
    Maze maze = new Maze();
    @Test
    void test1() {

        int[][] in = {{0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] end = {4, 4};
        boolean expected = true;
        boolean actual = maze.hasPath(in, start, end);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void test2() {

        int[][] in = {{0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] end = {3,2};
        boolean expected = false;
        boolean actual = maze.hasPath(in, start, end);
        Assert.assertEquals(expected, actual);
    }
}