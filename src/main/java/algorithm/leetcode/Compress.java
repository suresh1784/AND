package algorithm.leetcode;

public class Compress {
    public static int compress(char[] chars) {
        if (chars.length<=1){
            return chars.length;
        }
        int left = 0 ;
        int c = 0 ;
        for (int right = 0; right < chars.length ; right++){
            if (chars[left]!=chars[right]){
            int length = String.valueOf(c).length();
            if (c>1){
                left = left+length+1;
                c = 0;
            }else {
                left ++;
                c = 0;
            }
            }
            c++;
        }
        int length = String.valueOf(c).length();
        if (c>1) {
            left = left + length + 1;
        }else {
            left ++;
        }
        return left;
    }

    public static void main(String[] args){
        char[] ch1 = {'a','a','b','b','c','c','c'};
        char[] ch2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] ch3 = {'a','b'};

        char[][] ch = { ch1, ch3, ch2};
        for (char[] c : ch){
            System.out.println(compress(c));
        }

    }
}
