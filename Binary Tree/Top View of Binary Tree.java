// Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

//        1
//     /     \
//    2       3
//   /  \    /   \
// 4    5  6   7

// Top view will be: 4 2 1 3 7
// Note: Return nodes from leftmost node to rightmost node.

// Example 1:

// Input:
//       1
//    /    \
//   2      3
// Output: 2 1 3
// Example 2:

// Input:
//        10
//     /      \
//   20        30
//  /   \    /    \
// 40   60  90    100
// Output: 40 20 10 30 100
// Your Task:
// Since this is a function problem. You don't have to take input. Just complete the function topView() that takes root node as parameter and returns a list of nodes visible from the top view from left to right.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(N).

// { Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        
        class Pair
        {
            int h;
            Node node;
            Pair(int h,Node node)
            {
                this.h=h;
                this.node=node;
            }
        }
    
        if(root==null)
        {
            return new ArrayList<>();
        }
        
        ArrayList<Integer> top = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        TreeMap<Integer,Node> M = new TreeMap<>();
        
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            if(!M.containsKey(curr.h))
            {
                M.put(curr.h,curr.node);
            }
            if(curr.node.left!=null)
            {
                q.add(new Pair(curr.h-1,curr.node.left));
            }
            if(curr.node.right!=null)
            {
                q.add(new Pair(curr.h+1,curr.node.right));
            }
        }
        
        for(Map.Entry<Integer,Node> entry:M.entrySet())
        {
            top.add(entry.getValue().data);
        }
        return top;
    }
}
