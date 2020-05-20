package patterns.BFS;

import java.util.*;


class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        // TODO: Write your code here

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode top = q.poll();

            if (top.left != null){
                q.offer(top.left);
            }

            if (top.right!= null){
                q.offer(top.right);
            }


        if (top.val == key){
            break;
        }

        }

        return q.peek();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}
