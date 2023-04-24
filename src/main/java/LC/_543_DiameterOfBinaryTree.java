package LC;

public class _543_DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root) {
        if (root == null) return -1; //the height is -1, because tree is null. Height of tree consisting of one node is 0;
        int leftHeight =  1 + dfs(root.left); //recurse -> adding 1 to account for edge between root and root.left
        int rightHeight = 1 + dfs(root.right); //recurse -> adding 1 to account for edge between root and root.right

        diameter = Math.max(diameter, (leftHeight + rightHeight)); // add height from both sides of current root to get total diameter of path
        return (Math.max(leftHeight, rightHeight));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode () {}
        TreeNode (int val) {
            this.val = val;
        }
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
