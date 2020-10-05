package algorithm.leetcode;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class DeleteNode {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null){
            return null;
        }
        Set<Integer> set = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode> result = new ArrayList<>();
        q.offer(root);

        while (!q.isEmpty()){
            TreeNode top = q.poll();
            //TreeNode parent = top;
            Queue<TreeNode> q1 = new LinkedList<>();
            if (set.contains(top.val)){
                if (top.left!= null){
                    q.offer(top.left);
                }

                if (top.right!= null){
                    q.offer(top.right);
                }
                continue;
            }
            q1.offer(top);
            while (!q1.isEmpty()){
                TreeNode currTop = q.poll();


                if (currTop.left != null ){
                    if (set.contains(currTop.left)){
                        TreeNode curr = currTop.left;
                        if (curr.left!= null){
                            q.offer(curr.left);
                        }

                        if (curr.right != null){
                            q.offer(curr.right);
                        }

                        currTop.left = null;
                    }else {
                        q1.offer(currTop.left);
                    }
                }

                if (currTop.right != null ){
                    q1.offer(currTop.right);
                }
            }



        }

        return result;
    }

    public class Pair{
        TreeNode actual;
        TreeNode parent;

        public Pair(TreeNode actual, TreeNode parent){
            this.actual = actual;
            this.parent = parent;
        }
    }

    public List<TreeNode> delNodes1(TreeNode root, int[] to_delete){
        if (root == null){
            return null;
        }
        Set<Integer> set = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode> result = new ArrayList<>();

        return result;
    }




    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
            this.left = left;
            this.right = right;
         }
      }

}
