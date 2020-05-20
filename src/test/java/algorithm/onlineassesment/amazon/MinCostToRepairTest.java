package algorithm.onlineassesment.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MinCostToRepairTest {
    MinCostToRepair minCostToRepair = new MinCostToRepair();
    @Test
    void test1(){
        int n = 5;
        int[][] edges = {{1,2},{2,3}, {3,4}, {4,5}, {1,5}};
        int[][] newEdges = {{1,2,12},{3,4,30}, {1,5,8}};
        int expected = 20;
        int actual = minCostToRepair.minimumCost(n, edges, newEdges);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void test2(){
        int n = 6;
        int[][] edges = {{1,2},{2,3}, {3,4}, {4,5}, {1,5}};
        int[][] newEdges = {{1, 6, 410}, {2, 4, 800}};
        int expected = 410;
        int actual = minCostToRepair.minimumCost(n, edges, newEdges);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void test3(){
        int n = 6;
        int[][] edges = {{1, 2}, {2, 3}, {4, 5}, {5, 6}, {1, 5}, {2, 4}, {3, 4}};
        int[][] newEdges = {{1, 5, 110}, {2, 4, 84}, {3, 4, 79}};
        int expected = 79;
        int actual = minCostToRepair.minimumCost(n, edges, newEdges);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void test4(){
        int n = 6;
        int[][] edges = {{1, 4}, {4, 5}, {2, 3}};
        int[][] newEdges = {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};
        int expected = 7;
        int actual = minCostToRepair.minimumCost(n, edges, newEdges);
        Assert.assertEquals(expected,actual);
    }

}