package algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

class n_queens {
    // this method determines if a queen can
    // be placed at proposed_row, proposed_col
    // with current solution i.e. this move
    // is valid only if no queen in current
    // solution should attacked square at
    // proposed_row and proposed_col
    static boolean is_valid_move(
            int proposed_row,
            int proposed_col,
            List<Integer> solution) {

        // we need to check with all queens
        // in current solution
        for (int i = 0; i < proposed_row; ++i) {
            int old_row = i;
            int old_col = solution.get(i);

            int diagonal_offset = proposed_row - old_row;
            if (old_col == proposed_col ||
                    old_col == proposed_col - diagonal_offset ||
                    old_col == proposed_col + diagonal_offset) {
                return false;
            }
        }

        return true;
    }

    static void solve_n_queens_rec(
            int n,
            List<Integer> solution,
            int row,
            List<List<Integer>> results) {

        if (row == n) {
            System.out.println("result solution : "+ solution);
            results.add(new ArrayList<Integer>(solution));
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (is_valid_move(row, i, solution)) {
                solution.add(row, i);
                System.out.println("solution : "+ solution);
                solve_n_queens_rec(n, solution, row + 1, results);
                solution.remove(solution.size()-1);
            }
        }
    }

    static void solve_n_queens(
            int n,
            List<List<Integer>> results) {

        List<Integer> solution = new ArrayList<Integer>(n);

        solve_n_queens_rec(n, solution, 0, results);
    }

    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        solve_n_queens(4, results);
        System.out.println("Total Solutions Count: " + results.size());
        for (List<Integer> result : results) {
            for (Integer r : result) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
        System.out.println("Total Solutions Count = " + results.size());
    }
}