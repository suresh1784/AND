package algorithm.Square;

import java.util.*;

public class SearchCats {


    public static class Cat implements  Comparable<Cat>{
       String name;
       Integer height;
       Integer weight;

       public Cat(String name , Integer heigth, Integer weight){
           this.name = name;
           this.height = heigth;
           this.weight = weight;
       }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Cat o) {
           if (weight!= o.weight)
            return Integer.compare(weight, o.weight);

           return Integer.compare(height, o.height);
        }
    }

    public static List<Cat> getCatNames(List<Cat> cats, String searchCriteria, Integer searchValue, String symbol) {
    List<Cat> result = new ArrayList<>();
    Collections.sort(cats, (a, b) -> Integer.compare(a.weight, b.weight));

    System.out.println(cats);
    return  result;
    }

    public static void main(String[] args){
        String[] names = {"a","b","c","d","e","f","g","h"};
        Integer[] height = {31,24,67,12,45,21,31,12};
        Integer[] weight = {120,124,160,130,175,120,124,142};
        List<Cat> cats = new ArrayList<>();
        TreeSet<Cat> treeSet = new TreeSet<>((a,b)-> Integer.compare(a.weight,b.weight));
        TreeMap<Integer, List<Cat>> treeMap =
                new TreeMap<Integer, List<Cat>>();




        for (int i = 0 ; i <  names.length ; i++){
            cats.add(new Cat(names[i], height[i], weight[i]));
            if (treeMap.get(weight[i])==null){
                treeMap.put(weight[i], new ArrayList<>());
            }
            treeMap.get(weight[i]).add(new Cat(names[i], height[i], weight[i]));
        }

       // Cmp cmp = new Cmp();
     //   Map<String, Integer>  map = new TreeMap<String, Integer>(Cmp);
        Comparator<Map.Entry<String, Integer>> cmp1 = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return 0;
            }
        };


       List<Cat> res = treeMap.floorEntry( 121).getValue();
        System.out.println("res "+res);

        SortedMap<Integer, List<Cat>>  res1 = treeMap.headMap(121);

        NavigableMap<Integer, List<Cat>>  res2 = treeMap.headMap(120, true);
        for (Map.Entry<Integer, List<Cat>> entry : res2.entrySet()){
            System.out.println("inside Loop " + entry.getValue());
        }
        treeSet.addAll(cats);
        Cat r =  treeSet.floor(new Cat("", 46, 120));
        SortedSet<Cat> rr =     treeSet.subSet(new Cat("", 0, 120), new Cat("", 0, 125));
        List<Cat> result = getCatNames(cats, "", 0,"");

    }

    public  class  Cmp implements Comparator<Map.Entry<String,Integer>>{
        public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b){
            return Integer.compare(a.getValue(), b.getValue());
        }
    }
}
