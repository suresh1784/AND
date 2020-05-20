package algorithm.onlineassesment.amazon;

import java.util.*;

public class WebsitePattern {
    class Pair{
        String userName;
        int timeStamp;
        String web;

        public Pair(String userName, int timeStamp , String web){
            this.userName = userName;
            this.timeStamp = timeStamp;
            this.web = web;
        }

    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0 ; i < username.length; i++){
            pairs.add(new Pair(username[i], timestamp[i], website[i]));
        }

        pairs.sort((a,b)-> {
            if (a.userName.equals(b.userName)){
             return   Integer.compare(a.timeStamp,b.timeStamp);
            }
           return a.userName.compareTo(b.userName);
        });
        Map<String, Integer> freqMap = new HashMap<>();
        Map<String, List<String>> listMap = new HashMap<>();
        for (Pair pair : pairs){
            if (listMap.get(pair.userName)==null){
                listMap.put(pair.userName, new ArrayList<>());
            }
            listMap.get(pair.userName).add(pair.web);
        }
        int max = 0 ;
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entrySet : listMap.entrySet()){
            List<String> lists = entrySet.getValue();
            int n = lists.size();
            String s;
            for (int i = 0 ; i < n-2; i++){

                for (int j = i+1 ; j < n-1; j++){

                    for (int k = j+1; k < n ; k++){
                       s = lists.get(i)+"_"+lists.get(j)+"_"+lists.get(k);
                       freqMap.put(s, freqMap.getOrDefault(s, 0)+1);
                       if (freqMap.get(s)>max){
                           max = freqMap.get(s);
                           result = new ArrayList<>();
                           result.add(s);
                       }else if (freqMap.get(s)==max){
                           result.add(s);
                       }
                    }
                }
            }
        }
        result.sort((a,b)-> a.compareTo(b));
        List<String> res = Arrays.asList(result.get(0).split("_"));
        return res;
    }
}
