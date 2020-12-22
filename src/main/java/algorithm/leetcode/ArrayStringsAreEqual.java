package algorithm.leetcode;

public class ArrayStringsAreEqual {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0 ;
        int j = 0 ;
        int a = 0;
        int b = 0;
        while (i < word1.length && j < word2.length){
            String s1 = word1[i];
            String s2 = word2[j];
            int len1 = s1.length();
            int len2 = s2.length();

            while (a < len1 && b < len2){

                if (s1.charAt(a)!= s2.charAt(b)){
                    return false;
                }

                a++;
                b++;
            }

            if (a==len1){
                i++;
                a=0;
            }

            if (b==len2){
                j++;
                b=0;
            }


        }

        return true;
    }


    public static void main(String[] args) {
        String[] a1 = new String[2];
        String[] a2 = new String[2];

        a1[0] = "ab";
        a1[1] = "c";

        a2[0] = "a";
        a2[1] = "bc";


        System.out.println(arrayStringsAreEqual(a1,a2));
    }

}
