package algorithm.dp;

public class LightOutPuzzle {
    public static void main(String[] args){
        int[][] input = {{0,1,0},
                {1,1,1},
                {0,1,0}};
        int count = flip(input);
        System.out.println(count);
    }

    public static int flip(int[][] input){
        return flip(input, 0 , isZero(input));
    }

   public static  int minCount = Integer.MAX_VALUE;

    static int flip(int[][] input, int level, boolean isZero){
        if (isZero){
            return 1;
        }

        if (level >=  input.length){
            return 0;
        }

        int flipCount = 0 ;
        for (int i = 0 ; i < input.length; i++ ){
            int[][] temp = input;
            input = modify(input, i , level);
            System.out.println("i , level (" +i + " , " + level+")");
            flipCount+= flip(input, level+1, isZero(input));
            input = temp;
        }
       // System.out.println("FlipCOunt" + flipCount);
        if (flipCount >0)
        minCount = Math.min(minCount, flipCount);
     //   System.out.println("minCount "+minCount);

        return flipCount;

    }

   public static boolean isZero (int[][]  input){
        for (int i = 0 ; i < input.length ; i++){
            for (int j = 0 ; j < input.length ; j++){
                if (input[i][j]==1){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] modify (int[][]  input, int i , int j){
        input[i][j] = input[i][j]==0 ? 1:0;
        if ( j+1 < input.length){
            input[i][j+1] = input[i][j+1]==0 ? 1:0;
        }
        if (i-1 >=0 ){
            input[i-1][j] = input[i-1][j]==0 ? 1:0;
        }
        if (i+1 < input.length){
            input[i+1][j] = input[i+1][j]==0 ? 1:0;
        }
        if (j-1 >=0 ){
            input[i][j-1] = input[i][j-1]==0 ? 1:0;
        }
        return input;
    }



}
