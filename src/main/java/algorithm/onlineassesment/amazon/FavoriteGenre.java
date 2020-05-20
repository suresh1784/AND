package algorithm.onlineassesment.amazon;
import java.util.*;
public class FavoriteGenre {
    public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>>  res = new HashMap<>();
        Map<String, String> songToGenre = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : genreMap.entrySet()){
            String genre = entry.getKey();
            List<String> songs = entry.getValue();
            for (String song : songs){
                songToGenre.put(song, genre);
            }
        }

        for (Map.Entry<String, List<String>> entry : userMap.entrySet()){
            String user = entry.getKey();
            List<String>  songs = entry.getValue();
            Map<String, Integer> freqMap = new HashMap<>();
            List<String> topGeneres = new ArrayList<>();
            int max = -1;
            for (String song : songs){
                String genere = songToGenre.get(song);
                freqMap.put(genere, freqMap.getOrDefault(genere, 0)+1);
                if (freqMap.get(genere) >= max){
                    if (freqMap.get(genere) == max){
                        topGeneres.add(genere);
                    }else {
                        max = freqMap.get(genere);
                        topGeneres = new ArrayList<>();
                        topGeneres.add(genere);
                    }
                }
            }

            res.put(user, topGeneres);
        }

        return res;
    }
}
