package algorithm.onlineassesment.amazon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

class CriticalConnectionsTest {
    CriticalConnections criticalConnections = new CriticalConnections();

    @Test
    void test1() {
        int n = 4;
        List<List<Integer>> conn = new ArrayList<>();
        int[][] connArray = {{0, 1}, {1, 2}, {2, 0}, {1, 3}};
        for (int[] arr : connArray) {
            List<Integer> list = Arrays.asList(arr[0], arr[1]);
            conn.add(list);
        }
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1,3));
        List<List<Integer>> actual = criticalConnections.criticalConnections(n, conn);
        assertThat(actual, containsInAnyOrder(expected.toArray()));

    }

    @Test
    void test2() {
        int n = 5;
        List<List<Integer>> conn = new ArrayList<>();
        int[][] connArray = {{1, 2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}};
        for (int[] arr : connArray) {
            List<Integer> list = Arrays.asList(arr[0], arr[1]);
            conn.add(list);
        }
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1,2),
                Arrays.asList(4,5));
        List<List<Integer>> actual = criticalConnections.criticalConnections(n, conn);
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

    @Test
    void test3() {
        int n = 6;
        List<List<Integer>> conn = new ArrayList<>();
        int[][] connArray = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {2, 5}, {4, 6}, {5, 6}};
        for (int[] arr : connArray) {
            List<Integer> list = Arrays.asList(arr[0], arr[1]);
            conn.add(list);
        }
        List<List<Integer>> expected = Arrays.asList();
        List<List<Integer>> actual = criticalConnections.criticalConnections(n, conn);
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

    @Test
    void test4() {
        int n = 6;
        List<List<Integer>> conn = new ArrayList<>();
        int[][] connArray = {{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9}};
        for (int[] arr : connArray) {
            List<Integer> list = Arrays.asList(arr[0], arr[1]);
            conn.add(list);
        }
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(3,4), Arrays.asList(3,6), Arrays.asList(4,5));
        List<List<Integer>> actual = criticalConnections.criticalConnections(n, conn);
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

}