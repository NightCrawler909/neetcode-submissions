class Solution {
    public int goodNodes(TreeNode root) {
        // We start the DFS at the root. 
        // The initial max value on the path is just the root's value itself.
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        // Base Case: An empty node cannot be a good node
        if (node == null) {
            return 0;
        }

        int count = 0;

        // 1. Check if the current node is "good"
        if (node.val >= maxSoFar) {
            count = 1;
        }

        // 2. Update the highest value we have seen on this path so far
        maxSoFar = Math.max(maxSoFar, node.val);

        // 3. Recurse down the left and right branches, 
        // passing down the updated maxSoFar, and add the results to our count
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        // 4. Return the total count for this branch
        return count;
    }
}