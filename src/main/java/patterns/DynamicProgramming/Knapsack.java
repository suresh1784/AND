package patterns.DynamicProgramming;

class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
      //  return this.knapsackRecursivev1(profits, weights, capacity, 0);
        Integer[][] matrix = new Integer[profits.length][capacity+1];
        int result =  this.knapsackRecursive(profits, weights, capacity, profits.length-1, matrix);
        for (int i = 0; i < matrix.length; i++) {         //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) {   //this equals to the column in each row.
                System.out.print(matrix[i][j]!=null ?matrix[i][j]+ " ": "# " + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }

        return result;
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex, Integer[][] dp) {
        if (currentIndex <0){
            return 0;
        }

        if (capacity<0){
            return 0;
        }

        if (dp[currentIndex][capacity]!= null){
            return dp[currentIndex][capacity];
        }

        int p1 = 0 ;
        if (capacity-weights[currentIndex] >=0){
            p1 = profits[currentIndex]+knapsackRecursive(profits,weights,capacity-weights[currentIndex],currentIndex-1,dp);
        }

        int p2 = knapsackRecursive(profits,weights,capacity,currentIndex-1,dp);
        dp[currentIndex][capacity]= Math.max(p1,p2);
        return  dp[currentIndex][capacity];
    }

// Recursive Brute Force
    private int knapsackRecursivev1(int[] profits, int[] weights, int capacity, int currentIndex) {
        if (currentIndex >= profits.length){
            return 0;
        }

        if (capacity<0){
            return 0;
        }

        int p1 = 0 ;
        if (capacity-weights[currentIndex] >=0){
            p1 = profits[currentIndex]+knapsackRecursivev1(profits,weights,capacity-weights[currentIndex],currentIndex+1);
        }

        int p2 = knapsackRecursivev1(profits,weights,capacity,currentIndex+1);
        return Math.max(p1,p2);
    }


    public int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        // populate the capacity=0 columns, with '0' capacity we have '0' profit
        for(int i=0; i < n; i++)
            dp[i][0] = 0;

        // if we have only one weight, we will take it if it is not more than the capacity
        for(int c=0; c <= capacity; c++) {
            if(weights[0] <= c)
                dp[0][c] = profits[0];
        }

        // process all sub-arrays for all the capacities
        for(int i=1; i < n; i++) {
            for(int c=1; c <= capacity; c++) {
                int profit1= 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if(weights[i] <= c)
                    profit1 = profits[i] + dp[i-1][c-weights[i]];
                // exclude the item
                profit2 = dp[i-1][c];
                // take maximum
                dp[i][c] = Math.max(profit1, profit2);
            }
        }


        //print Matrix

        for (int i = 0; i < dp.length; i++) {         //this equals to the row in our matrix.
            for (int j = 0; j < dp[i].length; j++) {   //this equals to the column in each row.
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }


        // maximum profit will be at the bottom-right corner.
        return dp[n-1][capacity];
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 17};
        int[] weights = {1, 2, 3, 6};
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackBottomUp(profits, weights, 8);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackBottomUp(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
