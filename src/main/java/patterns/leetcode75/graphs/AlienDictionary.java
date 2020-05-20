package patterns.leetcode75.graphs;


import java.util.*;

public class AlienDictionary {
    public static String alienOrder(String[] words) {
        StringBuilder result = new StringBuilder();

        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (String word : words){
            for (Character ch : word.toCharArray()){
                degree.put(ch, 0);
            }
        }

        for (int i = 1 ; i < words.length ; i ++){
            String word1 = words[i-1];
            String word2 = words[i];
            int c1 = 0;
            int c2 = 0;
            while (c1< word1.length() && c2 < word2.length()){
                Character ch1 = word1.charAt(c1);
                Character ch2 = word2.charAt(c2);
                if (ch1==ch2){
                    c1++;
                    c2++;
                }else {
                    if (graph.get(ch1) == null) {
                        graph.put(ch1, new ArrayList<>());
                    }

                    graph.get(ch1).add(ch2);
                    degree.put(ch2, degree.getOrDefault(ch2, 0) + 1);
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : degree.entrySet()){
            if (entry.getValue()==0){
                q.offer(entry.getKey());
            }
        }

        while (!q.isEmpty()){
            Character top = q.poll();
            result.append(top);
            List<Character> children = new ArrayList<>();
            if (graph.get(top)!=null){
                children = graph.get(top);
            }

            for (Character child : children){
                degree.put(child, degree.get(child)-1);
                if (degree.get(child)==0){
                    q.offer(child);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args){
//        String[] words = {
//                "wrt",
//                "wrf",
//                "er",
//                "ett",
//                "rftt"
//        };

        String[] words = {
                "ab","adc"
        };

        System.out.println(alienOrder(words));

    }
}
