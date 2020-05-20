package patterns.subsets;

import java.util.*;

class GeneralizedAbbreviation {

    public static List<String> generateGeneralizedAbbreviation1(String word) {
        List<String> result = new ArrayList<String>();
        result.add(word);
        for (int i = 0 ; i < word.length(); i++){
            int size = result.size();
            for (int j = 0 ; j < size ; j++){
                String s = result.get(j);
          //      System.out.println("s "+s);
                String temp = convert(s.toCharArray(),i);
          //      System.out.println("temp "+temp);
                result.add(temp);
            }
        }
        return result;
    }

    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<String>();
        dfs(word, result, "", 0);
        return result;
    }

    public static void dfs(String word, List<String> result, String str, int level){
        if (level >= word.length()){
            result.add(str);
            return;
        }


            char ch = word.charAt(level);
            dfs(word, result, abr(str+1), level+1 );
            dfs(word, result, str+ch, level+1 );
    }

    static String abr(String str){
        int count = 0 ;
        String result = "";
        for (char ch : str.toCharArray()){
         if (Character.isDigit(ch)){
             count = count+Character.getNumericValue(ch);
         }else {
             if (count > 0){
                 result=result+count+ch;
                 count = 0 ;
             }else {
                 result=result+ch;
             }
         }
        }

        if (count > 0 ){
            result = result +count;
        }

        return result;
    }


    public static String convert(char[] s, int i){

        s[i]= '1';
        return new String(s);
    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
