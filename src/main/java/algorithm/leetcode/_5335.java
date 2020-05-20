package algorithm.leetcode;

public class _5335 {
    public static int maxStudents(char[][] seats) {
        if (seats.length ==0){
            return 0;
        }
        return maxStudents(seats, 0, 0);
    }

    private  static int maxStudents(char[][] seats,  int i , int j){
        if (i==seats.length){
            i =0;
            j++;
            if (j==seats[0].length){
                return 0;
            }
        }
        int c1 = 0 ;
        int c2 = 0 ;
        if (seats[i][j]=='.'){
            if (isValid(seats, i, i)){
                seats[i][j]='1';
                c1 = maxStudents(seats, i+1, j)+1;
                seats[i][j]='.';
                c2 = maxStudents(seats, i+1, j);
            }
        }
        return Math.max(c1, c2);
    }

    private static boolean isValid(char[][] seats, int i , int j){
        if (j-1 >= 0){
            if (seats[i][j-1]=='1'){
                return false;
            }
        }

        if (j+1< seats[0].length){
            if (seats[i][j+1]=='1'){
                return false;
            }
        }

        if (i-1 >= 0  && j-1>=0){
            if (seats[i-1][j-1]=='1'){
                return false;
            }
        }

        if (i+1 < seats.length  && j+1<seats[0].length){
            if (seats[i+1][j+1]=='1'){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        char[][] seats = {{'#','.','#','#','.','#'},
                {'.','#','#','#','#','.'},
                {'#','.','#','#','.','#'}};


        System.out.println(maxStudents(seats));
    }


}
