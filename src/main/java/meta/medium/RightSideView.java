package meta.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList();
        if (root == null) return rightSide;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            for (int index = 0; index < levelLength; index++) {
                TreeNode node = queue.poll();
                if (index == levelLength - 1) {
                    rightSide.add(node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return rightSide;
    }
}
// Time complexity : O(n)
// Space Complexity :O(w)