package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProbabilityTest {
    MaxProbability maxProbability = new MaxProbability();

    @Test
    void maxProbability() {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0 ;
        int end = 2;

        double expected = 0.25000;
        double actual = maxProbability.maxProbability(n,edges, succProb, start, end);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);

    }

    @Test
    void maxProbability1() {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.3};
        int start = 0 ;
        int end = 2;

        double expected = 0.30000;
        double actual = maxProbability.maxProbability(n,edges, succProb, start, end);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);

    }

    @Test
    void maxProbability2() {
        int n = 3;
        int[][] edges = {{0,1}};
        double[] succProb = {0.5};
        int start = 0 ;
        int end = 2;

        double expected = 0.00000;
        double actual = maxProbability.maxProbability(n,edges, succProb, start, end);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);

    }


}