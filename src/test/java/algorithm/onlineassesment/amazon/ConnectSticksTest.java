package algorithm.onlineassesment.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
class ConnectSticksTest {
    @Test
    void test1(){
        int[] sticks = {2,4,3};
        int expected = 14;
        ConnectSticks connectSticks = new ConnectSticks();
        int actual = connectSticks.connectSticks(sticks);
        Assert.assertEquals(actual,expected);
    }

    @Test
    void test2(){
        int[] sticks = {1,8,3,5};
        int expected = 30;
        ConnectSticks connectSticks = new ConnectSticks();
        int actual = connectSticks.connectSticks(sticks);
        Assert.assertEquals(actual,expected);
    }

}