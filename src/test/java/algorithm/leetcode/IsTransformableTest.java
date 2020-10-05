package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsTransformableTest {
    IsTransformable isTransformable = new IsTransformable();
    @Test
    void isTransformable() {
        String s = "84532";
        String t = "34852";
        boolean expected = true;
        boolean actual = isTransformable.isTransformable(s,t);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void isTransformable1() {
        String s = "34521";
        String t = "23415";
        boolean expected = true;
        boolean actual = isTransformable.isTransformable(s,t);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void isTransformable2() {
        String s = "12345";
        String t = "12435";
        boolean expected = false;
        boolean actual = isTransformable.isTransformable(s,t);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void isTransformable3() {
        String s = "1";
        String t = "2";
        boolean expected = false;
        boolean actual = isTransformable.isTransformable(s,t);
        Assert.assertEquals(expected, actual);
    }
}