package algorithm.sf;

public class ReverseWords {
    public String reverseWords(String s) {
        if (s.contains(" ")){
            String[] sarr = s.trim().split("\\s+");
            StringBuilder sb = new StringBuilder();
            for(int i = sarr.length-1; i >=0  ; i--){
                sb.append(sarr[i]);
                if (i > 0)
                    sb.append(" ");
            }
            return sb.toString();
        }
        return s;
    }
}
