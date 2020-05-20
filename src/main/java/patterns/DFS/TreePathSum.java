package patterns.DFS;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class TreePathSum {
    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null){
            return false;
        }


        if (root.left == null && root.right == null){
            return root.val == sum;
        }

        Boolean left = hasPath(root.left, sum-root.val);
        Boolean right = hasPath(root.right, sum-root.val);

        return left || right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
    }
}
