package algorithm.strings;
import java.util.*;

public class StringManipulation {
    public static void main(String[] args){
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        map.put(1, new HashSet<>(Arrays.asList(1,2)));
        reverseWords("Hello Jon How are you".toCharArray());
    //    System.out.println(reverseString(reverseString("Hello Jon How are you")));
   //     System.out.println(removeDuplicate("aabbbbccddddeeee"));
    }

    static String removeDuplicates(String input){
        char[] charStr = input.toCharArray();
        Set<Character> set = new HashSet<>() ;
        String result = "";
        for (int i = 0 ; i < charStr.length; i ++){
            if (!set.contains(charStr[i])){
                set.add(charStr[i]);
                result = result+charStr[i];
            }
        }
        return result;
    }

    static String removeDuplicate(String input) {
        char[] charStr = input.toCharArray();
        int writeInx = 0 ;
        for (int i = 1; i < charStr.length; i++){
            if (charStr[i]!=charStr[writeInx]){
                char temp = charStr[i];
                charStr[++writeInx] = temp;

            }
        }
return new String(charStr).substring(0, writeInx+1);
    }

    static String reverseString (String input){
        char[] inputChar = input.toCharArray();
        reverse(inputChar, 0 , input.length()-1);
        System.out.println(new String(inputChar));
        for (int i = 0 , j = 0 ; j <= inputChar.length-1 ; j++){
            if (j==inputChar.length-1 ||inputChar[j]==' '){
                reverse(inputChar, i , j);
                i = j+1;
            }


        }
        return new String(inputChar);
    }




    static void reverse (char[] input , int start, int end){
        while (start< end){
            char tmp = input[start];
            input[start] = input[end];
            input[end] = tmp;
            start++;
            end--;
        }
    }


   static void reverseWords(char[] input){
        int n = input.length;
        reverse(input, 0 , n-1);

        int start = 0 ; int finish = 0 ;
        while(start<n){
            while (start<finish || (start< n && input[start]==' ')){
                start++;
            }

            while (finish < start || (finish < n && input[finish]!=' ')){
                finish++;
            }

            reverse (input , start, finish-1);
        }
       System.out.println(new String(input));
    }

}
