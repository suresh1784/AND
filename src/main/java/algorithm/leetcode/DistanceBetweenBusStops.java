package algorithm.leetcode;

public class DistanceBetweenBusStops {

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int max = 0 ;
        int forward = 0;
        int reverse = 0  ;

        if (start > destination){
            int temp = start;
            start = destination;
            destination = temp;
        }


        for (int i = start ; i < destination ; i++){
            forward += distance[i];
        }


       while (true){
        //   System.out.println("start" +start);

           if (start == 0){
               start = distance.length-1;
           }

           if (start < destination){
               reverse += distance[start-1];
           }else {
               reverse += distance[start];
           }

           if (start == destination){

               break;
           }
           start--;

       }

     //   System.out.println("forward " +forward);
     //   System.out.println("reverse "+ reverse);
        return Math.min(forward, reverse);
    }


    public static void main(String[] args){
        int[] distance = {7,10,1,12,11,14,5,0};
        int[] distance1 = {1,2,3,4};
        System.out.println( distanceBetweenBusStops(distance, 7 ,2));
    }
}
