package patterns.DynamicProgramming.patternv1.games;

public class DivisorGame {
    public static boolean divisorGame(int N) {
        Boolean[] dp = new Boolean[N+1];
        if (N>=1)
        dp[1] = false;
        if (N>=2)
        dp[2] = true;
        if (N>=3)
        dp[3] = false;
        if (N>=4)
        dp[4] = true;
        if (N>=5)
        dp[5] = false;


        return divisorGame(N, dp);
    }

    public static boolean divisorGame(int N, Boolean[] dp){
       // System.out.println(N);
        if (dp[N]!= null){
            return dp[N];
        }

        for (int i = 1; i < N ; i++){
            if ((N%i==0)) {
                if (!divisorGame(N - i, dp)) {
                    dp[N] = true;
                    return dp[N];
                } else {
                    dp[N] = false;
                }
            }
        }
    return dp[N];
    }

    public static void main(String[] args){
        for (int i = 1; i < 1001; i++){
            System.out.println("Value "+ i + " -- " + divisorGame(i));
        }
    }
}
