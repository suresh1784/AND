package algorithm.onlineassesment.amazon;

import algorithm.graph.practice.NumberOfIsland;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberofIslandsTest {

    @Test
    void numIslands() {
        char[][] island = {{11110},{11010},{11000},{00000}};
        NumberofIslands numberofIslands = new NumberofIslands();
        numberofIslands.numIslands(island);
    }
}