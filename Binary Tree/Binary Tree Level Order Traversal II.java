// Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
  
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) 
    {
        List<List<Integer>> reverse = new ArrayList<>();
        
        //base condition
        if(root==null)
        {
            return reverse;
        }
        
        Stack<List<Integer>> stack = new Stack<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
       q.add(root);
        
        while(!q.isEmpty())
        {
            int n =q.size();
            List<Integer> l = new ArrayList<>();
            while(n>0)
            {
                TreeNode temp = q.poll();
                l.add(temp.val);
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
                n--;
            }
            stack.push(l);
        }
        while(!stack.isEmpty())
        {
            reverse.add(stack.pop());
        }
        return reverse;
    }
}
