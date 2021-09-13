// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.
  
//   Input: root = [1,2,3,4,5]
// Output: 3
// Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
// Example 2:

// Input: root = [1,2]
// Output: 1

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public int diameterOfBinaryTree(TreeNode root) 
    {
        //base condition
        if(root==null)
        {
            return 0;
        }
        
        //if two nodes are on the left side.
        int ld = diameterOfBinaryTree(root.left);
        //if two node are on the right side.
        int rd = diameterOfBinaryTree(root.right);
        
        //one left side deepest and one right side deepest.
        int f = height(root.left) + height(root.right);  //here we are only looking for the edges...
        //not the number of node..otherwise we would have to add +1..(for the root node.)
        
        //final max height considered..
        int h = Math.max(Math.max(ld,rd),f);
        
        return h;
    }
    
    public int height(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh,rh)+1;
    }
}
