package patterns.DFS.leetcode;

import java.util.*;

// https://leetcode.com/problems/reconstruct-itinerary/
public class FindItinerary {
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.putIfAbsent(from, new PriorityQueue<>((a, b) -> a.compareTo(b)));
            map.get(from).offer(to);
        }
        List<String> result = new LinkedList<>();
        // DFS
        dfs("JFK", map, result, tickets.size());
        result.add(0, "JFK");
        return result;

    }
// https://leetcode.com/problems/reconstruct-itinerary/

    public static void dfs(String in, Map<String, PriorityQueue<String>> map, List<String> result, int n) {
        if (result.size() >= n + 1) {
            return;
        }
        if (map.get(in) != null) {
            while (!map.get(in).isEmpty()) {
                String child = map.get(in).poll();
                dfs(child, map, result, n);
                result.add(0, child);
            }
        }
    }
}
