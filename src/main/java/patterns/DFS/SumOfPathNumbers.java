package patterns.DFS;

import java.util.*;



class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        // TODO: Write your code here

        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int num){
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null){
            num = num*10+root.val;
            return num;
        }

       int left = dfs(root.left, num*10+root.val);
       int right = dfs(root.right, num*10+root.val);
       return left+right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}