package algorithm.hired;
import java.util.Map;
import java.util.HashMap;
public class NoRepeatSubstring {

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.solution("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.solution("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.solution("abccde"));
    }

    public static long solution(String s) {
        // Type your solution here
        int windowStart = 0;
        long maxLength = 0L;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(s.charAt(windowEnd), windowEnd); // insert the 'rightChar' into the map
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }
}
