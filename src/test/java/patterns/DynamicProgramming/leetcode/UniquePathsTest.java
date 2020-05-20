package patterns.DynamicProgramming.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniquePathsTest {
        UniquePaths uniquePaths = new UniquePaths();
    @Test
    void uniquePaths() {
        int m =7;
        int n = 3;
        int actual = uniquePaths.uniquePaths(m , n);
        System.out.println(actual);
    }
}