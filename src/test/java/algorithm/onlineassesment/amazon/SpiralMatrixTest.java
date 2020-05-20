package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class SpiralMatrixTest {

    @Test
    void generateMatrix() {
        int n = 3;
        int[][] expected = {{1,2,3},{8,9,4},{7,6,5}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] actual = spiralMatrix.generateMatrix(n);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    void generateMatrix1() {
        int n = 4;
        int[][] expected = {{1,2,3,4},
                            {12,13,14,5},
                            {11,16,15,6},
                            {10,9,8,7}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] actual = spiralMatrix.generateMatrix(n);
        Assert.assertArrayEquals(expected, actual);
    }
}