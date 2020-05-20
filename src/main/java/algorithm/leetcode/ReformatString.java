package algorithm.leetcode;

import java.util.*;
public class ReformatString {
    public String reformat(String s) {
        Queue<Character> characterList = new LinkedList<>();
        Queue<Character> numberList = new LinkedList<>();
        for (Character ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                numberList.add(ch);
            }else {
                characterList.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!characterList.isEmpty() && ! numberList.isEmpty()){
            Character ch1 = characterList.poll();
            Character ch2 = numberList.poll();
            if (characterList.size() > numberList.size()){
                sb.append(ch1);
                sb.append(ch2);
            }else {
                sb.append(ch2);
                sb.append(ch1);
            }
        }

        if (!characterList.isEmpty() || ! numberList.isEmpty()){
            if (characterList.size()==1){
                sb.append(characterList.poll());
            }
            else if (numberList.size()==1){
                sb.append(numberList.poll());
            }else {
                return "";
            }


        }

        return sb.toString();
    }
}
