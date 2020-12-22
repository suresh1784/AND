package algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class CanMakePalindrome {
    static String canMakePalindrome(String s){
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)-> Character.compare(a.getKey(), b.getKey()));

        StringBuilder sb = new StringBuilder(s.length());

        Map<Character, Integer> temp =
        map.entrySet()
                .stream()
                .filter(p -> (p.getValue()%2==1))
                .collect(Collectors.toMap(p-> p.getKey(),  p-> p.getValue()));

        if (temp.size()>1){
            return "impossible";
        }
        pq.addAll(map.entrySet());
      //  System.out.println(pq);
        while (!pq.isEmpty()){
          //  System.out.println(pq);
            Map.Entry<Character, Integer> top = pq.poll();
            if (top.getValue() >=2){
                sb.append(top.getKey());
                top.setValue(top.getValue()-2);
                if (top.getValue()>0)
                pq.offer(top);
            }
        }
        String forward = sb.toString();
        String reverse = sb.reverse().toString();
        String result = temp.entrySet().iterator().hasNext() ? (forward+temp.entrySet().iterator().next().getKey()+reverse) : (forward+reverse);
      //  sb.append()
        return result;
    }

    public static void main(String[] args) {
        System.out.println(""+canMakePalindrome("malayalam"));
        System.out.println(""+canMakePalindrome("abacb"));
        System.out.println(""+canMakePalindrome("acmicpc"));
        System.out.println(""+canMakePalindrome("aabaab"));
        System.out.println(""+canMakePalindrome("bsbttxs"));

    }
}
