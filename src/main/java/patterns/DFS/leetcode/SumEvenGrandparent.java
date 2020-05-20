package patterns.DFS.leetcode;



import java.util.*;

public class SumEvenGrandparent {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class Pair {
        boolean isEven ;
        TreeNode tree;
        public Pair(TreeNode tree){
            this.tree = tree;
            this.isEven = tree.val%2==0;
        }
    }

    public static int sumEvenGrandparent(TreeNode root) {
        if (root == null){
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        List<TreeNode> grandParent = new ArrayList<>();
        q.offer(new Pair(root));
        while(!q.isEmpty()){
           Pair top = q.poll();
           if (top.isEven && isGrandChildrenExists(top.tree)){
               grandParent.add(top.tree);
           }

           if (top.tree.left!=null){
               q.offer(new Pair(top.tree.left));
           }
            if (top.tree.right!=null){
                q.offer(new Pair(top.tree.right));
            }

        }
        List<Integer> grandChildren = new ArrayList<>();
        int sum = 0;
        for (TreeNode node : grandParent){
            if (node.left != null){
                if ( node.left.left!=null ){
                    grandChildren.add(node.left.left.val);
                }
                if ( node.left.right!= null ){
                    grandChildren.add(node.left.right.val);
                }
            }
            if ( node.right!= null){
                if ( node.right.left!=null ){
                    grandChildren.add(node.right.left.val);
                }
                if ( node.right.right!= null ){
                    grandChildren.add(node.right.right.val);
                }
            }
        }

       for (Integer node : grandChildren){
           sum += node;
       }


        return sum;
    }

    public static boolean isGrandChildrenExists(TreeNode root){
        if (root.left != null){
            if (root.left.left!=null){
                return true;
            }
            if (root.left.right!= null){
                return true;
            }
        }
        if (root.right!= null){
            if (root.right.left!=null){
                return true;
            }
            if (root.right.right!= null){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new  TreeNode(7);
        root.right = new  TreeNode(8);
        root.left.left = new  TreeNode(2);
        root.left.right = new  TreeNode(7);
        root.right.left = new  TreeNode(1);
        root.right.right = new  TreeNode(3);
        root.left.left.left = new  TreeNode(9);
        root.left.right.left = new  TreeNode(1);
        root.left.right.right = new  TreeNode(4);
        root.right.right.right = new  TreeNode(5);
        System.out.println("Result " + sumEvenGrandparent(root));
         TreeNode root1 = new  TreeNode(37);
        root1.left = new  TreeNode(1);
        root1.right = new  TreeNode(2);
        root1.left.left = new  TreeNode(3);
        root1.left.left = new  TreeNode(4);
        root1.right.left = new  TreeNode(5);
        root1.right.right = new  TreeNode(6);
        System.out.println("Result " + sumEvenGrandparent(root1));
    }
}
