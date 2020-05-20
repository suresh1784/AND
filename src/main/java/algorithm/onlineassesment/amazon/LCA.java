package algorithm.onlineassesment.amazon;
import java.util.*;
public class LCA {
    public static class Node {
        int val;
        List<Node> children;
        public Node(int val, List<Node> children){
            this.val = val;
            this.children = children;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    public static Node LCA(Node root ,Node n1, Node n2){
        if (root == null){
            return null;
        }

        if (root.equals(n1)|| root.equals(n2)){
            return root;
        }

        List<Node> children = root.children;
        int num = 0 ;
        Node commonNode = null;
        for (Node child : children){
            Node node = LCA(child, n1, n2);
            if (node != null){
                commonNode = node;
                num++;
            }
            if (num >=2){
                return root;
            }
        }

        return commonNode;
    }

    public static Node LCAs(Node root ,Set<Node> set){
        if (root == null){
            return null;
        }

        if (set.contains(root)){
            return root;
        }

        List<Node> children = root.children;
        int num = 0 ;
        Node commonNode = null;
        for (Node child : children){
            Node node = LCAs(child, set);
            if (node != null){
                commonNode = node;
                num++;
            }
            if (num >=set.size()){
                return root;
            }
        }

        return commonNode;
    }

    public static void main(String[] args) {
        Node node = new Node(1, new ArrayList<Node>());
        Node node5 = new Node(5, new ArrayList<Node>());
        Node node14 = new Node(14, new ArrayList<Node>());
        Node node15 = new Node(15, new ArrayList<Node>());
        Node node16 = new Node(16, new ArrayList<Node>());
        Node node17 = new Node(17, new ArrayList<Node>());
        Node node6 = new Node (6, Arrays.asList(node14, node15));
        Node node7 = new Node (6, Arrays.asList(node16, node17));
        Node node2 = new Node(2, Arrays.asList(node5, node6, node7));

        //
        Node node8 = new Node(8, new ArrayList<Node>());
        Node node18 = new Node(18, new ArrayList<Node>());
        Node node19 = new Node(19, new ArrayList<Node>());
        Node node20 = new Node(20, new ArrayList<Node>());
        Node node21 = new Node(21, new ArrayList<Node>());
        Node node9 = new Node (9, Arrays.asList(node18, node19));
        Node node10 = new Node (10, Arrays.asList(node20, node21));
        Node node3= new Node(3, Arrays.asList(node8, node9, node10));
        //
        Node node11 = new Node(11, new ArrayList<Node>());
        Node node22 = new Node(22, new ArrayList<Node>());
        Node node23 = new Node(23, new ArrayList<Node>());
        Node node24 = new Node(24, new ArrayList<Node>());
        Node node25 = new Node(25, new ArrayList<Node>());
        Node node12 = new Node (12, Arrays.asList(node22, node23));
        Node node13 = new Node (13, Arrays.asList(node24, node25));
        Node node4= new Node(4, Arrays.asList(node11, node12, node13));

        node.children.addAll(Arrays.asList(node2, node3, node4));

        System.out.println(LCA(node, node13, node25));
        Set<Node> in = new HashSet<>();
        in.addAll(Arrays.asList(node14,node5, node17, node19, node24));
        System.out.println(LCAs(node,in));
    }
}
