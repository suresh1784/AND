package patterns.Graph.TopologigalSort;

import java.util.*;

class AlienDictionary {
    public static String findOrder(String[] words) {
        Map<Character, Set<Character>> relationMap = new HashMap<>();
        Map<Character, Integer> degreeMap = new HashMap<>();

        for (int i = 0 ; i+1 < words.length ; i++ ){
            String w1 = words[i];
            String w2 = words[i+1];

            int a = 0 ;
            int b = 0 ;

            while (a < w1.length() && b< w2.length()){
                char c1 = w1.charAt(a);
                char c2 = w2.charAt(b);
                if (c1!= c2){
                    Set<Character> set = new HashSet<>();
                    if (relationMap.containsKey(c1)){
                        set = relationMap.get(c1);
                    }
                    if (!set.contains(c2))
                        degreeMap.put(c2 , degreeMap.getOrDefault(c2, 0 )+1);
                    set.add(c2);
                    relationMap.put(c1, set);

                    if (!degreeMap.containsKey(c1)){
                       degreeMap.put(c1, 0) ;
                    }
                    break;
                }else {
                    a++;
                    b++;
                }
            }

        }


        Queue<Character> q = new LinkedList<>();
        for (Map.Entry<Character, Integer> entrySet : degreeMap.entrySet()){
            if (entrySet.getValue()==0 ){
                q.offer(entrySet.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()){
            Character top = q.poll();
            sb.append(top);
            Set<Character> set = new HashSet<>();
            if (relationMap.containsKey(top)){
                set = relationMap.get(top);
            }

            for (char c : set){
                degreeMap.put(c, degreeMap.get(c)-1);
                if (degreeMap.get(c)==0){
                    q.offer(c);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }
}