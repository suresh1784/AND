package algorithm.onlineassesment.amazon;


public class NumberToWords {
    String[] ones = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    String[] twos = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"","Thousand", "Million", "Billion", "Trillion"};
    public String numberToWords(long num) {
        if (num ==0){
            return "Zero";
        }
        return helper(num);
    }

    private String helper(long num){
        if (num <= 10 ){
            return ones[(int)num-1];
        }

        if (num < 20){
            return twos[(int)num-10-1];
        }

        if (num < 100){
            int quotient = (int)num/10;
            int reminder = (int)num%10;
            return tens[quotient-1] + (reminder >0?" " +helper(reminder):"");
        }

        if (num < 1000){
            int quotient = (int)num/ 100;
            int reminder = (int)num%100;
            return helper(quotient) +" "+ "Hundred"+(reminder >0?" "+helper(reminder):"");
        }

        int p = numberOfThousand(num);
        while (p > 0 ){
            long quotient = (int)(num/Math.pow(1000,p));
            long reminder = (long)(num%Math.pow(1000,p));
            return helper(quotient) +" "+ thousands[p]+(reminder >0?" "+helper(reminder):"");
        }
        return null;
    }

    private int numberOfThousand(long num){
        int count = 0 ;
        while (num >= 1000){
            count++;
            num = num/1000;
        }
        return count;
    }

    private String dfs(int num, int p){
        if (num <= 10 ){
            return ones[num-1];
        }

        if (num < 20){
            return twos[num-10-1];
        }

        if (num < 100){
            int quotient = num/10;
            int reminder = num%10;
            return tens[quotient-1] +" " +dfs(reminder,0);
        }

        if (num < 1000){
            int quotient = num/ 100;
            int reminder = num%100;
            return dfs(quotient,0) +" "+ "Hundred"+" "+dfs(reminder,0);
        }

        if (num < 1000000){
            int quotient = num/1000;
            int reminder = num%1000;
            return dfs(quotient,0) +" "+ "Thousand"+" "+dfs(reminder,0);
        }

        if (num < 1000000000){
            int quotient = num/1000000;
            int reminder = num%1000000;
            return dfs(quotient,0) +" "+ "Million"+" "+dfs(reminder,0);
        }

        else {
            int quotient = num/1000000000;
            int reminder = num%1000000000;
            return dfs(quotient,0) +" "+ "Billion"+" "+dfs(reminder,0);
        }

    }
}
