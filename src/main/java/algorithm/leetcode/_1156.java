package algorithm.leetcode;

import java.util.*;

public class _1156 {
    public static int maxRepOpt1(String text) {
        if (text== null || text.length()==0){
            return 0;
        }
        int max = 0;
        max = maxRepeat(text);

        int i= 0 ;
        int j = i+1;

        while (i < text.length() && j < text.length()){
            if (text.charAt(i)!= text.charAt(j)){
                String newtext = swap(text, i , j);
                max= Math.max(maxRepeat(newtext), max);
            }
            j++;

            if (j == text.length()-1){
                i++;
                j= i+1;
            }

        }

        return max;
    }

    static String swap(String str, int i, int j)
    {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    public static int maxRepeat(String text) {
        int max = 0;
        int count = 1;
        if (text.length()==0){
            count =0;
        }
        char[] ch = text.toCharArray();

        for (int i = 1; i < ch.length; i++) {
            if (ch[i - 1] == ch[i]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(count, max);
        return max;
    }

    public static void main(String[] args) {
        String text = null;
        String text1 = "ababa";
        String text2 = "aaabaaa";
        String text3 = "aaabbaaa";
        String text4 = "aaaaa";
        String text5 = "abcdef";
        String text6 = "aaaaaaabbbabababbabbabababbaababababbbbababaaabaababaaabaabbbbabbaabbbbabaaaaababbbbaaaaaaaaaabababbbabaabbbabbbabaabaababbbbbbabbbbbbbabbaabbbbabaababaababbbbaaabbababaabbabaaababababaaabbbbbbbabbabababbbabbababaabbaabbababbbbabbbbaaaaababbbababbbbabaaabaababaabaabbbabbaaaabaaabbababbbbbbbbbbbabaaaaaaaaabaabbabaaabaababbabaaaabaaaaabbbaaaaaaabbbbabaababbaaaaabaababaababbaaaabbbabbabaabbbbbbabbbababaaababaaabbbaaaaababbbabbbbaabbaaaababaababbbbbababbbbbaababbababbbbaaabaababbbbbaaabaaabaaaaabbabaabaababaaabbabbbaaaaababbaaababababaabbbaabbbaababababbbaababababbaabbbbaaabbabaabaabaabababaabbbbabbabababbbabbbabaabbbbabababaababbabbaaaabbabbaaababaababbaaababbabaabbbaaabbbbabbbaaabbababbbabaaabaaabbbaabbbaaabbbaaabbbbbaabaaabababbbbabaaaabaabbbabbbabbbaaabbbaabbbabbbaaaaaabbaaabbabaababbbbbbabbaaabbaabaababbbbabaabbbbababbbaaaababbabababbaababbbbabababaabbaabbabaaabbbbaaaaaaababbabaaaabaababbbaaaaaabbaaaaaabaaaaababbbaaabaabaaaabbaaababbbabbbaaabababbbbbbbaabababbbaabbaababbbbbbaaaaaaabaaababaabaabbbbabbababaaaaabbbaabaabbabbbabababbababababbaababbaabbaaaaabaaabaabbbbaabbbababbbaaaabababbbbbabbaaabbabbbaababaabbbababbaababababbbbbaaaabbbaaabbbbaabbababbabaaababbbbbbaaaaababababbbabbabaaaaaabaabaabaabbbbbbaabbbbbbaaabbaaaaababaababbabaaaaababababbbaabbaabaabbbaaaaabbaaaabbaaaababaabbbaaaabaababaabababababbbaaabaabababaaaabbaababbbbaabaaabbabbbbaabbbbabbbbaabbbaaabbbbbaaaaaabbababaaaaabaabaababaabbbaaabbbbbaaaabaababaabbabaabaabaabbbbabababbaaaaabbabbbbaaabbaabbbaaaaaaaaabaaaabbbbbabaaaaabbabaaaabbabbaaaabbbaabababaaaaaaaabbbaaabbaaaababbbbbbababaabaababaaaababbaaababbbbbaabaaaaabbaaaaabbabbababbbbababaaabbababbbabbbbbaaaaaabaabaabbaababaaaabbaaababaabaabaaabbabbaaaaabaabbaabaaababaabbaabaabababababbbaba";
        System.out.println(text + " -- 3 -- " + maxRepOpt1(text));
        System.out.println(text1 + " -- 3 -- " + maxRepOpt1(text1));
        System.out.println(text2 + " -- 6 -- " + maxRepOpt1(text2));
        System.out.println(text3 + " -- 4 -- " + maxRepOpt1(text3));
        System.out.println(text4 + " -- 5 -- " + maxRepOpt1(text4));
        System.out.println(text5 + " -- 1 -- " + maxRepOpt1(text5));

    }
}
