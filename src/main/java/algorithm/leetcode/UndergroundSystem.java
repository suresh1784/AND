package algorithm.leetcode;
import java.util.*;
public class UndergroundSystem {
    public static class Node {
        int numOfTravel;
        long totalTime;
        double avgTime;
        public void addTime(int newTime){
           // double currTotalTime = numOfTravel*avgTime;
          //  double newCurrTotalTime = currTotalTime+newTime;
            totalTime = totalTime+newTime;
            numOfTravel = numOfTravel+1;
            avgTime = (double)totalTime/(double)numOfTravel;
        }

        public Node(){
            numOfTravel = 0;
            avgTime = 0.0;
            totalTime= 0;
        }
    }

    public static class Station{
        String from;
        String to;
        public Station(String from, String to){
            this.from = from;
            this.to = to;
        }

        public Station(){
            this.from = null;
            this.to = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Station station = (Station) o;
            return from.equals(station.from) &&
                    to.equals(station.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);

        }

        @Override
        public String toString() {
            return "Station{" +
                    "from='" + from + '\'' +
                    ", to='" + to + '\'' +
                    '}';
        }
    }

    public static class  Customer {
        String fromStation;
        int startTime;

        public Customer(String fromStation, int startTime){
            this.fromStation = fromStation;
            this.startTime = startTime;
        }
    }

    Map<Station,Node> map;
    Map<Integer, Customer > customerMap;

    public UndergroundSystem() {
    map = new HashMap<>();
    customerMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        customerMap.put(id, new Customer(stationName,t));
    }

    public void checkOut(int id, String stationName, int t) {
       Customer customer =  customerMap.get(id);
       Station station = new Station(customer.fromStation,stationName);
       if (!map.containsKey(station)){
          map.put(station, new Node()) ;
       }
       int newTime = t-customer.startTime;
     //   System.out.println("Station " + station.toString()+" New Time "+newTime);
        Node time = map.get(station);
        time.addTime(newTime);
       map.put(station, time);
    }

    public double getAverageTime(String startStation, String endStation) {
      return  map.get(new Station(startStation,endStation)).avgTime;
    }

//    public static void main(String[] args){
//        UndergroundSystem undergroundSystem = new UndergroundSystem();
//        undergroundSystem.checkIn(45, "Leyton", 3);
//        undergroundSystem.checkIn(32, "Paradise", 8);
//        undergroundSystem.checkIn(27, "Leyton", 10);
//        undergroundSystem.checkOut(45, "Waterloo", 15);
//        undergroundSystem.checkOut(27, "Waterloo", 20);
//        undergroundSystem.checkOut(32, "Cambridge", 22);
//        System.out.println( undergroundSystem.getAverageTime("Paradise", "Cambridge"));       // return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
//        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
//        undergroundSystem.checkIn(10, "Leyton", 24);
//        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.0
//        undergroundSystem.checkOut(10, "Waterloo", 38);
//        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 12.0
//    }
}


