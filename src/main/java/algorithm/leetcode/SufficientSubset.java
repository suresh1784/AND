package algorithm.leetcode;

public class SufficientSubset {
    public static class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void inOrder(TreeNode root){
        if (root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.val +" --> ");
        inOrder(root.right);
    }

    public static TreeNode sufficientSubset(TreeNode root, int limit) {
        return recursive(root, limit, 0, root);
    }






    public static TreeNode recursive(TreeNode x, int limit, int sum, TreeNode prev) {
        if (x == null){
            return null;
        }
        if (sum+x.val < limit && x.left == null && x.right == null){
            return null;
        }


        x.left = recursive(x.left, limit, sum+x.val, x);
        x.right = recursive(x.right, limit, sum+x.val, x);
        if (x.left == null && x.right== null){
            if (sum+x.val < limit){
               x = null;
            }
        }

        return x;


    }
    public static void main(String[] args){
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.left.left = new TreeNode(-11);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(1);
        tree.right = new TreeNode(8);
        tree.right.right = new TreeNode(4);
        tree.right.left = new TreeNode(17);
        tree.right.right.right = new TreeNode(3);
        tree.right.right.left = new TreeNode(5);
        inOrder(tree);
        System.out.println("--------------------");
        inOrder(sufficientSubset(tree, 22));
    }
}
