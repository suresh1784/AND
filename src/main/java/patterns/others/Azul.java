package patterns.others;

import java.util.Arrays;

public class Azul {
    public static void main(String[] args){
        int[][] input = new int[5][5];
        maxPosition(input);
    }

    public static void maxPosition(int[][] input){
        int m = input.length;
        int n = input.length;
        for (int i = 0 ; i < m ; i ++){
            for (int j = 0 ; j < n ; j++){
                System.out.println("i ->> "+ i + " j ->> "+j);
                int[][] arr = new int[5][5];
                dfs(arr, i , j,0);
                System.out.println(sum(arr));
            }
        }
    } // maxPosition

    public static void dfs(int[][] input , int i , int j, int level){
        if (level == 25){
            return ;
        }
        input[i][j]= 1;
        input[i][j]= calculatePoint(input, i, j);
        for (Coordinates next : Arrays.asList(new Coordinates(i+1, j), new Coordinates(i, j+1),
                new Coordinates(i-1, j), new Coordinates(i, j-1))){
            if (next.r >=0 && next.r < input.length && next.c >=0 && next.c < input[0].length && input[next.r][next.c]==0){
                 dfs(input, next.r, next.c, level+1);
            }
        }
    }

    public static int sum(int[][] input){
        int sum = 0 ;
        for (int i = 0 ; i < input.length ; i++){
            for (int j = 0 ; j < input[0].length ; j++){
                sum += input[i][j];
            }
        }
        return sum;
    }



    public static int calculatePoint(int[][] input , int r , int c){
        int sumRow = 0 ;
        int sumCol = 0 ;
        int m = input.length;
        int n = input.length;
        for (int i = r ; i < m ; i++){
            if (input[i][c]>0){
                sumRow+= 1;
            }
        }

        for (int i = r-1 ; i >= 0 ; i--){
            if (input[i][c]>0){
                sumRow+=1;
            }
        }

        for (int j = c ; j < n ; j++){
            if (input[r][j]>0){
                sumCol+= 1;
            }
        }

        for (int j = c-1 ; j >= 0 ; j--){
            if (input[r][j]>0){
                sumCol+=1;
            }
        }

        if (sumCol > 1 && sumRow > 1){
            return sumCol+sumRow;
        } else if (sumCol == 1 && sumRow ==1){
            return 1;
        } else if (sumCol == 1 || sumRow ==1){
            return Math.max(sumCol , sumRow);
        }
        return 0;
    }

    public static class Coordinates {
        int r;
        int c;

        public Coordinates(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
