package patterns.DynamicProgramming.Pattern5;

public class StringTransformation {

    public void findMDI(String s1, String s2) {
        int c1 = findLCSLength(s1, s2);
    }

    private int findLCSLength(String s1, String s2) {
        return 0;
    }

    public static void main(String[] args) {
        StringTransformation mdi = new StringTransformation();
        mdi.findMDI("abc", "fbc");
        mdi.findMDI("abdca", "cbda");
        mdi.findMDI("passport", "ppsspt");
    }

}
