package patterns.DFS;

import java.util.*;



class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        // TODO: Write your code here
        List<Integer> list = new ArrayList<>();
        dfs(root,sum, allPaths, list);
        return allPaths;
    }

    public static void dfs(TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> list){
        if (root == null){
            return;
        }

        if (sum==root.val && root.left == null && root.right == null){
            list.add(root.val);
            allPaths.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }

        list.add(root.val);
        dfs(root.left, sum-root.val , allPaths, list);
        dfs(root.right, sum-root.val, allPaths, list);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
