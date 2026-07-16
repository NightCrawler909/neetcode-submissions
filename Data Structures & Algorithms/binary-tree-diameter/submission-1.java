class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight(root);
        return diameter;
    }

    private int maxHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = maxHeight(root.left);
        int right = maxHeight(root.right);

        diameter = Math.max(diameter, left+right);

        return 1 + Math.max(left,right);

    }
}