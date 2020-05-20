package algorithm.onlineassesment.amazon;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class WebsitePatternTest {
    WebsitePattern websitePattern = new WebsitePattern();
    @Test
    void mostVisitedPattern() {
        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};
        List<String> expected = Arrays.asList("home","about","career");
        List<String> actual = websitePattern.mostVisitedPattern(username, timestamp, website);
        assertThat(actual , containsInAnyOrder(expected.toArray()));
    }

    @Test
    void mostVisitedPattern1() {
        String[] username = {"u1","u1","u1","u2","u2","u2"};
        int[] timestamp = {1,2,3,4,5,6};
        String[] website = {"a","b","c","a","b","a"};
        List<String> expected = Arrays.asList("a","b","a");
        List<String> actual = websitePattern.mostVisitedPattern(username, timestamp, website);
        assertThat(actual , containsInAnyOrder(expected.toArray()));
    }

    @Test
    void mostVisitedPattern2() {
        String[] username = {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
        int[] timestamp = {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930};
        String[] website = {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};
        List<String> expected = Arrays.asList("hibympufi","hibympufi","yljmntrclw");
        List<String> actual = websitePattern.mostVisitedPattern(username, timestamp, website);
        assertThat(actual , containsInAnyOrder(expected.toArray()));
    }
}