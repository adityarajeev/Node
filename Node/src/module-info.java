import java.io.*;
public class Node
{
    int val;
    Node left, right;

    Node(int itm)
    {
        val = itm;
        left = right = null;
    }
}
class Main
{
    public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
   
    static void flatBTtoSke(Node root,int order)
    {
       
        if(root == null)
        {
            return;
        }
       
        if(order > 0)
        {
            flatBTtoSke(root.right, order);
        }
        else
        {
            flatBTtoSke(root.left, order);
        }
        Node rightNode = root.right;
        Node leftNode = root.left;
       
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
       
        if (order > 0)
        {
            flatBTtoSke(leftNode, order);
        }
        else
        {
            flatBTtoSke(rightNode, order);
        }
    }
   
    static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        traverseRightSkewed(root.right);       
    }
   
    public static void main (String[] args)
    {
        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left= new Node(55);

        int order = 0;
        flatBTtoSke(node, order);
        traverseRightSkewed(headNode);
    }
}