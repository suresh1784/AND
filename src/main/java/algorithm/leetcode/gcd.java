package algorithm.leetcode;

public class gcd {
    static int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }


    public static String gcdOfStrings(String str1, String str2) {
        System.out.println("Str1 "+str1);
        System.out.println("Str2 "+str2);
        if (str1.equals("") ){
            return str2;
        }

        if (str2.equals("")){
            return str1;
        }

        if (str1.equals(str2)){
            return str1;
        }

        if (str1.length()>str2.length()){
            if (str1.contains(str2))
                return gcdOfStrings(str1.replace(str2, ""), str2);
            return "";

        }

            if (str2.contains(str1))
                return gcdOfStrings(str1, str2.replace(str1, ""));
            return "";


    }

    // Driver method
    public static void main(String[] args)
    {
        int a = 98, b = 56;
     //   System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b));
        String str1 = "ABABAB";
                String str2 = "ABAB";
        System.out.println("Result " +  gcdOfStrings(str1,str2));
    }




}
