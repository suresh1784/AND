package patterns.BFS;

import java.util.*;


class MinimumBinaryTreeDepth {
    public static int findDepthv1(TreeNode root) {
        // TODO: Write your code here

        int height = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            TreeNode top = q.poll();
            int pHeight =height;

            if (top.left != null){
                q.offer(top.left);
                height = pHeight+1;
            }else {
                min = Math.min(min, height);
               // return height;
            }

            if (top.right != null){
                q.offer(top.right);
                height = pHeight+1;
            }else {
                min = Math.min(min, height);
            }
        }
        return min;
    }

    public static int findDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int height = 0 ;
        while (!q.isEmpty()) {
            int size = q.size();
            height++;
            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();
                if (top.left == null && top.right == null) {
                    return height;
                }

                if (top.left != null) {
                    q.offer(top.left);
                }

                if (top.right != null) {
                    q.offer(top.right);
                }
            }
        }

    return -1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}
