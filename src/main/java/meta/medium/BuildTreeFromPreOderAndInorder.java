package meta.medium;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromPreOderAndInorder {
    private Map<Integer, Integer> inorderMap = new HashMap();
    private int preOrderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;
        int currVal = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(currVal);
        int inorderIndex = inorderMap.get(currVal);
        root.left = arrayToTree(preorder, left, inorderIndex - 1);
        root.right = arrayToTree(preorder, inorderIndex + 1, right);
        return root;
    }
}

// Time complexity :O(n)
// Space Complexity :O(n)