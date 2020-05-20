package algorithm.hired;

import java.util.*;

public class FirstCharacter {

    public static void main(String[] args) {
        String s = "Who wants hot watermelon";
        System.out.println(solution(s));
    }

    public static long solution(String s) {
        // Type your solution here
        char[] chars = s.toLowerCase().toCharArray();
        Map<Character, Long> indexMap = new HashMap<>();
        long count = 0;
        for (char ch : chars) {
            if (indexMap.get(ch) != null) {
                indexMap.put(ch, -1L);
            } else {
                indexMap.put(ch, count);
            }
            count++;
        }

        long firstIndex = -1;
        for (Map.Entry entry : indexMap.entrySet()) {
            if ((Long) entry.getValue() >= 0L) {
                if (firstIndex == -1){
                    firstIndex = (Long)entry.getValue();
                }else {
                    firstIndex = Math.min((Long)entry.getValue(), firstIndex);
                }
            }
        }


        return firstIndex;
    }
}
