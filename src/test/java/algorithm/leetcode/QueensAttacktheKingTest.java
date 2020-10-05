package algorithm.leetcode;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class QueensAttacktheKingTest {

    QueensAttacktheKing queensAttacktheKing = new QueensAttacktheKing();
    @Test
    void queensAttacktheKing1() {
        int[][] queens = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[] kings = {0,0};

        List<List<Integer>> actual = queensAttacktheKing.queensAttacktheKing(queens,kings);
        System.out.println(actual);
    }

    @Test
    void queensAttacktheKing2() {
        int[][] queens = {{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}};
        int[] kings = {3,3};

        List<List<Integer>> actual = queensAttacktheKing.queensAttacktheKing(queens,kings);
        System.out.println(actual);
    }

    @Test
    void queensAttacktheKing3() {
        int[][] queens = {{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},{1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}};
        int[] kings = {3,4};

        List<List<Integer>> actual = queensAttacktheKing.queensAttacktheKing(queens,kings);
        System.out.println(actual);
    }


    @Test
    void queensAttacktheKing4() {
    }

}