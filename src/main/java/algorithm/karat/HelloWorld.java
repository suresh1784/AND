package algorithm.karat;

public class HelloWorld {
    public static void main(String args[]) {
        int[][] input =  {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}} ;//[[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
    int cost = twoCitySchedCost(input);
        System.out.println(cost);
    }

    public static int twoCitySchedCost(int[][] costs) {
        int minCost = 0;
        for (int[] cost : costs){
            int min = Integer.MAX_VALUE;
            for (int cityCost : cost){
                min = Math.min(min, cityCost);
                System.out.println(min);
            }
            System.out.println("---- "+ min);
            minCost+= min;
        }
        return minCost;
    }
}
