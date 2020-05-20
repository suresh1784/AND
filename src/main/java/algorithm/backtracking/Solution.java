package algorithm.backtracking;

public class Solution {
    static String[] lows = "Zero One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen".split(" ");
    static String[] tens = "Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety".split(" ");
    static String[] bigs = "Hundred Thousand Million Billion".split(" ");

    public static String convert(int n) {
        if (n < 20)
            return lows[n];

        if (n < 100)
            return tens[n / 10 - 2] + helper(n % 10);

        if (n < 1000)
            return lows[n / 100] + " " + bigs[0] + helper(n % 100);

        int m = 1000;

        for (int i = 1; i < bigs.length; i++, m *= 1000)
            if (n / 1000 < m)
                return convert(n / m) + " " + bigs[i] + helper(n % m);

        return convert(n / m) + " " + bigs[bigs.length - 1] + helper(n % m);
    }

    public static String helper(int n) {
        return n == 0 ? "" : " " + convert(n);
    }


    public static void main (String[] args){
        System.out.println(convert(1234567891));
    }
}