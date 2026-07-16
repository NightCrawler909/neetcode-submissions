class Solution {
    // Global variable to track the highest sum we've seen so far
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 1. Get the max path sum from the left and right children.
        // If a path is negative, we use Math.max(0, ...) to just ignore it.
        int leftMax = Math.max(0, dfs(node.left));
        int rightMax = Math.max(0, dfs(node.right));

        // 2. Calculate the "Split" (Left + Current + Right)
        // Does this inverted "V" path beat our global record?
        int currentPathSum = leftMax + node.val + rightMax;
        maxSum = Math.max(maxSum, currentPathSum);

        // 3. Return the "Straight Line" to the parent
        // We can only choose one branch to continue the path upwards
        return node.val + Math.max(leftMax, rightMax);
    }
}