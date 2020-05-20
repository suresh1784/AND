package algorithm.onlineassesment.amazon;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderIITest {
    WordLadderII wordLadderII = new WordLadderII();
    @Test
    void findLadders() {
       String beginWrd = "hit";
       String endWord = "cog"  ;
       List<String> dict = Arrays.asList("hot","dot","dog","lot","log","cog");
       List<List<String>> expected = Arrays.asList(Arrays.asList("hit","hot","dot","dog","cog"), Arrays.asList("hit","hot","lot","log","cog"));
       List<List<String>> actual = wordLadderII.findLadders(beginWrd, endWord,dict );
       assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

    @Test
    void findLadders1() {
        String beginWrd = "hit";
        String endWord = "cog"  ;
        List<String> dict = Arrays.asList("hot","dot","dog","lot","log");
        List<List<String>> expected = Arrays.asList();
        List<List<String>> actual = wordLadderII.findLadders(beginWrd, endWord,dict );
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }
}