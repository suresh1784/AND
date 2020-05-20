package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class TimeofFunctionsTest {
    TimeofFunctions timeofFunctions = new TimeofFunctions();
    @Test
    void exclusiveTime() {
        int n = 2;
        List<String> logs = Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6");
        int[] expected = {3,4};
        int[] actual = timeofFunctions.exclusiveTime(n, logs);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void exclusiveTime1() {
        int n = 3;
        List<String> logs = Arrays.asList("0:start:0","1:start:2","1:end:5","2:start:6","2:end:9","0:end:12");
        int[] expected = {5,4,4};
        int[] actual = timeofFunctions.exclusiveTime(n, logs);
        Assert.assertEquals(expected, actual);
    }
}