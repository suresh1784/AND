package algorithm.onlineassesment.amazon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class KClosestPointsTest {
KClosestPoints kClosestPoints = new KClosestPoints();
    @Test
    void test1(){
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        int[][] actual = kClosestPoints.kClosest(points,k);
        int[][] expected = {{-2,2}};
        assertArrayEquals(expected,actual);
    }

    @Test
    void test2(){
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][] actual = kClosestPoints.kClosest(points,k);
        int[][] expected = {{-2,4},{3,3}};
        assertArrayEquals(expected,actual);
    }
}