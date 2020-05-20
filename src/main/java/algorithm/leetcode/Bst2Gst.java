package algorithm.leetcode;

import java.sql.SQLOutput;

public class Bst2Gst {
    public static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x)
     { val = x; }
     TreeNode(int x, TreeNode left, TreeNode right)
        {
            val = x;
        this.left = left;
        this.right = right;
        }
    }


    public static void inOrder(TreeNode root, String traverse){
        if (root == null){
            return;
        }

        inOrder(root.left, traverse+" -> left ");
        System.out.println(traverse + " ---> "+ root.val);
        inOrder(root.right , traverse + " -> right");
    }


    public static void insert(TreeNode root, int key, TreeNode parent , String direction){
        if (root == null){
            if (direction == "right") {
                parent.right = new TreeNode(key);
            }else {
                parent.left = new TreeNode(key);
            }
            return;
        }
        if (root.val < key){
            insert(root.right, key, root, "right");
        }else{
            insert(root.left, key, root, "left");
        }
    }


    public static void delete (TreeNode root, int key , TreeNode parent, String direction){
        if (root== null){
            return;
        }

        if (root.val == key){
            TreeNode child = null;
            if (root.left == null || root.right == null ){
                if (root.left != null){
                    child = root.left;
                }else if (root.right != null) {
                    child = root.right;
                }
            } else if ((root.left != null && root.right != null )){

            }

            if (direction == "left")
                parent.left = child;
            else
                parent.right = child;
            return;
        }

        if (root.val > key){
            delete(root.left, key, root, "left");
        }else {
            delete(root.right, key, root, "right");
        }

    }

   static TreeNode  binaryTreeFromSubArray(int[] arr){
        return binaryTree(arr, 0 , arr.length-1);
   }

  static TreeNode binaryTree(int[] arr, int start, int end){
      if (start> end){
          return null;
      }

      int mid = (start+end)/2;

      return new TreeNode(arr[mid], binaryTree(arr, start, mid-1), binaryTree(arr, mid+1, end));
   }





    public static void main(String[] args){
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(1);
        tree.left.left = new TreeNode(0);
        tree.left.right = new TreeNode(3);
        tree.left.right.right = new TreeNode(4);
        tree.right = new TreeNode(7);
        tree.right.left = new TreeNode(6);

        tree.right.right = new TreeNode(8);
        tree.right.right.right = new TreeNode(9);
        inOrder(tree, "root");

        insert(tree, 2, tree, "root");
        System.out.println("-----------Added-----------------");
        inOrder(tree , "root");
        delete(tree, 2, tree , "root");
        System.out.println("-----------deleted--> 2 -----------------");
        inOrder(tree , "root");
        delete(tree, 8, tree , "root");
        System.out.println("-----------deleted--> 8 -----------------");
        inOrder(tree , "root");

        int[] arr = {1, 2, 3, 4,5, 10, 20 , 30 , 40 , 50 , 60 , 70 , 80 , 90 , 100 , 110 , 120};
        inOrder(binaryTreeFromSubArray(arr), "root");
    }
}
