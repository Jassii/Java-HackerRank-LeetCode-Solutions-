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
    static int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        
        postIndex=postorder.length-1;
        
        TreeNode root = buildTree(inorder,postorder,0,inorder.length-1);
        
        return root;
    }
    
    public TreeNode buildTree(int inorder[],int postorder[],int start,int end)
    {
        //default condition
        if(start>end)
        {
            return null;
        }
        
        //current value
        int curr = postorder[postIndex--];
        TreeNode current = new TreeNode(curr);
        
        if(start==end)
        {
            return current;
        }
        
        //finding the index of the curr value.
        int index = search(inorder,start,end,curr);
        
        //first creating a (right branch).
        current.right = buildTree(inorder,postorder,index+1,end);
        
        //then creating a (left branch).
        current.left = buildTree(inorder,postorder,start,index-1);
        
        return current;  //at last return the current node.
    }
    
    public int search(int inorder[],int start,int end,int data)
    {
        for(int i=start;i<=end;i++)
        {
            if(inorder[i]==data)
            {
                return i;
            }
        }
        return -1; //when index is not found.
    }
}
