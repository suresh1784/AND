package algorithm.leetcode;

public class Interpret {
    public static String interpret(String command) {

        String cmd1 =command.replace("()","o");
        String cmd2 = cmd1.replace("(al)","al");
        return cmd2;
    }

    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
    }
}
