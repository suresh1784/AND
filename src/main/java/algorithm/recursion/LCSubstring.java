package algorithm.recursion;

public class LCSubstring {
    private static Integer res = 0 ;
    public static void main (String[] args){
        String s = "abdlmnqprs";
                String t = "cdplmntrsw";

                if (s!= null && t!=null){
                    char[] s1 = s.toCharArray();
                    char[] t1 = t.toCharArray();
                    Integer count = 0;
                   lcs (s1,t1, 0, 0 , count);
                    System.out.println("count  "+count);
                 //   System.out.println("result "+result);
                    System.out.println("res "+res);
                } // if

    } //main


    public static void lcs(char[] s, char[] t, int i, int j, Integer count ){
        if (i == s.length -1 || j == t.length-1 ){
            System.out.println(" ## count  "+count);

            res = Math.max(res, count);
            return ;
        }



        if (s[i] == t[j]){

            lcs(s,t, i+1, j+1, count+1);

        }else{

            lcs (s,t, i+1, j , 0);
            lcs (s,t, i, j+1 , 0);


        }

    }//lcs
}
