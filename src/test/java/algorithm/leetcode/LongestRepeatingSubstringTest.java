package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingSubstringTest {
    LongestRepeatingSubstring obj = new LongestRepeatingSubstring();
    @Test
    void longestRepeatingSubstring() {
        String s = "abcd";
        int expected = 0;
        int actual = obj.longestRepeatingSubstring(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void longestRepeatingSubstring1() {
        String s = "abbaba";
        int expected = 2;
        int actual = obj.longestRepeatingSubstring(s);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void longestRepeatingSubstring2() {
        String s = "aabcaabdaab";
        int expected = 3;
        int actual = obj.longestRepeatingSubstring(s);
        Assert.assertEquals(expected, actual);
    }


    @Test
    void longestRepeatingSubstring3() {
        String s = "aaaaa";
        int expected = 4;
        int actual = obj.longestRepeatingSubstring(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void longestRepeatingSubstring4() {
        String s = "aaabaabaaaababaaaaaaaabaabaaabbbaaaabbbabbbaaaababbbababbbabaaabbaabaaabbaabbaaaabbbaaaabababbbbbaabbbabbaaabababbbbbbaabaaaabbbaaaaaabbbababbaabbbbaabaaabbababbbbabbbabbaabaaaaaabbabaabbbbbabaabababaabbabaaaabbbabbbbbabbaaaaabaababbbbabbaaaaaababbbbaabbbaabaaabaabbbbabbabaabaaaabaaabaaaaaabbbbabbbabbabaaabbbaaaaababaabaabbbbbababaaabbaaaabbbabababaabaabbababbbaaaaabbbabaabbbbbaaabbbaaaaaaabbbbbbbbabbaabbbabaaaabbbbabababababbabbbbbababaaaaababaabbabbbbaababaabbbbbabbbabbaaabbababaabbabbbbaaabaabbaaabbbababaabaaaaaabababaaababaaabaabaabaababaabbaaaaaabababbbabbaababbbababbabababbbabbababbbabbaaaabbbaaabbaababababaaaabbababbbbaaababababbabababbaaaaaabababbbabbabbbaabaaaaabbbbaabaababbbbbbbbbbbbaaaaaaababbbbbaaabaaaaaabaababaababaabaaabbbbaabbbaabbaaaaabaaabaaaababbaabaaaababbbaabbbabaabbaabbbbbabaaaaabaabbabaabbaaaabbababaaabaabbabbbaaaaaaababbbabaaaaaabbbaaabbbabaaabbaaaabbbaabaabbaaaaaaaaabababaaabbaabaaaaaaabbbbabbabbbbbbabbbbbbbaabbbaaaabbabbbbbaabaabbbbbbaabbabbabbaababbbaababbbaab";
        int expected = 20;
        int actual = obj.longestRepeatingSubstring(s);
        Assert.assertEquals(expected, actual);
    }
}