package patterns.mock;

public class LongestConcecutive {

      public static class TreeNode {
          int val;
          TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }


        public static int max = 0 ;
        public static int longestConsecutive(TreeNode root) {
            max = 0;
            longestConsecutiveIncreasing(root, root.val, 1);
            longestConsecutiveDecreasing(root, root.val, 1);
            return max;
        }

        public static void longestConsecutiveIncreasing(TreeNode root, int prev, int count) {
            if (root == null){
                return;
            }

            longestConsecutiveIncreasing(root.left, root.val, count);
            if (prev+1==root.val){
                count++;
            }else{
                count= 1;
            }

            max = Math.max(count,max);

            longestConsecutiveIncreasing(root.right, root.val, count);



        }

        public static void longestConsecutiveDecreasing(TreeNode root, int prev, int count) {
            if (root == null){
                return;
            }

            longestConsecutiveDecreasing(root.left, root.val, count);
            if (prev-1==root.val){
                count++;
            }else{
                count= 1;
            }

            max = Math.max(count,max);

            longestConsecutiveDecreasing(root.right, root.val, count);



        }

        public static void main(String[] args){
            TreeNode node = new TreeNode(2);
            node.left = new TreeNode(1);
            node.left = new TreeNode(1);
            node.right = new TreeNode(3);

            System.out.println(longestConsecutive(node));

        }


    } // class


