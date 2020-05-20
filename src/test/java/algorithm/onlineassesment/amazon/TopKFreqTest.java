package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


class TopKFreqTest {

    @Test
    void topKFrequentTest1() {
        int k = 2;
        String[] keywords = {"i", "love", "leetcode", "i", "love", "coding"};

        TopKFreq topKFreq = new TopKFreq();
        List<String> actual = topKFreq.topKFrequent(keywords, k);
        List<String> expected = Arrays.asList("i", "love");
        assertThat(actual, is(expected));
    }

    @Test
    void topKFrequentTest2() {
        int k = 4;
        String[] keywords = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        TopKFreq topKFreq = new TopKFreq();
        List<String> actual = topKFreq.topKFrequent(keywords, k);
        List<String> expected = Arrays.asList("the", "is", "sunny", "day");
        assertThat(actual, is(expected));
    }
}