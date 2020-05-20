package patterns.DFS;

import java.util.*;



class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        // TODO: Write your code here
        return dfs(root, sequence, 0);
    }

    static boolean dfs(TreeNode root, int[] sequence , int level){
        if (root== null){
            return false;
        }

        if (level >= sequence.length){
            return false;
        }

        if (root.right == null && root.left == null && level == sequence.length-1){
            return sequence[level]== root.val;
        }

        if (sequence[level]== root.val)
            return dfs(root.left, sequence , level+1) || dfs(root.right, sequence , level+1) ;
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}