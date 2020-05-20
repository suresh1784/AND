package algorithm.leetcode;

import java.util.*;

public class _5303 {

    public static String freqAlphabets(String s) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'a');
        map.put(2, 'b');
        map.put(3, 'c');
        map.put(4, 'd');
        map.put(5, 'e');
        map.put(6, 'f');
        map.put(7, 'g');
        map.put(8, 'h');
        map.put(9, 'i');
        map.put(10, 'j');
        map.put(11, 'k');
        map.put(12, 'l');
        map.put(13, 'm');
        map.put(14, 'n');
        map.put(15, 'o');
        map.put(16, 'p');
        map.put(17, 'q');
        map.put(18, 'r');
        map.put(19, 's');
        map.put(20, 't');
        map.put(21, 'u');
        map.put(22, 'v');
        map.put(23, 'w');
        map.put(24, 'x');
        map.put(25, 'y');
        map.put(26, 'z');
        String result = "";
        int count = s.length()-1;
        char[] ch = s.toCharArray();
        while (count >=0){
            if (ch[count]=='#'){
                String s1 = ""+ch[count-2]+ch[count-1];
                result = map.get(Integer.parseInt(s1))+result;
                count = count -3;
            }else {
                String s1 = ""+ch[count];
                result = map.get(Integer.parseInt(s1))+result;
                count = count-1;
            }
        }


        return result;
    }

    public static void main(String[] args){
    String s1 = "10#11#12";
    String s2 = "1326#";
    String s3 = "25#";
    String s4 = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
    String[] S = {s1, s2, s3, s4, ""};

    for (String  s: S){
        System.out.println(s + " result "+freqAlphabets(s));
    }

    }
}
