package patterns.BFS;


import java.util.*;


class RightViewTree {
    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
           int size = q.size();

           for (int i = 0 ; i < size ; i++){
               TreeNode top = q.poll();
               if (i == size-1){
                   result.add(top);
               }

               TreeNode left = top.left;
               TreeNode right = top.right;

               if (left!= null){
                   q.offer(left);
               }

               if (right !=null){
                   q.offer(right);
               }
           }


        }

        // TODO: Write your code here
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}