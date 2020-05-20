package algorithm.onlineassesment.amazon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.*;
class WordBreak2Test {
    WordBreak2 wordBreak2 = new WordBreak2();
    @Test
    void wordBreak() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> expected = Arrays.asList("cats and dog","cat sand dog");
        List<String> actual = wordBreak2.wordBreak(s,wordDict);
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }
    @Test
    void wordBreak1() {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> expected = Arrays.asList("pine apple pen apple",
                "pineapple pen apple",
                "pine applepen apple");
        List<String> actual = wordBreak2.wordBreak(s,wordDict);
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

    @Test
    void wordBreak3() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        List<String> expected = Arrays.asList();
        List<String> actual = wordBreak2.wordBreak(s,wordDict);
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }
}