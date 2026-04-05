package meta.medium;

public class SumRootToLeafInBST {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int curr) {
        if (root == null) return 0;
        curr = curr * 10 + root.val;
        if (root.left == null && root.right == null) return curr;
        int left = dfs(root.left, curr);
        int right = dfs(root.right, curr);
        return left + right;
    }
}
// Time complexity :O(n)
// Space Complexity :O(h)