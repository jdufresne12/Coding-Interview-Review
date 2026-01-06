
/*
 * 1161. Maximum Level Sum of a Binary Tree
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */

class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxSum = 0;
        int maxLevel = 1;
        int currentLevel = 1;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        maxSum = root.val;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int currentLevelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelSum += currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                maxLevel = currentLevel;
            }
            currentLevel++;
        }

        return maxLevel;
    }

    private TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int index = 1;

        while (index < values.length) {
            TreeNode current = queue.poll();

            if (values[index] != null) {
                current.left = new TreeNode(values[index]);
                queue.offer(current.left);
            }
            index++;

            if (index < values.length && values[index] != null) {
                current.right = new TreeNode(values[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = sol.buildTree(new Integer[] { 1, 7, 0, 7, -8, null, null });
        System.out.println(sol.maxLevelSum(root));
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
