// John Dufresne - Tree section solutions

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) 
            return 0;
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isValidBST(TreeNode root) {
        return false;
    }
}
