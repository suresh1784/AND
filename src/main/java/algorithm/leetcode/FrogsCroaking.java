package algorithm.leetcode;

import java.util.*;
import java.util.LinkedList;



public class FrogsCroaking {
    public static class sort implements  Comparable<sort>{
        Character ch;
        int index;
        public sort(Character ch , int index){
            this.ch = ch;
            this.index = index;
        }

        @Override
        public int compareTo(sort o) {
            return Integer.compare(index, o.index);
        }
    }
    public int minNumberOfFrogs(String croakOfFrogs) {
        int minCount = 0;
        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        map.put('c', new LinkedList<>());
        map.put('r', new LinkedList<>());
        map.put('o', new LinkedList<>());
        map.put('a', new LinkedList<>());
        map.put('k', new LinkedList<>());
        int index = 0 ;
        for (Character ch : croakOfFrogs.toCharArray()){
            if (map.get(ch)== null){
                return -1;
            }
            map.get(ch).addLast(index);
            index++;
        }

        minCount = map.get('c').size();

        LinkedList<Character>  croak = new LinkedList<>();
        croak.addAll(Arrays.asList('c','r','o','a','k'));


        for (Map.Entry<Character,LinkedList<Integer>> entry : map.entrySet()){
            if (entry.getValue().size()!= minCount){
                return -1;
            }
        }
        int chIndex = -1;
        int result = 0;

        LinkedList<Integer> c = map.get('c');
        LinkedList<Integer> k = map.get('k');
        List<sort> sortList = new ArrayList<>();
        for (int i : c){
            sortList.add(new sort('c', i));
        }

        for (int i : k){
            sortList.add(new sort('k', i));
        }
        int count = 0 ;
        sortList.sort((a,b)-> Integer.compare(a.index, b.index));
        for (sort s : sortList){
            if (s.ch =='c'){
                result++;
            }else {
                result--;
            }
            System.out.println(count);
            count = Math.max(count, result);
        }

        while (map.get('k')!= null){

            for (Character ch : croak){
                int currIndex = map.get(ch).removeFirst();
                if (map.get(ch).size()==0){
                    map.remove(ch);
                }
                if (currIndex< chIndex){
                    return -1;
                }
                if (ch!='c')
//                result = Math.max(currIndex-chIndex , result);
                chIndex = currIndex;
                if (ch =='k'){
                    chIndex = -1;
                }
            }
        }

        if (map.size() > 0){
            return -1;
        }



        return count;
    }
}
