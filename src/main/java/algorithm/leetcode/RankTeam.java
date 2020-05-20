package algorithm.leetcode;

import java.util.*;

public class RankTeam {
    public static String rankTeams(String[] votes) {
    String result = "";
    Map<Character, Integer>  map = new HashMap<>();
    PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<Map.Entry<Character,Integer>>((a,b) -> {
        if (a.getValue() != b.getValue()) {
            return Integer.compare(a.getValue(), b.getValue());
        } else {
            return Integer.compare(Character.getNumericValue(a.getKey()), Character.getNumericValue(b.getKey()));
        }
    });
    int count = 0 ;
    int weight = votes[0].length();
    while (count < votes[0].length()-1) {
        pq = new PriorityQueue<Map.Entry<Character,Integer>>((a,b) -> {
            if (a.getValue() != b.getValue()) {
                return Integer.compare(b.getValue(), a.getValue());
            } else {
                return Integer.compare(Character.getNumericValue(a.getKey()), Character.getNumericValue(b.getKey()));
            }
        });

        for (String vote : votes) {
            char ch = vote.charAt(count);
            map.put(ch, map.getOrDefault(ch,0)+weight);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }

        if (!pq.isEmpty()){
            Map.Entry<Character, Integer> top = pq.poll();
            int firstval = top.getValue();

            if (!pq.isEmpty() && firstval == pq.peek().getValue()){
                pq.offer(top);
            }else {
                result = result+top.getKey();
                map.remove(top.getKey());
                if (result.length() < votes[0].length()-count){

                }
            }
        }

        count++;
        weight--;
    }
        while(!pq.isEmpty()){
            result = result+pq.poll().getKey();
        }
        return result;
    }


    public static void main(String[] args){
        String[] str1 = {"ABC","ACB","ABC","ACB","ACB"};
        String[] str2 = {"BCA","CAB","CBA","ABC","ACB","BAC"};
        String[] str3 = {"WXYZ","XYZW"};

        System.out.println(rankTeams(str3));
    }

}
