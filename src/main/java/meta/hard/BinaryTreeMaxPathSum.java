package meta.hard;

import meta.medium.TreeNode;

public class BinaryTreeMaxPathSum {
    private int maxPath = 0;

    public int maxPathSum(TreeNode root) {
        //iterate to find all paths
        findGain(root);
        return maxPath;
    }

    private int findGain(TreeNode node) {
        if (node == null) return 0;
        //find gain from left and gain from right
        int leftGain = Math.max(findGain(node.left), 0);
        int rightGain = Math.max(findGain(node.right), 0);
        //compare gains and set ans
        maxPath = Math.max(maxPath, leftGain + rightGain + node.val);
        //compare and set max to return
        return Math.max(leftGain + node.val, rightGain + node.val);
    }
}
