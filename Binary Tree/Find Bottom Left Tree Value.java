// Given the root of a binary tree, return the leftmost value in the last row of the tree.
//   Input: root = [2,1,3]
// Output: 1
  
//   Input: root = [1,2,3,4,null,5,6,null,null,7]
// Output: 7


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
    public int findBottomLeftValue(TreeNode root) 
    {
        int value=Integer.MIN_VALUE;
        if(root==null)
        {
            return -1;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int n = q.size();
            int i;
            for(i=1;i<=n;i++)
            {
                TreeNode temp = q.poll();
                if(i==1)
                {
                    value=temp.val;
                }
                
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
        }
        return value;
    }
}
