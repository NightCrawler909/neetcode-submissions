class Solution {
    // Keeps track of the current root we are processing in the preorder array
    private int preorderIndex = 0;
    
    // Maps the value to its exact index in the inorder array for O(1) lookup
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 1. Build the map once
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        // 2. Start the recursive build using the full bounds of the inorder array
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        // Base Case: If the bounds cross, there are no nodes left to build
        if (left > right) {
            return null;
        }

        // 1. Grab the current root value from preorder and increment the index
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // 2. Find where this root sits in the inorder array
        int mid = inorderMap.get(rootVal);

        // 3. Recurse down to build the branches
        // Everything to the left of 'mid' goes to the left child
        root.left = build(preorder, left, mid - 1);
        
        // Everything to the right of 'mid' goes to the right child
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}