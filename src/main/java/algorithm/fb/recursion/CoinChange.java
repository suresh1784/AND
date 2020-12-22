package algorithm.fb.recursion;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int result = helper(coins, 0 , amount);
        return result!=Integer.MAX_VALUE ? result:-1;
    }


    static int helper(int[]  coins, int i, int target){
        if (target == 0){
            return 0 ;
        }

        if (target < 0 || i >= coins.length){
            return Integer.MAX_VALUE;
        }

        int count1 = Integer.MAX_VALUE;
        int res = helper(coins, i , target-coins[i]);
        if (res != Integer.MAX_VALUE){
            count1 = res+1;
        }
        int count2 = helper(coins, i+1, target);

        return Math.min(count1, count2);
    }

    boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
    return (coinChange(denominations, targetMoney)>=0);
    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        int target_1 = 94;
        int arr_1[] = {5, 10, 25, 100, 200};
        boolean expected_1 = false;
        boolean output_1 = canGetExactChange(target_1, arr_1);
        check(expected_1, output_1);

        int target_2 = 75;
        int arr_2[] = {4, 17, 29};
        boolean expected_2 = true;
        boolean output_2 = canGetExactChange(target_2, arr_2);
        check(expected_2, output_2);

        int target_3 = 11;
        int arr_3[] = {1,2,5};
        boolean expected_3 = true;
        boolean output_3 = canGetExactChange(target_3, arr_3);
        check(expected_3, output_3);


        int target_4 = 3;
        int arr_4[] = {2};
        boolean expected_4 = false;
        boolean output_4 = canGetExactChange(target_4, arr_4);
        check(expected_4, output_4);


        int target_5 = 2;
        int arr_5[] = {1};
        boolean expected_5 = true;
        boolean output_5 = canGetExactChange(target_5, arr_5);
        check(expected_5, output_5);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new CoinChange().run();
    }
}
