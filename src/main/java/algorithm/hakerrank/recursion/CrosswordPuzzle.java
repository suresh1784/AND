package algorithm.hakerrank.recursion;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CrosswordPuzzle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] crossword = new String[10];

        for(int crossword_i = 0; crossword_i < 10; crossword_i++){
            crossword[crossword_i] = in.next();
        }
        String hints = in.next();
        String[] result = crosswordPuzzle(crossword, hints);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }

    static String[] crosswordPuzzle(String[] crossword, String hints) {
        // Complete this function
        return null;
    }
}
