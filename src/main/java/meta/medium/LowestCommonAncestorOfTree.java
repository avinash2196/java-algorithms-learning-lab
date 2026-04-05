package meta.medium;

public class LowestCommonAncestorOfTree {
    public class Solution {

        private TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            recurseTree(root, p, q);
            return ans;
        }

        private boolean recurseTree(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) return false;

            boolean left = recurseTree(node.left, p, q);
            boolean right = recurseTree(node.right, p, q);
            boolean mid = (node == p || node == q);

            // If any two of the three flags are true, this node is the LCA
            if ((mid ? 1 : 0) + (left ? 1 : 0) + (right ? 1 : 0) >= 2) {
                ans = node;
            }

            return mid || left || right;
        }
    }
}
// Time complexity : O(n)
// Space Complexity :O(h)