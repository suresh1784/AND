package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumRequestsTest {
    MaximumRequests maximumRequests = new MaximumRequests();
    @Test
    void maximumRequests1() {
        int n = 5;
        int[][] requests = {{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}};
        int expected = 5;
        int actual = maximumRequests.maximumRequests(n, requests);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void maximumRequests2() {
        int n = 3;
        int[][] requests = {{0,0},{1,2},{2,1}};
        int expected = 3;
        int actual = maximumRequests.maximumRequests(n, requests);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void maximumRequests3() {
        int n = 4;
        int[][] requests = {{0,3},{3,1},{1,2},{2,0}};
        int expected = 4;
        int actual = maximumRequests.maximumRequests(n, requests);
        Assert.assertEquals(expected, actual);
    }
//{{0,0},{1,1},[{0,0},{2,0},{2,2},{1,1},{2,1},{0,1},{0,1}}
    @Test
    void maximumRequests4() {
        int n = 3;
        int[][] requests = {{0,0},{1,1},{0,0},{2,0},{2,2},{1,1},{2,1},{0,1},{0,1}};
        int expected = 5;
        int actual = maximumRequests.maximumRequests(n, requests);
        Assert.assertEquals(expected, actual);
    }


}