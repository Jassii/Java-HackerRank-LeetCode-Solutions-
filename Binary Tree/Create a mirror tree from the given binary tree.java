// Given a binary tree, the task is to create a new binary tree which is a mirror image of the given binary tree.
//   Input:
//         5
//        / \
//       3   6
//      / \
//     2   4
// Output:
// Inorder of original tree: 2 3 4 5 6 
// Inorder of mirror tree: 6 5 4 3 2
// Mirror tree will be:
//   5
//  / \
// 6   3
//    / \
//   4   2

// Input:
//         2
//        / \
//       1   8
//      /     \
//     12      9
// Output:
// Inorder of original tree: 12 1 2 8 9 
// Inorder of mirror tree: 9 8 2 1 12



import java.util.*;
 
class GFG{
     
static class Node
{
    int val;
    Node left;
    Node right;
}
 
// Helper function that allocates
// a new node with the given data
// and null left and right references
public static Node createNode(int val)
{
    Node newNode = new Node();
    newNode.val = val;
    newNode.left = null;
    newNode.right = null;
    return newNode;
}
 
// Function to print the inorder traversal
public static void inOrder(Node root)
{
    if (root == null)
        return;
 
    inOrder(root.left);
    System.out.print(root.val + " ");
    inOrder(root.right);
}
 
// Function to convert to mirror tree
// by swapping the left and right links.
public static Node mirrorTree(Node root)
{
    if(root==null)
    {
        return null;
    }
    
    Node left = mirrorTree(root.left);
    Node right = mirrorTree(root.right);
    
    root.left = right;
    root.right = left;
    
    return root;
}
 
// Driver Code
public static void main(String args[])
{
    Node tree = createNode(5);
    tree.left = createNode(3);
    tree.right = createNode(6);
    tree.left.left = createNode(2);
    tree.left.right = createNode(4);
    System.out.print("Inorder of original tree: ");
    inOrder(tree);
 
    // Function call
    mirrorTree(tree);
 
    System.out.print("\nInorder of mirror tree: ");
    inOrder(tree);
}
}
