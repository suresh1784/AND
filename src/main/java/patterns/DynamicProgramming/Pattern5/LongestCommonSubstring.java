package patterns.DynamicProgramming.Pattern5;

public class LongestCommonSubstring {

    public int findLCSLength(String s1, String s2) {
       // return findLCSLengthRecursive1(s1,s2,0,0, 0);
        return findLCSLengthRecursive(s1,s2,0,0);
    }

    private int findLCSLengthRecursive1(String s1, String s2, int i1, int i2, int count) {
        if(i1 == s1.length() || i2 == s2.length())
            return count;

        if(s1.charAt(i1) == s2.charAt(i2))
            count = findLCSLengthRecursive1(s1, s2, i1+1, i2+1, count+1);

        int c1 = findLCSLengthRecursive1(s1, s2, i1, i2+1, 0);
        int c2 = findLCSLengthRecursive1(s1, s2, i1+1, i2, 0);

        return Math.max(count, Math.max(c1, c2));
    }

    private int findLCSLengthRecursive(String s1, String s2, int i1, int i2) {
        if(i1 == s1.length() || i2 == s2.length()){
            return 0;
        }
        int count = 0;
        if(s1.charAt(i1) == s2.charAt(i2)) {

            count = findLCSLengthRecursive(s1, s2, i1 + 1, i2 + 1) + 1;
            System.out.println("count "+count);

        }else {
            count = 0 ;
        }



        int c1 = findLCSLengthRecursive(s1, s2, i1, i2+1);
        System.out.println("c1 "+c1);
        int c2 = findLCSLengthRecursive(s1, s2, i1+1, i2);
        System.out.println("c2 "+c2);
        return Math.max (count, Math.max(c1, c2));
    }




    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        System.out.println(lcs.findLCSLength("abdca", "cbda")); //2
        System.out.println(lcs.findLCSLength("passport", "ppsspt"));// 3
    }
}
