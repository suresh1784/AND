package patterns.Graph.leetcode;


import java.util.*;

public class PathsWithMaxScore_5137 {

    public static int  max = 0 ;
    public static int[] pathsWithMaxScore(List<String> board) {
        max = 0;
    int[] result = new int[2];
    int m = board.size();
    if (m==0){
    return result;
    }
    int n = board.get(0).length();
    boolean[][] visited =new boolean[m][n];
    Map<Integer, Integer> freqMap = new HashMap<>();
    dfsMax(board,m,n, visited, m-1, n-1, 'S',0, freqMap);
      //  System.out.println("---- Max "+max);
        int currMax = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            if (currMax <= entry.getKey()){
                result[0] = entry.getKey();
                result[1] = entry.getValue();
            }
        }
    return result;
    }


    private static int dfsMax(List<String> board, int m , int n , boolean[][] visited, int i , int j , char ch, int sum , Map<Integer, Integer> freqMap){
        visited[i][j] = true;
        int max1 = 0 ;
        for (Coordinate next :  Arrays.asList(new Coordinate(i-1, j) ,new Coordinate(i, j-1), new Coordinate(i-1, j-1) )){
            int sum1 = 0 ;
            if (next.x >= 0 && next.y >=0 && board.get(next.x).charAt(next.y)!='X' && !visited[next.x][next.y]){
                char currCh = board.get(next.x).charAt(next.y);
                if (Character.isDigit(currCh)){
                    int val = currCh-'0';
            //        System.out.println("val " + val);
                   sum1 = val+ dfsMax(board, m , n, visited, next.x, next.y, currCh, sum+val , freqMap);
                    max1 = Math.max(sum1, max1);
                }else if (currCh=='E'){
              //      System.out.println("Max" + max);
               //     System.out.println("Sum" + sum);
                   // max = Math.max(sum, max );
                    if (sum1>= max){
                        max = sum1;
                        freqMap.put(max, freqMap.getOrDefault(max, 0)+1);
                    }

                    return sum;
                }else if (currCh=='S'){
                    sum = dfsMax(board, m , n, visited, next.x, next.y, currCh,sum, freqMap);
                    max1 = Math.max(sum, max1);
                }

            }
        }

        return max1;
    }


    public static class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String [] args){
        //["E11345","X452XX","3X43X4","44X312","23452X","1342XS"]
        List<String> board = new ArrayList<>();
        board.add("E11345");
        board.add("X452XX");
        board.add("3X43X4");
        board.add("44X312");
        board.add("23452X");
        board.add("1342XS");
//        board.add("EX");
//        board.add("XS");
        System.out.println(pathsWithMaxScore(board));
    }
}
