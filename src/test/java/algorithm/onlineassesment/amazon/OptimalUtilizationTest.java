package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

class OptimalUtilizationTest {
    @Test
    void test1(){
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        int target = 7;
    List<int[]> expected = new ArrayList<>();
    int[][] aArray = {{1, 2}, {2, 4}, {3, 6}};
    int[][] bArray  = {{1, 2}};
    int[][] cArray = {{2, 1}};
    a.addAll(Arrays.asList(aArray));
    b.addAll(Arrays.asList(bArray));
    expected.addAll(Arrays.asList(cArray));
    OptimalUtilization optimalUtilization = new OptimalUtilization();
    List<int[]> actual = optimalUtilization.optimalUtilization(a,b, target);
    Assert.assertThat(actual,containsInAnyOrder(expected.toArray()));
    }

    @Test
    void test2(){
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        int target = 10;
        List<int[]> expected = new ArrayList<>();
        int[][] aArray = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
        int[][] bArray  = {{1, 2}, {2, 3}, {3, 4},{4, 5}};
        int[][] cArray = {{2, 4}, {3, 2}};
        a.addAll(Arrays.asList(aArray));
        b.addAll(Arrays.asList(bArray));
        expected.addAll(Arrays.asList(cArray));
        OptimalUtilization optimalUtilization = new OptimalUtilization();
        List<int[]> actual = optimalUtilization.optimalUtilization(a,b, target);
        Assert.assertThat(actual,containsInAnyOrder(expected.toArray()));
    }

    @Test
    void test3(){
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        int target = 20;
        List<int[]> expected = new ArrayList<>();
        int[][] aArray = {{1, 8}, {2, 7}, {3, 14}};
        int[][] bArray  = {{1, 5}, {2, 10}, {3, 14}};
        int[][] cArray = {{3, 1}};
        a.addAll(Arrays.asList(aArray));
        b.addAll(Arrays.asList(bArray));
        expected.addAll(Arrays.asList(cArray));
        OptimalUtilization optimalUtilization = new OptimalUtilization();
        List<int[]> actual = optimalUtilization.optimalUtilization(a,b, target);
        Assert.assertThat(actual,containsInAnyOrder(expected.toArray()));
    }

    @Test
    void test4(){
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        int target = 20;
        List<int[]> expected = new ArrayList<>();
        int[][] aArray = {{1, 8}, {2, 15}, {3, 9}};
        int[][] bArray  = {{1, 8}, {2, 11}, {3, 12}};
        int[][] cArray = {{1, 3}, {3, 2}};
        a.addAll(Arrays.asList(aArray));
        b.addAll(Arrays.asList(bArray));
        expected.addAll(Arrays.asList(cArray));
        OptimalUtilization optimalUtilization = new OptimalUtilization();
        List<int[]> actual = optimalUtilization.optimalUtilization(a,b, target);
        Assert.assertThat(actual,containsInAnyOrder(expected.toArray()));
    }
}