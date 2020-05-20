package patterns.DFS;


import java.util.ArrayList;
import java.util.List;

class MaximumPathSum {
    public static int max = 0 ;
    public static int findMaximumPathSum(TreeNode root) {
        // TODO: Write your code here
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int value = dfs(root, 0, list, result);
        System.out.println(result);
        return max;
    }


    static int dfs(TreeNode root, int s, List<Integer> list, List<List<Integer>> result){
     return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
