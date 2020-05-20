package patterns.DFS.leetcode;
import java.util.*;
public class CanVisitAllRooms {
    public static boolean canVisitAllRoomsv1(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        List<Integer> zeros = rooms.get(0);
        visited[0] = true;
        int count = rooms.size()-1;
        for (Integer zero: zeros){
            q.offer(zero);
        }

        while (!q.isEmpty()){
            Integer top = q.poll();
            if (!visited[top]) {
                visited[top] = true;
                count--;
                if (count == 0){
                    return true;
                }
            }
            List<Integer> keys = rooms.get(top);
            for (Integer key : keys){
                if (!visited[key]){
                    q.offer(key);
                }
            }
        }
    return count == 0;
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visisted = new boolean[rooms.size()];
        return dfs(rooms, visisted, rooms.size()-1, 0);
    }

    public static boolean dfs(List<List<Integer>> rooms, boolean[] visited, int count, int room){
        if (count == 0){
            return true;
        }

        visited[room] = true;

        List<Integer> lists = rooms.get(room);
        for (Integer list : lists){
            if (!visited[list]) {
                count--;
                if (dfs(rooms, visited, count, list)){
                    return true;
                }
            }
        }

        return count == 0;

    }

    public static void main(String[] args){
        int[][] input1 = {{1},{2},{3},{4}};
        int[][] input2 = {{1,3},{3,0,1},{2},{0}};
        // [[1,7,9],[8,3,6],[1],[6,5],[4,7,7],[5,2,6],[4,5],[2],[9,8,2,3,4,8],[1,3,9]]
        List<List<Integer>> in1 = new ArrayList<>();
        List<Integer> t1 = new ArrayList<>();
        t1.add(1);
        t1.add(7);
        t1.add(9);
        List<Integer> t2 = new ArrayList<>();
        t2.add(3);
        t2.add(8);
        t2.add(6);
        List<Integer> t3 = new ArrayList<>();
        t3.add(1);
        List<Integer> t4 = new ArrayList<>();
        t4.add(6);
        t4.add(5);
        List<Integer> t5 = new ArrayList<>();
        t5.add(4);
        t5.add(7);
        t5.add(7);
        List<Integer> t6 = new ArrayList<>();
        t6.add(5);
        t6.add(2);
        t6.add(6);

        List<Integer> t7 = new ArrayList<>();
        t7.add(5);
        t7.add(4);

        List<Integer> t8 = new ArrayList<>();
        t8.add(2);

        List<Integer> t9 = new ArrayList<>();
        t9.add(9);
        t9.add(8);
        t9.add(2);
        t9.add(3);
        t9.add(4);
        t9.add(8);

        List<Integer> t10 = new ArrayList<>();
        t9.add(9);
        t9.add(1);
        t9.add(3);


        in1.add(t1);
        in1.add(t2);
        in1.add(t2);
        in1.add(t4);
        in1.add(t5);
        in1.add(t6);
        in1.add(t7);
        in1.add(t8);
        in1.add(t9);
        in1.add(t10);


        System.out.println(canVisitAllRooms(in1));
    }
}
