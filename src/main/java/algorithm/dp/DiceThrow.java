package algorithm.dp;
import java.util.*;


public class DiceThrow {
    public static void main (String[] args){
      //  System.out.println(findNumberOfWays(2,4,1));
     //   System.out.println(findNumberOfWays(2,2,3));
        long startTime = System.nanoTime();
            System.out.println(numRollsToTarget(1,6,3));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("-------"+duration);
        long startTime1 = System.nanoTime();
        System.out.println(findWays(30,30,500));
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1);
        System.out.println("------"+duration1);
      //  System.out.println(findNumberOfWays(2,4,5));
      //  System.out.println(findNumberOfWays(3,4,5));
    }
//int d, int f, int target

    public static long findWays(int m, int n, int x){

        long[][] table = new long[n+1][x+1];

        for(int j = 1; j <= m && j <= x; j++)
            table[1][j] = 1;

        for(int i = 2; i <= n;i ++){
            for(int j = 1; j <= x; j++){
                for(int k = 1; k < j && k <= m; k++)
                    table[i][j] += table[i-1][j-k];
            }
        }


        return table[n][x];
    }

    public static int numRollsToTarget1(int m, int n, int x){

        int[][] table = new int[n+1][x+1];

        for(int j = 1; j <= m && j <= x; j++)
            table[1][j] = 1;

        for(int i = 2; i <= n;i ++){
            for(int j = 1; j <= x; j++){
                for(int k = 1; k < j && k <= m; k++)
                    table[i][j] += table[i-1][j-k];
            }
        }


        return table[n][x];
    }

    public static int numRollsToTarget(int dice, int faces, int sum ){
        Map<String, Integer>  map = new HashMap<>();
        return recc(dice,faces,sum, 1, map );
    }

    static int recc(int dice, int faces, int sum, int face, Map<String, Integer> map){

        String key1 = dice+"-"+sum;
        if (map.get(key1)!=null){
            return map.get(key1);
        }

        if (0==dice && sum==0){
            return 1;
        }

        if (0 == dice || sum <0 ){
            return 0;
        }

        int count = 0 ;


    for (int i = 1; i <= faces; i++){
    count+= recc(dice-1, faces, sum -i, i,map);
    }

    String key = dice+"-"+sum;
    map.put(key,count);

    return map.get(key);
    }

}
