package algorithm.onlineassesment.amazon;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

class SearchSuggestionsTest {

    @Test
    void suggestedProducts1() {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        SearchSuggestions searchSuggestions = new SearchSuggestions();
        List<List<String>> actual = searchSuggestions.suggestedProducts( products, searchWord);
        List<List<String>> expected = new ArrayList<>();
        String[][] results = {
                {"mobile", "moneypot", "monitor"},
                {"mobile", "moneypot", "monitor"},
                {"mouse", "mousepad"},
                {"mouse", "mousepad"},
                {"mouse", "mousepad"}
        };

        for (String[] result : results ){
            expected.add(Arrays.asList(result));
        }
        assertThat(actual, is(expected));
    }

    @Test
    void suggestedProducts2() {
        String[] products = {"havana"};
        String searchWord ="havana";
        SearchSuggestions searchSuggestions = new SearchSuggestions();
        List<List<String>> actual = searchSuggestions.suggestedProducts( products, searchWord);
        List<List<String>> expected = new ArrayList<>();
        String[][] results = {
                {"havana"},
                {"havana"},
                {"havana"},
                {"havana"},
                {"havana"},
                {"havana"}
        };

        for (String[] result : results ){
            expected.add(Arrays.asList(result));
        }
        assertThat(actual, is(expected));
    }


    @Test
    void suggestedProducts3() {
        String[] products = {"bags","baggage","banner","box","cloths"};
        String searchWord ="bags";
        SearchSuggestions searchSuggestions = new SearchSuggestions();
        List<List<String>> actual = searchSuggestions.suggestedProducts( products, searchWord);
        List<List<String>> expected = new ArrayList<>();

        String[][] results = {{"baggage","bags","banner"},{"baggage","bags","banner"},{"baggage","bags"},{"bags"}};
        for (String[] result : results ){
            expected.add(Arrays.asList(result));
        }
        assertThat(actual, is(expected));
    }

    @Test
    void suggestedProducts4() {
        String[] products = {"havana"};
        String searchWord ="tatiana";
        SearchSuggestions searchSuggestions = new SearchSuggestions();
        List<List<String>> actual = searchSuggestions.suggestedProducts( products, searchWord);
        List<List<String>> expected = new ArrayList<>();
        String[][] results = {{},{},{},{},{},{},{}};
        for (String[] result : results ){
            expected.add(Arrays.asList(result));
        }
        assertThat(actual, is(expected));
        assertThat(actual, is(expected));
    }
}