// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//   Input: root = [1,2,2,3,4,4,3]
// Output: true
//   Input: root = [1,2,2,null,3,null,3]
// Output: false


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
    public boolean isSymmetric(TreeNode root) 
    {
        boolean res = mirror(root,root);
        return res;
    }
    public boolean mirror(TreeNode node1,TreeNode node2)
    {
        //base condition
        if(node1==null && node2==null)
        {
            return true;
        }
        
        //first comparison is done inorder to avoid null pointer exception
        if((node1!=null && node2!=null) && (node1.val==node2.val))
        {
            return mirror(node1.left,node2.right) && (mirror(node1.right,node2.left));
        }
        return false;
    }
}
