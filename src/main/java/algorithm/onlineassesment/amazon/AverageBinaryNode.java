package algorithm.onlineassesment.amazon;

public class AverageBinaryNode {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class AvgNode{
        double avg;
        int count;

        public AvgNode(double avg, int count){
            this.avg = avg;
            this.count = count;
        }
    }
    static double maxAvg = 0.0 ;
    public static double maximumAverageSubtree(TreeNode root) {
        if (root == null){
            return 0.0;
        }

        dfs(root);
        return maxAvg;
    }

    static AvgNode dfs(TreeNode root){
        if (root == null){
            return new AvgNode(0.0, 0);
        }
// if we need to consider one child into considerstion
//        if (root.left == null && root.right == null){
//            return new AvgNode(root.val, 1);
//        }

        AvgNode left = dfs(root.left);
        AvgNode right = dfs(root.right);

        double leftTotal = left.avg*left.count;
        double rightTotal = right.avg*right.count;
        double total = leftTotal+rightTotal+root.val;
        int count = left.count+right.count+1;
        double avg = total/count;
        if (avg> maxAvg){
            maxAvg = avg;
        }
        return new AvgNode(avg, count);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(12);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(18);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(8);

        System.out.println(maximumAverageSubtree(root));
    }
}
