package algorithm.onlineassesment.amazon;
import java.util.*;
public class PartitionLabels {
    public static class Letter{
        int start;
        int end;
        public Letter( int start, int end){

            this.start = start;
            this.end = end;
        }
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Letter> map = new HashMap<>();
        int count = 1;
        for (char ch : S.toCharArray()){
            if (map.get(ch)==null){
                map.put(ch, new Letter( count, count));
            }
            map.get(ch).end = count;
            count++;
        } // for

        List<Letter> letters = new ArrayList<>();
        letters.addAll(map.values());
        letters.sort((a,b) -> Integer.compare(a.start, b.start));
        List<Letter>  res = new ArrayList<>();
        res.add(letters.get(0));
        Letter last = letters.get(0);
        int e = 0 ;
        for (Letter let : letters){
            int currStart = let.start;
            int currEnd = let.end;
            int start = last.start;
            int end = last.end;

            if (currStart < end){
                last = new Letter(Math.min(currStart, start), Math.max(currEnd, end));
            }else {
                if (end-e>0)
                result.add(end-e);
                e = end;
                last = let;
            }
        }
        if (last.end-e>0)
        result.add(last.end-e);
        return result;
    }
}
