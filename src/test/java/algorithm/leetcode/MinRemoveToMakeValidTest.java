package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinRemoveToMakeValidTest {
    MinRemoveToMakeValid minRemoveToMakeValid = new MinRemoveToMakeValid();
    @Test
    void minRemoveToMakeValid() {
        String s = "lee(t(c)o)de)";
        String expected = "lee(t(c)o)de";
        String actual = minRemoveToMakeValid.minRemoveToMakeValid(s);
        minRemoveToMakeValid.minRemoveToMakeValid(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void minRemoveToMakeValid1() {
        String s = "a)b(c)d";
        String expected = "ab(c)d";
        String actual = minRemoveToMakeValid.minRemoveToMakeValid(s);
        minRemoveToMakeValid.minRemoveToMakeValid(s);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void minRemoveToMakeValid2() {
        String s = "))((";
        String expected = "";
        String actual = minRemoveToMakeValid.minRemoveToMakeValid(s);
        minRemoveToMakeValid.minRemoveToMakeValid(s);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void minRemoveToMakeValid3() {
        String s = "(a(b(c)d)";
        String expected = "a(b(c)d)";
        String actual = minRemoveToMakeValid.minRemoveToMakeValid(s);
        minRemoveToMakeValid.minRemoveToMakeValid(s);
        Assert.assertEquals(expected, actual);
    }
}