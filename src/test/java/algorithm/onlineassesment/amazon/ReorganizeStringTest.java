package algorithm.onlineassesment.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ReorganizeStringTest {
    ReorganizeString reorganizeString = new ReorganizeString();
    @Test
    void test1(){
    String str = "aab";
    String expected = "aba";
    String actual = reorganizeString.reorganizeString(str);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void test2(){
        String str = "aaab";
        String expected = "";
        String actual = reorganizeString.reorganizeString(str);
        Assert.assertEquals(expected,actual);
    }
}