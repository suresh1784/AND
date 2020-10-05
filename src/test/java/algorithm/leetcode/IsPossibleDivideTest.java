package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsPossibleDivideTest {
    IsPossibleDivide isPossibleDivide = new IsPossibleDivide();
    @Test
    void isPossibleDivide() {
        int[] nums = {1,2,3,3,4,4,5,6};
        int k = 4;
        boolean expected =true ;
        boolean actual = isPossibleDivide.isPossibleDivide(nums, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void isPossibleDivide1() {
        int[] nums = {3,2,1,2,3,4,3,4,5,9,10,11};
        int k = 3;
        boolean expected =true ;
        boolean actual = isPossibleDivide.isPossibleDivide(nums, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void isPossibleDivide2() {
        int[] nums = {3,3,2,2,1,1};
        int k = 3;
        boolean expected =true ;
        boolean actual = isPossibleDivide.isPossibleDivide(nums, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void isPossibleDivide3() {
        int[] nums = {1,2,3,4};
        int k = 3;
        boolean expected =false ;
        boolean actual = isPossibleDivide.isPossibleDivide(nums, k);
        Assert.assertEquals(expected, actual);
    }
}