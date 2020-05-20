package algorithm.leetcode;

import java.util.*;

public class RomanToInt {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int length = s.length()-1;
        int result = 0 ;
        int prev = 0 ;
        for (int i = length ; i >= 0 ; i -- ){
            Character temp = s.charAt(i);
            int val = map.get(temp);
            if (prev <= val){
                result += val;
                prev = val;
            }else {
                result -= val;
                prev = val;
            }
        }
        return result;
    }

    public static String intToRoman(int num) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(1,'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50 , 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000,'M');

        return helper(num, map,0);
    }

    static String helper(int num, Map<Integer, Character> map , int level){
        if (num <= 0){
            return "";
        }
        if (map.get(num)!= null){
            return map.get(num)+"";
        }

        if (num <= 3){
           return map.get(1)+helper(num-1, map, level);
        }

        if (num == 4){
            return "IV";
        }

        if (num <= 8 ){
            return map.get(5)+helper(num-5, map, level);
        }

        if (num== 9 ){
            return "IX";
        }

        if (10 < num && num< 50 ){
            int carry = num/10;
            int reminder = num%10;
            if (carry <= 3){
                return map.get(10)+helper(num-10, map, level);
            }

            if (carry == 4){
                return "XL"+helper(reminder, map,level);
            }
        }

        if (50 < num && num < 100){
            int carry = num/10;
            int reminder = num%10;

            if (carry <=8){
                return map.get(50)+helper(num-50, map, level);
            }

            if (carry == 9){
                return "XC"+helper(reminder, map,level);
            }
        }

        if (100 < num && num < 500){
            int carry = num/100;
            int reminder = num%100;

            if (carry <=3){
                return map.get(100)+helper(num-100, map, level);
            }

            if (carry == 4){
                return "CD"+helper(reminder, map,level);
            }
        }

        if (500 < num && num < 1000){
            int carry = num/100;
            int reminder = num%100;

            if (carry <=8){
                return map.get(500)+helper(num-500, map, level);
            }

            if (carry == 9){
                return "CM"+helper(reminder, map,level);
            }
        }

        if (1000< num && num < 4000){
            int carry = num/1000;
            int reminder = num%1000;

            if (carry <=3){
                return map.get(1000)+helper(num-1000, map, level);
            }
        }

        return null;
    }



    public static void main(String[] args){
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("XL"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("IV"));
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(5));
        System.out.println(intToRoman(1994));

    }
}
