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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> zigzag = new ArrayList<>(); 
        //base condition
        if(root==null)
        {
            return zigzag;
        }
        
        Stack<TreeNode> current  = new Stack<>(); //current stack.
        Stack<TreeNode> next = new Stack<>(); //next stack.
        
        boolean left_to_right=true;
        
        current.push(root);
        
        List<Integer> res = new ArrayList<>();//list for storing values level wise.
        
        while(!current.isEmpty())
        {
            TreeNode temp=current.pop();
            
            res.add(temp.val);
            
            //left to right..
            if(left_to_right)
            {
                if(temp.left!=null)
                {
                    next.push(temp.left);
                }
                if(temp.right!=null)
                {
                    next.push(temp.right);
                }
            }
            else  //right to left..
            {
                if(temp.right!=null)
                {
                    next.push(temp.right);
                }
                if(temp.left!=null)
                {
                    next.push(temp.left);
                }
            }
            
            if(current.isEmpty())//if the current stack is empty..kindly swap it..
            {
                //swap the stacks..
                Stack<TreeNode> t = current;
                current=next;
                next=t;
                
                left_to_right=!left_to_right;//change the direction.
                
                zigzag.add(res);
                
                //instead of clearing the res list using .clear() method..simply initialize 
                //it with the new ArrayList...done below..
                res = new ArrayList<>();
            }
        }
        
        return zigzag;
    }
}
