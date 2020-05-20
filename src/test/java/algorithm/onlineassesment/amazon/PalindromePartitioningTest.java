package algorithm.onlineassesment.amazon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class PalindromePartitioningTest {
    PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
    @Test
    void partition() {
        String s = "aab";
        List<List<String>> actual = palindromePartitioning.partition(s);
        System.out.println(actual);
    }

    @Test
    void partition1() {
        String s = "0204451881";
        List<List<String>> actual = palindromePartitioning.partition(s);
        System.out.println(actual);
    }
}