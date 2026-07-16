class Solution {
    public boolean isValidBST(TreeNode root) {
        // Start the DFS with infinite boundaries
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // Base Case: An empty tree is technically a valid BST
        if (node == null) {
            return true;
        }

        // Check: If the node's value violates the current boundaries, it's invalid
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recurse:
        // 1. Left subtree: The max boundary becomes the current node's value
        // 2. Right subtree: The min boundary becomes the current node's value
        // BOTH must be true for the tree to be valid.
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}