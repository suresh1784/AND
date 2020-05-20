package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class StringKSizeKCharsTest {
    StringKSizeKChars stringKSizeKChars = new StringKSizeKChars();
    @Test
    void subStringKSizeKChars() {
        String in = "abcabc";
        int k = 3;
        List<String> expected = Arrays.asList("abc", "bca", "cab");
        List<String> actual = stringKSizeKChars.subStringKSizeKChars(in, k);
        assertThat(actual,containsInAnyOrder(expected.toArray()));
    }

    @Test
    void subStringKSizeKChars1() {
        String in = "abacab";
        int k = 3;
        List<String> expected = Arrays.asList("bac", "cab");
        List<String> actual = stringKSizeKChars.subStringKSizeKChars(in, k);
        assertThat(actual,containsInAnyOrder(expected.toArray()));
    }

    @Test
    void subStringKSizeKChars2() {
        String in = "awaglknagawunagwkwagl";
        int k = 4;
        List<String> expected = Arrays.asList("wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag");
        List<String> actual = stringKSizeKChars.subStringKSizeKChars(in, k);
        assertThat(actual,containsInAnyOrder(expected.toArray()));
    }
}