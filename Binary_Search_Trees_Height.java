import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{

	public static int getHeight(Node root)  //this function calculates the height of the tree..
    {
      //Write your code here
      Node temp = root;  //for traversing the BST..
      if(temp==null)  //empty tree
      {
          return -1;  //height of the binary tree is equal to the (number of layers-1).
      }
      //tree is not empty..
      int lh = getHeight(temp.left);  //going to the left side..
      int rh = getHeight(temp.right);  //going to the right side..
      if(lh>rh)  //if left side height is greater than right side height..
      {
          return (lh+1);  //+1 because of the root node..
      }
      else
      {
          return (rh+1); //+1 because of the root node..
      }
    }
    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
	 public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}
