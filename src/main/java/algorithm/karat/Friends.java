package algorithm.karat;
import java.util.*;

public class Friends {

    public static void adjencyList(String[] employeesInput, String[] friendshipsInput){
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

            for (String friend : friendshipsInput){
                String[] entry =friend.split(",");
                int id1 = Integer.parseInt(entry[0]);
                int id2 = Integer.parseInt(entry[1]);

                if (map.get(id1) != null){
                    ArrayList<Integer> friends = map.get(id1);
                    friends.add(id2);
                    map.put(id1,friends);
                }else {
                    map.put(id1,new ArrayList<>(Arrays.asList(id2)));
                }


                if (map.get(id2) != null){
                    ArrayList<Integer> friends = map.get(id2);
                    friends.add(id1);
                    map.put(id2,friends);

                }else {
                    map.put(id2,new ArrayList<>(Arrays.asList(id1)));
                }
            }

        System.out.println("result start ------- ");
            for (String emp : employeesInput){
                String[] entry = emp.split(",");
                int id = Integer.parseInt(entry[0]);
                if (map.get(id)==null){
                    System.out.println(id +": None");
                }else {
                    ArrayList<Integer> friends = map.get(id);
                    String friend = "";
                    for (int i : friends){
                        if (friend.length()==0){
                            friend = friend+i;
                        }else {
                            friend = friend + "," + i;
                        }
                    }

                    System.out.println(id +": "+friend);
                }
            }
        System.out.println("result end ------- ");
    }


    public static void main(String[] args) {
        String[] employeesInput = {
                "1,Richard,Engineering",
                "2,Erlich,HR",
                "3,Monica,Business",
                "4,Dinesh,Engineering",
                "6,Carla,Engineering"
        };


        String[] friendshipsInput = {
                "1,2",
                "1,3",
                "2,4"
        };

        adjencyList(employeesInput,friendshipsInput);
    }

    //And this would be considered an acceptable form of output for the adjacency list:
    //
    //# 1: 2, 3
    //# 2: 1, 4
    //# 3: 1
    //# 4: 2
    //# 6: None
    // */
}
