package algorithm.leetcode;

public class NumWaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
       if (numBottles < numExchange){
           return numBottles;
       }

       return recursive(numBottles, 0 , numExchange);
    }

    public int recursive(int fullBottle, int emptyBottle, int numExchange){
        if (fullBottle==0){
            if (emptyBottle < numExchange){
                return 0;
            }
            return recursive(emptyBottle/numExchange, emptyBottle%numExchange, numExchange);
        }

        return fullBottle+recursive(fullBottle/numExchange, emptyBottle+(fullBottle%numExchange), numExchange);
    }

    public static void main(String[] args) {
        NumWaterBottles func = new NumWaterBottles();
        System.out.println(func.numWaterBottles(9,3));
        System.out.println(func.numWaterBottles(15,4));
        System.out.println(func.numWaterBottles(5,5));
        System.out.println(func.numWaterBottles(2,3));
        System.out.println(func.numWaterBottles(17,3));
    }

//    public int numWaterBottles(int numBottles, int numExchange) {
//        if (numBottles < numExchange){
//            return numBottles;
//        }
//
//        return numBottles+numWaterBottles((numWaterBottles(numBottles/numExchange, numExchange)+ numBottles%numExchange)/numExchange,numExchange )+numBottles/numExchange;
//    }
}
