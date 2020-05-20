package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchMatrixTest {
    int[][] matrix = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
    @Test
    void searchMatrix() {
        int in = 5 ;
        SearchMatrix searchMatrix = new SearchMatrix();
        Assert.assertEquals(searchMatrix.searchMatrix(matrix, in), true );
    }

    @Test
    void searchMatrix1() {
        int in = 20 ;
        SearchMatrix searchMatrix = new SearchMatrix();
        Assert.assertEquals(searchMatrix.searchMatrix(matrix, in), false );
    }
}