package algorithm.sf;

public class NumDecodings {
    public static int numDecodings(String s) {
        int result = 0 ;
        return helper(s, 0, -1);
    }


    public static int helper(String input , int level, int val){
//        if ( val >26){
//            return 0;
//        }

        if (val == 0){
            return 0;
        }

        if (level == input.length() ){
            System.out.println("--");
            return 1;
        }
        int count = 0 ;
        if (level+2 <=input.length() && Integer.parseInt(input.substring(level,level+2))<=26){
            System.out.println("<>");
          count =  helper(input, level+2,Integer.parseInt(input.substring(level,level+2)));
        }

        int count1 = helper(input, level+1, Integer.parseInt(input.substring(level,level+1)));
        return count+count1;
    }

    public static void main(String[] args){
        System.out.println("123".substring(0,1));
        String input1 = "12";
        System.out.println("12 "+numDecodings(input1));
        String input2 = "226";
        System.out.println("226 "+numDecodings(input2));
        String input3 = "2006";
        System.out.println("2626 "+numDecodings(input3));
    }


}
