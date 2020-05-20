package algorithm.hakerrank.recursion;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PasswordCraker {

    static String passwordCracker(String[] pass, String attempt) {
        // Complete this function
        HashSet<String> dict = new HashSet<>();
        for (String s : pass) {
           dict.add(s) ;
        }

        String result  = breakWord(  attempt.toCharArray() , 0,dict) ;
        if (result != null) {
            return result;
        }else {
            return "WRONG PASSWORD";
        }

    }//passwordCraker







    public static String breakWord(char[] str,int low,Set<String> dictionary){
        StringBuilder buff = new StringBuilder();
        for(int i= low; i < str.length; i++){
            buff.append(str[i]);
            if(dictionary.contains(buff.toString())){
                String result = breakWord(str, i+1, dictionary);
                if(result != null){
                    result =  buff.toString() + " " + result;
                    return result;
                }
            }
        }
        if(dictionary.contains(buff.toString())){
            return buff.toString();
        }
        return null;
    }



    public static void main(String[] args) {

            String[] pass = new String[8];
            pass[0] = "abra";
            pass[1] = "ka";
            pass[3] = "dabra";
            pass[4] = "i";
            pass[5] = "am";
            pass[6] = "a";
            pass[7] = "ace";

            String attempt0 = "iamace";
            String attempt1 = "abra";
            String attempt2 = "kaabra";
            String attempt3 = "kadabraka";
            String attempt4 = "kadabraabra";
            String result = passwordCracker(pass, attempt4);
            System.out.println(result);


        }

    }





