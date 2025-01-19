// John Dufresne - Driver Class for Trees Section

public class Main {
    public static TreeNode createBinaryTree(int[] values) {   
        if(values == null || values.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        TreeNode current = root;

        for(int i = 1; i < values.length; i+=2) {
            if(current != null) {
                if(i < values.length && values[i] != 0) {
                    current.left = new TreeNode(values[i]);
                    current = current.left;
                }
                if(i + 1 < values.length && values[i+1] != 0) {
                    current.right = new TreeNode(values[i+1]);
                    current = current.right;
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        /* 
            Maximum Depth of Binary Tree
            Input: root = [3,9,20,null,null,15,7]
            Output: 3
        */
        int[] values = {3,9,20,0,0,0,7};
        TreeNode root = createBinaryTree(values);
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root));

        //-----------------------------------------------------------------------------
        /* 
            Remove Nth Node From End of List
            Input: root = [3,9,20,null,null,15,7]
            Output: 3
        */

        //-----------------------------------------------------------------------------
        /* 
            Remove Nth Node From End of List
            Input: root = [3,9,20,null,null,15,7]
            Output: 3
        */

        //-----------------------------------------------------------------------------
        /* 
            Remove Nth Node From End of List
            Input: root = [3,9,20,null,null,15,7]
            Output: 3
        */

        //-----------------------------------------------------------------------------
        /* 
            Remove Nth Node From End of List
            Input: root = [3,9,20,null,null,15,7]
            Output: 3
        */

    }
}
