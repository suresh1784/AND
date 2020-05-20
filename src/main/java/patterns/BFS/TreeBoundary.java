package patterns.BFS;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class Status {
    TreeNode node;
    boolean isBoundary ;

    public Status(TreeNode node, boolean isBoundary){
        this.node = node;
        this.isBoundary = isBoundary;
    }
}


class TreeBoundary {

    public static List<TreeNode> findBoundary(TreeNode root) {
     Queue<TreeNode> q = new LinkedList<>();
     q.offer(root);
     List<TreeNode> result = new ArrayList<>();
     while (!q.isEmpty()){
         int size = q.size();
         for (int i = 0 ; i < size ; i++){
             TreeNode top = q.poll();
             if (i == 0){
                 result.add(top);
             }

             if (i==size-1 && i > 0){
                 result.add(top);
             }

             if (top.left == null && top.right == null && i > 0 && i < size-1){

                     result.add(top);

             }

             if (top.left!= null){
                 q.offer(top.left);
             }

             if (top.right != null){
                 q.offer(top.right);
             }
         }
     }

     return result;
    }
    public static List<TreeNode> findBoundaryv1(TreeNode root) {
        List<TreeNode>result = new ArrayList<>();
        result.add(root);
        // TODO: Write your code here
        Queue<Status> q = new LinkedList<>();

        q.offer(new Status(root.left, true));
        while (!q.isEmpty()){
            Status top = q.poll();
            TreeNode pNode = top.node;
            boolean isBoundary = top.isBoundary;

            if (isBoundary || isLeaf(pNode)){
                result.add(pNode);
            }


            TreeNode left = pNode.left;

            if (left != null){
                q.offer(new Status(left, true));
            }

            TreeNode right = pNode.right;

            if (right!= null){
                q.offer(new Status(right, left== null && isBoundary));
            }

        }
        q.offer(new Status(root.right, true));

        while (!q.isEmpty()){
            Status top = q.poll();
            TreeNode pNode = top.node;
            boolean isBoundary = top.isBoundary;

            if (isBoundary || isLeaf(pNode)){
                result.add(pNode);
            }


            TreeNode left = pNode.left;
            TreeNode right = pNode.right;

            if (right!= null){
                q.offer(new Status(right, true));
            }

            if (left != null){
                q.offer(new Status(left, isBoundary&& right==null ));
            }



        }

        return result;
    }

    public static boolean isLeaf(TreeNode root){
    if (root.left == null && root.right == null){
        return true;
    }

    return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(15);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        List<TreeNode> result = TreeBoundary.findBoundary(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }

}

