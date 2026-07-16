class Solution {
    // Class-level variables to track state across recursive calls
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    private void inOrder(TreeNode node, int k) {
        // Base case: null node, or we already found our answer
        if (node == null || count >= k) {
            return;
        }

        // 1. Traverse Left
        inOrder(node.left, k);

        // 2. Process Current Node
        count++;
        if (count == k) {
            result = node.val;
            return; // We found it, stop exploring this branch
        }

        // 3. Traverse Right
        inOrder(node.right, k);
    }
}