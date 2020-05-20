package algorithm.onlineassesment.amazon;
import java.util.*;
public class CombinationalSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
     //   helper(candidates, target, 0, result, new ArrayList<>(), new HashSet<>());
      //  dfs_com(candidates, 0, target ,new ArrayList<>(), result );
        List<List<Integer>> res = dfs_com1(candidates, 0 , target, new HashMap());
        System.out.println("res "+res);
        return res;
    }

    public void helper(int[] candidates, int target, int index,List<List<Integer>> result, List<Integer> list, Set set ){
        if (target==0){
            if (!set.contains(list.hashCode())){
                set.add(list.hashCode());
                result.add(new ArrayList<>(list));
            }

            return;
        }

        if (target<0 || index>=candidates.length){
            return;
        }
//        if(index-1>=0 && candidates[index]==candidates[index-1]){
//
//        }else {
            list.add(candidates[index]);
            helper(candidates, target - candidates[index], index + 1, result, list, set);
            list.remove(list.size() - 1);
       // }
        helper(candidates, target,index+1,  result, list, set);
    }

    void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return ;
        }
        if (target < 0) return;
        for (int i = cur; i < cand.length; i++){
            if (i > cur && cand[i] == cand[i-1]) continue;
            path.add(path.size(), cand[i]);
            dfs_com(cand, i+1, target - cand[i], path, res);
            path.remove(path.size()-1);
        }
    }

    List<List<Integer>> dfs_com1(int[] cand, int cur, int target, Map<String, List<List<Integer>>> map) {
        String str = cur+"_"+target;
        if (map.containsKey(str)){

            return map.get(str);
        }
       List<List<Integer>> res =new  ArrayList<>();
        if (target == 0) {
            List<Integer> list = new ArrayList<>();
            res.add(new ArrayList(list));
            return res;
        }

        for (int i = cur; i < cand.length; i++){
            if (i > cur && cand[i] == cand[i-1]) continue;
            List<List<Integer>>  lists = dfs_com1(cand, i+1, target - cand[i], map);
            for (List<Integer> l : lists){
                l.add(cand[i]);
                res.add(new ArrayList<>(l));
                l.remove(l.size()-1);
            }

        }
        map.put(str, res);
        return res;
    }
}
