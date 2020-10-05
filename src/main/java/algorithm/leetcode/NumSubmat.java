package algorithm.leetcode;

import java.util.Objects;

public class NumSubmat {

    class mat{
        int r;
        int c;
        public mat(int r, int c){
            this.r = r ;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof mat)) return false;
            mat mat = (mat) o;
            return r == mat.r &&
                    c == mat.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    class pos {
        mat start;
        mat end;

        public pos(mat start , mat end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof pos)) return false;
            pos pos = (pos) o;
            return start.equals(pos.start) &&
                    end.equals(pos.end);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    public int numSubmat(int[][] mat) {
        if (mat == null || mat.length ==0 ){
            return 0;
        }

        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0 ; i < m ; i ++ ){
            for (int j = 0 ; j < n ;j++){
                if (mat[i][j]==1){

                }
            }
        }
        return 0;
    }
}
