package meta.easy;

public class ClosestInBST {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            if ((Math.abs(root.val - target) < Math.abs(closest - target)) || ((Math.abs(root.val - target) == Math.abs(closest - target)) && root.val < closest)) {
                closest = root.val;
            }
            root = root.val < target ? root.left : root.right;
        }
        return closest;
    }
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }
}


