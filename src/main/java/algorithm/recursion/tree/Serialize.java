package algorithm.recursion.tree;

public class Serialize {


    public static void inOrder(TreeNode root, String traverse){
        if (root == null){
            return;
        }

        inOrder(root.left, traverse+" -> left ");
        System.out.println(traverse + " ---> "+ root.value);
        inOrder(root.right , traverse + " -> right");
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
        String serialize = serialize(tree);
        System.out.println(serialize);
        TreeNode tree1 = deserialize(serialize);
        inOrder(tree1, "root");
    }

    public static int index = 0 ;
    public static TreeNode deserialize(String data) {

        return recursive(data.split(":"));
    }

    public static TreeNode recursive(String[] s1){
        if (index >= s1.length){
            return null;
        }

        String s = s1[index];
        index++;

        if (s.equals("#")){
            return null;
        }
        TreeNode left = recursive(s1);
        TreeNode right = recursive(s1);
        TreeNode result = new TreeNode(Integer.parseInt(s));
        result.left = left ; //recursive(s1);
        result.right = right ; // recursive(s1);

        return result;

        //return new TreeNode(Integer.parseInt(s), left, right);
    }

    public static  String serialize(TreeNode root){
    StringBuilder sb = new StringBuilder();
    preOrder(root, sb);
      //  System.out.println(sb.toString());
    return sb.toString();
    }

    static void preOrder(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("#");
            sb.append(":");
            return;
        }

        sb.append(root.value);
        sb.append(":");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int val){
            this.value = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.value = val;
            this.left = left;
            this.right = right;
        }
    }
}
