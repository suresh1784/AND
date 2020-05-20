package patterns.mock;

public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        if (s.length()==1){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(s);
        System.out.println(sb.toString());
        String str = sb.toString().substring(1,sb.length()-1);
        System.out.println(str);
        return str.contains(s);
    }

    public static void main(String[] args){
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
    }
}
