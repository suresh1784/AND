package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KDistanceApartTest {
    KDistanceApart reorganizeString = new KDistanceApart();
    @Test
    void test1(){
        String str = "aabbcc";
        String expected = "abcabc";
        int k = 3;
        String actual = reorganizeString.rearrangeString(str,k);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void test2(){
        String str = "aaab";
        String expected = "";
        int k = 3;
        String actual = reorganizeString.rearrangeString(str,k);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void test3(){
        String str = "aaadbbcc";
        String expected = "abacabcd";
        int k = 2;
        String actual = reorganizeString.rearrangeString(str,k);
        Assert.assertEquals(expected,actual);
    }

}