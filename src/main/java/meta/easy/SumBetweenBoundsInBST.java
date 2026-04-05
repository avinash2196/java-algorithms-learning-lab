package meta.easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class SumBetweenBoundsInBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val >= low && node.val <= high) {
                sum += node.val;
            }
            if (node.left != null && node.val > low) queue.add(node.left);
            if (node.right != null && node.val < high) queue.add(node.right);
        }
        return sum;
    }
}
// Time complexity :O(n) n-- all nodes
// Space Complexity :O(w)  w--width of tree