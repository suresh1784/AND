package algorithm.onlineassesment.amazon;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import org.hamcrest.collection.IsMapContaining;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

class FavoriteGenreTest {

    @Test
    void favoritegenre() {
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David" , Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

        Map<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock" , Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep" , Arrays.asList("song7"));
        songGenres.put("Techno" , Arrays.asList("song2", "song4"));
        songGenres.put("Pop" , Arrays.asList("song5", "song6"));
        songGenres.put("Jazz" , Arrays.asList("song8", "song9"));

        Map<String, List<String>> expected = new HashMap<>();
        expected.put("David",Arrays.asList("Rock", "Techno"));
        expected.put("Emma",Arrays.asList("Pop"));

        FavoriteGenre favoriteGenre = new FavoriteGenre();
        Map<String, List<String>> actual = favoriteGenre.favoritegenre(userSongs, songGenres);
        assertThat(actual.size(), is(2));
        assertThat(actual, is(expected));
        for (Map.Entry<String, List<String> > entry : expected.entrySet()){
            List<String> actualList = actual.get(entry.getKey());
            List<String> expectedList = entry.getValue();
            assertThat(actualList,containsInAnyOrder(expectedList.toArray()));
        }
    }

    @Test
    void favoritegenre1() {
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2"));
        userSongs.put("Emma", Arrays.asList("song3", "song4"));

        Map<String, List<String>> songGenres = new HashMap<>();

        Map<String, List<String>> expected = new HashMap<>();
        expected.put("David", new ArrayList<>());
        expected.put("Emma", new ArrayList<>());



        FavoriteGenre favoriteGenre = new FavoriteGenre();
        Map<String, List<String>> actual = favoriteGenre.favoritegenre(userSongs, songGenres);
        assertThat(actual.size(), is(2));
        assertThat(actual, is(expected));
        for (Map.Entry<String, List<String> > entry : expected.entrySet()){
            List<String> actualList = actual.get(entry.getKey());
            List<String> expectedList = entry.getValue();
            assertThat(actualList,containsInAnyOrder(expectedList.toArray()));
        }
    }
}