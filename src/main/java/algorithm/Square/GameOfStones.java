package algorithm.Square;
import java.util.*;
public class GameOfStones {

    public static String winner(List<Integer>  in , List<List<Integer>> options){
        if (!isMove(in) || !canApply(in , options)){
            return "second";
        }

        if (notNextMove(in , options)){
            return "first";
        }

        if (winner(computeNewValue(in, options.get(0)) ,options )=="first" && winner(computeNewValue(in, options.get(1)) ,options )=="first" && winner(computeNewValue(in, options.get(2)) ,options )=="first"){
            return "second";
        }else {
            return "first";
        }


    }

    public static boolean isMove(List<Integer> in){
        for (int i : in){
            if (i < 0 ){
                return false;
            }
        }
        return true;
    }

    public static boolean canApply(List<Integer>  in , List<List<Integer>> options){
        for (List<Integer> option : options){
            List<Integer> newVal = computeNewValue(in, option);
            if (isMove(newVal)){
                return true;
            }
        }
        return false;
    }

    public static boolean notNextMove(List<Integer>  in , List<List<Integer>> options){
        for (List<Integer> option : options){
            List<Integer> newVal = computeNewValue(in, option);
            if (!isMove(newVal)){
                return true;
            }
        }
        return false;
    }

    public static List<Integer> computeNewValue(List<Integer> in , List<Integer> option){
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < in.size() ; i ++){
            int in1 = in.get(i);
            int option1 = option.get(i);
            result.add(in1+option1);
        }
        return result;
    }

    public static class Player{
        Integer player ;
        List<Integer> board;
        public Player(Integer player , List<Integer> board){
            this.player = player;
            this.board = board;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "player=" + player +
                    ", board=" + board +
                    '}';
        }
    }

    public static int getOtherPlayer(int player){
        if (player ==1){
            return 2;
        }
        if (player ==2){
            return 1;
        }

        return 0;
    }



    public static void gameOfStones(List<Integer> in , List<List<Integer>> options){
        Queue<Player>  q = new LinkedList<>();
        q.offer(new Player(1, in));
        List<Player> lostPlayer = new ArrayList<>();
        List<List<Player>> trackings = new ArrayList<>();
        List<Player> tracking = new ArrayList<>();
        while (!q.isEmpty()){
            Player top = q.poll();
            if (!canApply(top.board , options)){
                trackings.add(tracking);
                tracking = new ArrayList<>();
               lostPlayer.add(top) ;
            }

            for (List<Integer> option : options){
                List<Integer> newBoard = computeNewValue(top.board , option);
                if (isMove(newBoard)){
                    Player player = new Player(getOtherPlayer(top.player), newBoard);
                    tracking.add(player);
                    q.offer(player);
                }
            }


        }

        System.out.println(lostPlayer);
    }

    public static void main(String[] args){
        List<Integer> in = new ArrayList<>();
        in.addAll(Arrays.asList(6,4,8,8));

        List<List<Integer>> options = new ArrayList<>();
        options.addAll(Arrays.asList(Arrays.asList(-2, -2, 1, 0), Arrays.asList(-4, -4, 0 , 0 ), Arrays.asList(0 , 0 , -2, -2)));

        gameOfStones(in,options);

    }
}
