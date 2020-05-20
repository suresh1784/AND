package patterns.DFS;

import java.util.*;



class CountAllPathSum {

    public static Map<Integer, Integer> map;
    public static int countPaths(TreeNode root, int S) {
        // TODO: Write your code here
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int value = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        dfs(root, S, list, result, map1);

        System.out.println("Result "+result);
        return value;
    }


    static void dfs(TreeNode root, int s, List<Integer> list, List<List<Integer>> result, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        int currTarget = s - root.val;
        if (map.containsKey(currTarget)){
            list = new ArrayList<>();
            list.add(currTarget);
            list.add(root.val);
            result.add(new ArrayList<>(list));

        }
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        dfs(root.left, s, list, result, map);
        dfs(root.right, s, list, result, map);



    }

    static int dfs1(TreeNode root, int s, List<Integer> list, List<List<Integer>> result){
        if (root == null){
            return 0;
        }

        if (s<0){
            return 0;
        }

        if (s==root.val){
            list.add(root.val);
            System.out.println(list);
            result.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return 1;
        }


        int left = 0;
             list.add(root.val);
             left +=   dfs1(root.left, s-root.val, list, result);
             list.remove(list.size()-1);
             left +=   dfs1(root.left, s, list, result);
        int right = 0;
        list.add(root.val);
            right += dfs1(root.right, s-root.val, list, result);
           list.remove(list.size()-1);
            right += dfs1(root.right, s, list, result);


            return left+right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(6);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root1, 7));
    }
}