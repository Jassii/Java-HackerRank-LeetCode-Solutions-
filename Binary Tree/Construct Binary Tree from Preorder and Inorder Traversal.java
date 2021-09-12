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
    static int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        preIndex=0;
        int n = preorder.length;
        
        TreeNode root = buildTree(preorder,inorder,0,n-1);
        
        return root;
    }
    
    public TreeNode buildTree(int preorder[],int inorder[],int start,int end)
    {
        //default condition
        if(start>end)
        {
            return null;
        }
        
        //created a node.
        int curr = preorder[preIndex++];  //from the preorder list.
        
        TreeNode current = new TreeNode(curr);
        
        if(start==end)
        {
            return current;
        }
        
        //index of that node value in the inorder list.
        int index = search(inorder,start,end,current.val);
        
        //now making left branch.
        current.left = buildTree(preorder,inorder,start,index-1);
        
        //now making right branch.
        current.right = buildTree(preorder,inorder,index+1,end);
        
        return current;
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
        return -1;//index not found..
    }
}
