package algorithm.leetcode;
import java.util.*;

public class PerfectCity {

    public class Pair{
        Coordinate coordinate;
        double distance;
        public Pair(Coordinate coordinate, double distance){
            this.coordinate = coordinate;
            this.distance = distance;
        }
    }
    public class Coordinate{
        double x;
        double y;

        public Coordinate(double x, double y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;
            Coordinate that = (Coordinate) o;
            return Double.compare(that.x, x) == 0 &&
                    Double.compare(that.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    double perfectCity(double[] departure, double[] destination) {
        Queue<Pair>  q = new LinkedList<>();

        double xCelling = Math.ceil(departure[0]);
        double xFloor = Math.floor(departure[0]);

        double yCelling = Math.ceil(departure[1]);
        double yFloor = Math.floor(departure[1]);
        Set<Coordinate> visited = new HashSet<>();
        if (departure[0] == xFloor){
            q.offer(new Pair (new Coordinate(departure[0],yFloor),departure[1]-yFloor));
            q.offer(new Pair (new Coordinate(departure[0],yCelling),yCelling-departure[1]));
            visited.add(new Coordinate(departure[0],yFloor));
            visited.add(new Coordinate(departure[0],yCelling));
        }else if (departure[1] == yFloor){
            q.offer(new Pair (new Coordinate(xFloor,departure[1]),departure[0]-xFloor));
            q.offer(new Pair (new Coordinate(xCelling, departure[1]),xCelling-departure[0]));
            visited.add(new Coordinate(xFloor,departure[1]));
            visited.add(new Coordinate(xCelling, departure[1]));
        }

      //  q.offer(new Pair (new Coordinate(departure[0],departure[1]),0));

        double result = 0 ;
        while (!q.isEmpty()){
            Pair top = q.poll();
            Coordinate cord = top.coordinate;
            if (cord.x == destination[0] || cord.y == destination[1]){
                double diff = 0 ;
                if (cord.x == destination[0]){
                    if (cord.y > destination[1]){
                        diff = cord.y - destination[1];
                    }else {
                        diff = destination[1] - cord.y;
                    }
                }

                if (cord.y == destination[1]){
                    if (cord.x > destination[0]){
                        diff = cord.x - destination[0];
                    }else {
                        diff = destination[0] - cord.y;
                    }
                }
                System.out.println(cord);
                result = top.distance + diff;
                break;
            }

            double x = cord.x;
            double y = cord.y;
           for (Coordinate next : Arrays.asList(new Coordinate(x+1, y), new Coordinate(x-1,y), new Coordinate(x,y+1), new Coordinate(x,y-1))){
               if (next.x >= 0 && next.x <= 10 && next.y >=0 && next.y <= 10 && !visited.contains(next)){
                   q.offer(new Pair(next, top.distance+1));
               }
           }


        }

        return result;
    }


    public static void main(String[] args) {
        double[] departure = {0.4, 1};
        double[] destination = {0.9, 3};
        PerfectCity perfectCity = new PerfectCity();

        System.out.println(perfectCity.perfectCity(departure, destination));
    }
}
