package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class TreasureIslandTest {

    @Test
    void updateMatrix() {
        TreasureIsland treasureIsland = new TreasureIsland();
        int[][] input = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] actual = treasureIsland.updateMatrix(input);
        int[][] expected = {{0,0,0},{0,1,0},{0,0,0}};
        Assert.assertArrayEquals(actual, expected);
    }

    @Test
    void updateMatrix1() {
        TreasureIsland treasureIsland = new TreasureIsland();
        int[][] input = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] actual = treasureIsland.updateMatrix(input);
        int[][] expected = {{0,0,0},{0,1,0},{1,2,1}};
        Assert.assertArrayEquals(actual, expected);
    }
}