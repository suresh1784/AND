package patterns.DFS;

import java.util.*;

public class LCAFindSmallestRegion {


    public static String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        String root = regions.get(0).get(0);
        Map<String,List<String>> graph = new HashMap<>();

        for (List<String> region : regions){
            for (int i = 0 ; i < region.size(); i++){
                graph.put(region.get(0), region.subList(1,region.size()));
            }
        }

    return lca(graph, region1, region2, root);
    }


    public static String lca (Map<String,List<String>> graph, String region1, String region2, String root) {
        String r1 = null, r2 = null;
        if (root.equals(region1) || root.equals(region2)) {
            return root;
        }

        if (graph.containsKey(root)) {
            for (String s : graph.get(root)) {
                String temp = lca(graph, region1, region2, s);
                if (temp == null) {
                    continue;
                } else if (r1 == null) {
                    r1 = temp;
                } else {
                    r2 = temp;
                }
            }
        }
        if (r1 != null && r2 != null) {
            return root;
        }

        return (r1!=null) ? r1 : r2;
    }


    public static String lca1 (Map<String,List<String>> graph, String region1, String region2, String root) {

        if (root.equals(region1) || root.equals(region2)) {
            return root;
        }

        String r1 = null;
        int count = 0 ;
        if (graph.containsKey(root)) {
            for (String s : graph.get(root)) {
                String temp = lca1(graph, region1, region2, s);
                if (temp != null) {
                    r1 = temp;
                    count++;

                }
            }
        }
        if(count ==2){
            return root;
        }

        return r1;
    }

    // for Binary Tree

    class TreeNode {
        TreeNode left ;
        TreeNode right;
        int val ;
        public TreeNode(int val){
            this.val = val ;
        }
    }

    // for Binary Tree

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if (root == null){
           return null;
       }

       if (root == p || root == q){
           return root;
       }

       TreeNode left = lowestCommonAncestor(root.left, p , q);
       TreeNode right = lowestCommonAncestor(root.right, p , q);
       if (left != null && right != null){
           return root;
       }

       return left != null ? left : right;
    }


    public static void main(String[] args){
        //regions = [["Earth","North America","South America"],
        //["North America","United States","Canada"],
        //["United States","New York","Boston"],
        //["Canada","Ontario","Quebec"],
        //["South America","Brazil"]],
        //region1 = "Quebec",
        //region2 = "New York"
        //Output: "North America"

        List<List<String>> regions = new ArrayList<>();
        List<String> region1 = new ArrayList<>();
        region1.add("Earth");
        region1.add("North America");
        region1.add("South America");
        List<String> region2 = new ArrayList<>();
        region2.add("North America");
        region2.add("United States");
        region2.add("Canada");
        region2.add("Mexico");
        List<String> region3 = new ArrayList<>();
        region3.add("United States");
        region3.add("New York");
        region3.add("Boston");
        region3.add("Dublin");
        List<String> region4 = new ArrayList<>();
        region4.add("Canada");
        region4.add("Ontario");
        region4.add("Quebec");
        List<String> region5 = new ArrayList<>();
        region5.add("South America");
        region5.add("Brazil");

        String r1 = "Mexico";
        String r2 = "New York";

        regions.addAll(Arrays.asList(region1,region2,region3,region4, region5));
        System.out.println(findSmallestRegion(regions, r1,r2));

    }


}
