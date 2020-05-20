package algorithm.leetcode;

public class _5230 {
    public static void main(String[] args){
       int[][] coordinates = {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        double top = coordinates[1][1]-coordinates[0][1];
        double bot = coordinates[1][0]-coordinates[0][0];

        double m = top/bot ;
        int n = coordinates.length-1;
        for (int i = 2; i < coordinates.length; i=i+2){
            double top1 = coordinates[i][1]-coordinates[i-1][1];
            double bot1 = coordinates[i][0]-coordinates[i-1][0];
            double m1 =(top1/bot1);
            if (m1 != m ){
                return false;
            }
        }
        double top2 = coordinates[n][1]-coordinates[n-1][1];
        double bot2 = coordinates[n][0]-coordinates[n-1][0];

        double m2 =(top2/bot2);
        if (m2!= m){
            return false;
        }
        return true;
    }
}
