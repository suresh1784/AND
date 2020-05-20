package patterns.DFS;

public class DecodeString {
    public static String decodeString(String s) {
        return dfs(s);
    }

    private static String dfs(String s){
        if (!s.contains("[") && !s.contains("]")){
            return s;
        }
        int[] val = findStartAndEnd(s);
        int st = val[0];
        int en = val[1];
       return  dfs(s.substring(0,st)+helper(s.substring(st, en))+s.substring(en, s.length()));

    }

    static int[] findStartAndEnd(String s){
    int[] result = new int[2];
    int start = 0 ;
    int end = s.length()-1;
    boolean flag = Boolean.FALSE;
    for (int i = 0 ; i < s.length(); i++){
        if (Character.isDigit(s.charAt(i))){
            if (!flag){
                start = i;
                flag = Boolean.TRUE;
            }

        }

        if (s.charAt(i)=='['){
            flag = Boolean.FALSE;
        }

        if (s.charAt(i)==']'){
            end = i+1;
            break;
        }
    }
    result[0]= start;
    result[1]= end;
     //   System.out.println(s.substring(start,end));
    return result;
    }


    public static String helper(String str){
        String result = "";
        String tempNum = "";
        String tempStr = "";
        for (char ch : str.toCharArray()){
            if (Character.isDigit(ch)){
                tempNum = tempNum+ch;
            } else if (ch == '[' || ch == ']'){
                continue;
            } else {
                tempStr = tempStr+ch;
            }
        }

        Integer k = Integer.parseInt(tempNum);
        while (k > 0){
            result +=tempStr;
            k--;
        }

        return result;
    }


    public static void main(String[] args){
        System.out.println(helper("3[abc]"));
        System.out.println(findStartAndEnd("2az4[l3[abc]]ef"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("2az4[l3[abc]]ef"));
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
    }

}
