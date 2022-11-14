import java.io.*;
 
class Node
{
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}

}

public class Transaction 
{
	public static Node node;
    static Node prevNode = null;
    static Node headNode = null;

    static void BTToSkewed(Node root,int order)
    {
    	 if(root == null)
         {
             return;
         }
    	 if(order > 0)
         {
             BTToSkewed(root.right, order);
         }
         else
         {
             BTToSkewed(root.left, order);
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
             BTToSkewed(leftNode, order);
         }
         else
         {
             BTToSkewed(rightNode, order);
         }
     }
        
    static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.data + " ");
        traverseRightSkewed(root.right);       
    }
    
	public static void main(String[] args) 
	{
		Transaction tree = new Transaction();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left= new Node(55);
    
        int order = 0;
        BTToSkewed(node, order);
        traverseRightSkewed(headNode);
	}

}