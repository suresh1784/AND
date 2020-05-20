package patterns.DynamicProgramming.leetcode;

public class RobberTree {

        static class TreeNode{
            int val;
            TreeNode left ;
            TreeNode right;
    }

        public int rob(TreeNode root) {
            if (root == null){
                return 0;
            }

            int c1 = 0 ;
             c1 += (root.val + ((root.left!=null) ? (rob(root.left.left)+rob(root.left.right)) : 0 )+((root.right!=null)? (rob(root.right.left)+rob(root.right.right)) : 0));

            int c2 = rob(root.left)+rob(root.right);
            return Math.max(c1,c2);
        }

}
