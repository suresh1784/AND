package patterns.DynamicProgramming.patternv1.games;
// not yet solved
public class CanIWin {
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Boolean[] dp = new Boolean[desiredTotal+1];
        return helper(maxChoosableInteger, desiredTotal, dp);
    }

    static boolean helper(int maxChoosableInteger, int desiredTotal, Boolean[] dp){
        if (dp[desiredTotal]!=null){
            return dp[desiredTotal];
        }

        if (desiredTotal < 0 ){
            return false;
        }

//        if (desiredTotal <= maxChoosableInteger){
//            dp[desiredTotal] = true;
//            return true;
//        }

        for (int i = 1; i < maxChoosableInteger ; i++){
            if (!helper(maxChoosableInteger, desiredTotal-i, dp)){
                dp[desiredTotal]= true;
                return true;
            }else {
                dp[desiredTotal]= false;
            }
        }
        dp[desiredTotal]= false;
        return false;
    }
    public static void main(String[] args){
        System.out.println(canIWin(10, 40));
    }
}
