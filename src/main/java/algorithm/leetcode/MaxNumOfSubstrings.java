package algorithm.leetcode;
import java.nio.channels.Channel;
import java.util.*;
public class MaxNumOfSubstrings {
    public class Pos{
        Character ch;
        int start;
        int end;

        public Pos( int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public List<String> maxNumOfSubstrings(String s) {
        List<String> result = new ArrayList<>();

        char[] chars = s.toCharArray();
        int lenth = s.length();

        Map<Character, Pos> posHashMap= new HashMap<>();
   //     Map<Integer, HashSet<Character>> indexMap = new HashMap<>();

        for (int i = 0 ; i < lenth ; i++){
            Character ch = chars[i];
            if (!posHashMap.containsKey(ch)){
             posHashMap.put(ch, new Pos(i,i));
            }
            int lastIndex = posHashMap.get(ch).end;
            posHashMap.get(ch).end = i;

//            if (!indexMap.containsKey(i)){
//                indexMap.put(i, new HashSet<>());
//            }


//            int currIndex = i ;
//            while (lastIndex <= currIndex){
//                indexMap.get(currIndex).add(ch);
//                currIndex--;
//            }
        }

        PriorityQueue<Map.Entry<Character, Pos>> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.getValue().end, b.getValue().end));

        HashSet<Character> overlap = new HashSet<>();
        HashSet<Integer> indexSet = new HashSet<>();

        for (Map.Entry<Character, Pos> entry : posHashMap.entrySet()){
            pq.offer(entry);
        }

        while(!pq.isEmpty()){
            Map.Entry<Character, Pos> top = pq.poll();
            int start = top.getValue().start;
            int end = top.getValue().end;


            if (overlap.contains(top.getKey())){
                continue;
            }
            StringBuilder sb = new StringBuilder();
            List<Integer> temp = new ArrayList<>();
            int end1 = top.getValue().end;
            int start1 = top.getValue().start;
            for (int i = top.getValue().start ; i <= end1; i++){
                temp.add(i);
                start1 = Math.min(start1,posHashMap.get(chars[i]).start );
                end1 = Math.max(end1, posHashMap.get(chars[i]).end);
                sb.append(chars[i]);
                if (indexSet.contains(i)){
                    break;
                }
            }

            for (int i = start1 ; i < start ; i++){

            }

            if (sb.length() == end1-start1+1 ){
                result.add(sb.toString());
                indexSet.addAll(temp);
            }


        }

        return result;
    }

    public static void main(String[] args) {
        String s1 =  "adefaddaccc";
        String  s2 = "abbaccd";
        String s3 = "abab";
        String s4 = "ababa";
        MaxNumOfSubstrings maxNumOfSubstrings = new MaxNumOfSubstrings();
        System.out.println(maxNumOfSubstrings.maxNumOfSubstrings(s1));
        System.out.println(maxNumOfSubstrings.maxNumOfSubstrings(s2));
        System.out.println(maxNumOfSubstrings.maxNumOfSubstrings(s3));
        System.out.println(maxNumOfSubstrings.maxNumOfSubstrings(s4));
    }


}
