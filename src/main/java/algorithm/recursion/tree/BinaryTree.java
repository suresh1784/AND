package algorithm.recursion.tree;

import java.util.*;

/**
 * Date 07/07/2014
 * @author tusroy
 *
 * Youtube link - https://youtu.be/bmaeYtlO2OE
 * Youtube link - https://youtu.be/_SiwrPXG9-g
 * Youtube link - https://youtu.be/NA8B84DZYSA
 *
 */
class NodeRef{
    Node node;
}

enum Color{
    RED,
    BLACK
}

class Node{
    Node left;
    Node right;
    Node next;
    int data;
    int lis;
    int height;
    int size;
    Color color;

    public static Node newNode(int data){
        Node n = new Node();
        n.left = null;
        n.right = null;
        n.data = data;
        n.lis = -1;
        n.height = 1;
        n.size = 1;
        n.color = Color.RED;
        return n;
    }
}

public class BinaryTree {
    public Node addNode(int data, Node head){
        Node tempHead = head;
        Node n = Node.newNode(data);
        if(head == null){
            head = n;
            return head;
        }
        Node prev = null;
        while(head != null){
            prev = head;
            if(head.data < data){
                head = head.right;
            }else{
                head = head.left;
            }
        }
        if(prev.data < data){
            prev.right = n;
        }else{
            prev.left = n;
        }
        return tempHead;
    }

    class IntegerRef{
        int height;
    }

    public int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight  = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void inOrder(Node root){
        if (root!=null){
            inOrder(root.left);
            System.out.println(" - > "+ root.data);
            inOrder(root.right);
        }

    }


    public static Node reverse(Node root){
        if (root == null || (root.left == null && root.right == null)){
            return root;
        }

        Node temp = reverse (root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return temp;
    }

    public static List<List<Integer>>  levelOrder (Node root){
        List<List<Integer>> res = new ArrayList<List<Integer>>();


        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0 ; i <size; i++){
                Node currVal = q.poll();

                list.add(currVal.data);

                if (currVal.left!= null){
                    q.add(currVal.left);
                }
                if (currVal.right != null){
                    q.add(currVal.right);
                }



            }// for
            System.out.println(list);
            res.add(list);
        } //while

        return res;

    }


    public static Node greaterTree(Node root){

    dfs(root, 0);
    return root;

    }

    static int dfs(Node root, int val){
        if (root == null){
            return val;
        }

        root.data = root.data+ dfs(root.right, val) ;
        return dfs(root.left, root.data);
        
    }

    static  Node lowesCommonAncestor(Node root, Node p, Node q)    {

        if (root == null ){
            return null;
        }

        if (root == p || root == q)   {
            return root;
        }

        Node left = lowesCommonAncestor(root.left, p, q)  ;
        Node right = lowesCommonAncestor(root.right, p, q);

        if (left != null && right != null){
            return root;
        }

        return (left != null) ? left : right;

    }

    static Node greaterTree1(Node root){
        if (root == null || (root.right!= null && root.left != null)){
            return root;
        }

       Node temp = greaterTree1(root.right);
       root.data = root.data  + root.right.data;
       root.left.data = root.left.data +root.data;
       return temp;
    }

    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();

        Node head = Node.newNode(40);
        Node head20 = Node.newNode(20);
        Node head60 = Node.newNode(60);
        Node head10 = Node.newNode(10);
        Node head30 = Node.newNode(30);
        Node head50 = Node.newNode(50);
        Node head70 = Node.newNode(70);
        head.left = head20;
        head.right = head60;
        head.left.left = head10;
        head.left.right = head30;
        head.right.left = head50;
        head.right.right = head70;


    //    inOrder(head);
    //    System.out.println(bt.height(head));
        levelOrder(lowesCommonAncestor(head, head30, head10));
     //   levelOrder(greaterTree1(head));

    }
}
