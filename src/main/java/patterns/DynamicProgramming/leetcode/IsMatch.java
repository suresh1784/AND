package patterns.DynamicProgramming.leetcode;

public class IsMatch {
    public static boolean isMatch(String s, String p) {
        return isMatchRecursive(s.toCharArray(), p.toCharArray(), s.length()-1, p.length()-1, p.charAt(p.length()-1));
    }

    public static boolean isMatchRecursive(char[] s, char[] p, int i , int j, char prev){
        if (i==-1){
            if (prev=='*'){
                return j==0;
            }
            return false;
        }

        if (j <0){
            if (prev=='*'){
                return i==0;
            }
            return false;
        }

        if (i==0 && j ==0 ){
            return s[0]==p[0] || p[0]=='.';
        }

        Boolean b1 ;
        Boolean b2;
        if (s[i]==p[j]|| p[j]=='.'){
            if (prev =='*'){
               if( isMatchRecursive(s,p, i-1,j, prev) ){
                   return true;
               };
            }
            if (isMatchRecursive(s,p, i-1,j-1, p[j])){
                return true;
            }
        }

        if (p[j]=='*'){
            return (isMatchRecursive(s,p, i,j-1, p[j]) ) ;
        }
        return false;
    }


    public static void main(String[] args){
        String s = "mississippi";
        String p = "mis*is*ip*.";
        System.out.println(isMatch(s,p));
    }
}
