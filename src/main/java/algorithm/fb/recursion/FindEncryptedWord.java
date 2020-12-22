package algorithm.fb.recursion;

import algorithm.fb.Heap.FindMaxProduct;

public class FindEncryptedWord {
    String findEncryptedWord(String s) {
        // Write your code here
    return helper(s, 0 , s.length()-1);
    }

    String helper (String s, int start , int end ){

        if (start==end){
            return s.charAt(start)+"";
        }

        if (start > end){
            return "";
        }

        int mid = (start+end)/2;

        return s.charAt(mid)+helper(s,start,mid-1)+helper(s, mid+1, end);
    }












    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String s_1 = "abc";
        String expected_1 = "bac";
        String output_1 = findEncryptedWord(s_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String expected_2 = "bacd";
        String output_2 = findEncryptedWord(s_2);
        check(expected_2, output_2);

        String s_3 = "abcxcba";
        String expected_3 = "xbacbca";
        String output_3 = findEncryptedWord(s_3);
        check(expected_3, output_3);

        String s_4 = "facebook";
        String expected_4 = "eafcobok";
        String output_4 = findEncryptedWord(s_4);
        check(expected_4, output_4);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new FindEncryptedWord().run();
    }
}
