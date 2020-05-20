package algorithm.leetcode;

public class RemoveAllDuplicates {

    public static String removeDuplicates(String S) {
     return  helper(S,1);
    }

    static String helper(String s, int level) {

        for (int i =1; i < s.length() ; i++){
            if (s.charAt(i-1) == s.charAt(i)){
                return helper(s.substring(0,i-1)+s.substring(i+1), level+1);
            }
        }
        return s;
    }


//    static String helper(String s, int level){
//        System.out.println(s);
//        if (s.length() <= 1){
//            return s;
//        }
//        String result = "";
//        for (int i=1; i < s.length() ; i++){
//            if (s.charAt(i - 1) == s.charAt(i)){
//
//             result =helper(s.substring(0,i-1)+s.substring(i+1), level+1) ;
//            }
//
//            if (s.length()<=2){
//                return s;
//            }
//        }
//
//        return result;
//    }
    public static void main(String[] args){
        //[2,7,4,1,8,1]

        String input = "aaaaaaaa";
        String input1 = "abbaca";
        String input2 =  "azxxzy";
        String input3 = "abbbabaaa"; //"ababa"
        String result = removeDuplicates(input3);
        System.out.println("Result " +result);

    }
}
