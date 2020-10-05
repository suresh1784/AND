package algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MinInsertions {

    public int minInsertions1(String s) {
        int open = 0 ;
        int closed = 0 ;
        for (char ch : s.toCharArray()){
            if (ch == '('){
                closed += 2;
            }

            if (ch == ')'){
                if (closed > 0 ){
                    closed -= 1;
                }else {
                    open += 1;
                }
            }
        }

        System.out.println("open " +open );
        System.out.println("closed " +closed );
        int total = 0 ;
        if (open%2!=0){
            total +=1;
            open+=1;
        }

        total += open/2;
        total+= closed;
        return total ;
    }


    public int minInsertions(String s) {
       // Stack<Character> stack = new Stack<>();
        Deque<Character> dq = new ArrayDeque<>();
        char lastChar = '1';
        for (char ch : s.toCharArray()){
            if (ch == '('){
                if (lastChar==')'){
                    dq.addLast(')');

                    lastChar = '1';
                }
               dq.addLast('(');
            }

            if (ch == ')'){
               if (lastChar==')'){
                   if (!dq.isEmpty() && dq.getLast()=='('){
                       dq.removeLast();
                       lastChar = '1';
                   }else {
                       dq.addLast(')');
                       dq.addLast(')');
                       lastChar = '1';
                   }
               } else {
                   lastChar = ')';
               }
            }
        }
        if (lastChar==')'){
            dq.addLast(')');
        }

        System.out.println(dq);

        int open = 0 ;
        int closed = 0 ;
        int total = 0 ;
        while (!dq.isEmpty()){
            char ch= dq.removeFirst();
            if (ch == '('){

                if (closed >0){
                    total += getValue(open , closed);
                    open = 0 ;
                    closed = 0 ;
                }
                open +=1;
            }

            if (ch == ')'){
                closed +=1;
            }
        }

        total += getValue(open , closed);


        return total ;
    }

    private int getValue(int open , int closed) {
        System.out.println("open " + open);
        System.out.println("closed " + closed);
        int total = 0;

        if (closed % 2 != 0) {
            total += 1;
            closed += 1;
        }

        if (open < closed){
            closed = closed / 2;

        }else {
            open = open *2;
        }
        total += Math.abs(open - closed);
        System.out.println("----- total "+total);
        return total ;
    }

    public static void main(String[] args) {
//       String[] sArray =  {"(()))", "())", "))())(", "((((((",")))))))", "(()))(()))()())))"};
       MinInsertions minInsertions = new MinInsertions();
//       for (String s : sArray){
//           System.out.println(s+" - "+minInsertions.minInsertions(s));
//           System.out.println("---------------------------------------------------");
//       }
       String s1 = "(()((()((";
        System.out.println(s1+" - "+minInsertions.minInsertions(s1));
    }
}
