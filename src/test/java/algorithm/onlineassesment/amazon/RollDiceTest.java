package algorithm.onlineassesment.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
class RollDiceTest {
RollDice rollDice = new RollDice();

@Test
    void test1(){
    int d = 1;
    int f = 6;
    int t = 6;
    int expected = 1;
    int actual = rollDice.numRollsToTarget(d,f,t);
    Assert.assertEquals(expected,actual);
}

    @Test
    void test2(){
        int d = 1;
        int f = 6;
        int t = 6;
        int expected = 1;
        int actual = rollDice.numRollsToTarget(d,f,t);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void test3(){
        int d = 2;
        int f = 6;
        int t = 7;
        int expected = 6;
        int actual = rollDice.numRollsToTarget(d,f,t);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void test4(){
        int d = 2;
        int f = 5;
        int t = 10;
        int expected = 1;
        int actual = rollDice.numRollsToTarget(d,f,t);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void test5(){
        int d = 1;
        int f = 2;
        int t = 3;
        int expected = 0;
        int actual = rollDice.numRollsToTarget(d,f,t);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void test6(){
        int d = 30;
        int f = 30;
        int t = 500;
        int expected = 222616187;
        int actual = rollDice.numRollsToTarget(d,f,t);
        Assert.assertEquals(expected,actual);
    }
}